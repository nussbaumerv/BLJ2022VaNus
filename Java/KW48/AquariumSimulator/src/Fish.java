public class Fish {
    private int id;
    private boolean salty;
    private String race;
    private int positionX;
    private int positionY;


    public Fish(int id, boolean slaty, String race, int x, int y){
        this.id = id;
        this.salty = slaty;
        this.race = race;
        this.positionX = x;
        this.positionY = y;
    }
    public void printFish(){
        String SaltyOut = "Sweet-water";
        if(salty){
            SaltyOut = "Saltwater";
        }
        System.out.println("\uD83D\uDC1F " + id + ". |  X: "+ positionX + " |  Y: "+ positionY+" |  " + SaltyOut + " |  Race: " + race);
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getId() {
        return id;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
