import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
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

        System.out.println(content.toString());

        String s = content.toString();
        String sTrim = s.substring(s.indexOf("<blockquote>&ldquo;") + 19, s.indexOf("&rdquo;"));
        sTrim.trim();

        System.out.println(sTrim);

    }
}