package com.hotmail.kalebmarc.jtools;

/**
 *
 * Class containing flexible and efficient methods to obtain pseudorandom integers.
 *
 * @author Kaleb Haslam
 * @version 1.0
 * @since 1.0
 *
 *
 */
public class Random{
        private Random(){}

    /**
     * Returns a pseudorandom anywhere from 1, to max.
     * @param max The max value to return.
     * @return a pseudorandom integer from 1 to max.
     */
     public static int rInt(int max){

         //Make sure the program doesn't crash if user decides to input a negative value
         if(max <= 0){
             HandleError.printConsoleCustom("Error in rInt: Input cannot be a negative value."); //TODO provide better debugging information here.
             return 1;
         }

         java.util.Random ran = new java.util.Random();

         return (ran.nextInt(max) + 1);
     }

    /**
     * Returns a pseudorandom integer from min to max. More useful/flexible than returning a value between
     * 1 and max (You can do that using this method anyways by doing rInt(1, max);). Negative numbers are accepted
     * while using this method. If the max value is < the min value, it will be assumed you wanted it the other way
     * around.
     * @param min Minimum value to be returned.
     * @param max Maximum value to be returned.
     * @return a pseudorandom integer from min to max.
     */
     public static int rInt(int min, int max){

         if(min > max){
             int temp = max;
             max = min;
             min = temp;
         }

         java.util.Random ran = new java.util.Random();

         return (ran.nextInt((max - min) + 1) + min);

     }

    /**
     * Returns a pseudorandom integer from min to max, and will only return <i>even</i> values.
     * <i>Ex.</i> 2, 4, 6, 8, 10, 12, etc. Will never return an odd value (1, 3, 5, 7, 9, Etc). If
     * the max value is < the min value, it will be assumed you wanted it the other way around.
     * @param min Minimum value to be returned.
     * @param max Maximum value to be returned.
     * @return an even pseudorandom integer from min to max
     */
    public static int rIntEven(int min, int max){

        if(min > max){
            int temp = max;
            max = min;
            min = temp;
        }
        if(min == max){
            HandleError.printConsoleCustom("min and max cannot be the same value when using rIntOdd, or rIntEven.");
            return 0;
        }

        java.util.Random ran = new java.util.Random();

        try{
            while(true){
                int ranTemp = ran.nextInt((max - min) + 1) + min;
                if((ranTemp % 2) == 0) return ranTemp;
            }
        }catch(Exception e){
            HandleError.printConsole(e);
            return 0;
        }
    }

    /**
     * Returns a pseudorandom integer from min to max, and will only return <i>odd</i> values.
     * <i>Ex.</i> 1, 3, 5, 7, 9, etc. Will never return an odd value (2, 4, 6, 8, 10, Etc).
     * If the max value is < the min value, it will be assumed you wanted it the other way
     * around.
     * @param min Minimum value to be returned.
     * @param max Maximum value to be returned.
     * @return an odd pseudorandom integer from min to max
     */
    public static int rIntOdd(int min, int max){
        if(min > max){
            int temp = max;
            max = min;
            min = temp;
        }
        if(min == max){
            HandleError.printConsoleCustom("min and max cannot be the same value when using rIntOdd, or rIntEven.");
            return 0;
        }

        java.util.Random ran = new java.util.Random();

        try{
            while(true){
                int ranTemp = ran.nextInt((max - min) + 1) + min;
                if((ranTemp % 2) != 0) return ranTemp;
            }
        }catch(Exception e){
            HandleError.printConsole(e);
            return 0;
        }
    }
}
