import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileHandler handler = new FileHandler();
        String correct = handler.readFile("CheckFiles\\correct.txt");
        String input = handler.readFile("CheckFiles\\input.txt");

        DetailAnalyzation detailAnalyzation = new DetailAnalyzation();
        detailAnalyzation.analyze(correct, input);
    }
}