/**
 * Profile.java defines constructors and methods to create a new
 * user profile as well as accessing, updating, or comparing atrributes
 * of the user profile.
 * @author Khushi Ranpura
 */

package p2;

public class Profile implements Comparable<Profile>
{
    private String fname;
    private String lname;
    private Date dob;

    private static final int SAME_PROFILE = 0;
    private static final int DIFF_LNAME= 1;
    private static final int DIFF_FNAME = 2;
    private static final int DIFF_DOB = 3;

    /**
     * Constructor to create a new instance of Profile, and initialize
     * its instance variables
     * @param first user's first name
     * @param last user's last name
     * @param birthday user's birthday
     */
    public Profile (String first, String last, Date birthday)
    {
        this.fname = first;
        this.lname = last;
        this.dob = birthday;
    }

    /**
     * Setter method to update first name of a user.
     * @param first new first name
     */
    public void setFname(String first)
    {
        this.fname= first;
    }

    /**
     * Setter method to update last name of a user.
     * @param last new last name
     */
    public void setLname(String last)
    {
        this.lname = last;
    }

    /**
     * Setter method to update dob of a user.
     * @param date new dob
     */
    public void setDob(Date date)
    {
        this.dob = date;
    }

    /**
     * Getter method to access dob of a user
     * @return dob
     */
    public Date getDob()
    {
        return dob;
    }

    /**
     * Getter method to access first name of a user
     * @return fname
     */
    public String getFname()
    {
        return fname;
    }

    /**
     * Getter method to access last name of a user
     * @return lname
     */
    public String getLname()
    {
        return lname;
    }

    /**
     * Compares whether two profiles are equal, meaning they have
     * the same first name, last name, and dob.
     * @param profile the object to be compared.
     * @return 0 if equal profiles,
     *         DIFF_DOB for different dob,
     *         DIFF_FNAME for different fname,
     *         DIFF_LNAME for different lname
     */
    @Override
    public int compareTo(Profile profile)
    {
        if (this.lname.equals(profile.getLname()))
        {
            if (this.fname.equals(profile.getFname()))
            {
                if (this.dob.equals(profile.getDob()))
                {
                    return SAME_PROFILE;
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

    /**
     * Calls compareTo method to check if two profiles are equal
     * @param obj
     * @return true if two profiles are equal, else false.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Profile)
        {
            Profile profile = (Profile) obj;
            if (this.compareTo(profile) == SAME_PROFILE)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}