package p2;

import org.junit.Test;

import static org.junit.Assert.*;

public class isValidJUnitTest {

    @org.junit.Test
    public void testFebDays_NonLeap()
    {
        Date date = new Date(2, 29, 2011);
        assertFalse(date.isValid());
    }

    @org.junit.Test
    public void testFebDays_Leap()
    {
        Date date = new Date(2,29,2012);
        assertTrue(date.isValid());
    }

    @org.junit.Test
    public void testMonth_OutOfRange()
    {
        Date date = new Date(17, 2, 2018);
        assertFalse(date.isValid());
    }

    @org.junit.Test
    public void testMonthsWith31Days()
    {
        Date date = new Date(3, 32, 2023);
        assertFalse(date.isValid());
    }

    @org.junit.Test
    public void testMonthsWith30Days()
    {
        Date date = new Date(11, 31, 2023);
        assertFalse(date.isValid());
    }

    @org.junit.Test
    public void testDay_OutOfRange()
    {
        Date date = new Date(11, 0, 2023);
        assertFalse(date.isValid());
    }

    @org.junit.Test
    public void testDay_InRange()
    {
        Date date = new Date(8,11,2024);
        assertTrue(date.isValid());
    }
}