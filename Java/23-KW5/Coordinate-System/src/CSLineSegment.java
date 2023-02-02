public class CSLineSegment {
    public static void addPoint(int x, int y, CoordinateSystem cs){
        CSPoint point = new CSPoint(x,y);
        point.setId(0);
        cs.addPoint(point);
    }
    public CSLineSegment(CSPoint p1, CSPoint p2, CoordinateSystem cs){
        int x1 = (int) p1.getX();
        int y1 = (int) p1.getY();

        int x2 = (int) p2.getX();
        int y2 = (int) p2.getY();

        int xDiff = Math.abs(x1-x2);
        int yDiff = Math.abs(y1-y2);

        int xM = xDiff;
        int yM = yDiff;



        double distBetween = (Math.pow(xDiff,2)) + (Math.pow(yDiff,2));
        distBetween = Math.sqrt(distBetween);

        for(int i = 0; i < distBetween; i++){
            addPoint((x1 + (i * xM)), (y1 + (i * yM)), cs);


        }

    }
}
