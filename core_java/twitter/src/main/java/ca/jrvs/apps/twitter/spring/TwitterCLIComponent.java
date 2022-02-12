package ca.jrvs.apps.twitter.spring;
import ca.jrvs.apps.twitter.TwitterCLIApp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

@Configuration
@ComponentScan(value = "ca.jrvs.apps.twitter") //scans the package to get components
public class TwitterCLIComponent {

    public static void main(String[] args) throws UnsupportedEncodingException, URISyntaxException {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                TwitterCLIComponent.class
        ); //IoC container
        TwitterCLIApp app = context.getBean(TwitterCLIApp.class);
        app.run(args);
    }

}