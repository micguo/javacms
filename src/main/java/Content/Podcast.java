package Content;

/**
 * Created by Keepsmile on 2016-06-07.
 */
public class Podcast implements Displayable
{
    private String header;
    private String body;

    public Podcast(String header, String body)
    {
        this.header = header;
        this.body = body;
    }

    public String getDisplay()
    {
        String out;
        out = "(Podcast)" + this.header + "\n";
        out += this.body;

        return out;
    }
}
