import java.util.*;

public class Starter {
    public static void addFish(ArrayList<Fish> fishs, Aquarium acuarium, int fishCount) {
        Scanner scan = new Scanner(System.in);
        String race;
        int x;
        int y;
        boolean salty = true;

        System.out.println("Enter the Race: ");
        race = scan.nextLine();

        System.out.print("Enter X: ");
        x = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter Y: ");
        y = scan.nextInt();
        scan.nextLine();

        Fish fish = new Fish(fishCount, salty, race, x, y);
        fishs.add(fish);
    }
    public static void moveFish(ArrayList<Fish> fishs) {
        Scanner scan = new Scanner(System.in);
        int id;
        int xAfter;
        int yAfter;

        System.out.println("Move Fish");

        for (int i = 0; i < fishs.size(); i++) {
            fishs.get(i).printFish();
        }

        System.out.print("Enter Number of the Fish: ");
        id = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter X of Fish's destination: ");
        xAfter = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter X of Fish's destination: ");
        yAfter = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < fishs.size(); i++) {
            if (fishs.get(i).getId() == id) {
                fishs.get(i).setPositionX(xAfter);
                fishs.get(i).setPositionY(yAfter);
            }
        }

    }
    public static void main(String[] args) {
        System.out.println("\n-------------------------------------");
        System.out.println("|     Welcome to my Aquarium        |");
        System.out.println("-------------------------------------");

        Aquarium aquarium = new Aquarium();
        ArrayList<Fish> fishs = new ArrayList<Fish>();
        Scanner scan = new Scanner(System.in);
        int fishCount = 0;
        boolean keepDoing = true;

        do {
            System.out.println("\n" +
                    "1.  Add Fish to Aquarium\n" +
                    "2.  Move Fish\n" +
                    "3.  Exit\n");
            System.out.print("Enter specific number: ");
            int option = 0;
            boolean valid;

            try {
                option = scan.nextInt();
                valid = true;
            } catch (InputMismatchException ime) {
                valid = false;
            }
            scan.nextLine();
            System.out.println("");
            if (valid == false) {
                System.out.println("Please Enter a valid input");
            }
            else if (option == 1) {
                fishCount++;
                addFish(fishs, aquarium, fishCount);
            } else if (option == 2) {
                moveFish(fishs);
            } else if (option == 3) {
                keepDoing = false;
            } else {
                System.out.println("Please Enter a valid input");
            }

            aquarium.updateAquarium(fishs);
            aquarium.printAquarium();
        }
        while (keepDoing);
    }
}
