package br.com.tcc.pageservice;

import br.com.tcc.UserController;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class PageController extends UserController {

    @RequestMapping("/page")
    public String page(Model model) {

        Instagram4j instagram = getInstagram();

        InstagramSearchUsernameResult userResult = null;

        try {
            userResult = instagram.sendRequest(new InstagramSearchUsernameRequest(instagram.getUsername()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("user", userResult.getUser());

        return "page/page";

    }

}
