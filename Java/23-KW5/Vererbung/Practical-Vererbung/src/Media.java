import java.security.spec.RSAOtherPrimeInfo;

public class Media {
    private String title;
    private int releaseDate;
    private String language;
    int price;
    private String mediaType;

    public Media(String title, int releaseDate, String language, int price, String mediaType){
        this.title = title;
        this.releaseDate = releaseDate;
        this.language = language;
        this.price = price;
        this.mediaType = mediaType;
    }

    public void printInfo() {
        System.out.println("\n********************************************************\n");
        System.out.println(mediaType + "\n");
        System.out.println("Title: " + title);
        System.out.println("Release Date: " + releaseDate);
        System.out.println("Language: " + language);
        System.out.println("Price: " + price + " CHF");

    }

}
