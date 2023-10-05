package p2;

public class Profile implements Comparable<Profile>
{
    private String fname;
    private String lname;
    private Date dob;

    public Profile (String first, String last, Date birthday)
    {
        this.fname = first;
        this.lname = last;
        this.dob = birthday;
    }
    @Override
    public int compareTo(Profile profile)
    {
        if (this.fname.equals(profile.fname) && this.lname.equals(profile.lname) &&
                this.dob.equals(profile.dob))
            return 0;
        else
            return -1;
    }
}