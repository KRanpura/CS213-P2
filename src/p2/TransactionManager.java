package p2;
import java.util.Objects;
import java.util.Scanner;
public class TransactionManager
{

    //CHECKING IF ACCOUNT EXISTS ALREADY IS NOT IMPLEMENTED NOR MAKING A NEW ACCOUNT (ONLY PASRSING)
    private void openHelper(String[] openBank)
    {
        if (openBank.length < 5) {
            System.out.println("Missing data for opening an account.");
            return;
        }
        //all of them require first name, last name, DOB, initial deposit
        String accountType = openBank[0]; //C, CC, S, MM

        //first name
        String firstName = openBank[1];
        String lastName = openBank[2];
        String dateStr = openBank[3];
        int month = Integer.parseInt(dateStr.split("/")[0]);
        int day = Integer.parseInt(dateStr.split("/")[1]);
        int year = Integer.parseInt(dateStr.split("/")[2]);
        Date dob = new Date(month, day, year);
        if (!validDOB(dob))
        {
            return;
        }
        Profile profile = new Profile(firstName, lastName, dob);
        double balance = Double.parseDouble(openBank[4]);
        if (balance<=0)
        {
            System.out.println("Initial deposit cannot be 0 or negative.");
            return;
        }
        //MM accounts need at least $2000 to open
        if(Objects.equals(accountType, "MM") && balance <2000)
        {
            System.out.println("Minimum of $2000 to open a Money Market account.");
            return;
        }
        if(Objects.equals(accountType, "CC"))
        {
            if(Integer.parseInt(openBank[5])!=0 || Integer.parseInt(openBank[5])!=1 || Integer.parseInt(openBank[5])!=2)
            {
                System.out.println("Invalid campus code.\n");
            }
        }
    }

    private  void closeHelper(String [] closeBank)
    {
        //C MM Jane Doe 10/1/1995
        String accountType = closeBank[0];
        String firstName = closeBank[1];
        String lastName = closeBank[2];
        String dateStr = closeBank[3];
        int month = Integer.parseInt(dateStr.split("/")[0]);
        int day = Integer.parseInt(dateStr.split("/")[1]);
        int year = Integer.parseInt(dateStr.split("/")[2]);
        Date dob = new Date(month, day, year);
        if (!validDOB(dob))
        {
            return;
        }
        Profile profile = new Profile(firstName, lastName, dob);
    }

    private void depositHelper(String[] depositBank)
    {
        String accountType = depositBank[0];
        String firstName = depositBank[1];
        String lastName = depositBank[2];
        String dateStr = depositBank[3];
        int month = Integer.parseInt(dateStr.split("/")[0]);
        int day = Integer.parseInt(dateStr.split("/")[1]);
        int year = Integer.parseInt(dateStr.split("/")[2]);
        Date dob = new Date(month, day, year);
        if (!validDOB(dob))
        {
            return;
        }
        Profile profile = new Profile(firstName, lastName, dob);
        //check if deposit is not String
        try {
            double depositAmnt = Double.parseDouble(depositBank[4]);
            if (depositAmnt <= 0) {
                System.out.println("Deposit amount cannot be 0 or negative.\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid deposit amount. Please enter a valid number for the deposit.\n");
        }

    }
    private void withdrawHelper(String[] withdrawBank)
    {
        String accountType = withdrawBank[0];
        String firstName = withdrawBank[1];
        String lastName = withdrawBank[2];
        String dateStr = withdrawBank[3];
        int month = Integer.parseInt(dateStr.split("/")[0]);
        int day = Integer.parseInt(dateStr.split("/")[1]);
        int year = Integer.parseInt(dateStr.split("/")[2]);
        Date dob = new Date(month, day, year);
        if (!validDOB(dob))
        {
            return;
        }
        Profile profile = new Profile(firstName, lastName, dob);
        //check if deposit is not String
        try {
            double depositAmnt = Double.parseDouble(withdrawBank[4]);
            if (depositAmnt <= 0) {
                System.out.println("Deposit amount cannot be 0 or negative.\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid deposit amount. Please enter a valid number for the deposit.\n");
        }

    }
    private boolean validDOB(Date eventDate)
    {
        Date today = new Date();
        if (!eventDate.isValid())
        {
            System.out.println(eventDate.toString() + " not a valid calendar date!");
            return false;
        }
        else if (eventDate.compareTo(today) < 0)
        {
            System.out.println(eventDate.toString() + " cannot be today or a future day.");
            return false;
        }
        else
        {
            return true;
        }
    }
    public void run ()
    {
//        p2.TransactionManager class. This is the user interface class that processes the transactions entered on the
//            terminal and performs all Input/Ouput. This class handles all Java exceptions and invalid data before it
//            calls the methods in p2.AccountDatabase class to complete the transactions. For example,
//        InputMismatchException, NumberFormatException, NoSuchElementException, invalid dates of birth,
//            invalid campus codes, and invalid amounts. Whenever there is an exception or invalid data, display a
//        message on the terminal. See the Project2ExpectedOutput.txt for the proper messages to display. -2 points
//        for each exception not caught or invalid data not checked in this class or messages not displayed. You must
//        include a run() method to process the command lines. You will lose 5 points for not including this method,
//            or the method exceed 40 lines.

        System.out.println("Task Manager is running.");
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        AccountDatabase account = new AccountDatabase();
        while(scanner.hasNextLine() && isRunning) {
            String line = scanner.nextLine().trim(); // Read the entire line
            if (!line.isEmpty()) {
                String[] commandAndArgs = line.split(" ", 2); // Split the line into command and arguments
                String command = commandAndArgs[0];
                String bankString = (commandAndArgs.length > 1) ? commandAndArgs[1] : "";
                switch (command) {
                    case "O":
                        openHelper(bankString.split("\\s+"));
                        break;
                    case "C":
                        closeHelper(bankString.split("\\s+"));
                    case "D":
                        depositHelper(bankString.split("\\s+"));
                    case "W":
                        withdrawHelper(bankString.split("\\s+"));
                    case "P":
                        account.printSorted();
                        break;
                    case "PI":
                        account.printFeesAndInterests();
                        break;
                    case "UB":
                        account.printUpdatedBalances();
                        break;
                    case "Q":
                        isRunning= false;
                        break;
                    default:
                        System.out.println("Invalid command!");

                }

            }
        }
    }


}
