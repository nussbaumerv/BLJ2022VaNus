
public class Main {
    static double claculate(double length, double durchmesser){
        double result = (Math.PI/4) * (durchmesser * durchmesser) * (length / 10000);
        return result;


    }
    public static void main(String[] args) {
        double length = 5;
        double durchmesser = 15;
        double result = claculate(length, durchmesser);
        System.out.println(result + " cm2");

    }
}
