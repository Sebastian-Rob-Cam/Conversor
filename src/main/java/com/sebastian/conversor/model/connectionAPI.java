package main.java.com.sebastian.conversor.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class connectionAPI {
    public connectionAPI() {
    }

    public String getJSON(String currencyCode) {
        String urlString = "https://v6.exchangerate-api.com/v6/a1f3f9d4e4ed91862cf61d73/latest/" + currencyCode;

        String json = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Ocurrió un error " + responseCode);
            } else {
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                reader.close();

                json = stringBuilder.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

}
