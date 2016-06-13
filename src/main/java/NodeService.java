import com.oracle.jrockit.jfr.DataType;

/**
 * Created by Hao on 2016-06-12.
 */
public class NodeService
{
    private enum Options {
        OP_UPDATE,
        OP_INSERT
    }
    /**
     * Save a node object
     * @param Node n
     * @return interger, n
     */
    static public Integer save(Node n)
    {
        Options op;
        Integer nid =  n.getId();
        if (nid != null) {
            op = Options.OP_UPDATE;
        } else {
            op = Options.OP_INSERT;
        }

        switch(op) {
            case OP_INSERT:
                System.out.print("Insert node");
                break;
            case OP_UPDATE:
                System.out.print("Update node");
                break;
            default:
                throw new RuntimeException("System error");
        }
        return nid;
    }
}
