package hello.Controllers;

import hello.JsonReader;
import hello.SSLFixer;
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

        String apiKey = "RGAPI-e3645fd6-cf23-43d7-8872-c1f676111d43";
        String url = "https://" + location + "1.api.riotgames.com/lol/summoner/v3/summoners/by-name/" + summonerName + "?api_key=" + apiKey;
        System.out.println("Acessando: " + url);

        try {
            SSLFixer ssl = new SSLFixer();
            ssl.TrustSSLCertificates();
            summoner = getJson(url);
        } catch (Exception e){
            System.out.println("Ocorreu um erro durante a obtencao do JSON. \n" + url + "\n" + e);
        }

        model.addAttribute("summoner", summoner);
        return "summoner";

    }

}
