package hello;

import javafx.beans.binding.StringExpression;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonReader {

    private String readAll(BufferedReader rd) throws IOException {
        String line = rd.readLine();
        int length = 0;

        while( (line != null) && (!line.isEmpty()) ){
            length = length + line.length();
            line = rd.readLine();
        }

        return line;
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        System.setProperty("http.agent", "Chrome");
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json;
            if (jsonText.equals("")){
                json = new JSONObject();
            } else {
                json = new JSONObject(jsonText);
            }
            return json;
        } finally {
            is.close();
        }
    }

    public JSONObject getJson(String url) throws IOException, JSONException {
        JSONObject json = readJsonFromUrl(url);
        return json;
    }
}