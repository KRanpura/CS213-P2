package p2;

public abstract class Account implements Comparable<Account>
{
    //protected means only used by subclasses
    protected Profile holder;
    protected double balance;
    protected final static int MONTHS = 12;

    private static final int EQUAL = 0;
    private static final int NOT_EQUAL = 1;

    //abstract meaning subclasses implement these methods, not done here in this class
    public abstract double monthlyInterest();
    public abstract double monthlyFee();
    public abstract String getType();
    public abstract String toString();

    public Account(Profile accHolder, double accBalance)
    {
        this.holder = accHolder;
        this.balance = accBalance;
    }

    @Override
    public int compareTo(Account account)
    {
        if (this.holder.equals(account.holder))
        {
            return EQUAL;
        }
        else
        {
            return NOT_EQUAL;
        }
    }

    public Profile getHolder()
    {
        return this.holder;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }
}