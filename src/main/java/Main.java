import Content.Article;
import Content.Podcast;

import java.sql.*;

/**
 * Created by Keepsmile on 2016-06-07.
 */

public class Main {
    public static void main(String[] args)
    {
        System.out.print("Welcome");
        Article articleObj = new Article("Ottawa new story", "ottawa new");
        Podcast podcastObj = new Podcast("Giadio radio", "homeland new");
        Render.render(articleObj);
        System.out.print("\n");
        Render.render(podcastObj);
        System.out.print("\n");
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
                System.out.print(rs.getInt("Id") + " - ");
                System.out.print(rs.getString("Body") + "\n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        System.out.println(link);
    }
}
