public class CSLineSegment {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    private int id = 1;

    private CSPoint p1;
    private CSPoint p2;

    public CSLineSegment(CSPoint p1, CSPoint p2){
        this.p1 = p1;
        this.p2 = p2;

        x1 = (int) p1.getX();
        y1 = (int) p1.getY();

        x2 = (int) p2.getX();
        y2 = (int) p2.getY();

    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public CSPoint getP1() {
        return p1;
    }

    public CSPoint getP2() {
        return p2;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ": Line";
    }
}
