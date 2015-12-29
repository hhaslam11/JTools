package com.hotmail.kalebmarc.jtools;

import javax.swing.JOptionPane;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Contains a variety of methods to handle errors in different ways.
 * Recommended to use in a try-catch block.
 *
 * @author Kaleb Haslam
 * @version 1.0
 * @since 1.0
 */
public class HandleError {

    private static String getErrorMsg(Exception e){

        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return "Looks like something went wrong!\n\n" +
                "Short Description:\n" +
                e.getLocalizedMessage() + "\n\n" +
                "More details: \n" +
                sw.toString();

    }

    /**
     * <h1>Popup full</h1>
     * <p>Opens a popup window saying there's an error, and displays the stacktrace.</p>
     *
     * @param e The caught exception
     */
    public static void popup(Exception e){

        JOptionPane.showMessageDialog(null, getErrorMsg(e), "An error has occurred", JOptionPane.WARNING_MESSAGE);

    }

    /**
     * <h1>Console full</h1>
     * <p>Prints to the console saying there's an error, then prints the stacktrace.</p>
     *
     * @param e The caught exception
     */
    public static void printConsole(Exception e){

        System.err.println(getErrorMsg(e));

    }

    /**
     * <h1>Popup and console full</h1>
     * <p>Opens a popup window as well as printing to the console, saying there's an error, and displays the stacktrace.</p>
     *
     * @param e The caught exception
     */
    public static void popupAndConsole(Exception e){

        System.err.println(getErrorMsg(e));
        JOptionPane.showMessageDialog(null, getErrorMsg(e), "An error has occurred", JOptionPane.WARNING_MESSAGE);

    }

    /**
     * <h1>Popup Custom text</h1>
     * <p>Opens a popup window with a custom error message. Does not show stacktrace unless you include it in the string.</p>
     *
     * @param message Your custom error message
     */
    public static void popupCustom(String message){

        //Yes, you could do this directly, but its easier/cleaner to use HandleError.popupCustom(msg);
        JOptionPane.showMessageDialog(null, message, "An error has occurred", JOptionPane.WARNING_MESSAGE);

    }

    /**
     * <h1>Print Console Custom text</h1>
     * <p>Prints to the console a custom error message. Does not show stacktrace unless you include it in the string.</p>
     *
     * @param message Your custom error message
     */
    public static void printConsoleCustom(String message){

        //TODO Maybe add more functionality to this method, since it'd make more sense to do this directly
        System.err.println(message);

    }

    /**
     * <h1>Popup and Console Custom text</h1>
     * <p>Displays both a popup window, and prints to console a custom error message. Does not show stacktrace unless you include it in the string.</p>
     *
     * @param message Your custom error message
     */
    public static void popupAndConsoleCustom(String message){

        System.err.println(message);
        JOptionPane.showMessageDialog(null, message, "An error has occurred", JOptionPane.WARNING_MESSAGE);

    }

    /**
     * <h1>Popup Plain</h1>
     * <p>Opens a popup window saying there's an error. Does not show stacktrace</p>
     */
    public static void popup(){

        JOptionPane.showMessageDialog(null, "Something went wrong.", "An error has occurred", JOptionPane.WARNING_MESSAGE);

    }

    /**
     * <h1>Print console Plain</h1>
     * <p>Prints a message to the console saying there's an error. Does not show stacktrace</p>
     */
    public static void printConsole(){

        System.err.println("An error has occurred");

    }

    /**
     * <h1>Popup and Console Plain</h1>
     * <p>Opens a popup window, and prints to the console saying there's an error. Does not show stacktrace</p>
     */
    public static void popupAndConsole(){

        System.err.println("An error has occurred");
        JOptionPane.showMessageDialog(null, "Something went wrong.", "An error has occurred", JOptionPane.WARNING_MESSAGE);

    }

    /**
     * <h1>Get Error Message</h1>
     * <p>Returns full error message as a string. The template for the error message is:
     *    <i>
     *      <br />
     *      Looks like something went wrong!
     *      <br /><br />
     *      Short Description:<br />
     *      [Description of error]
     *      <br /><br />
     *      More Details:<br />
     *      [Stack Trace]
     *    </i>
     * </p>
     * @param e The caught exception
     * @return a full error message as a String
     * @see HandleError#popup(Exception)
     * @see HandleError#printConsole(Exception)
     * @see HandleError#popupAndConsole(Exception)
     *
     */
    public static String getMessage(Exception e){
        return getErrorMsg(e);
    }
}
