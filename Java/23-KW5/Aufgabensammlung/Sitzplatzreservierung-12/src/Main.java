import java.util.Random;

public class Main {
    public static void printArena(char[][] saal, int rows){
        for(int r = rows-1; r >= 0; r--){
            for(int c = 0; c < r+3; c++){
                System.out.print(saal[r][c]);
            }
            System.out.println("");
        }
    }
    public static char[][] createArena(int rows){
        char[][] saal = new char[rows][rows+3];
        Random rand = new Random();
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < rows+3; c++){
                if(rand.nextInt(2) == 1) {
                    saal[r][c] = '-';
                }else{
                    saal[r][c] = '#';
                }
            }

        }
        printArena(saal, rows);
        return saal;
    }


    public static void main(String[] args) {
        createArena(5);
    }
}