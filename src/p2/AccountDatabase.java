/**
 * AccountDatabase.java initializes an array of account types
 * and implements methods to find, open, close, withdraw from,
 * and deposit in accounts.
 * @author Khushi Ranpura, Kusum Gandham
 */

package p2;

import java.text.DecimalFormat;

public class AccountDatabase
{
    private Account [] accounts; //list of various types of accounts
    private int numAcct; //number of accounts in the array
    private static final int NOT_FOUND = -1;

    private static final int MM_MIN_BALANCE = 2000;

    /**
     * Constructor to create a new instance of an AccountDatabase and
     * initialize its instance variables.
     */
    public AccountDatabase()
    {
        this.numAcct = 0;
        this.accounts = new Account[0];
    }

    /**
     * Finds an account in the database
     * @param account account to find
     * @return index if account found, or NOT_FOUND if not found
     */
    private int find(Account account) //search for an account in the array
    {
        for (int i = 0; i < this.accounts.length; i++)
        {
            if (this.accounts[i] != null || this.accounts[i].equals(account))
            {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * Grows the database when it is full.
     */
    private void grow() //increase the capacity by 4
    {
        Account[] newArray = new Account[this.accounts.length+4];
        for (int i = 0; i < this.accounts.length; i++)
        {
            newArray[i] = this.accounts[i];
        }
        this.accounts = newArray;
    }

    /**
     * Checks if the database contains an account by calling the find method.
     * @param account to check for
     * @return true if account is in database, or false if it is not in the database
     */
    public boolean contains(Account account) //overload if necessary
    {
        if (find(account) != NOT_FOUND)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /**
     * Opens a new account and adds it to the database.
     * @param account to add
     * @return true if successfully added, else false
     */
    public boolean open(Account account) //add a new account
    {
        //System.out.println(account);
        if (contains(account))
        {
            return false;
        }
        if (!contains(account))
        {
            if (this.accounts.length == 0) //array has initial capacity 0
            {
                grow();
            }
            for (int i = 0; i < this.accounts.length; i++)
            {
                if (this.accounts[i] == null)
                {
                    this.accounts[i] = account;
                    this.numAcct++;
                    if (i == this.accounts.length - 1) {
                        grow();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Closes an account by removing it from the database.
     * @param account to be closed
     * @return true if successfully closed, else false
     */
    public boolean close(Account account) //remove the given account
    {
        int index = find(account);
        if (index == NOT_FOUND)
        {
            return false;
        }
        else
        {
            this.accounts[index] = null; // Remove account
            this.numAcct--;

            // Shift events to fill the gap
            for (int i = index; i < this.accounts.length - 1; i++) {
                this.accounts[i] = this.accounts[i + 1];
            }
            // Set the last spot to null
            this.accounts[this.accounts.length - 1] = null;
            return true;
        }
    }

    /**
     * Withdraws money from account if there are sufficient funds
     * @param account to withdraw money from
     * @return true if withdrawal is successful, else false
     */
    public boolean withdraw(Account account) //false if insufficient fund
    {
        int accIndex = find(account);
        if (accIndex == NOT_FOUND)
        {
            return false;
        }
        double balance = this.accounts[accIndex].getBalance();
        if (balance < account.getBalance())
        {
            return false;
        }
        double newBalance = account.getBalance();
        double updateBalance = balance - newBalance;
        this.accounts[accIndex].setBalance(updateBalance);
        if (account instanceof MoneyMarket)
        {
            MoneyMarket acc = (MoneyMarket) this.accounts[accIndex];
            if (acc.getBalance() < MM_MIN_BALANCE)
            {
                acc.setLoyal(false);
            }
            acc.setWithdrawal(acc.getWithdrawal() + 1);
            if (acc.getWithdrawal() > 3)
            {
                acc.setBalance(acc.getBalance() - 10);
            }
            this.accounts[accIndex] = acc;
        }
        return true;
    }

    /**
     * Deposits money in an account
     * @param account to deposit money in
     */
    public void deposit(Account account)
    {
        int accIndex = find(account);
        double depositAmount = account.getBalance();
        if (accIndex == NOT_FOUND) {
            return; // Exit the method to avoid further processing
        }
        double currentBalance = this.accounts[accIndex].getBalance();
        currentBalance += depositAmount;
        this.accounts[accIndex].setBalance(currentBalance);

        if (account instanceof MoneyMarket) {
            MoneyMarket mmAccount = (MoneyMarket) this.accounts[accIndex];
            if (mmAccount.getBalance() >= MM_MIN_BALANCE) {
                mmAccount.setLoyal(true);
            }
            this.accounts[accIndex] = mmAccount;
        }
    }

    /**
     * Prints all accounts in the account database grouped by account type
     */
    public void printSorted() //sort by account type and profile
    {
        if (this.accounts.length == 0)
        {
            System.out.println("Account database is empty!");
            return;
        }
        System.out.println("*Accounts sorted by account type and profile.");
        Account [] databaseToPrint = getSortedDatabase();
        for (int i = 0; i < databaseToPrint.length; i++)
        {
            System.out.println(databaseToPrint[i].toString());
        }
    }

    /**
     * Prints all accounts in the account database grouped by account type
     * along with associated fees and interests to be applied.
     */
    public void printFeesAndInterests() //calculate interests/fees
    {
        if (this.accounts.length == 0)
        {
            System.out.println("Account database is empty!");
            return;
        }
        System.out.println("*List of accounts with fee and monthly interest.");
        Account [] databaseToPrint = getSortedDatabase();
        for (int i = 0; i < databaseToPrint.length; i++)
        {
            System.out.println(databaseToPrint[i].toString() + "::fee $" +
                    databaseToPrint[i].format(databaseToPrint[i].monthlyFee()) +
                    "::monthly interest $" +
                    databaseToPrint[i].format(databaseToPrint[i].monthlyInterest()));
        }
    }

    /**
     * Prints all accounts in the account database grouped by account type
     * along with all fees and interests applied
     */
    public void printUpdatedBalances() //apply the interests/fees
    {
        if (this.accounts.length == 0)
        {
            System.out.println("Account database is empty!");
            return;
        }
        System.out.println("*list of accounts with fees and interests applied.");
        Account [] databaseToPrint = getSortedDatabase();
        for (int i = 0; i < databaseToPrint.length; i++)
        {
            double fees = databaseToPrint[i].monthlyFee();
            double interest = databaseToPrint[i].monthlyInterest();
            databaseToPrint[i].setBalance(databaseToPrint[i].getBalance() + fees + interest);
            System.out.println(databaseToPrint[i].toString());
        }
    }

    /**
     * Helper method to return all accounts in database sorted by type of account.
     * @return nonNullAccounts array of sorted events
     */
    public Account[] getSortedDatabase()
    {
        Account[] nonNullAccounts = new Account[numAcct];
        int nonNullCount = 0;
        for (Account account : accounts)
        {
            if (account != null)
            {
                nonNullAccounts[nonNullCount++] = account;
            }
        }
        for (int i = 0; i < nonNullCount - 1; i++)
        {
            for (int j = 0; j < nonNullCount - i - 1; j++) {
                String accountType1 = nonNullAccounts[j].getType();
                String accountType2 = nonNullAccounts[j + 1].getType();
                if (accountType1.compareTo(accountType2) > 0) {
                    Account temp = nonNullAccounts[j];
                    nonNullAccounts[j] = nonNullAccounts[j + 1];
                    nonNullAccounts[j + 1] = temp;
                }
            }
        }
        return nonNullAccounts;
    }
}
