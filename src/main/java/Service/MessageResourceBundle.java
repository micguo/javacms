package Service;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Keepsmile on 2016-06-17.
 */
public class MessageResourceBundle {

    static private ResourceBundle rc;

    public static String getString(String key)
    {
        if (MessageResourceBundle.rc == null) {
            rc = ResourceBundle.getBundle("message", new Locale("en"));
        }

        return Encoder.ISO2UTF8(rc.getString(key));
    }
}
