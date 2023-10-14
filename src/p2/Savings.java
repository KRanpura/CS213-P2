package p2;

public class Savings extends Account
{
    protected boolean isLoyal; //loyal customer status
    protected static final double MONTHLY_FEE_IN_DOLLARS = 25;

    private static final double LOYAL_ANNUAL_INTEREST = 0.0425;
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
            return (this.balance * (LOYAL_ANNUAL_INTEREST / MONTHS));
        }
        return (this.balance * (ANNUAL_INTEREST_RATE / MONTHS)); //placeholder
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

    public String getType()
    {
        return "Savings";
    }

    public String getTypeInitial() { return "MM";}
    public boolean getLoyal()
    {
        return this.isLoyal;
    }

    public void setLoyal(boolean status)
    {
        this.isLoyal = status;
    }

    protected String getLoyalString()
    {
        if (this.isLoyal)
        {
            return ("is loyal");
        }
        else
        {
            return "";
        }
    }
    @Override
    public String toString()
    {
        return (this.getType() + "::" + this.getHolder().getFname() + " " +
                this.getHolder().getLname() + " " + this.getHolder().getDob().toString() + " " +
                "::Balance: $" + format(this.getBalance()) + "::" + this.getLoyalString());
    }
}
