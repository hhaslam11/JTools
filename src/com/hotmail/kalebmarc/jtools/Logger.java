package com.hotmail.kalebmarc.jtools;

import java.io.File;
import java.io.PrintStream;
import java.util.Date;

/**
 * This class is meant to be used to <i>log</i> data to a ConsoleFrame, the console/terminal,
 * a text file, or some/all of these.
 *
 * @author Kaleb Haslam
 * @version 1.0
 * @since 1.0
 */
public class Logger {

    private ConsoleFrame attachedConsoleFrame;
    private File attachedFile;
    private PrintStream output;

    private boolean timeDisplay     = false;
    private boolean logConsole      = true;
    private boolean logConsoleFrame = false;
    private boolean logFile         = false;

    public Logger(){}

    /**
     * Use this to attach a ConsoleFrame to the current Logger.
     * Attaching a ConsoleFrame will display logs to the attached
     * ConsoleFrame. It can be toggled by calling setLogToConsoleFrame(boolean).
     * It's enabled by default when you first attach a ConsoleFrame.
     * @param frame the frame to be attached to the log
     * @see Logger#setLogToConsoleFrame(boolean)
     */
    public void addConsoleFrame(ConsoleFrame frame){
        this.attachedConsoleFrame = frame;
        this.logConsoleFrame = true;
    }

    /**
     * Use this to attach a File to the current Logger.
     * Attaching a File will display logs to the attached
     * File. It can be toggled by calling setLogToFile(boolean).
     * It's enabled by default when you first attach a File.
     * @param file the path to the file you want to log to (In String format)
     * @see Logger#setLogToFile(boolean)
     */
    public void addLogFile(String file){

        try{

            //Convert file to File, then set as this.attachedFile
            this.attachedFile = new File(file);

            //Create file
            this.output = new PrintStream(this.attachedFile);

            this.logFile = true;

        }catch (Exception e){
            HandleError.printConsole(e);
        }

    }

    /**
     * Prints a log to all enabled outputs.
     * @param message The log to be displayed/printed
     */
    public void print(String message){
        //Build log
        String log = "";
        if(this.timeDisplay){
            Date date = new Date();
            log = String.format("%tT ", date);
            log += ": ";
        }
        log += message;
        this.log(log);
    }

    /**
     * Prints a log to all enabled outputs.
     * @param message The log to be displayed/printed
     */
    public void println(String message){
        //Build log
        String log = "";
        if(this.timeDisplay){
            Date date = new Date();
            log = String.format("%tT ", date);
            log += ": ";
        }
        log += message;
        log += "\n";
        this.log(log);
    }

    /**
     * Prints a log to all enabled outputs, with a tag in front of it.
     * @param message The log to be displayed/printed
     * @param tag The text you want to be displayed in the tag
     */
    public void print(String message, String tag){
        //Build log
        String log = "";
        if(this.timeDisplay){
            Date date = new Date();
            log = String.format("%tT ", date);
        }
        log += "[" + tag.toUpperCase() + "]";
        log += ": " + message;
        this.log(log);
    }

    /**
     * Prints a log to all enabled outputs, with a tag in front of it.
     * @param message The log to be displayed/printed
     * @param tag The text you want to be displayed in the tag
     */
    public void println(String message, String tag){
        //Build log
        String log = "";
        if(this.timeDisplay){
            Date date = new Date();
            log = String.format("%tT ", date);
        }
        log += "[" + tag.toUpperCase() + "]";
        log += ": " + message;
        log += "\n";
        this.log(log);
    }

    /**
     * Prints a log to all enabled outputs, with a tag in front of it.
     * @param message The log to be displayed/printed
     * @param tag The Tag you want to be displayed
     */
    public void print(String message, Tag tag){
        //Build log
        String log = "";
        if(this.timeDisplay){
            Date date = new Date();
            log = String.format("%tT ", date);
        }
        log += tag.get();
        log += ": " + message;
        this.log(log);
    }

    /**
     * Prints a log to all enabled outputs, with a tag in front of it.
     * @param message The log to be displayed/printed
     * @param tag The Tag you want to be displayed
     */
    public void println(String message, Tag tag){
        //Build log
        String log = "";
        if(this.timeDisplay){
            Date date = new Date();
            log = String.format("%tT ", date);
        }
        log += tag.get();
        log += ": " + message;
        log += "\n";
        this.log(log);
    }

    private void log(String log){
        //Log to console
        if(this.logConsole){
            System.out.print(log);
        }

        //Log to ConsoleFrame
        if(this.logConsoleFrame){
            this.attachedConsoleFrame.print(log);
        }

        //Log to File
        if(this.logFile){
            this.output.print(log);
        }
    }

    /**
     *
     * @param timeDisplay enable/disable Time Display
     */
    public void setTimeDisplay(boolean timeDisplay){
        this.timeDisplay = timeDisplay;
    }
    public boolean isTimeDisplayEnabled(){
        return this.timeDisplay;
    }

    /**
     * Set whether or not to log to the console/terminal/command line
     * Enabled by default
     */
    public void setLogToConsole(boolean logToConsole){
        this.logConsole = logToConsole;
    }

    /**
     *
     * @return true if logToConsole is enabled
     */
    public boolean isLogToConsoleEnabled(){
        return this.logConsole;
    }

    /**
     * Set whether or not to log to a log file
     * Disabled by default
     */
    public void setLogToFile(boolean logToFile){
        if(this.attachedFile == null) return;
        this.logFile = logToFile;
    }

    /**
     *
     * @return true if logToFile is enabled
     */
    public boolean isLogToFileEnabled(){
        return this.logFile;
    }

    /**
     * Set whether or not to log to a ConsoleFrame
     * Disabled by default
     */
    public void setLogToConsoleFrame(boolean logToConsoleFrame){
        if(this.attachedConsoleFrame == null) return;
        this.logConsoleFrame = logToConsoleFrame;
    }

    /**
     *
     * @return true if logToConsoleFrame is enabled
     */
    public boolean isLogToConsoleFrameEnabled(){
        return logConsoleFrame;
    }
}
