import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        String langConfigPath = "resources\\german.properties";

        Properties langProps = new Properties();
        langProps.load(new FileInputStream(langConfigPath));

        System.out.println(langProps.getProperty("introMessage"));
    }
}