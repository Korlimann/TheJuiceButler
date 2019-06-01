import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkAdapter;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthException;
import net.dean.jraw.oauth.OAuthHelper;

public class TheJuiceButler {

    private static UserAgent userAgent = new UserAgent("bot", "at.korli.sparklybot", "v0.1", "SparklyBot");
    private static Credentials credentials = Credentials.script("Korlimann", "Flamelibra1", "407i4Cy1YIV_iQ", "CGNLBH0hDO2HpoJGmYkUmmZXILU");
    private static NetworkAdapter adapter = new OkHttpNetworkAdapter(userAgent);
    private static RedditClient redditClient;

    public static void main(String[] args) {
        try {
            redditClient = OAuthHelper.automatic(adapter, credentials);
        } catch (OAuthException e) {
            System.out.println("REEEEEEEEEEEEEEEEEEEE");
        }   
    }
}
