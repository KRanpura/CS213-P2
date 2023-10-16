/**
 * Campus.java is an enum class that defines campus constants
 * associated with CollegeChecking accounts, and ways to access
 * and update them.
 * @author Khushi Ranpura
 */
package p2;
public enum Campus
{
    NEW_BRUNSWICK(0),
    NEWARK(1),
    CAMDEN(2);
    private int campusCode;

    private Campus(int code)
    {
        this.campusCode = code;
    }

    public int getCampusCode()
    {
        return this.campusCode;
    }
}
