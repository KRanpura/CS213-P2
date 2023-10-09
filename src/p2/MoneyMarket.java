package p2;

public class MoneyMarket extends Savings
{
    private static final double ANNUAL_INTEREST_RATE = 0.0475; //default loyal customer status interest
    private int withdrawal; //number of withdrawals

    public MoneyMarket (Profile accHolder, double balance, int numWithdraw)
    {
        super(accHolder, balance, true);
        this.withdrawal = numWithdraw;
    }

    public double monthlyInterest()
    {
        return (ANNUAL_INTEREST_RATE / MONTHS);
    }

    public double monthlyFee()
    {
        return super.monthlyFee();
    }

    public int getWithdrawal()
    {
        return this.withdrawal;
    }

}
