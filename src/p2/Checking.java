/**
 * Checking.java defines the Checking subclass of Account and
 * implements methods to calculate fees and interest, and to print
 * account information.
 * @author Khushi Ranpura
 */

package p2;

public class Checking extends Account {
    private static final double MONTHLY_FEE_IN_DOLLARS = 12;
    protected static final double ANNUAL_INTEREST_RATE = 0.010;

    /**
     * Constructor to make a new instance of the Checking account class.
     * @param accHolder  account holder of new Checking account
     * @param accBalance balance of new checking account
     */
    public Checking(Profile accHolder, double accBalance) {
        super(accHolder, accBalance);
    }

    /**
     * Calculates the monthly interest for the checking account
     * it is called on.
     * @return interest amount as a double
     */
    public double monthlyInterest() {
        return (this.balance * (ANNUAL_INTEREST_RATE / MONTHS));
    }

    /**
     * Calculates the monthly fees for the checking account
     * it is called on.
     * @return fee amount as a double
     */
    public double monthlyFee() {
        if (this.getClass() == CollegeChecking.class || this.balance > 1000) {
            return 0.0;
        } else {
            return MONTHLY_FEE_IN_DOLLARS;
        }
    }

    /**
     * Helper method that returns the type of the account as a String for printing purposes.
     * @return type as a String
     */
    public String getType() {
        return "Checking";
    }

    /**
     * Helper method that returns the initials of the type of the account as a String
     * for printing purposes.
     * @return type initial as a string
     */
    public String getTypeInitial() {
        return "C";
    }

    /**
     * toString method to format the account for printing.
     * @return formatted account String
     */
    @Override
    public String toString() {
        return (this.getType() + "::" + this.getHolder().getFname() + " " +
                this.getHolder().getLname() + " " + this.getHolder().getDob().toString() + " " +
                "::Balance: $" + format(this.getBalance()));
    }

}
