
/**
 Data.java defines the Date object and implements Date constructors, along with
 methods to compare dates, change dates, and check the validity of a date.
 @author Khushi Ranpura
 */

package p2;
import java.util.Calendar;
public class Date implements Comparable<Date> {
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int APRIL = 4;
    private static final int JUNE = 6;
    private static final int SEPTEMBER = 9;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;
    public static final int HOURS_IN_A_DAY = 24;
    public static final int MINUTES_PER_HOUR = 60;
    public static final int SECONDS_PER_MINUTE = 60;
    public static final int MILLISEC_PER_MIN = 1000;
    public static final int LEAP_YEAR_DAYS = 29;
    public static final int NON_LEAP_YEAR_DAYS = 28;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int MIN_DAYS = 1;
    public static final int MAX_30_DAYS = 30;
    public static final int MAX_31_DAYS = 31;
    private int year;
    private int month;
    private int day;

    /**
     * Returns the day of the Date object it is called on.
     *
     * @return day.
     */
    public int getDay() {
        return day;
    }

    /**
     * Returns the month of the Date object it is called on.
     *
     * @return month.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the year of the Date object it is called on.
     *
     * @return year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the day value of a Date object.
     *
     * @param day the new day value of the Date object.
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Sets the month value of a Date object.
     *
     * @param month the new month value of the Date object.
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Sets the year value of a Date object.
     *
     * @param year the new year value of the Date object.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Default Date constructor that creates a new Date object
     * initialized to current date and time.
     */
    public Date() {
        Calendar calendar = Calendar.getInstance();

        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Date constructor that creates a new Date object when parameters are passed in.
     *
     * @param month the month of the new date object
     * @param day   the day of the new date object
     * @param year  the year of the new date object
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * Checks validity of a date object.
     *
     * @return true if the date is valid, false otherwise.
     */
    public boolean isValid() {
        if (this.month >= JANUARY && this.month <= DECEMBER) {
            if (this.month == FEBRUARY) {
                if (isLeapYear(this.year)) {
                    return (this.day >= MIN_DAYS && this.day <= LEAP_YEAR_DAYS);
                } else {
                    return (this.day >= MIN_DAYS && this.day <= NON_LEAP_YEAR_DAYS);
                }
            } else if (this.month == APRIL || this.month == JUNE || this.month == SEPTEMBER || this.month == NOVEMBER) {
                return (this.day >= MIN_DAYS && this.day <= MAX_30_DAYS);
            } else //all other months have 31 days
            {
                return (this.day >= MIN_DAYS && day <= MAX_31_DAYS);
            }
        } else {
            return false;
        }
    }

    /**
     * Compares two dates based on month, day, and year.
     * Calculates difference in dates if they are not equal.
     *
     * @param otherDate the Date object to compare the initial Date to.
     * @return 0 if the dates are equal, otherwise the difference between the two dates in days.
     */
    @Override
    public int compareTo(Date otherDate) {
        if (this.year != otherDate.year || this.month != otherDate.month || this.day != otherDate.day) {
            Calendar thisDate = Calendar.getInstance();
            thisDate.set(this.year, this.month, this.day);

            Calendar other = Calendar.getInstance();
            other.set(otherDate.year, otherDate.month, otherDate.day);
            long thisDateTimeInMillis = thisDate.getTimeInMillis();
            long otherDateTimeInMillis = other.getTimeInMillis();
            long daysDifference = (otherDateTimeInMillis - thisDateTimeInMillis) /
                    (HOURS_IN_A_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE * MILLISEC_PER_MIN);
            return ((int) daysDifference);
        } else {
            return 0;
        }
    }

    /**
     * Checks if a particular year is a leap year.
     *
     * @param year the year to check for being a leap year.
     * @return true if it is a leap year, false otherwise.
     */
    private boolean isLeapYear(int year) {
        if (year % QUADRENNIAL == 0) {
            if (year % CENTENNIAL == 0) {
                return (year % QUATERCENTENNIAL == 0);
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * public toString method to return a Date's month, date, year
     * attributes formatted as a date.
     *
     * @return a string containing formatted date
     */
    @Override
    public String toString() {
        return (this.month + "/" + this.day + "/" + this.year);
    }

}
