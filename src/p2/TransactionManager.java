/**
 * TransactionManager.java initializes an instance of
 * AccountDatabase.java and contains methods to parse user input for
 * account details before performing account operations on the account database.
 * @author Kusum Gandham, Khushi Ranpura
 */

package p2;
import java.util.Objects;
import java.util.Scanner;
public class TransactionManager
{

    public static final int MIN_MM_BALANCE = 2000;
    private static final double DAYS_IN_YEAR  = 365.25;
    private Profile makeProfile(String [] toParse)
    {
        //String accountType = toParse[0];
        String firstName = toParse[1];
        String lastName = toParse[2];
        String dateStr = toParse[3];
        int month = Integer.parseInt(dateStr.split("/")[0]);
        int day = Integer.parseInt(dateStr.split("/")[1]);
        int year = Integer.parseInt(dateStr.split("/")[2]);
        Date dob = new Date(month, day, year);
        if (!validDOB(dob))
        {
            return null;
        }
        Profile profile = new Profile(firstName, lastName, dob);
        return profile;
    }

    private void openHelper(String[] openBank, AccountDatabase db)
    {
        if (openBank.length < 5) {
            System.out.println("Missing data for opening an account.");
            return;
        }
//        for (int i = 0; i< openBank.length; i++)
//        {
//            System.out.println(i +":"+ openBank[i]);
//        }
        //all of them require first name, last name, DOB, initial deposit
        String accountType = openBank[0]; //C, CC, S, MM
        //System.out.println(openBank[4]);
        try {
            double balance = Double.parseDouble(openBank[4].trim());
            //System.out.println("in here");
            if (balance<=0)
            {
                System.out.println("Initial deposit cannot be 0 or negative.");
                return;
            }
            Profile profile = makeProfile(openBank); //pass to helper function
            if (profile == null)
            {
                return;
            }
            if(Objects.equals(accountType, "MM") && balance < MIN_MM_BALANCE)
            {
                System.out.println("Minimum of $2000 to open a Money Market account.");
                return;
            }
            Date today = new Date();
            if(Objects.equals(accountType, "MM") && profile.getDob().compareTo(today)/DAYS_IN_YEAR > 24)
            {
                System.out.println("DOB invalid: " + profile.getDob().toString() + " over 24.");
                return;
            }
            else if(Objects.equals(accountType,"MM")) {
                MoneyMarket moneyMarket = new MoneyMarket(profile, balance);
                boolean result = db.open(moneyMarket);
                if (result)
                {
                    System.out.println(profile.getFname() + " " + profile.getLname() + " " + profile.getDob() + "(" + accountType + ") opened.");
                }
                else{
                    System.out.println(profile.getFname() + " " + profile.getLname() + " " + profile.getDob() + "(" + accountType + ") is already in the database.");
                }
                return;
            }
            if(Objects.equals(accountType, "CC"))
            {
                if(Integer.parseInt(openBank[5])!=0 && Integer.parseInt(openBank[5])!=1 &&
                        Integer.parseInt(openBank[5])!=2)
                {
                    System.out.println("Invalid campus code.");
                    return;
                }
                else
                {
                    Campus campus = Campus.values()[Integer.parseInt(openBank[5])]; // Parse the campus code correctly
                    CollegeChecking collegeChecking = new CollegeChecking(profile, balance, campus);
                    //System.out.println(db.open(collegeChecking));
                    boolean result = db.open(collegeChecking);
                    if (result) {
                        System.out.println(profile.getFname() + " " + profile.getLname() + " " + profile.getDob() + "(" + accountType + ") opened.");
                    } else {
                        System.out.println(profile.getFname() + " " + profile.getLname() + " " + profile.getDob() + "(" + accountType + ") is already in the database.");
                    }
                    return;
                }
            }
            Account account = makeAccount(profile, balance, accountType);
            boolean result = db.open(account);
            if(result)
            {
                System.out.println(profile.getFname() + " " + profile.getLname() + " " + profile.getDob()+ "("+accountType+") opened." );
            }
            else if (!result)
            {
                System.out.println(db.open(account));
                System.out.println(profile.getFname() + " " + profile.getLname() + " " + profile.getDob()+ "("+accountType+") is already in the database." );
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Not a valid amount.");
        }
    }

    private void closeHelper(String [] closeBank, AccountDatabase db)
    {
        //C MM Jane Doe 10/1/1995
        if (closeBank.length < 5) {
            System.out.println("Missing data for closing an account.");
            return;
        }
        String accountType = closeBank[0];
        Profile profile = makeProfile(closeBank);
        if (profile == null)
        {
            return;
        }
        Account account = makeAccount(profile, 0, accountType);
        if (!db.contains(account))
        {
            System.out.println(printResponse(account) + " is not in the database.");
            return;
        }
        db.close(account);
        System.out.println(printResponse(account)+ " has been closed.");
    }

    private void depositHelper(String[] depositBank, AccountDatabase db)
    {

        String accountType = depositBank[0];
        Profile profile = makeProfile(depositBank);
        if (profile == null)
        {
            return;
        }
        //check if deposit is not String
        try {
            double depositAmt = Double.parseDouble(depositBank[4]);
            if (depositAmt <= 0) {
                System.out.println("Deposit - amount cannot be 0 or negative.\n");
                return;
            }
            Account account = makeAccount(profile, depositAmt, accountType);
            db.deposit(account);
        } catch (NumberFormatException e) {
            System.out.println("Not a valid amount.\n");
        }
    }
    private void withdrawHelper(String[] withdrawBank, AccountDatabase db)
    {
        String accountType = withdrawBank[0];
        Profile profile = makeProfile(withdrawBank);
        if (profile == null)
        {
            return;
        }
        //check if deposit is not String
        try {
            double withdrawAmt = Double.parseDouble(withdrawBank[4]);
            if (withdrawAmt <= 0) {
                System.out.println("Withdraw - amount cannot be 0 or negative.\n");
                return;
            }
            Account account = makeAccount(profile, withdrawAmt, accountType);
            if (!db.contains(account))
            {
                System.out.println(printResponse(account) + " is not in the database.");
            }
            if (db.withdraw(account))
            {
                System.out.println(printResponse(account) + " Withdraw - balance updated.");
            }
            else
            {
                System.out.println(printResponse(account) + " Withdraw - insufficient fund.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Not a valid amount.\n");
        }

    }
    private boolean validDOB(Date date)
    {
        Date today = new Date();
        if (!date.isValid())
        {
            System.out.println("DOB invalid: " + date.toString() + " not a valid calendar date!");
            return false;
        }
        else if (date.compareTo(today) < 0)
        {
            System.out.println("DOB invalid: " + date.toString() + " cannot be today or a future day.");
            return false;
        }
        else if (date.compareTo(today) / DAYS_IN_YEAR < 16)
        {
            System.out.println("DOB invalid: " + date.toString() + " under 16.");
            return false;
        }
        else
        {
            return true;
        }
    }

    private Account makeAccount(Profile profile, double balance, String accountType)
    {
        switch(accountType)
        {
            case "C":
                Checking checking = new Checking (profile, balance);
                return checking;
            case "CC":
                CollegeChecking collegeChecking = new CollegeChecking(profile, balance, null);
                return collegeChecking;
            case "S":
                Savings savings = new Savings(profile, balance, false);// fix
                return savings;
            case "MM":
                MoneyMarket market = new MoneyMarket(profile, balance);
                return market;
            default:
                System.out.println("Invalid command type!");
                return null;
        }
    }
    private String printResponse(Account account)
    {
        return (account.getHolder().getFname() + " " + account.getHolder().getLname() + " " +
                account.getHolder().getDob().toString() + "(" + account.getTypeInitial() + ")");
    }
    public void run ()
    {
        System.out.println("Transaction Manager is running.\n");
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        AccountDatabase database = new AccountDatabase();
        while(scanner.hasNextLine() && isRunning) {
            String line = scanner.nextLine().trim(); // Read the entire line
            if (!line.isEmpty()) {
                String[] commandAndArgs = line.split(" ", 2); // Split the line into command and arguments
                String command = commandAndArgs[0];
                String bankString = (commandAndArgs.length > 1) ? commandAndArgs[1] : "";
                bankString = bankString.trim();
                switch (command) {
                    case "O":
                        openHelper(bankString.split("\\s+"), database);
                        break;
                    case "C":
                        closeHelper(bankString.split("\\s+"), database);
                        break;
                    case "D":
                        depositHelper(bankString.split("\\s+"), database);
                        break;
                    case "W":
                        withdrawHelper(bankString.split("\\s+"), database);
                        break;
                    case "P":
                        database.printSorted();
                        break;
                    case "PI":
                        database.printFeesAndInterests();
                        break;
                    case "UB":
                        database.printUpdatedBalances();
                        break;
                    case "Q":
                        System.out.println("Transaction Manager is terminated.\n");
                        isRunning= false;
                        break;
                    default:
                        System.out.println("Invalid command!");

                }

            }
        }
    }

}