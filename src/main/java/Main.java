import Content.Article;
import Content.Podcast;

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
    }
}
