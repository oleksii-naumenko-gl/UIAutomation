package com.citrix.grasshopper.at.steps;

/**
 * Created by admin on 2/27/17.
 */
public class tst {
    public static void main(String[] args){

        String x = new String();
        x = "verifyAfterUserHasViewdFaxDetailsGreenDotISRemovedFromFaxEntryAndInboxCountIsDecremented";

        for (int i = 0; i<=x.length() - 1; i++){
           if (Character.isUpperCase(x.charAt(i))){

               x = x.substring(0, i) + " " + x.substring(i, x.length());

               i++;
           }
       }


      System.out.println(x);

    }

}
