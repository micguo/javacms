/**
 * Created by Hao on 2016-06-11.
 */
public class Node
{
    private  Integer id;
    private String body;

    public Node() {}

    public Node(Integer id, String body)
    {
        this.id = id;
        this.body = body;
    }

    public String getBody()
    {
        return this.body;
    }
    public void setBody(String body)
    {
        this.body = body;
    }

    public Integer getId()
    {
        return this.id;
    }
}
