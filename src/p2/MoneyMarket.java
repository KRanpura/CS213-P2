/**
 * MoneyMarket.java defines the MoneyMarket subclass of Savings and
 * implements methods to calculate fees and interest, and to print
 * account information.
 * @author Khushi Ranpura
 */
package p2;

public class MoneyMarket extends Savings
{
    private static final double ANNUAL_INTEREST_RATE = 0.0475; //default loyal customer status interest
    private int withdrawal; //number of withdrawals

    /**
     * Constructor that creates a new instance of MoneyMarket account
     * and initializes its instance variables.
     * @param accHolder profile of account holder
     * @param balance balance of new account
     */
    public MoneyMarket (Profile accHolder, double balance)
    {
        super(accHolder, balance, true);
        this.withdrawal = 0;
    }

    /**
     * Calculates the monthly interest for the money market account
     * it is called on.
     * @return interest amount as a double
     */
    public double monthlyInterest()
    {
        return (this.balance * (ANNUAL_INTEREST_RATE / MONTHS));
    }

    /**
     * Calculates the monthly fees for the money market account
     * it is called on
     * @return monthly fee amount as a double
     */
    public double monthlyFee()
    {
        return super.monthlyFee();
    }

    /**
     * Getter method that returns the loyalty status of the account
     * @return isLoyal boolean variable
     */
    public boolean getLoyal()
    {
        return this.isLoyal;
    }

    /**
     * Setter method that updates the loyalty status of the account
     * @param status new loyalty status
     */
    public void setLoyal(boolean status)
    {
        super.setLoyal(status);
    }

    /**
     * Getter method that returns number of withdrawals made for the account.
     * @return withdrawal
     */
    public int getWithdrawal()
    {
        return this.withdrawal;
    }

    /**
     * Setter method that updates the number of withdrawals made for the account.
     * @param numWithdraw new number of withdrawals
     */
    public void setWithdrawal(int numWithdraw)
    {
        this.withdrawal = numWithdraw;
    }

    /**
     * Helper method that returns the type of the account as a String for printing purposes.
     * @return type as a String
     */
    public String getType()
    {
        return "Money Market::Savings";
    }

    /**
     * Helper method that returns the initials of the type of the account as a String
     * for printing purposes.
     * @return type initial as a string
     */
    public String getTypeInitial() { return "MM";}

    /**
     * toString method to format the account for printing.
     * @return formatted account String
     */
    @Override
    public String toString()
    {
        return (this.getType() + "::" + this.getHolder().getFname() + " " +
                this.getHolder().getLname() + " " + this.getHolder().getDob().toString() + " " +
                "::Balance: $" + format(this.getBalance()) + "::" + this.getLoyalString() +
                "::withdrawal: " + this.withdrawal);
    }

//    @Override
//    public int compareTo(Account account) {
//        return super.compareTo(account);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
}
