package p2;

public class Checking extends Account
{
    private static final double MONTHLY_FEE_IN_DOLLARS = 12;
    protected static final double ANNUAL_INTEREST_RATE = 0.010;

    public Checking (Profile accHolder, double accBalance)
    {
        super(accHolder, accBalance);
    }

    public double monthlyInterest()
    {
        return (this.balance * (ANNUAL_INTEREST_RATE / MONTHS));
    }

    public double monthlyFee()
    {
        if (this.getClass() == CollegeChecking.class || this.balance > 1000)
        {
            return 0.0;
        }
        else
        {
            return MONTHLY_FEE_IN_DOLLARS;
        }
    }

    public String getType()
    {
        return "Checking";
    }

    public String getTypeInitial() { return "C";}

    @Override
    public String toString()
    {
        return (this.getType() + "::" + this.getHolder().getFname() + " " +
                this.getHolder().getLname() + " " + this.getHolder().getDob().toString() + " " +
                "::Balance: $" + format(this.getBalance()));
    }
}
