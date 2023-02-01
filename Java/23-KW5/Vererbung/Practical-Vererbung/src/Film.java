public class Film extends Media {
    private int fsk;
    private Person regisseur;


    public Film(String title, int releaseDate, String language, int price, String mediaType, int fsk, String firstName, String lastName, int age){
        super(title, releaseDate, language, price, mediaType);
        this.fsk = fsk;
        regisseur = new Person(firstName, lastName, age);
    }
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("FSK: " + fsk);
        regisseur.printPerson();
    }
}