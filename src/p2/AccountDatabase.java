package p2;

import p2.Account;

public class AccountDatabase
{
    private Account [] accounts; //list of various types of accounts
    private int numAcct; //number of accounts in the array
    private int find(Account account) //search for an account in the array
    {
        return 0; //placeholder
    }
    private void grow() //increase the capacity by 4
    {

    }
    public boolean contains(Account account) //overload if necessary
    {
        return false; //placeholder
    }
    public boolean open(Account account) //add a new account
    {
        return false; //placeholder
    }
    public boolean close(Account account) //remove the given account
    {
        return false; //placeholder
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
