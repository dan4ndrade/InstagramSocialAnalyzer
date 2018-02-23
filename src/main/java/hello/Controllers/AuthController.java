package hello.Controllers;

import hello.JsonReader;
import hello.SSLFixer;
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

        // Alternative way to pass the bypass ssl certification without verify
        SSLFixer ssl = new SSLFixer();
        ssl.TrustSSLCertificates();

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


    /*
    public String accessTkn (String code) {

        try {

            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost("https://api.instagram.com/oauth/access_token");

            // Request parameters and other properties.
            List<NameValuePair> params = new ArrayList<NameValuePair>(2);
            params.add(new BasicNameValuePair("client_id", Constants.CLIENT_ID));
            params.add(new BasicNameValuePair("client_secret", Constants.CLIENT_SECRET));
            params.add(new BasicNameValuePair("grant_type", "authorization_code"));
            params.add(new BasicNameValuePair("redirect_uri",  Constants.REDIRECT_URI_AUTH));
            params.add(new BasicNameValuePair("code",  code));


            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            //Execute and get the response.
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            System.out.println("entity "+ entity.getContent());

            if (entity != null) {
                InputStream instream = entity.getContent();
                try {

                    return (getStringfromStream(instream));
                    // do something useful
                } finally {
                    instream.close();
                }
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "Abhay";


    }
    */


}
