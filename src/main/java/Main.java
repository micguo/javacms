import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Keepsmile on 2016-06-07.
 */

public class Main {
    public static void main(String[] args)
    {
        HashSet<Node> nodeSet = new HashSet<Node>();
        System.out.print("Welcome\n");

        Connection link = null;
        try {
            String url = "jdbc:mysql://127.0.0.1:8083/javacms";
            String username = "root";
            String password = "root";
            link = DriverManager.getConnection(url, username, password);

            Statement statement = link.createStatement();

            String sql = "SELECT * FROM Node";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                nodeSet.add(NodeFactory.CreateNode(rs.getInt("Id"), rs.getString("Body")));
            }

            Iterator<Node> i = nodeSet.iterator();
            while (i.hasNext()) {
                Render.render(i.next());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        boolean retry = true;
        while (retry) {
            switch (listOptions()) {
                case 1:
                    Node node = new Node();
                    String body = askBody();
                    System.out.println("body: " + body);
                    NodeService.save(node);
                    break;
                case 2:
                    Render.renderSet(nodeSet);
                    System.out.print("haha");
                    break;
                case 3:
                    retry = false;
                    break;
            }
        }
    }

    private static String askBody()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a new node body:");
        String input = s.nextLine();
        s.reset();

        return input;
    }


    /**
     * TODO: 2016-06-11   Don't count "Enter" as an input value
     * @return Integer option
     */
    private static Integer listOptions()
    {
        boolean retry = true;
        int option = 0;
        Scanner s = new Scanner(System.in);
        while (retry) {
            System.out.println("Choose an option:");
            System.out.println("1. Add new node.");
            System.out.println("2. List node.");
            System.out.println("3. Exit.");
            if (s.hasNextLine()) {
                try {
                    option = Integer.parseInt(s.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Integer is expected.");
                }
                switch (option) {
                    case 1:
                    case 2:
                    case 3:
                        retry = false;
                        break;
                }
            }
            s.reset();
        }

        System.out.flush();
        return option;
    }
}
