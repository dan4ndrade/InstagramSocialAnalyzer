package hello.Controllers;

import hello.JsonReader;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SummonerController extends JsonReader{

    @RequestMapping("/summoner")
    public String searchSummoner(@RequestParam(value="summonerName") String summonerName,@RequestParam(value="location") String location, Model model) {

        JSONObject summoner = null;

        String url = "https://" + location + "1.api.riotgames.com/lol/summoner/v3/summoners/by-name/" + summonerName + "?api_key=RGAPI-9ec97eb6-1968-458e-8e79-1400102dbf9f";

        try {
            summoner = getJson(url);
        } catch (Exception e){
            System.out.println("Ocorreu um erro durante a obtencao do JSON. \n" + url + "\n" + e);
        }

        model.addAttribute("summoner", summoner);
        return "summoner";

    }

}
