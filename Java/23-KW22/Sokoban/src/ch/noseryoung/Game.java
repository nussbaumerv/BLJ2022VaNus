package ch.noseryoung;

import java.util.ArrayList;

import static java.lang.System.exit;

public class Game {

    private int[][] gameField;
    private int xPlayer;
    private int yPlayer;

    private ArrayList<String> spots;


    public Game() {
        initialize();
    }

    public void initialize() {
        gameField = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 1, 4, 2, 3, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 0, 3, 4, 1, 0, 0},
                {0, 1, 4, 1, 1, 3, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 4, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 3, 3, 0, 1, 0},
                {0, 1, 0, 0, 0, 4, 0, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        setSpots();
    }

    public void setSpots() {
        spots = new ArrayList<>();
        for (int y = 0; y < getColCount(); y++) {
            for (int x = 0; x < getRowCount(); x++) {
                if (gameField[y][x] == 4) {
                    spots.add(x + "/" + y);
                }
                if (gameField[y][x] == 2) {
                    xPlayer = x;
                    yPlayer = y;
                }
            }
        }
    }

    public void checkWin() {
        int spotsToCover = spots.size();

        for (int y = 0; y < getColCount(); y++) {
            for (int x = 0; x < getRowCount(); x++) {
                if (gameField[y][x] == 3 && spots.contains(x + "/" + y)) {
                    spotsToCover--;
                }
            }
        }

        if (spotsToCover == 0) {
            System.out.println("Won");

            gameField = new int[][]{
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 1, 1, 1, 1, 1, 0, 0},
                    {0, 1, 1, 1, 0, 0, 0, 1, 0, 0},
                    {0, 1, 4, 2, 3, 0, 0, 1, 0, 0},
                    {0, 1, 1, 1, 0, 3, 4, 1, 0, 0},
                    {0, 1, 4, 1, 1, 3, 0, 1, 0, 0},
                    {0, 1, 0, 1, 0, 4, 0, 1, 1, 0},
                    {0, 1, 3, 0, 3, 3, 3, 4, 1, 0},
                    {0, 1, 4, 0, 0, 4, 0, 0, 1, 0},
                    {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
            };
            setSpots();
        }
    }


    public void movePlayer(String method) {
        for (int y = 0; y < getColCount(); y++) {
            for (int x = 0; x < getRowCount(); x++) {
                if (gameField[y][x] == 2) {
                    if (gameField[yPlayer][xPlayer] == 1) {
                        xPlayer = x;
                        yPlayer = y;
                    } else if (gameField[yPlayer][xPlayer] == 3) {
                        int xCheck = xPlayer;
                        int yCheck = yPlayer;
                        switch (method) {
                            case "UP":
                                yCheck--;
                                break;
                            case "DOWN":
                                yCheck++;
                                break;
                            case "LEFT":
                                xCheck--;
                                break;
                            case "RIGHT":
                                xCheck++;
                                break;
                        }

                        if (gameField[yCheck][xCheck] == 1 || gameField[yCheck][xCheck] == 3) {
                            xPlayer = x;
                            yPlayer = y;
                        } else {
                            if (spots.contains(x + "/" + y)) {
                                gameField[y][x] = 4;
                            } else {
                                gameField[y][x] = 0;
                            }
                            gameField[yPlayer][xPlayer] = 2;
                            gameField[yCheck][xCheck] = 3;

                        }
                    } else {
                        if (spots.contains(x + "/" + y)) {
                            gameField[y][x] = 4;
                        } else {
                            gameField[y][x] = 0;
                        }
                        gameField[yPlayer][xPlayer] = 2;
                    }
                }
            }


        }
        checkWin();
    }

    public void moveUp() {
        yPlayer -= 1;
        movePlayer("UP");
    }

    public void moveDown() {
        yPlayer += 1;
        movePlayer("DOWN");
    }

    public void moveLeft() {
        xPlayer -= 1;
        movePlayer("LEFT");
    }

    public void moveRight() {
        xPlayer += 1;
        movePlayer("RIGHT");
    }

    public void escAction() {
        exit(0);
    }

    public int[][] getField() {
        return gameField;
    }

    public int getColCount() {
        return gameField.length;
    }

    public int getRowCount() {
        return gameField[0].length;
    }
}
