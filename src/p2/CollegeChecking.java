/**
 * CollegeChecking.java defines the CollegeChecking subclass of Checking and
 * implements methods to calculate fees and interest, and to print
 * account information.
 * @author Khushi Ranpura
 */
package p2;

public class CollegeChecking extends Checking
{
    private Campus campus; //campus code

    /**
     * Constructor to create a new instance of the CollegeChecking account class.
     * @param accHolder account holder
     * @param accBalance balance of new account
     * @param campus campus associated with new account
     */
    public CollegeChecking(Profile accHolder, double accBalance, Campus campus)
    {
        super(accHolder, accBalance);
        this.campus = campus;
    }

    /**
     * Calculates the monthly interest for the college checking account
     * it is called on.
     * @return interest amount as a double
     */
    public double monthlyInterest()
    {
        return super.monthlyInterest();
    }

    /**
     * Calculates the monthly fees for the college checking account
     * it is called on.
     * @return fee amount as a double
     */
    public double monthlyFee()
    {
        return super.monthlyFee();
    }

    /**
     * Getter method to access the campus attribute of the College Checking account.
     * @return campus
     */
    public Campus getCampus()
    {
        return this.campus; //campus is an enum constant
    }

    /**
     * Helper method that returns the type of the account as a String for printing purposes.
     * @return type as a String
     */
    public String getType()
    {
        return "College Checking";
    }

    /**
     * Helper method that returns the initials of the type of the account as a String
     * for printing purposes.
     * @return type initial as a string
     */
    public String getTypeInitial() { return "CC";}

    /**
     * toString method to format the account for printing.
     * @return formatted account String
     */
    @Override
    public String toString()
    {
        String campusString = (this.campus != null) ? this.getCampus().toString() : "N/A";
        return (this.getType() + "::" + this.getHolder().getFname() + " " +
                this.getHolder().getLname() + " " + this.getHolder().getDob().toString() +
                "::Balance: $" + format(this.getBalance()) + "::" + campusString);
    }

}

