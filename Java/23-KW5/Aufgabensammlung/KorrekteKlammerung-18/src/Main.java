public class Main {
    public static boolean detectCorrectBraces(String input) {
        int openBraces = 0;
        int closedBraces = 0;
        boolean validPro = true;
        boolean validFinal = false;

        char[] inputChar = input.toCharArray();
        for (int i = 0; i < inputChar.length; i++) {
            if (inputChar[i] == '(') {
                openBraces++;
            }
            if (inputChar[i] == ')') {
                if(openBraces > closedBraces) {
                    closedBraces++;
                } else{
                    validPro = false;
                }
            }
        }
        if (openBraces == closedBraces && validPro) {
            validFinal = true;
        }
        return validFinal;
    }

    public static void main(String[] args) {
        String input = "";
        System.out.println("Correct braces set: " + detectCorrectBraces(input));
    }
}