public class Film extends Digital {
    private String mainCaracter;
    private Person regisseur;


    public Film(String title, int releaseDate, String language, int price, String mediaType, int fsk, int storage, String mainCaracter, String firstName, String lastName, int age){
        super(title, releaseDate, language, price, mediaType, fsk, storage);
        this.mainCaracter = mainCaracter;
        regisseur = new Person(firstName, lastName, age);
    }
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Main Caracter: " + mainCaracter);
        regisseur.printPerson();
    }
}