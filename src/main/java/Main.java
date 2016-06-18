import Service.ConsoleInteractTool;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by Keepsmile on 2016-06-07.
 */

public class Main {
    public static void main(String[] args) throws SQLException
    {
        List<Node> nodeList;
        String body;
        Node node;
        Integer nid;
        System.out.print("Welcome\n");

        boolean retry = true;
        while (retry) {
            switch (listOptions()) {
                case 1:
                    node = new Node();
                    body = ConsoleInteractTool.textfield("Enter a new node body");
                    node.setBody(body);
                    NodeService.save(node);
                    break;
                case 2:
                    nid = null;
                    while (nid == null) {
                        try {
                            nid = Integer.parseInt(ConsoleInteractTool.textfield("Enter nid"));
                        } catch (NumberFormatException e) {
                            System.out.println("Integer is expected.");
                        }
                    }
                    node = NodeService.load(nid);
                    System.out.println("Old body value:");
                    Render.render(node);
                    body = ConsoleInteractTool.textfield("New body value");
                    node.setBody(body);
                    NodeService.save(node);
                    break;
                case 3:
                    nid = Integer.parseInt(ConsoleInteractTool.textfield("Remove node. Enter node id"));
                    node = NodeService.load(nid);
                    if (node != null) {
                        Render.render(node);
                        String resp = ConsoleInteractTool.textfield("Are you sure (y/N)?");
                        System.out.print(resp);
                        if (resp.equals("Y") || resp.equals("y")) {
                            if (NodeService.delete(nid)) {
                                System.out.println("Node " + nid + " deleted.");
                            }
                        }
                    } else {
                        System.out.println("Invalid node id");
                    }
                    break;
                case 4:
                    nodeList = NodeService.loadAll();
                    Render.renderList(nodeList);
                    break;
                case 5:
                    retry = false;
                    break;
            }
        }
    }

    /**
     * @return Integer option
     */
    private static Integer listOptions()
    {
        String q = "Choose_Option";
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "New_Node");
        map.put(2, "Update_Node");
        map.put(3, "Delete_Node");
        map.put(4, "List_Node");
        map.put(5, "Exit");

        Integer op = ConsoleInteractTool.select(q, map);
        System.out.println(op);
        return op;
    }
}
