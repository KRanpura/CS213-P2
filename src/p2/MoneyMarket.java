package p2;

public class MoneyMarket extends Savings
{
    private static final double ANNUAL_INTEREST_RATE = 0.0475; //default loyal customer status interest
    private int withdrawal; //number of withdrawals

    public MoneyMarket (Profile accHolder, double balance)
    {
        super(accHolder, balance, true);
        this.withdrawal = 0;
    }

    public double monthlyInterest()
    {
        return (this.balance * (ANNUAL_INTEREST_RATE / MONTHS));
    }

    public double monthlyFee()
    {
        return super.monthlyFee();
    }

    public boolean getLoyal()
    {
        return this.isLoyal;
    }

    public void setLoyal(boolean status)
    {
        super.setLoyal(status);
    }

    public int getWithdrawal()
    {
        return this.withdrawal;
    }

    public void setWithdrawal(int numWithdraw)
    {
        this.withdrawal = numWithdraw;
    }

    public String getType()
    {
        return "Money Market::Savings";
    }

    public String getTypeInitial() { return "MM";}

    @Override
    public String toString()
    {
        return (this.getType() + "::" + this.getHolder().getFname() + " " +
                this.getHolder().getLname() + " " + this.getHolder().getDob().toString() + " " +
                "::Balance: $" + format(this.getBalance()) + "::" + this.getLoyalString() +
                "::withdrawal: " + this.withdrawal);
    }
}
