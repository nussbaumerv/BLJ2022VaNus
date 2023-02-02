import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {


    public void readFile(ArrayList<Media> mediaList){
        int i = 0;
        String line;
        String splitBy = ",";
        String path = "C:\\Source\\BLJ2022VaNus\\Java\\23-KW5\\Vererbung\\Practical-Vererbung\\src\\books.csv";
        try{
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                String[] mediaInfo = line.split(splitBy);

                int releaseYear = Integer.parseInt(mediaInfo[1]);
                int price = Integer.parseInt(mediaInfo[3]);
                int pageCount = Integer.parseInt(mediaInfo[5]);
                int age = Integer.parseInt(mediaInfo[8]);

                Book book = new Book(mediaInfo[0], releaseYear, mediaInfo[2], price, mediaInfo[4], pageCount, mediaInfo[6], mediaInfo[7], age);
                mediaList.add(book);


            }
            br.close();
        } catch(IOException e){
            System.out.println("F");
        }
    }
}
