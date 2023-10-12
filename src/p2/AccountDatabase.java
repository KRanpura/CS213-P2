package p2;

import p2.Account;

public class AccountDatabase
{
    private Account [] accounts; //list of various types of accounts
    private int numAcct; //number of accounts in the array
    private static final int NOT_FOUND = -1;

    public AccountDatabase()
    {
        this.numAcct = 0;
        this.accounts = new Account[0];
    }
    private int find(Account account) //search for an account in the array
    {
        for (int i = 0; i < this.accounts.length; i++)
        {
            if (this.accounts[i] != null)
            {
                if (this.accounts[i].compareTo(account) == 0)
                {
                    return i;
                }
            }
        }
        return NOT_FOUND;
    }

    private void grow() //increase the capacity by 4
    {
        Account[] newArray = new Account[this.accounts.length+4];
        for (int i = 0; i < this.accounts.length; i++)
        {
            newArray[i] = this.accounts[i];
        }
        this.accounts = newArray;
    }

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

    //the same profile cannot open more than 1 of the same type of account
    public boolean open(Account account) //add a new account
    {
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
    public boolean withdraw(Account account) //false if insufficient fund
    {
        if (account instanceof MoneyMarket)
        {
            MoneyMarket acc = (MoneyMarket) account;
            checkLoyal(acc);
        }
        //decrease balance by 10 again here if numWithdrawals > 3
        return false; //placeholder
    }
    public void deposit(Account account)
    {
        if (account instanceof MoneyMarket)
        {
            MoneyMarket acc = (MoneyMarket) account;
            checkLoyal(acc);
        }
    }
    public void printSorted() //sort by account type and profile
    {
        if (this.accounts.length == 0)
        {
            System.out.print("Account database is empty!");
            return;
        }
        Account [] databaseToPrint = getSortedDatabase();
        for (int i = 0; i < databaseToPrint.length; i++)
        {
            System.out.println(databaseToPrint[i].toString());
        }
    }

    public void printFeesAndInterests() //calculate interests/fees
    {
        if (this.accounts.length == 0)
        {
            System.out.print("Account database is empty!");
            return;
        }
        Account [] databaseToPrint = getSortedDatabase();

    }
    public void printUpdatedBalances() //apply the interests/fees
    {
        if (this.accounts.length == 0)
        {
            System.out.print("Account database is empty!");
            return;
        }
    }

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

    private void checkLoyal(MoneyMarket account)
    {
        if (account.getBalance() > 2000)
        {
            account.setLoyal(true);
        }
        else
        {
            account.setLoyal(false);
        }
    }



}
