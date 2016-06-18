import java.util.Iterator;
import java.util.List;

/**
 * Created by Keepsmile on 2016-06-07.
 */
public class Render {
    static public void render(Node n)
    {
        System.out.println("Node said " + n.getBody() +"(id:" + n.getId() +")");
        System.out.println("\tCreated:" + n.getCreated());
        System.out.println("\tUpdated:" + n.getUpdated());
    }

    static public void renderList(List<Node> nodeList)
    {
        Iterator<Node> iterator = nodeList.iterator();
        while(iterator.hasNext())
        {
            render(iterator.next());
        }
    }
}
