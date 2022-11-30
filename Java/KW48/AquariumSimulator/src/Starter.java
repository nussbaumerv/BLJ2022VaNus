import java.util.*;

public class Starter {
    public static void addFish(ArrayList<Fish> fishs, Aquarium aquarium, int fishCount) {
        Scanner scan = new Scanner(System.in);
        String race;
        int x;
        int y;

        System.out.print("Enter the Race: ");
        race = scan.nextLine();

        System.out.print("Enter X: ");
        x = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter Y: ");
        y = scan.nextInt();
        scan.nextLine();

        System.out.println("\nIn what water Type should your Fish live?");
        System.out.println("\n" +
                "1.  Saltwater\n" +
                "2.  Sweet-water\n");
        System.out.print("Enter specific number: ");
        int water = 0;
        boolean salty;
        boolean valid = true;
        try {
            water = scan.nextInt();
        } catch (InputMismatchException ime) {
            valid = false;
        }
        scan.nextLine();

        if (water == 1) {
            water = 1;
            salty = true;
        } else if (water == 2) {
            water = 2;
            salty = false;
        } else if (valid == false) {
            System.out.println("Invalid Input\n Saltwater was chosen.");
            salty = true;
        } else {
            System.out.println("Invalid Input\n Saltwater was chosen.");
            salty = true;
        }

        if (aquarium.isSalty() == salty) {
            Fish fish = new Fish(fishCount, salty, race, x, y);
            fishs.add(fish);
        } else {
            System.out.println("\nOh no. \uD83D\uDC80 \nYour fish died because you chose the wrong water type");
        }
    }

    public static void moveFish(ArrayList<Fish> fishs) {
        if (fishs.size() >= 1) {
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
        } else {
            System.out.println("\nCreate a Fish first.");
        }
    }

    public static void removeFish(ArrayList<Fish> fishs) {
        if (fishs.size() >= 1) {
            Scanner scan = new Scanner(System.in);
            int id;
            int xAfter;
            int yAfter;

            System.out.println("Remove Fish");

            for (int i = 0; i < fishs.size(); i++) {
                fishs.get(i).printFish();
            }

            System.out.print("Enter Number of the Fish: ");
            id = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < fishs.size(); i++) {
                if (fishs.get(i).getId() == id) {
                    fishs.remove(i);
                }
            }
        } else {
            System.out.println("\nCreate a Fish first.");
        }
    }

    public static void infoFish(ArrayList<Fish> fishs) {
        if (fishs.size() >= 1) {
            for (int i = 0; i < fishs.size(); i++) {
                fishs.get(i).printFish();
            }
        } else {
            System.out.println("\nCreate a Fish first.");
        }
    }

    public static void main(String[] args) {
        System.out.println("\n-------------------------------------");
        System.out.println("|     Welcome to my Aquarium        |");
        System.out.println("-------------------------------------");
        Scanner scan = new Scanner(System.in);
        int cols = 20;
        int rows = 10;
        boolean valid;

        System.out.print("Amount of Columns: ");
        try {
            cols = scan.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("Invalid Input\nThe Default value of 20 was chosen.");
        }
        scan.nextLine();

        System.out.print("Amount of Rows: ");
        try {
            rows = scan.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("Invalid Input\nThe Default value of 10 was chosen.");
        }
        scan.nextLine();

        if (rows < 1 || cols < 1) {
            System.out.println("Invalid Input\nThe Default values were chosen.");
            cols = 20;
            rows = 10;
        }

        System.out.println("\nWhat water Type do you want?");
        System.out.println("\n" +
                "1.  Saltwater\n" +
                "2.  Sweet-water\n");
        System.out.print("Enter specific number: ");
        int water = 0;
        boolean salty;
        valid = true;
        try {
            water = scan.nextInt();
        } catch (InputMismatchException ime) {
            valid = false;
        }
        scan.nextLine();

        if (water == 1) {
            water = 1;
            salty = true;
        } else if (water == 2) {
            water = 2;
            salty = false;
        } else if (valid == false) {
            System.out.println("Invalid Input\nSaltwater was chosen.");
            salty = true;
        } else {
            System.out.println("Invalid Input\nSaltwater was chosen.");
            salty = true;
        }

        Aquarium aquarium = new Aquarium(salty, cols, rows);
        ArrayList<Fish> fishs = new ArrayList<Fish>();
        int fishCount = 0;
        boolean keepDoing = true;

        do {
            System.out.println("\n" +
                    "1.  Print Aquarium\n" +
                    "2.  Add Fish to Aquarium\n" +
                    "3.  Move Fish\n" +
                    "4.  Remove Fish\n" +
                    "5.  Print Information about your fish\n" +
                    "6.  Exit\n");
            System.out.print("Enter specific number: ");
            int option = 0;

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
            } else if (option == 1) {
                aquarium.updateAquarium(fishs);
                aquarium.printAquarium();
            } else if (option == 2) {
                fishCount++;
                addFish(fishs, aquarium, fishCount);
            } else if (option == 3) {
                moveFish(fishs);
            } else if (option == 4) {
                removeFish(fishs);
            } else if (option == 5) {
                infoFish(fishs);
            } else if (option == 6) {
                keepDoing = false;
            } else {
                System.out.println("Please Enter a valid input");
            }
        }
        while (keepDoing);
    }
}
