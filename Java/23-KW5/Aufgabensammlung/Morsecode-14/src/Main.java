public class Main {
    public static void main(String[] args) {
        String input = "Wozu Worte drucken, es gibt doch Schreiber";

        input = input.toLowerCase();
        input = input.replaceAll("\\s", "");
        input = input.replaceAll(",","");

        String[] morseArr = new String[123];

        morseArr[48] = "---- -";
        morseArr[49] = ".----";
        morseArr[50] = "..---";
        morseArr[51] = "...--";
        morseArr[52] = "....-";
        morseArr[53] = ".....";
        morseArr[54] = "-....";
        morseArr[55] = "--...";
        morseArr[56] = "---..";
        morseArr[57] = "----.";

        morseArr[97] = ".-";
        morseArr[98] = "-...";
        morseArr[99] = "-.-.";
        morseArr[100] = "-..";
        morseArr[101] = ".";
        morseArr[102] = "..-.";
        morseArr[103] = "--.";
        morseArr[104] = "....";
        morseArr[105] = "..";
        morseArr[106] = ".---";
        morseArr[107] = "-.-";
        morseArr[108] = ".-..";
        morseArr[109] = "--";
        morseArr[110] = "-.";
        morseArr[111] = "---";
        morseArr[112] = ".--.";
        morseArr[113] = "--.-";
        morseArr[114] = ".-.";
        morseArr[115] = "...";
        morseArr[116] = "-";
        morseArr[117] = "..-";
        morseArr[118] = "...-";
        morseArr[119] = ".--";
        morseArr[120] = "-..-";
        morseArr[121] = "-.--";
        morseArr[122] = "--..";

        System.out.println(input);
        char[] charInput = input.toCharArray();

        for (int i = 0; i < charInput.length; i++) {
            int indexVar = (int) charInput[i];
            System.out.print(morseArr[indexVar]+" ");
        }

    }
}
