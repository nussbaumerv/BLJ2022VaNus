public class Main {
    public static void main(String[] args) {
        int numberToTest = 12321;
        int lengthOfNumber = 1;
        while(numberToTest > 9){
            numberToTest /= 10;
            lengthOfNumber++;
        }
        System.out.println(lengthOfNumber);


    }
}
