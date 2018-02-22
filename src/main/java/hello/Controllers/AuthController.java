package hello.Controllers;

import hello.JsonReader;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class AuthController extends JsonReader {

    @RequestMapping("/auth")
    public String login(@RequestParam(value="code", required=true) String authCode, Model model){
        model.addAttribute("authCode", authCode);

        String urlAccessToken = "https://api.instagram.com/oauth/access_token?client_id=68bcc1d330a847f99c46938021d4df40&client_secret=d4bd8c139123435cb04a275b31a2fed1&grant_type=authorization_code&redirect_uri=http://localhost:8080/auth&code=" + authCode;

        JSONObject accessResult = null;

        try {
            accessResult = getJson(urlAccessToken);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        model.addAttribute("accessResult", accessResult);

        return "home";
    }

}
