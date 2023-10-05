package p2;

public abstract class Account implements Comparable<Account>
{
    //protected means only used by subclasses
    protected Profile holder;
    protected double balance;

    //abstract meaning subclasses implement these methods, not done here in this class
    public abstract double monthlyInterest();
    public abstract double monthlyFee();


    public int compareTo(Account account)
    {
        return 1; //placeholder
    }
}