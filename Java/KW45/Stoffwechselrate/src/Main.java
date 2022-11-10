public class Main {
    static void claculate(int weight, int height, int age){
        System.out.println("Mann: " + (66.47 + 13.7 * weight + 5 * height - 6.8 * age) + " Kalorien");
        System.out.println("Frau: " + (655.1 + 9.6 * weight + 1.8 * height - 4.7 * age) + " Kalorien");
    }
    public static void main(String[] args) {
        int weight = 58;
        int height = 180;
        int age = 25;
        claculate(weight, height, age);

    }
}
