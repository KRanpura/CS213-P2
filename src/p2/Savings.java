/**
 * Savings.java defines the Savings subclass of Account and
 * implements methods to calculate fees and interest, and to print
 * account information.
 * @author Khushi Ranpura
 */
package p2;

public class Savings extends Account
{
    protected boolean isLoyal; //loyal customer status
    protected static final double MONTHLY_FEE_IN_DOLLARS = 25;

    private static final double LOYAL_ANNUAL_INTEREST = 0.0425;
    private static final double ANNUAL_INTEREST_RATE = 0.04;


    /**
     * Constructor to create a new instance of the Savings account class and
     * initialize its instance variables.
     * @param accHolder account holder
     * @param balance balance of new account
     * @param loyalStatus loyalty status of new account
     */
    public Savings(Profile accHolder, double balance, boolean loyalStatus)
    {
        super(accHolder, balance);
        this.isLoyal = loyalStatus;
    }

    /**
     * Calculates the monthly interest for the savings account
     * it is called on.
     * @return interest amount as a double
     */
    public double monthlyInterest()
    {
        if (this.isLoyal)
        {
            return (this.balance * (LOYAL_ANNUAL_INTEREST / MONTHS));
        }
        return (this.balance * (ANNUAL_INTEREST_RATE / MONTHS)); //placeholder
    }

    /**
     * Calculates the monthly fees for the savings account
     * it is called on.
     * @return fee amount as a double
     */
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

    /**
     * Helper method that returns the type of the account as a String for printing purposes.
     * @return type as a String
     */
    public String getType()
    {
        return "Savings";
    }

    /**
     * Helper method that returns the initials of the type of the account as a String
     * for printing purposes.
     * @return type initial as a string
     */
    public String getTypeInitial() { return "MM";}

    /**
     * Getter method to get loyalty status of the savings account
     * it is called on.
     * @return loyalty status
     */
    public boolean getLoyal()
    {
        return this.isLoyal;
    }

    /**
     * Setter method to update loyalty status of the savings account it
     * is called on.
     * @param status new loyalty status
     */
    public void setLoyal(boolean status)
    {
        this.isLoyal = status;
    }

    /**
     * Helper method to return loyalty status of the account as a string
     * @return is loyal if loyal, or ""
     */
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

    /**
     * toString method to format the account for printing.
     * @return formatted account String
     */
    @Override
    public String toString()
    {
        return (this.getType() + "::" + this.getHolder().getFname() + " " +
                this.getHolder().getLname() + " " + this.getHolder().getDob().toString() + " " +
                "::Balance: $" + format(this.getBalance()) + "::" + this.getLoyalString());
    }

}
