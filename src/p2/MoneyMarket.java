package p2;

public class MoneyMarket extends Savings
{
    private static final double ANNUAL_INTEREST_RATE = 0.045;
    private int withdrawal; //number of withdrawals

    public MoneyMarket (Profile accHolder, double balance, boolean loyalStatus, int numWithdraw)
    {
        super(accHolder, balance, loyalStatus);
        this.withdrawal = numWithdraw;
    }

    public int getWithdrawal()
    {
        return this.withdrawal;
    }
}
