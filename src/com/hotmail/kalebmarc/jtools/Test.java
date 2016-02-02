package com.hotmail.kalebmarc.jtools;

/**
 * This class is solely used for testing purposes, and such, should NOT exist in the final build.
 */
public class Test {

    public static void main(String args[]){

        ConsoleFrame f = new ConsoleFrame();
        f.setVisible(true);

        while(true){
            f.println(f.getInt());
        }
    }
}
