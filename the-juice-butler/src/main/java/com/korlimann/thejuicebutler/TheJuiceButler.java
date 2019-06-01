package com.korlimann.thejuicebutler;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkAdapter;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.models.*;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthException;
import net.dean.jraw.oauth.OAuthHelper;
import net.dean.jraw.references.CommentReference;
import net.dean.jraw.references.SubmissionReference;
import net.dean.jraw.references.SubredditReference;

public class TheJuiceButler {

    private static UserAgent userAgent = new UserAgent("bot", "com.korlimann.thejuicebutler", "v0.1", "TheJuiceButler");
    private static Credentials credentials = Credentials.script("TheJuiceButler", "DIYJuiceIsTheBest2019", "TsN4N2-Bv1tiPQ", "4OcVmKMd92pV_nnKGtN02TcSpCQ");
    private static NetworkAdapter adapter = new OkHttpNetworkAdapter(userAgent);
    private static RedditClient redditClient;
    private static Subreddit sr;
    private static SubredditReference subreddit;

    public static void main(String[] args) {
        try {
            redditClient = OAuthHelper.automatic(adapter, credentials);
        } catch (OAuthException e) {
            System.out.println("REEEEEEEEEEEEEEEEEEEE");
        }
        sr = redditClient.subreddit("DIY_ejuice").about();
        subreddit = redditClient.subreddit("testingground4bots");
        beUseful();
    }

    public static void beUseful() {
        while (true) {
            Listing<Message> unread = redditClient.me().inbox().iterate("unread")
                    .limit(1)
                    .build().next();

            if (!unread.isEmpty()) {
                Message f = unread.get(0);
                if(f.isComment()) {
                    String dest = f.getDest();
                    String parent = f.getParentId();
                    String fullname = f.getFullName();
                    String unique = f.getUniqueId();
                    String sub = f.getSubreddit();
                    String command = f.getBody();
                    System.out.println("Destination: " + dest);
                    System.out.println("Subreddit: " + sub);
                    System.out.println("Command: " + command);
                    System.out.println("Parent: " + parent);
                    System.out.println("Unique: " + unique);
                    if(command.startsWith("u/TheJuiceButler ")) {
                        if(command.contains("!alfred")) {
                            //CommentReference cparent = redditClient.comment(parent);
                            //CommentReference cfull = redditClient.comment(fullname);
                            CommentReference cunique = redditClient.comment(unique);
                            //cparent.reply("Alfred is the man!");
                            //cfull.reply("This is a test");
                            cunique.reply("Alfred is awesome!");
                        }
                    }
                }
                redditClient.me().inbox().markRead(true, f.getFullName());
            }
        }
    }
}
