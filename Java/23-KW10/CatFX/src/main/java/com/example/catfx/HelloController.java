package com.example.catfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HelloController {

    public void initialize() throws IOException {
        onLoadImage();
    }
    @FXML
    private ImageView imageView;

    @FXML
    protected void onChangeImage() throws IOException {
        onLoadImage();
    }

    private String getQuote() throws IOException {
        URL url = new URL("https://zenquotes.io/api/random");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();


        String s = content.toString();
        String sTrim = s.substring(s.indexOf("<blockquote>&ldquo;") + 19, s.indexOf("&rdquo;"));
        sTrim.trim();

        return sTrim;

    }

    @FXML
    protected void onLoadImage() throws IOException {
        String message;
        try{
            message = getQuote();
        } catch (Exception e){
            message = "To many requests";
        }
        System.out.println(message);
        Image image = new Image("https://cataas.com/cat/says/"+ message + "?width=600&height=600");
        imageView.setImage(image);

    }
}