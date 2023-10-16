package p2;

import org.junit.Test;

import static org.junit.Assert.*;

public class closejUnitTest
{
    @Test
    public void closePass() //valid
    {
        Date date = new Date(11, 10, 2001);
        Profile p = new Profile("Kusum", "Gandham", date);
        Checking checking = new Checking(p, 2000);
        AccountDatabase db = new AccountDatabase();
        db.open(checking);
        assertTrue(db.close(checking));
    }

    @Test
    public void closeFail() //invalid
    {
        Date date = new Date(11, 10, 2001);
        Profile p = new Profile("Kusum", "Gandham", date);
        Checking checking = new Checking(p, 2000);
        AccountDatabase db = new AccountDatabase();
        assertFalse(db.close(checking));
    }
}