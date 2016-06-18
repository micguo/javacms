import java.util.Date;

/**
 * Created by Hao on 2016-06-11.
 */
public class Node
{
    private Integer id;
    private String body;
    private Integer type = 1;

    private Date created;
    private Date updated;

    public Node() {}

    public Node(Integer id, Integer type, String body)
    {
        this.id = id;
        this.type = type;
        this.body = body;
    }
    public Integer getType() {return this.type;}
    public void setType(Integer type)
    {
        this.type = type;
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
    public void setId(Integer id)
    {
        this.id = id;
    }

    public Date getCreated() {return this.created;}
    public void setCreated(Date created)
    {
        this.created = created;
    }

    public Date getUpdated() {return this.updated;}
    public void setUpdated(Date updated)
    {
        this.updated = updated;
    }

}
