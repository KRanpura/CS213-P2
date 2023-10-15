package p2;

import java.text.DecimalFormat;

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
    public abstract String getTypeInitial();
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

    @Override
    public boolean equals(Object object)
    {
        if (object instanceof Account)
        {
            Account account = (Account) object;
            if (this.compareTo(account) == EQUAL)
            {
                return true;
            }
            return false;
        }
        return false;
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

    public String format(double balance)
    {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        return decimalFormat.format(balance);
    }
}