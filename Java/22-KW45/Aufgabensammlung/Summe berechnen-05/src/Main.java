public class Main {
    static void printNumbers(int startPoint, int endPoint){
        int result = 0;
        for(int i = startPoint; i <= endPoint; i++){
            result += i;
        }
        System.out.println("The result of the range of " + startPoint + " and " + endPoint + " is: " + result);
    }
    public static void main(String[] args) {
        printNumbers(3, 27);
        printNumbers(1, 100);
    }
}
