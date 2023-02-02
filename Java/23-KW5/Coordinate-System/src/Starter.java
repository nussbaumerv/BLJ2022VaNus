public class Starter {
    private static int idCounter = 0;

    public static void addPoint(int x, int y, CoordinateSystem cs){
        CSPoint point = new CSPoint(x,y);
        idCounter++;
        point.setId(idCounter);
        cs.addPoint(point);
    }
    public static void main(String[] args) {
        CoordinateSystem cs = new CoordinateSystem(500);

        addPoint(-25, -25, cs);
        CSRenderer renderer = new CSRenderer(cs, 1, 10);

    }
}
