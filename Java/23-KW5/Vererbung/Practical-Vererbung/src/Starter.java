public class Starter {
    public static void main(String[] args) {
        Book book = new Book("Harry Potter und die Heiligtümer des Todes", 2007, "English", 20, "Book", 100, "J.K", "Rowling", 57);
        book.printInfo();

        Film film = new Film("Harry Potter und die Heiligtümer des Todes", 2010, "English", 20, "Film", 14, 500, "Daniel Radcliffe", "Chris", "Columbus", 64);
        film.printInfo();

        Game game = new Game("Hogwarts Legecy", 2018, "English", 20,"Game", 14, 1000, "Multyplayer", "Playstation 5", "Sony", 10);
        game.printInfo();

        CD cd = new CD("The Complete Harry Potter Film Music Collection", 2011, "English", 20, "CD", 0, 20, 14, "Chris", "Columbus", 64);
        cd.printInfo();

    }
}