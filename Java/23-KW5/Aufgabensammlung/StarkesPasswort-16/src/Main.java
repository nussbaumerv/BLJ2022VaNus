public class Main {

    public static boolean isStrong(String password) {

        boolean lowerCase = false;
        boolean upperCase = false;
        boolean number = false;
        boolean specialCharacter = false;

        boolean secure = false;

        char[] charInput = password.toCharArray();

        for (int i = 0; i < charInput.length; i++) {
            int ascii = (int) charInput[i];

            if (ascii <= 90 && 65 <= ascii) {
                upperCase = true;
            }
            if (ascii <= 122 && 97 <= ascii) {
                lowerCase = true;
            }
            if (ascii <= 57 && 48 <= ascii) {
                number = true;
            }
            if (ascii == 33 || 42 == ascii) {
                specialCharacter = true;
            }
        }

        if (upperCase && lowerCase && number && specialCharacter && charInput.length >= 8) {
            secure = true;
        }
        return secure;
    }

    public static void main(String[] args) {
        String password = "aH6*LauTp21u";
        System.out.println("Secure: " + isStrong(password));

    }
}