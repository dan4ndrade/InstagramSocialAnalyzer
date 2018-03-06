package br.com.tcc.authservice;

import br.com.tcc.UserController;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class AuthenticationController extends UserController {

    @PostMapping("/auth")
    public String login(@RequestParam(value="username") String username, @RequestParam(value="password") String password){

        Instagram4j instagram = setInstagram(Instagram4j.builder().username(username).password(password).build());
        instagram.setup();
        try {
            instagram.login();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/search";

    }

}
