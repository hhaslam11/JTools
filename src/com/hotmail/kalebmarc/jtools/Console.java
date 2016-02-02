package com.hotmail.kalebmarc.jtools;

/**
 *
 * This class contains multiple tools for use when making command line programs.
 * Useful for getting valid user input from the console.
 *
 * @author Kaleb Haslam
 * @version 1.0
 * @since 1.0
 *
 */

public class Console {

    /**
     * <h1>Clears the console</h1>
     * <p>Prints out 75 blank lines to hide all other text.</p>
     */
    public static void cls(){

        for (int i = 0; i < 75; i++){
            System.out.println();
        }

    }

    /**
     * <h1>Clears the console</h1>
     * <p>Prints out x amount of blank lines to get rid of previous text.
     *    More lines will be slower, but will clear more text.</p>
     *
     * @param linesToPrint amount of blank lines to
     */
    public static void cls(int linesToPrint){

        for (int i = 0; i < linesToPrint; i++){
            System.out.println();
        }

    }

    /**
     * <p>When called, the thread will be paused until the user presses enter. Useful for displaying
     * information and letting the user choose when to continue</p>
     */
    public static void pause(){
        try{

            java.util.Scanner pauseScan = new java.util.Scanner(System.in);
            String temp = pauseScan.nextLine();
            System.out.println(temp);

        }catch (Exception e){
            //Blank for a reason - Not supposed to do anything.
        }
    }

    /**
     * <h1>Get Valid integer</h1>
     * <p>Waits for the user to enter something into the terminal/command prompt,
     *    then checks if it a valid integer. If the input is invalid, it will wait
     *    for the user to enter something again. Will repeat until the user enters
     *    a valid integer, and then returns it. Will not give any errors.</p>
     * @return a valid integer inputted by the user
     */
    public static int getValidInt(){

        java.util.Scanner in = new java.util.Scanner(System.in);

        while(!in.hasNextInt()) {
            in.nextLine();
        }

        return in.nextInt();

    }

    /**
     * <h1>Get Valid double</h1>
     * <p>Waits for the user to enter something into the terminal/command prompt,
     *    then checks if it a valid double. If the input is invalid, it will wait
     *    for the user to enter something again. Will repeat until the user enters
     *    a valid double, and then returns it. Will not give any errors.</p>
     * @return a valid double inputted by the user
     */
    public static double getValidDouble(){

        java.util.Scanner in = new java.util.Scanner(System.in);

        while(!in.hasNextDouble()) {
            in.nextLine();
        }

        return in.nextDouble();

    }

    /**
     * <h1>Get Valid String</h1>
     *
     * <p>Waits for the user to enter something into the terminal/command prompt,
     *    then checks if it a valid String. If the input is invalid, it will wait
     *    for the user to enter something again. Will repeat until the user enters
     *    a valid String, and then returns it. This will also trim all whitespace
     *    before and after the main String. Will not give any errors.</p>
     *
     * @return a valid String inputted by the user
     */
    public static String getValidString(){

        java.util.Scanner in = new java.util.Scanner(System.in);

        while(!in.hasNextLine()) {
            in.nextLine();
        }

        String valid = in.nextLine();
        //in.close();
        return valid.trim();

    }
    /**
     * <h1>Get Valid boolean</h1>
     * <p>Waits for the user to enter something into the terminal/command prompt,
     *    then checks if it a valid boolean. Any of the following is considered valid: <i>(Ignores case)</i>
     *    <ul>
     *        <li>y/n</li>
     *        <li>yes/no</li>
     *        <li>t/f</li>
     *        <li>true/false</li>
     *    </ul>
     *
     *    If the input is invalid, it will wait
     *    for the user to enter something again. Will repeat until the user enters
     *    a valid String, and then returns either true or false. Will not give any errors.</p>
     * @return a valid boolean inputted by the user
     */
    public static boolean getValidBoolean(){

        java.util.Scanner in = new java.util.Scanner(System.in);

        do {//infinite loop, so it will only break if a boolean in returned in Switch statement

            //Gets a valid String
            while (!in.hasNextLine()) {
                in.nextLine();
            }
            String userInput = in.nextLine();
            userInput = userInput.toUpperCase();

            //Test if string is a valid option
            switch(userInput){
                case "Y":
                    //in.close();
                    return true;
                case "N":
                    //in.close();
                    return false;
                case "YES":
                    //in.close();
                    return true;
                case "NO":
                    //in.close();
                    return false;
                case "TRUE":
                    //in.close();
                    return true;
                case "FALSE":
                    //in.close();
                    return false;
            }

        } while (true);

    }
    /**
     * Checks whether an integer is even or not.
     * @param check Number to check if its even
     * @return true if check is an even integer
     */
    public static boolean isEven(int check){
        return ((check % 2) == 0);
    }
    /**
     * Checks whether an integer is odd or not.
     * @param check Number to check if it's odd
     * @return true if check is an odd integer
     */
    public static boolean isOdd(int check){
        return (!((check % 2) == 0));
    }
}