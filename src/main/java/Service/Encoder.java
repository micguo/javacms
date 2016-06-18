package Service;

import java.io.UnsupportedEncodingException;

public abstract class Encoder {
    static public String ISO2UTF8(String text)
    {
        String rs = null;
        try {
            rs = new String(text.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.error(e.toString());
        }

        return rs;
    }

}
