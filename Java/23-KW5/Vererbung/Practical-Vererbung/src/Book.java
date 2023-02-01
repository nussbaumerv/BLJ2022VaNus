public class Book extends Media {
    private int pageCount;
    private Person author;


    public Book(String title, int releaseDate, String language, int price, String mediaType, int pageCount, String firstName, String lastName, int age){
        super(title, releaseDate, language, price, mediaType);
        this.pageCount = pageCount;
        author = new Person(firstName, lastName, age);
    }
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Page Count: " + pageCount);
        author.printPerson();
    }
}
