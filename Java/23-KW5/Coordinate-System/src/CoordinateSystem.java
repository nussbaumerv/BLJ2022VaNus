import java.util.ArrayList;


public class CoordinateSystem {
    ArrayList<CSPoint> points = new ArrayList<>();
    private int fieldSize;
    public CoordinateSystem(int size) {
        if(size > 0 && size % 20 == 0){
            this.fieldSize = size;
        } else{
            throw new IllegalArgumentException();
        }

    }
    public void addPoint(CSPoint point){
        points.add(point);
    }

    public int getCoordinateSystemSize() {
        return fieldSize;
    }

    public ArrayList<CSPoint> getPoints() {
        return points;
    }

    public CSPoint[] getAllPoints() {
        CSPoint[] pointArr = getPoints().toArray(new CSPoint[0]);
        return pointArr;
    }
}
