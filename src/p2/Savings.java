package p2;

public class Savings extends Account
{
    protected boolean isLoyal; //loyal customer status
    private static final double MONTHLY_FEE_IN_DOLLARS = 25;
    private static final double ANNUAL_INTEREST_RATE = 0.04;

    public Savings(Profile accHolder, double balance, boolean loyalStatus)
    {
        super(accHolder, balance);
        this.isLoyal = loyalStatus;
    }
    public double monthlyInterest()
    {
        return 1.0; //placeholder
    }

    //return monthly fee
    public double monthlyFee()
    {
        return MONTHLY_FEE_IN_DOLLARS;
    }
}
