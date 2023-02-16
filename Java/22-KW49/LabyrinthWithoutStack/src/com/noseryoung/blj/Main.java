package com.noseryoung.blj;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> chooseOption(int totalX, int totalY, int stateX, int stateY, int[][] arrField, int query) {
        ArrayList<Integer> options = new ArrayList<Integer>();
        if (stateX + 2 < totalX) {
            if ((arrField[stateY][stateX + 2]) == query) {
                options.add(1);
            }
        }
        if (stateY + 2 < totalY) {
            if (arrField[stateY + 2][stateX] == query) {
                options.add(2);
            }
        }
        if (stateX - 2 >= 0) {
            if (arrField[stateY][stateX - 2] == query) {
                options.add(3);
            }
        }
        if (stateY - 2 >= 0) {
            if (arrField[stateY - 2][stateX] == query) {
                options.add(4);
            }
        }
        return options;
    }

    public static void alogorythm(int[][] arrField) {
        int totalX = 11;
        int totalY = 11;
        int stateX = 9;
        int stateY = 9;

        int usedFields = 0;
        int totalFields = 25;
``
        arrField[stateY][stateX] = 4;
        do {
            ArrayList<Integer> options = chooseOption(totalX, totalY, stateX, stateY, arrField, 0);

            int option = 0;

            if (options.size() > 0) {
                usedFields++;
                if (options.size() == 1) {
                    option = options.get(0);
                } else {
                    option = options.get((int) (Math.random() * options.size()));
                }
                if (option == 1) {
                    arrField[stateY][stateX + 2] = 2;
                    arrField[stateY][stateX + 1] = 2;
                    stateX += 2;
                }
                if (option == 2) {
                    arrField[stateY + 2][stateX] = 2;
                    arrField[stateY + 1][stateX] = 2;
                    stateY += 2;
                }
                if (option == 3) {
                    arrField[stateY][stateX - 2] = 2;
                    arrField[stateY][stateX - 1] = 2;
                    stateX -= 2;
                }
                if (option == 4) {
                    arrField[stateY - 2][stateX] = 2;
                    arrField[stateY - 1][stateX] = 2;
                    stateY -= 2;
                }

            } else {
                ArrayList<Integer> optionsB = chooseOption(totalX, totalY, stateX, stateY, arrField, 2);
                if (optionsB.size() > 0) {
                    if (optionsB.size() == 1) {
                        option = optionsB.get(0);
                    } else {
                        option = optionsB.get((int) (Math.random() * options.size()));
                    }

                    if (option == 1) {
                        stateX += 2;
                    }
                    if (option == 2) {
                        stateY += 2;
                    }
                    if (option == 3) {
                        stateX -= 2;
                    }
                    if (option == 4) {
                        stateY -= 2;
                    }
                }else{
                    System.out.println("Fuck");
                }
            }
            printMaze(arrField);
        }
        while (usedFields < totalFields);

        arrField[stateY][stateX] = 5;
        System.out.println(usedFields);
    }

    private static void printMaze(int[][] arrField) {
        for (int i = 0; i < arrField.length; ++i) {
            for (int j = 0; j < arrField[i].length; ++j) {
                if (arrField[i][j] == 3) {
                    System.out.print("⬛ ");
                } else if (arrField[i][j] == 0) {
                    System.out.print("⬜ ");
                } else if (arrField[i][j] == 1) {
                    System.out.print("🟫 ");
                } else if (arrField[i][j] == 2) {
                    System.out.print("\uD83D\uDFE8 ");
                }else if (arrField[i][j] == 4) {
                    System.out.print("\uD83D\uDFE9 ");
                }else if (arrField[i][j] == 5) {
                    System.out.print("\uD83D\uDFE7 ");
                }
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {

        int[][] arrField = {
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                {3, 0, 1, 0, 1, 0, 1, 0, 1, 0, 3},
                {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
                {3, 0, 1, 0, 1, 0, 1, 0, 1, 0, 3},
                {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
                {3, 0, 1, 0, 1, 0, 1, 0, 1, 0, 3},
                {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
                {3, 0, 1, 0, 1, 0, 1, 0, 1, 0, 3},
                {3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3},
                {3, 0, 1, 0, 1, 0, 1, 0, 1, 0, 3},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
        };
        alogorythm(arrField);
        printMaze(arrField);
    }
}
