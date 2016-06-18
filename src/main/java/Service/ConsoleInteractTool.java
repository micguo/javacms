package Service;

import java.util.*;

/**
 * Created by Keepsmile on 2016-06-16.
 */
public class ConsoleInteractTool {
    static public Integer select(String label, Map<Integer, String> map)
    {
        boolean retry = true;
        int op = 0;
        Scanner s = new Scanner(System.in);
        while (retry) {
            System.out.println(Encoder.ISO2UTF8(MessageResourceBundle.getString(label) + ":"));
            Iterator<Map.Entry<Integer, String>> entries = map.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<Integer, String> entry = entries.next();
                System.out.println(entry.getKey().toString() + ". " +  Encoder.ISO2UTF8(MessageResourceBundle.getString(entry.getValue()))+".");
            }

            if (s.hasNextLine()) {
                try {
                    op = Integer.parseInt(s.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Integer is expected.");
                }

                if (op <= map.size()) {
                    retry = false;
                }
            }
            s.reset();
        }

        return op;
    }

    static public String textfield(String label)
    {
        Scanner s = new Scanner(System.in);
        System.out.println(label + ":");
        String input = s.nextLine();
        s.reset();

        return input;
    }
}
