import java.util.ArrayList;


public class CoordinateSystem {
    ArrayList<CSPoint> points = new ArrayList<>();
    ArrayList<CSLineSegment> lines = new ArrayList<>();
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
    public void addLine(CSLineSegment line){
        lines.add(line);
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

    public ArrayList<CSLineSegment> getLine() {
        return lines;
    }

    public CSLineSegment[] getAllLines() {
        CSLineSegment[] lineArr = getLine().toArray(new CSLineSegment[0]);
        return lineArr;
    }
}
