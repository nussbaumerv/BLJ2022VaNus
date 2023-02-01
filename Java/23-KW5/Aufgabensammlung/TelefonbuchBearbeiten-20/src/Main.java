import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String[] phonebook = new String[100];
        Scanner sc = new Scanner(new File("C:\\Source\\BLJ2022VaNus\\Java\\23-KW5\\Aufgabensammlung\\TelefonbuchBearbeiten-20\\src\\PhoneBook.csv"));

        sc.useDelimiter(",");

        int counter = 0;
        while (sc.hasNext()) {
            System.out.print(sc.next());
            phonebook[counter] = sc.next();
            counter++;
        }
        sc.close();
        for(int i = 0; i < phonebook.length; i++){
            System.out.println(phonebook[i]);
        }
    }
}
