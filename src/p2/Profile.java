package p2;

public class Profile implements Comparable<Profile>
{
    private String fname;
    private String lname;
    private Date dob;

    private static final int DIFF_LNAME = 1;
    private static final int DIFF_FNAME = 1;
    private static final int DIFF_DOB = 1;

    public Profile (String first, String last, Date birthday)
    {
        this.fname = first;
        this.lname = last;
        this.dob = birthday;
    }

    public void setFname(String first)
    {
        this.fname= first;
    }

    public void setLname(String last)
    {
        this.lname = last;
    }

    public void setDob(Date date)
    {
        this.dob = date;
    }

    public Date getDob()
    {
        return dob;
    }

    public String getFname()
    {
        return fname;
    }

    public String getLname()
    {
        return lname;
    }

    @Override
    public int compareTo(Profile profile)
    {
        if (this.lname.equals(profile.getLname()))
        {
            if (this.fname.equals(profile.getFname()))
            {
                if (this.dob.equals(profile.getDob()))
                {
                    return 0;
                }
                else
                {
                    return DIFF_DOB;
                }
            }
            else
            {
                return DIFF_FNAME;
            }
        }
        else
        {
            return DIFF_LNAME; // 1
        }

    }
}