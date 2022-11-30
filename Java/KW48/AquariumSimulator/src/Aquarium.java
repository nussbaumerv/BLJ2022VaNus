import java.util.*;

public class Aquarium {
    private int columns;
    private int rows;
    private boolean salty;
    private int[][] aquarium;
    public Aquarium(boolean salty, int cols, int rows){
        this.columns = cols;
        this.rows = rows;
        this.salty = salty;
        this.aquarium= new int[columns][rows];
    }
    public void updateAquarium(ArrayList<Fish> fishs) {
        for (int col = 0; col < aquarium.length; ++col) {
            for (int row = 0; row < aquarium[col].length; ++row) {
                aquarium[col][row] = 0;
            }
        }

        for (int i = 0; i < fishs.size(); i++) {
            int x = fishs.get(i).getPositionX();
            int y = fishs.get(i).getPositionY();

            for (int col = 0; col < aquarium.length; ++col) {
                for (int row = 0; row < aquarium[col].length; ++row) {
                    if (col == y && row == x) {
                        aquarium[col][row] = 1;
                    }
                }
            }
        }
    }

    public void printAquarium() {
        for (int i = 0; i < (2+rows); i++) {
            System.out.print("⬜ ");
        }
        System.out.println("");
        String aquariumAsString = Arrays.deepToString(aquarium);
        aquariumAsString = aquariumAsString.replace("[[", "⬜ ").replace("], [", " ⬜\n⬜ ").replace(", ", " ").replace("]]",
                " ⬜").replace("0", "\uD83D\uDFE6").replace("1", "\uD83D\uDC1F");
        System.out.println(aquariumAsString);

        for (int i = 0; i < (2+rows); i++) {
            System.out.print("⬜ ");
        }
        System.out.println("");
    }

    public boolean isSalty() {
        return salty;
    }
}

