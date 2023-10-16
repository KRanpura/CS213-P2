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

    /**
     * Private constructor to intialize new Campus enum
     * @param code code of Campus enum
     */
    private Campus(int code)
    {
        this.campusCode = code;
    }

    /**
     * Getter method to access campus code of campus enum
     * @return campusCode
     */
    public int getCampusCode()
    {
        return this.campusCode;
    }
}
