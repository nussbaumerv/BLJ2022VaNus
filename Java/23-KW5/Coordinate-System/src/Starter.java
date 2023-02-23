public class Starter {
    private static int pointCounter = 0;
    private static int lineCounter = 0;

    private static int triCounter = 0;

    public static CSPoint addPoint(int x, int y, CoordinateSystem cs){
        CSPoint point = new CSPoint(x,y);
        pointCounter++;
        point.setId(pointCounter);
        cs.addPoint(point);

        return point;
    }

    public static void addLine(CSPoint point1,CSPoint point2, CoordinateSystem cs){
        CSLineSegment line = new CSLineSegment(point1, point2);
        lineCounter++;
        line.setId(lineCounter);
        cs.addLine(line);
    }

    public static void addTriangle(CSPoint point1,CSPoint point2, CSPoint point3, CoordinateSystem cs){
        CSTriangleSegment triangle = new CSTriangleSegment(point1, point2, point3);
        triCounter++;
        triangle.setId(triCounter);
        cs.addTriangle(triangle);
    }
    public static void main(String[] args) {
        int pointSize = 4;

        CoordinateSystem cs = new CoordinateSystem(500);

        CSPoint point1;
        CSPoint point2;
        CSPoint point3;

       /* point1 = addPoint(-250, 0, cs);
        point2 = addPoint(0, -250, cs);

        addLine(point1,point2,cs);

        point1 = addPoint(250, 250, cs);
        point2 = addPoint(0, -250, cs);

        addLine(point1,point2,cs);

        point1 = addPoint(250, 250, cs);
        point2 = addPoint(-250, 0, cs);

        addLine(point1,point2,cs);
        */
        point1 = addPoint(-250, 0, cs);
        point2 = addPoint(0, -250, cs);
        point3 = addPoint(4, 4, cs);

        addTriangle(point1,point2,point3,cs);



        CSRenderer renderer = new CSRenderer(cs, 1, pointSize);
    }
}
