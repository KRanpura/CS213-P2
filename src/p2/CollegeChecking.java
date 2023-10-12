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

    @Override
    public String toString()
    {
        return (this.getType() + "::" + this.getHolder().getFname() + " " +
                this.getHolder().getLname() + " " + this.getHolder().getDob().toString() + " " +
                "::Balance: $" + this.getBalance() + "::" + this.getCampus());
    }
}

