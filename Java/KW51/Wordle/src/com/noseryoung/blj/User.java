package com.noseryoung.blj;

import java.net.MalformedURLException;
import java.util.Scanner;

public class User {
    private String userName;
    private String password;
    boolean loggedIn = false;

    public String getUserName() {
        return userName;
    }

    public void login() throws Exception {
        boolean keepDoing = true;
        Scanner scan = new Scanner(System.in);
        while(keepDoing) {

            System.out.println("\n\033[0;103m\033[1;90m Login \033[0m\n");
            System.out.println("Guest access:\n" +
                    "   Username: guest\n" +
                    "   Password: 1234\n");
            System.out.print("Enter Username: ");
            String username = scan.nextLine();
            System.out.print("Enter Password: ");
            String password = scan.nextLine();

            try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://valentin-nussbaumer.com/wordle/login.php?usr=" + username + "&pwd=" + password).openStream())) {
                String result = s.useDelimiter("\\A").next();
                result = result.trim();
                int resultInt = Integer.parseInt(result);

                if (resultInt == 1) {
                    System.out.println("You successfully logged in!");
                    this.userName = username;
                    this.password = password;
                    this.loggedIn = true;
                    keepDoing = false;
                }else{
                    System.out.println("Wrong password and or username!\n");
                }
            }
        }


    }
}
