public class Main {
    public static String urlEncode(String url){
        String urlEncoded = url;

        urlEncoded = urlEncoded.replace(" ","%20");
        urlEncoded = urlEncoded.replace("*","%2A");
        urlEncoded = urlEncoded.replace("+","%2B");
        urlEncoded = urlEncoded.replace(",","%2C");
        urlEncoded = urlEncoded.replace("/","%2F");
        urlEncoded = urlEncoded.replace(":","%3A");
        urlEncoded = urlEncoded.replace(";","%3B");
        urlEncoded = urlEncoded.replace("=","%3D");
        urlEncoded = urlEncoded.replace("?","%3F");

        return urlEncoded;

    }
    public static void main(String[] args) {
        String url = "https://www.hanser-fachbuch.de/buch/WebSockets/9783446443716";
        System.out.println("URL: " + url);
        System.out.println("Encoded URL: " + urlEncode(url));
    }
}