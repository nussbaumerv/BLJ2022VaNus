import java.util.*;

public class Starter {
    public static void main(String[] args) {
        System.out.println("*************************************");
        System.out.println("Welcome to my translator");
        System.out.println("*************************************");

        Scanner scan = new Scanner(System.in);
        boolean keepDoing = true;

        do {
            System.out.println("" +
                    "1.  From Text to Morse\n" +
                    "2.  From Morse to Text\n" +
                    "3.  EXIT\n");
            System.out.print("Enter specific number: ");
            int chooseFeautre = 0;
            boolean valid = true;

            try {
                chooseFeautre = scan.nextInt();
                scan.nextLine();
            }
            catch(InputMismatchException ime){
                valid = false;
            }

            if(valid == true){
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

        }while(keepDoing == true);

    }
}
