public class Main {
    public static boolean isEmail(String email){
        boolean validName = false;
        boolean validAt = false;
        boolean validDomain = false;
        boolean validPoint = false;
        boolean validEmail = false;

        int tldCount = 0;

        char[] emailChar = email.toCharArray();
        for(int i = 0; i < emailChar.length; i++){
            if(!validAt){
                if(emailChar[i] != '@' && emailChar[i] != '.'){
                    validName = true;
                } else if(emailChar[i] == '@' && validName){
                    validAt = true;
                }
            } else if(!validPoint){
                if(emailChar[i] != '@' && emailChar[i] != '.'){
                    validDomain = true;
                } else if(emailChar[i] == '.' && validDomain){
                    validPoint = true;
                }
            } else {
                if(emailChar[i] != '@' && emailChar[i] != '.'){
                    tldCount++;
                }
            }
        }
        if(tldCount == 2 || tldCount == 3){
            validEmail = true;
        }
        return validEmail;
    }
    public static void main(String[] args) {
        String email = "john@doe.net";
        System.out.println("This email is: " + isEmail(email));
    }
}