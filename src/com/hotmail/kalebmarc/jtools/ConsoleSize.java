package com.hotmail.kalebmarc.jtools;

/**
 * <p>
 *      This class contains X and Y values for a size of something.
 *      Meant to use with ConsoleFrame, for example:
 * 
 *      <i>ConsoleFrame.setSize(ConsoleSize)</i>
 * 
 *       instead of
 * 
 *      <i>ConsoleFrame.setSize(int x, int y)</i>
 * </p>
 *
 * <p>
 *      It's also useful when getting values, as <i>ConsoleFrame.getSize()</i>
 *      returns ConsoleSize, so you can use <i>cFrame.getSize.getX()</i> or <i>cFrame.getSize.getY()</i>
 * </p>
 * @author Kaleb Haslam
 * @version 1.0
 * @since 1.0
 */
public class ConsoleSize {
    
    private int xSize;
    private int ySize;
    
    public ConsoleSize(int x, int y){
        xSize = x;
        ySize = y;
    }

    /**
     * 
     * @return the x value
     */
    public int getX(){
        return xSize;
    }

    /**
     * 
     * @return the y value
     */
    public int getY(){
        return ySize;
    }

    /**
     * 
     * @param size the value you want to set as the xSize
     */
    public void setX(int size){
        xSize = size;
    }

    /**
     * 
     * @param size the value you want to set as the ySize
     */
    public void setY(int size){
        ySize = size;
    }

    /**
     *
     * @param x the x value
     * @param y the y value
     */
    public void set(int x, int y){
        xSize = x;
        ySize = y;
    }
}
