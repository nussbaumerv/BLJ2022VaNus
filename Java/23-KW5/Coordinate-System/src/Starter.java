public class Starter {
    private static int idCounter = 0;

    public static void addPoint(int x, int y, CoordinateSystem cs){
        CSPoint point = new CSPoint(x,y);
        idCounter++;
        point.setId(idCounter);
        cs.addPoint(point);
    }
    public static void main(String[] args) {
        int pointSize = 4;

        CoordinateSystem cs = new CoordinateSystem(500);

        addPoint(-25, -25, cs);
        addPoint(25, 25, cs);

        CSPoint point = new CSPoint(-60,-40);
        idCounter++;
        point.setId(idCounter);
        cs.addPoint(point);

        CSPoint point2 = new CSPoint(60,40);
        idCounter++;
        point2.setId(idCounter);
        cs.addPoint(point2);

        CSLineSegment line = new CSLineSegment(point, point2, cs);


        CSRenderer renderer = new CSRenderer(cs, 1, pointSize);

    }
}
