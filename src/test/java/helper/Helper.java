package helper;


public class Helper {

    public static int getUnreadDropdownCounter(String originalText){
        return Integer.parseInt(originalText.substring(1, originalText.length()));
    }

    public static String modifyFormattedNumber(String originalNumber){
        return originalNumber.replaceAll("[^0-9]", "");
    }
}
