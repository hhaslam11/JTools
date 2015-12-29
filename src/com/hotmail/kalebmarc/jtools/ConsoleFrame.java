package com.hotmail.kalebmarc.jtools;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * Creates a terminal-like frame for making console-based programs.
 * The user can enter commands(or anything, really) and your program can do what it needs to
 * depending on what commands the user enters.
 *
 * You can also output whatever text you want to the console.
 *
 * There's a couple advantages to using this over running console-based programs from a normal console
 * <ul>
 *     <li>This comes with an easy way to clear the output text</li>
 *     <li>The user can simply click on the executable .jar file, instead of running it from a terminal</li>
 * </ul>
 *
 * @see ConsoleFrame#cls()
 * @see ConsoleFrame#getInput()
 *
 * @author Kaleb Haslam
 * @version 1.0
 * @since 1.0
 */
public class ConsoleFrame {

    //Variables so program can stop and wait for user input when needed
    private final Object lock = new Object();
    private volatile boolean enterPressed = false;
    private String userInput;

    private boolean quitEnabled;

    private final JFrame frame            = new JFrame();
    private final JTextArea output        = new JTextArea();
    private final JTextField input        = new JTextField();
    private final BoxLayout boxLayout     = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
    private final JScrollPane scrollPane  = new JScrollPane(output);
    private final DefaultCaret caret      = (DefaultCaret)output.getCaret();
    private final ConsoleSize defaultSize = new ConsoleSize(500, 250);
    private final ConsoleSize maxSize     = new ConsoleSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private final MouseListener mouse     = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            input.grabFocus();
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    };
    private Action action = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e) {

            userInput = input.getText();
            input.setText("");
            synchronized (lock){
                enterPressed = true;
                lock.notify();
            }

        }
    };

    public ConsoleFrame(){

        input.addActionListener(action);
        output.addMouseListener(mouse);
        input.setMaximumSize(new Dimension(Integer.MAX_VALUE, 10));
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        output.setEditable(false);
        output.setAutoscrolls(true);
        frame.setLayout(boxLayout);
        frame.add(scrollPane);
        frame.add(input);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(defaultSize);
        frame.setLocationRelativeTo(null);

    }

    public ConsoleFrame(String title){

        input.addActionListener(action);
        input.setMaximumSize(new Dimension(Integer.MAX_VALUE, 10));
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        output.setEditable(false);
        output.setAutoscrolls(true);
        frame.setLayout(boxLayout);
        frame.add(scrollPane);
        frame.add(input);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(defaultSize);
        frame.setLocationRelativeTo(null);

    }

    /**
     * Clears the output
     */
    public void cls(){
        output.setText("");
    }

    /**
     * Prints a String to the console and stays on the same line
     *
     * @param message the String you want to print
     */
    public void print(String message){
        output.append(message);
    }

    /**
     * Prints a String to the console and goes down a line
     *
     * @param message the String you want to print
     */
    public void println(String message){
        output.append(message + "\n");
    }

    public void println(){
        output.append("\n");
    }

    public void println(int message){
        output.append(message + "\n");
    }
    public void print(int message){
        output.append(message + "");
    }

    /**
     * Replaces all the text in the console with a String
     *
     * @param text the String you want to display
     */
    public void setText(String text){
        output.setText(text);
    }

    /**
     * @return The current text in the console
     */
    public String getText(){
        return output.getText();
    }

    /**
     * Sets the size of the ConsoleFrame
     * @param x the width of the frame
     * @param y the height of the frame
     */
    public void setSize(int x, int y){
        frame.setSize(x, y);
        defaultSize.set(x, y);
    }

    /**
     * Sets the size of the ConsoleFrame
     * @param size ConsoleSize that contains the x and y values
     */
    public void setSize(ConsoleSize size){
        frame.setSize(size.getX(), size.getY());
        defaultSize.set(size.getX(), size.getY());
    }

    /**
     * Sets the width of the frame
     * @param x width you want the frame to be
     */
    public void setSizeX(int x){
        frame.setSize(x, frame.getY());
        defaultSize.setX(x);
    }

    /**
     * Sets the height of the frame
     * @param y height you want the frame to be
     */
    public void setSizeY(int y){
        frame.setSize(frame.getX(), y);
        defaultSize.setY(y);
    }

    /**
     * Use as frame.getSize.getX(); or frame.getSize.getY();
     * @return ConsoleSize The size of the frame
     * @see ConsoleSize#getX
     * @see ConsoleSize#getY
     */
    public ConsoleSize getSize(){
        return defaultSize;
    }

    /**
     * Sets the max size the frame can be
     * @param x max width
     * @param y max height
     */
    public void setMaxSize(int x, int y){
        frame.setMaximumSize(new Dimension(x, y));
        maxSize.set(x, y);
    }

    /**
     * Sets the max size of the ConsoleFrame
     * @param size ConsoleSize that contains the x and y values
     */
    public void setMaxSize(ConsoleSize size){
        frame.setMaximumSize(new Dimension(size.getX(), size.getY()));
        maxSize.set(size.getX(), size.getY());
    }

    /**
     * Sets the max width
     * @param x width
     */
    public void setMaxX(int x){
        frame.setMaximumSize(new Dimension(x, maxSize.getY()));
        maxSize.setX(x);
    }

    /**
     * Sets the max height
     * @param y height
     */
    public void setMaxY(int y){
        frame.setMaximumSize(new Dimension(maxSize.getX(), y));
        maxSize.setY(y);
    }

    /**
     * Get the max size the frame can be
     * @return ConsoleSize The max size of the frame
     * @see ConsoleSize#getX
     * @see ConsoleSize#getY
     */
    public ConsoleSize getMaxSize(){
        return maxSize;
    }

    /**
     * Get the max width
     * @return the max width
     */
    public int getMaxX(){
        return maxSize.getX();
    }

    /**
     * Get the max height
     * @return the max height
     */
    public int getMaxY(){
        return maxSize.getY();
    }

    /**
     * Sets whether or not the user can resize the frame
     * @param resizable is resizing allowed
     */
    public void setResizable(boolean resizable){
        frame.setResizable(resizable);
    }

    /**
     *
     * @return if the user can reset the frame or not
     */
    public boolean isResizable(){
        return frame.isResizable();
    }

    /**
     * Sets the location the frame is on the screen
     * @param x the x location
     * @param y the y location
     */
    public void setLocation(int x, int y){
        frame.setLocation(x, y);
    }

    /**
     * Gets the x location of the console
     * @return x location
     */
    public int getLocationX(){
        return frame.getX();
    }

    /**
     * Gets the y location of the console
     * @return y location
     */
    public int getLocationY(){
        return frame.getY();
    }

    /**
     * Moves the frame back to it's initial location (In the center of the screen)
     */
    public void resetLocation(){
        frame.setLocationRelativeTo(null);
    }

    /**
     * Sets the title of the window
     * @param title the title
     */
    public void setTitle(String title){
        frame.setTitle(title);
    }

    /**
     * Get the current title
     * @return the current title
     */
    public String getTitle(){
        return frame.getTitle();
    }

    /**
     * Sets whether or not the frame is visible
     * @param visible the visibility of the frame
     */
    public void setVisible(boolean visible){
        frame.setVisible(visible);
    }

    /**
     * @return true if the frame is visible
     */
    public boolean isVisible(){
        return frame.isVisible();
    }

    /**
     * If quit is disabled, the user will not be able to close the frame using the X button
     * (They would have to force close it)
     * @param quitEnabled disable quit?
     */
    public void setQuitEnabled(boolean quitEnabled){
        this.quitEnabled = quitEnabled;
        if(quitEnabled){
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }else{
            frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }

    /**
     * Get whether or not quit is enabled
     * @return false if quit is disabled
     */
    public boolean isQuitEnabled(){
        return quitEnabled;
    }

    /**
     * Disposes the frame
     * (Closes the frame)
     */
    public void dispose(){
        frame.setVisible(false);
        frame.dispose();
    }

    /**
     * <p>Waits for user to enter something in the console, and returns it as a String.</p>
     * @return an inputted String from user
     */
    public String getInput(){

        synchronized (lock){
            while(!enterPressed){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String temp = userInput;
            userInput = "";
            enterPressed = false;
            return temp;
        }
    }
}
