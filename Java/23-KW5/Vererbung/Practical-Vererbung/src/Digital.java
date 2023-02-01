public class Digital extends Media{
    private int fsk;
    private int storage;
    public Digital(String title, int releaseDate, String language, int price, String mediaType, int fsk , int storage){
        super(title, releaseDate, language, price, mediaType);
        this.fsk = fsk;
        this.storage = storage;
    }

    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("FSK: " + fsk);
        System.out.println("Storage: " + storage + " mb");
    }
}
