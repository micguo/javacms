package Content;

/**
 * Created by Keepsmile on 2016-06-07.
 */
public class Article implements Displayable
{
    private String header;
    private String body;

    public Article(String header, String body)
    {
        this.header = header;
        this.body = body;
    }

    public String getDisplay()
    {
        String out;
        out = "(Artilce)" + this.header + "\n";
        out += this.body;

        return out;
    }
}
