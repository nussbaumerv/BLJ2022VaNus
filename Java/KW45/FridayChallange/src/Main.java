import java.util.*;

public class Main {
    public static void printBackpack(ArrayList<String> Backpack) {
        System.out.println("| -----------------------------------");
        System.out.println("|            You Backpack           ");
        System.out.println("| -----------------------------------");
        for (int i = 0; i < Backpack.size(); i++) {
            System.out.println("| "+ (i+1) + ": " + Backpack.get(i));
            System.out.println("| -----------------------------------");
        }

    }
    public static void checkInput(ArrayList<String> Backpack, String toCheck) {
        for (int i = 0; i < Backpack.size(); i++) {
            if(Backpack.get(i).equals(toCheck)){
                Backpack.remove(i);
                System.out.println("The " + (i+1) + ". Element was removed");
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> Backpack = new ArrayList<String>();
        System.out.println("*************************************");
        System.out.println("|       Welcome to my Program       |");
        System.out.println("*************************************");
        System.out.println("Enter 0 to exit the Program");
        boolean keepDoing = true;
        do{
            System.out.print("\nEnter the item:");
            String item = scan.nextLine();
            if(item.equals("0")){
                keepDoing = false;
            }
            else {
                checkInput(Backpack, item);
                Backpack.add(item);
                printBackpack(Backpack);
            }

        }while(keepDoing == true);
        System.out.println("Thanks for using my Program");
    }
}