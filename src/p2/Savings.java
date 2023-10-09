package p2;

public class Savings extends Account
{
    protected boolean isLoyal; //loyal customer status
    protected static final double MONTHLY_FEE_IN_DOLLARS = 25;

    protected static final double LOYAL_ANNUAL_INTEREST = 0.0425;
    private static final double ANNUAL_INTEREST_RATE = 0.04;

    public Savings(Profile accHolder, double balance, boolean loyalStatus)
    {
        super(accHolder, balance);
        this.isLoyal = loyalStatus;
    }
    public double monthlyInterest()
    {
        if (this.isLoyal)
        {
            return (LOYAL_ANNUAL_INTEREST / MONTHS);
        }
        return (ANNUAL_INTEREST_RATE / MONTHS); //placeholder
    }
    //return monthly fee
    public double monthlyFee()
    {
        if (this.getClass() == MoneyMarket.class)
        {
            if (this.balance >= 2000)
            {
                return 0.0;
            }
            else
            {
                return MONTHLY_FEE_IN_DOLLARS;
            }
        }
        else
        {
            if (this.balance >=  500)
            {
                return 0.0;
            }
            else
            {
                return MONTHLY_FEE_IN_DOLLARS;
            }
        }

    }

    public boolean getLoyal()
    {
        return this.isLoyal;
    }

    public void setLoyal(boolean status)
    {
        this.isLoyal = status;
    }
}
