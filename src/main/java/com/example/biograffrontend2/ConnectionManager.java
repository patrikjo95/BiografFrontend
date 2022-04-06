package com.example.biograffrontend2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionManager {


    public String sendRequest(String request) {

        try {
            URL url = new URL("http://localhost:8080/" + request);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            System.out.println("status: " + status);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
