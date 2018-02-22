package hello.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("authURL", "https://www.instagram.com/oauth/authorize/?client_id=68bcc1d330a847f99c46938021d4df40&redirect_uri=http://localhost:8080/auth&response_type=code&scope=public_content+follower_list");
        return "index";
    }

}
