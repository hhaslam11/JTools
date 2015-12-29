package com.hotmail.kalebmarc.jtools;

/**
 * This class is solely used for testing purposes, and such, should NOT exist in the final build.
 */
public class Test {

    public static void main(String args[]){

        for(int i = 0; i <= 1000; i++){
            System.out.println(Random.rIntEven(5, 5));
        }
    }
}
