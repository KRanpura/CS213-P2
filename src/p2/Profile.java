package p2;

public class Profile implements Comparable<Profile>
{
    private String fname;
    private String lname;
    private Date dob;

    @Override
    public int compareTo(Object object)
    {
        return 0; //placeholder
    }

    public static class RunProject2
    {
        public static void main(String[] args)
        {
            new TransactionManager().run();
        }

    }
}

//commented out to get rid of errors
