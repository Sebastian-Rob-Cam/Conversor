package main.java.com.sebastian.conversor.model;

import com.google.gson.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class connectionAPI {
    public connectionAPI() {
    }

    public String getJSON(String currencyCode) {
        String urlString = "https://v6.exchangerate-api.com/v6/a1f3f9d4e4ed91862cf61d73/latest/" + currencyCode;

        String jsonToStringFormatted = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responceCode = connection.getResponseCode();
            if (responceCode != 200) {
                throw new RuntimeException("Ocurrio un error " + responceCode);
            } else {

                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(new InputStreamReader((InputStream) connection.getContent()));
                JsonObject jsonobj = root.getAsJsonObject();

                // String req_result = jsonobj.get("result").getAsString();

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                jsonToStringFormatted = gson.toJson(jsonobj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


         return jsonToStringFormatted;
    }
}
