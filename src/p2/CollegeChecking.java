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

    public CollegeChecking(Profile accHolder, double accBalance, Campus campus)
    {
        super(accHolder, accBalance);
        this.campus = campus;
    }
    public double monthlyInterest()
    {
        return super.monthlyInterest();
    }
    public double monthlyFee()
    {
        return super.monthlyFee();
    }

    public Campus getCampus()
    {
        return this.campus; //campus is an enum constant
    }

    public String getType()
    {
        return "College Checking";
    }

    public String getTypeInitial() { return "CC";}

    @Override
    public String toString()
    {
        String campusString = (this.campus != null) ? this.getCampus().toString() : "N/A";
        return (this.getType() + "::" + this.getHolder().getFname() + " " +
                this.getHolder().getLname() + " " + this.getHolder().getDob().toString() +
                "::Balance: $" + format(this.getBalance()) + "::" + campusString);
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

