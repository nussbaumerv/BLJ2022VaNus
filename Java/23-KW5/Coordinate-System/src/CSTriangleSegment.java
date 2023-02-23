public class CSTriangleSegment {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;

    private int id = 1;

    private CSPoint p1;
    private CSPoint p2;
    private CSPoint p3;

    public CSTriangleSegment(CSPoint p1, CSPoint p2, CSPoint p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

        x1 = (int) p1.getX();
        y1 = (int) p1.getY();

        x2 = (int) p2.getX();
        y2 = (int) p2.getY();

        x3 = (int) p3.getX();
        y3 = (int) p3.getY();

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

    public CSPoint getP3() {
        return p3;
    }

    public int getX3() {
        return x3;
    }

    public int getY3() {
        return y3;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ": Line";
    }
}
