import java.util.HashMap;
import java.util.Map.Entry;

public class Translator {
    public static String translateToMorse(int method, String input) {
        HashMap<String, String> morseMap = new HashMap<String, String>();

        morseMap.put("A", ".-");
        morseMap.put("B", "-...");
        morseMap.put("C", "-.-.");
        morseMap.put("D", "-..");
        morseMap.put("E", ".");
        morseMap.put("F", "..-.");
        morseMap.put("G", "--.");
        morseMap.put("H", "....");
        morseMap.put("I", "..");
        morseMap.put("J", ".---");
        morseMap.put("K", "-.-");
        morseMap.put("L", ".-..");
        morseMap.put("M", "--");
        morseMap.put("N", "-.");
        morseMap.put("O", "---");
        morseMap.put("P", ".--.");
        morseMap.put("Q", "--.-");
        morseMap.put("R", ".-.");
        morseMap.put("S", "...");
        morseMap.put("T", "-");
        morseMap.put("U", "..-");
        morseMap.put("V", "...-");
        morseMap.put("W", ".--");
        morseMap.put("X", "-..-");
        morseMap.put("Y", "-.--");
        morseMap.put("Z", "--..");

        morseMap.put("1", ".----");
        morseMap.put("2", "..---");
        morseMap.put("3", "...--");
        morseMap.put("4", "....-");
        morseMap.put("5", ".....");
        morseMap.put("6", "-....");
        morseMap.put("7", "--...");
        morseMap.put("8", "---..");
        morseMap.put("9", "----.");
        morseMap.put("0", "-----");

        morseMap.put(" ", "/");

        String before;
        String result = "";
        String translated = "";
        boolean successful = true;

        if (method == 1) {
            char inputArr[] = input.toCharArray();
            for (int i = 0; i < inputArr.length; i++) {
                before = Character.toString(inputArr[i]);
                translated = morseMap.get(before);
                if(translated == null || translated.isEmpty()){
                    successful = false;
                }
                result = result + translated + " ";
            }
        } else {
            String[] inputArr = null;
            inputArr = input.split(" ");

            for (int i = 0; i < inputArr.length; i++) {
                before = inputArr[i];
                for (Entry<String, String> entry : morseMap.entrySet()) {
                    if (entry.getValue().equals(before)) {
                        translated = entry.getKey();
                        if(translated == null || translated.isEmpty()){
                            successful = false;
                        }
                        result = result + translated;
                        break;
                    }
                }
            }
        }
        if(successful){
            return result;
        }
        else {
            return "Please enter Valid input";
        }
    }
}
