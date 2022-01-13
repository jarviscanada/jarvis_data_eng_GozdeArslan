package ca.jrvs.apps.twitter.example;

import java.util.Arrays;
import java.util.function.Consumer;
import oauth.signpost.OAuthConsumer;

public class TwitterApiTest {


    private static String CONSUMER_KEY=System.getenv("consumerKey");
    private static String CONSUMER_SECRET=System.getenv("consumerSecret");
    private static String ACCESS_TOKEN=System.getenv("accessToken");
    private static String TOKEN_SECRET=System.getenv("tokenSecret");

    public static void main(String[] args) throws Exception {


        //Setting up oauth
        OAuthConsumer consumer =new CommonHttpOAuthConsumer (CONSUMER_KEY,CONSUMER_SECRET);
        Consumer.setTokenWithSecret(ACCESS_TOKEN,TOKEN_SECRET);


        //Create HTTPS get request
        String status ="working on the twitter project";
        PercentEscaper persentEscaper=new PercentEscaper("",false);

        HttpsPost request =new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status=" + percentEscaper.escape(status));
            consumer.sign(request);
        System.out.println("Http request Headers");
        Arrays.stream(request.getAllHeaders().forEach(System.out::println));

        HttpsClient httpsClient = HttpsClientBuilder.create.build();
        HttpResponse response =httpsClient.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));

























        }
    }
}
