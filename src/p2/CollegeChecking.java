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
        return 1.0; //placeholder
    }

    public double monthlyFee()
    {
        return 1.0; //placeholder
    }
}

