package p2;
import java.util.Objects;
import java.util.Scanner;
public class TransactionManager
{

    private void openHelper(String[] openBank)
    {
        if (openBank.length < 5) {
            System.out.println("Missing data for opening an account.");
            return;
        }
        //all of them require first name, last name, DOB, intial deposit
        String accountType = openBank[0]; //C, CC, S, MM

        //first name
        String firstName = openBank[1];
        String lastName = openBank[2];
        String dateStr = openBank[3];
        int month = Integer.parseInt(dateStr.split("/")[0]);
        int day = Integer.parseInt(dateStr.split("/")[1]);
        int year = Integer.parseInt(dateStr.split("/")[2]);
        Date dob = new Date(month, day, year);
        if (!validDOB(dob))
        {
            return;
        }

    }
    private boolean validDOB(Date eventDate)
    {
        Date today = new Date();
        if (!eventDate.isValid())
        {
            System.out.println(eventDate.toString() + " not a valid calendar date!");
            return false;
        }
        else if (eventDate.compareTo(today) < 0)
        {
            System.out.println(eventDate.toString() + " cannot be today or a future day.");
            return false;
        }
        else
        {
            return true;
        }
    }
    public void run ()
    {
//        p2.TransactionManager class. This is the user interface class that processes the transactions entered on the
//            terminal and performs all Input/Ouput. This class handles all Java exceptions and invalid data before it
//            calls the methods in p2.AccountDatabase class to complete the transactions. For example,
//        InputMismatchException, NumberFormatException, NoSuchElementException, invalid dates of birth,
//            invalid campus codes, and invalid amounts. Whenever there is an exception or invalid data, display a
//        message on the terminal. See the Project2ExpectedOutput.txt for the proper messages to display. -2 points
//        for each exception not caught or invalid data not checked in this class or messages not displayed. You must
//        include a run() method to process the command lines. You will lose 5 points for not including this method,
//            or the method exceed 40 lines.

        System.out.println("Task Manager is running.");
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while(scanner.hasNextLine() && isRunning) {
            String line = scanner.nextLine().trim(); // Read the entire line
            if (!line.isEmpty()) {
                String[] commandAndArgs = line.split(" ", 2); // Split the line into command and arguments
                String command = commandAndArgs[0];
                String bankString = (commandAndArgs.length > 1) ? commandAndArgs[1] : "";
                switch (command) {
                    case "O":
                        openHelper(bankString.split("\\s+"));
                        break;
                    case "C":
                        //fill in
                    case "D":
                        //fill in
                    case "W":
                        //fill in
                    case "P":
                        //fill in
                    case "PI":
                        //fill
                    case "UB":
                        //fill in
                    case "Q":
                        isRunning= false;
                        break;
                    default:
                        System.out.println("Invalid command!");

                }

            }
        }
    }


}
