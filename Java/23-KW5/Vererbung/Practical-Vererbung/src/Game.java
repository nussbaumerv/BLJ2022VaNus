public class Game extends Digital {
    private String gameType;
    private Console console;


    public Game(String title, int releaseDate, String language, int price, String mediaType, int fsk, int storage, String gameType, String name, String brand, int performanceRating){
        super(title, releaseDate, language, price, mediaType, fsk, storage);
        this.gameType = gameType;
        console = new Console(name, brand, performanceRating);
    }
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Game type: " + gameType);
        console.printConsole();
    }
}