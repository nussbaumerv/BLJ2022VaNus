public class Game extends Media {
    private int fsk;
    private Console console;


    public Game(String title, int releaseDate, String language, int price, String mediaType, int fsk, String name, String brand, int performanceRating){
        super(title, releaseDate, language, price, mediaType);
        this.fsk = fsk;
        console = new Console(name, brand, performanceRating);
    }
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("FSK: " + fsk);
        console.printConsole();
    }
}