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
                if (this.accounts[i].equals(account))
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
    public boolean open(Account account) //add a new account
    {
        if (!contains(account))
        {
            if (this.accounts.length == 0) //array has initial capacity 0
            {
                grow();
            }
            if (account instanceof MoneyMarket && account.balance < 2000)
            {
                return false;
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
            return true;
        }
    }
    public boolean withdraw(Account account) //false if insufficient fund
    {
        return false; //placeholder
    }
    public void deposit(Account account)
    {

    }
    public void printSorted() //sort by account type and profile
    {

    }
    public void printFeesAndInterests() //calculate interests/fees
    {

    }
    public void printUpdatedBalances() //apply the interests/fees
    {

    }

    public static void main(String [] args)
    {
//            close(account); //1 true case
//            close(account2); //1 false csae
    }

}
