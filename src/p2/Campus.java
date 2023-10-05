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
