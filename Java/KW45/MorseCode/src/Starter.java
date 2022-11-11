import java.util.*;

public class Starter {
    public static void main(String[] args) {
        System.out.println("*************************************");
        System.out.println("Welcome to my translator");
        System.out.println("*************************************");

        boolean keepDoing = true;

        do {
            System.out.println("\nType EXIT to exit Program");
            System.out.print("Enter String: ");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            String inputUpper = input.toUpperCase();
            if(inputUpper.equals("EXIT") || inputUpper.equals("X")){
                keepDoing = false;
            }
            else {
                Translator newTranslate = new Translator();
                String result = newTranslate.translateToMorse(inputUpper);
                System.out.println(result);
            }
        }while(keepDoing == true);

    }
}
