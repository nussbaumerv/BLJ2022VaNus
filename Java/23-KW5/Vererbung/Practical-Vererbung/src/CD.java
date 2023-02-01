public class CD extends Media {
    private int minCount;
    private Person artist;


    public CD(String title, int releaseDate, String language, int price, String mediaType, int minCount, String firstName, String lastName, int age){
        super(title, releaseDate, language, price, mediaType);
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
