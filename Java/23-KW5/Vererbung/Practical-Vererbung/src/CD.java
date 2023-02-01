public class CD extends Digital {
    private int minCount;
    private Person artist;


    public CD(String title, int releaseDate, String language, int price, String mediaType, int fsk, int storage, int minCount, String firstName, String lastName, int age){
        super(title, releaseDate, language, price, mediaType, fsk, storage);
        this.minCount = minCount;
        artist = new Person(firstName, lastName, age);
    }
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("CD length: " + minCount + " min");
        artist.printPerson();
    }
}
