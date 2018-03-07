package br.com.tcc.searchservice;

import br.com.tcc.UserController;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class SearchController extends UserController {

    @RequestMapping("/search")
    public String search(){

        return "search/search";

    }

    @RequestMapping("/search=user")
    public ModelAndView searchUser(@ModelAttribute("username") String username, Model model) {

        Instagram4j instagram = getInstagram();
        InstagramSearchUsernameResult userResult = null;

        try {
            userResult = instagram.sendRequest(new InstagramSearchUsernameRequest(username));
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("user", userResult.getUser());

        return new ModelAndView( "search/iframeSearchUser" );

    }

}
