import java.util.Iterator;
import java.util.Set;

/**
 * Created by Keepsmile on 2016-06-07.
 */
public class Render {
    static public void render(Node n)
    {
        System.out.print("Node said " + n.getBody() +"(id:" + n.getId() +")\n");
    }

    static public void renderSet(Set<Node> nodeSet)
    {
        Iterator<Node> iterator = nodeSet.iterator();
        while(iterator.hasNext())
        {
            render(iterator.next());
        }
    }
}
