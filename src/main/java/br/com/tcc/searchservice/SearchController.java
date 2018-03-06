package br.com.tcc.searchservice;

import br.com.tcc.UserController;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class SearchController extends UserController {

    @RequestMapping("/search")
    public String search(){

        return "search";

    }

    @RequestMapping(value = "/search=user", method = RequestMethod.POST)
    public @ResponseBody InstagramSearchUsernameResult searchUser(@ModelAttribute("username") String username) {

        System.out.println("User: " + username);

        Instagram4j instagram = getInstagram();
        InstagramSearchUsernameResult userResult = null;

        try {
            userResult = instagram.sendRequest(new InstagramSearchUsernameRequest(username));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userResult;

    }

}
