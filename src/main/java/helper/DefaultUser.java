package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultUser {

    public static String login = "Oleksii.Naumenko@logmein.com";

    public static String password = "abc123";

    public static boolean isUk = false;

    public static boolean isMMSEnabled = false;

    public static String forwardingNumber = "6314524045";


    public static Number[] numbers = new Number[]
            {
                    new Number("(617) 221-3553", true),
                    new Number("(617) 855-9950", true),
                    new Number("(617) 249-0540", true),
                    new Number("(800) 683-9753", true),
                    new Number("(888) 963-9553", true)
            };

    public static Extension[] extensions = new Extension[]
            {
                    new Extension("Representative", "Ext 0"),
                    new Extension("Sales", "Ext 1"),
                    new Extension("Support", "Ext 2"),
                    new Extension("New Extension", "Ext 700"),
                    new Extension("New Extension", "Ext 701"),
                    new Extension("New Extension", "Ext 702"),
                    new Extension("New Extension", "Ext 703"),
                   // new Extension("New Extension","Ext 704"),
//                    new Extension("New Extension","Ext 705"),
//                    new Extension("New Extension","Ext 706"),
//                    new Extension("New Extension","Ext 707"),
//                    new Extension("New Extension","Ext 708"),
//                    new Extension("New Extension","Ext 709"),
//                    new Extension("New Extension","Ext 710"),
            };


}
