package p2;

public class CollegeChecking extends Checking
{
    private Campus campus; //campus code

    public CollegeChecking(Profile accHolder, double accBalance)
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
}

