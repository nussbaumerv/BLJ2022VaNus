import java.util.*;

public class Aquarium {
    private int columns;
    private int rows;
    private int rowsAvailable;
    private boolean salty;
    private int[][] aquarium;
    public Aquarium(boolean salty, int cols, int rows, int rowsAvailable){
        this.columns = cols;
        this.rows = rows;
        this.salty = salty;
        this.aquarium= new int[rows][columns];
        this.rowsAvailable = rowsAvailable;
    }
    public int checkIfFree(int x, int y){
        int state = 0;
        if(aquarium[x][y] == 1){
            state = 1;
        }
        else if(aquarium[x][y] == 2){
            state = 2;
        }
        else if(aquarium[x][y] == 0){
            state = 0;
        }
        else{
            state = 8;
        }
        return state;
    }
    public void updateAquarium(ArrayList<Fish> fishs) {
        int waterFree = rows - rowsAvailable;
        for (int row = 0; row < aquarium.length; ++row) {
            for (int col = 0; col < aquarium[row].length; ++col) {
                if(waterFree > 0){
                    aquarium[row][col] = 2;
                }
                else{
                    aquarium[row][col] = 0;
                }
            }
            waterFree--;
        }

        for (int i = 0; i < fishs.size(); i++) {
            int x = fishs.get(i).getPositionX();
            int y = fishs.get(i).getPositionY();

            for (int row = 0; row < aquarium.length; ++row) {
                for (int col = 0; col < aquarium[row].length; ++col) {
                    if ((col == y && row == x) && (aquarium[row][col] == 0)){
                        aquarium[row][col] = 1;
                    }
                }
            }
        }
    }

    public void printAquarium() {
        System.out.println("");
        String aquariumAsString = Arrays.deepToString(aquarium);
        aquariumAsString = aquariumAsString.replace("[[", "⬜ ").replace("], [", " ⬜\n⬜ ").replace(", ", " ").replace("]]",
                " ⬜").replace("0", "\uD83D\uDFE6").replace("1", "\uD83D\uDC1F").replace("2", "⬛");
        System.out.println(aquariumAsString);

        for (int i = 0; i < (2+columns); i++) {
            System.out.print("⬜ ");
        }
        System.out.println("");
    }

    public boolean isSalty() {
        return salty;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRowsAvailable(int rowsAvailable) {
        this.rowsAvailable = rowsAvailable;
    }
}

