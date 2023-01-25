package com.noseyoung.blj;

import java.util.*;

public class Starter {
    public static void printPersons(ArrayList<Person> arrPersons) {
        System.out.println("Your Person Manager List:");
        System.out.println("*************************************");
        for (int i = 0; i < arrPersons.size(); i++) {
            arrPersons.get(i).printPerson();
        }
    }

    public static void addPeopleToList(ArrayList<Person> arrPersons) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the amount of Person's:");
        boolean valid;
        int persons = 0;

        try {
            persons = scan.nextInt();
            valid = true;
        }
        catch(InputMismatchException ime){
            valid = false;
        }
        scan.nextLine();
        System.out.println("*************************************");
        if (persons > 0 && valid) {
            for (int i = 0; i < persons; i++) {
                System.out.print("Enter the person's Firstname:");
                String newFirstName = scan.nextLine();
                System.out.print("Enter the person's Lastname:");
                String newLastName = scan.nextLine();
                System.out.print("Enter the person's Email:");
                String newPersonEmail = scan.nextLine();
                System.out.print("Enter your person's Bestfriend:");
                String newPersonFriend = scan.nextLine();

                Person NewPerson = new Person(newFirstName, newLastName);
                NewPerson.setEmail(newPersonEmail);
                NewPerson.setBestFriend(newPersonFriend);

                arrPersons.add(NewPerson);
                System.out.println("*************************************");
            }

        } else {
            System.out.println("Please enter a valid Input");
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Person> arrPersons = new ArrayList<Person>();
        System.out.println("\n-------------------------------------");
        System.out.println("| Welcome to my Person list program |");
        System.out.println("-------------------------------------");
        boolean keepDoing = true;
        do {
            System.out.println("\n" +
                    "1.  Add People to List\n" +
                    "2.  Print List\n" +
                    "3.  Exit\n");
            System.out.print("Enter specific number: ");
            int option = 0;
            boolean valid;
            try {
                option = scan.nextInt();
                valid = true;
            }
            catch(InputMismatchException ime){
                valid = false;
            }
            scan.nextLine();
            System.out.println("");
            if(valid == false){
                System.out.println("Please Enter a valid input");
            }
            else if (option == 1) {
                addPeopleToList(arrPersons);
            } else if (option == 2) {
                printPersons(arrPersons);
            } else if (option == 3) {
                keepDoing = false;
            } else {
                System.out.println("Please Enter a valid input");
            }
        }while(keepDoing);
    }
}
