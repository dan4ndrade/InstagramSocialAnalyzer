package hello;

import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);

        Instagram4j instagram = Instagram4j.builder().username("danilohenriqueandrade").password("KrolorK3583873").build();
        instagram.setup();

        try {
            instagram.login();
            InstagramSearchUsernameResult userResult = instagram.sendRequest(new InstagramSearchUsernameRequest("github"));
            System.out.println("ID for @github is " + userResult.getUser().getPk());
            System.out.println("Number of followers: " + userResult.getUser().getFollower_count());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}