public class CSPoint extends java.awt.Point{
    private int id = 1;

    public CSPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setId(int id){
        this.id = id;
    }


    @Override
    public String toString() {
        return "Point: " + id + "[x=" + x + ",y=" + y + "]";
    }


}
