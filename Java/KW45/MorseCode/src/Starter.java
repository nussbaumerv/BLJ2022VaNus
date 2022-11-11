import java.util.*;

public class Starter {
    public static void main(String[] args) {
        System.out.println("*************************************");
        System.out.println("Welcome to my translator");
        System.out.println("*************************************");

        Scanner scan = new Scanner(System.in);
        boolean keepDoing = true;

        do {
            System.out.println("""
                    1.  From Text to Morse
                    2.  From Morse to Text
                    3.  EXIT
                    """);
            System.out.print("Enter specific number: ");
            int chooseFeautre = 0;
            boolean valid = true;

            try {
                chooseFeautre = scan.nextInt();
            }
            catch(InputMismatchException ime){
                valid = false;
            }
            scan.nextLine();

            if(valid){
                if(chooseFeautre == 1 || chooseFeautre == 2){
                    if(chooseFeautre == 1){
                        System.out.print("Enter Text: ");
                    }else{
                        System.out.print("Enter Morse: ");
                    }
                    String input = scan.nextLine();
                    String inputUpper = input.toUpperCase();

                    System.out.println("\n*************************************\n");

                    Translator newTranslate = new Translator();
                    String result = newTranslate.translateToMorse(chooseFeautre, inputUpper);
                    System.out.println(result);
                }
                else if(chooseFeautre == 3){
                    keepDoing = false;
                }
                else{
                    System.out.println("\n*************************************\n");
                    System.out.println("Please enter a valid input");
                }
            }
            else{
                System.out.println("\n*************************************\n");
                System.out.println("Please enter a valid input");

            }
            System.out.println("\n*************************************\n");

        }while(keepDoing);

    }
}
