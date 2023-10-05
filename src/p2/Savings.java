package p2;

public class Savings extends Account
{
    protected boolean isLoyal; //loyal customer status
    protected static final double MONTHLY_FEE_IN_DOLLARS = 25;
    private static final double ANNUAL_INTEREST_RATE = 0.04;
    public double monthlyInterest()
    {
        return 1.0; //placeholder
    }

    public double monthlyFee()
    {
        return 1.0; //placeholder
    }
}
