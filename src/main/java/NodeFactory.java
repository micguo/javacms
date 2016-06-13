/**
 * Created by Hao on 2016-06-11.
 */
public class NodeFactory
{
    public static Node CreateNode(Integer id, String body)
    {
        return new Node(id, body);
    }
}
