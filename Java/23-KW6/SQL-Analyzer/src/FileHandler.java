
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {
    public String trim(String content){
        String result = "";
        String[] lines = content.split("\n");
        for (String line : lines) {
            String[] columns = line.split(" \\| ");
            for (int i = 0; i < columns.length; i++) {
                columns[i] = columns[i].trim();
            }
           result = result + String.join(" | ", columns);
            result = result + "\n";
        }

        return result;

    }
    public String readFile(String path) throws FileNotFoundException {

        String content = "";

        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        content = trim(content);
        return content;

    }
}
