public class Main {
    public static void main(String[] args) {
        int numberToTest = 12321;
        int check = 0;
        int resultValue = 0;

        check = numberToTest;

        while (0 != check) {
            int decimalLess = check % 10;
            resultValue = resultValue * 10 + decimalLess;
            check = check / 10;
        }

        if (resultValue == numberToTest) {
            System.out.println("The number is a Palindrome");
        } else {
            System.out.println("The number isn't a Palindrome");
        }

    }
}
