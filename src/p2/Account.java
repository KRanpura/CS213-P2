/**
 * Account.java is a parent class that defines abstract methods and
 * variables for subclasses to access in order to create different
 * types of accounts and compare them.
 * @author Khushi Ranpura, Kusum Gandham
 */

package p2;

import java.text.DecimalFormat;

public abstract class Account implements Comparable<Account>
{
    //protected means only used by subclasses
    protected Profile holder;
    protected double balance;
    protected final static int MONTHS = 12;
    private static final int EQUAL = 0;
    private static final int NOT_EQUAL = 1;

    public static final int DIFF_ACCOUNT = 1;

    public static final int DIFF_PROFILE = 2;


    /**
     * Abstract method to calculate monthlyInterest in an account
     * @return interest amount
     */
    public abstract double monthlyInterest();

    /**
     * Abstract method to calculate monthlyFee in an account
     * @return fee amount
     */
    public abstract double monthlyFee();

    /**
     * Abstract method to return type of account as a String
     * @return type of account
     */
    public abstract String getType();

    /**
     * Abstract method to get initials of account type as a String
     * @return type initials
     */
    public abstract String getTypeInitial();

    /**
     * Abstract method to print an account
     * @return account string
     */
    public abstract String toString();

    /**
     * Account constructor to create a new account.
     * @param accHolder profile of user creating the account
     * @param accBalance balance of new account
     */
    public Account(Profile accHolder, double accBalance)
    {
        this.holder = accHolder;
        this.balance = accBalance;
    }

    /**
     * Method to compare if two accounts are equal based on whether
     * they are the same type of account and have the same profile holder.
     * @param account the object to be compared.
     * @return EQUAL if accounts have same profile and account type,
     *         DIFF_ACCOUNT if same profile and different account type,
     *         DIFF_PROFILE is different user
     */
    @Override
    public int compareTo(Account account) {
        if (this.holder.equals(account.getHolder())) { // Same holder/profile
            if (this.getType().equals(account.getType())) { // Same account type
                return EQUAL;
            } else {
                return DIFF_ACCOUNT;
            }
        } else {
            return DIFF_PROFILE;
        }
    }

    /**
     * Method to checks if two accounts are equal, meaning they are
     * the same type of account with the same user profile.
     * @param obj account to check equality for
     * @return true if accounts are equal, else false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            Account account = (Account) obj;
            return this.compareTo(account) == EQUAL;
        }
        return false;
    }

    /**
     * Getter method that returns profile of account holder.
     * @return holder
     */
    public Profile getHolder()
    {
        return this.holder;
    }

    /**
     * Getter method that returns balance of account.
     * @return balance
     */
    public double getBalance()
    {
        return this.balance;
    }

    /**
     * Setter method that updates balance of account.
     * @param balance new balance
     */
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    /**
     * Helper method to format account balance.
     * @param balance balance to be formatted
     */
    public String format(double balance)
    {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(balance);
    }
}