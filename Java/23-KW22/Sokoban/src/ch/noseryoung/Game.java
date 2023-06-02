package ch.noseryoung;

public class Game {

  private int[][] gameField;

  public Game() {
    gameField = new int[][] { 
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
      { 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 },
      { 0, 1, 1, 1, 0, 0, 0, 1, 0, 0 }, 
      { 0, 1, 4, 2, 3, 0, 0, 1, 0, 0 },
      { 0, 1, 1, 1, 0, 3, 4, 1, 0, 0 }, 
      { 0, 1, 4, 1, 1, 3, 0, 1, 0, 0 },
      { 0, 1, 0, 1, 0, 4, 0, 1, 1, 0 }, 
      { 0, 1, 3, 0, 3, 3, 3, 4, 1, 0 },
      { 0, 1, 0, 0, 0, 4, 0, 0, 1, 0 }, 
      { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    };
  }
  
  public void moveUp() {
    System.out.println("UP");
  }

  public void moveDown() {
    System.out.println("DOWN");
  }

  public void moveLeft() {
    System.out.println("LEFT");
  }

  public void moveRight() {
    System.out.println("RIGHT");
  }

  public void escAction() {
    System.out.println("ESC");
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
