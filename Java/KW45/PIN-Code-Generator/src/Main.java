public class Main {
    public static void main(String[] args) {
        int res = 0;

        for (int i = 0; i < 10000; i++){
            int length = String.valueOf(res).length();
            if (length < 2){
                System.out.println("Pin: 000" + res);
            }
            else if (length < 3){
                System.out.println("Pin: 00" + res);
            }
            else if (length < 4){
                System.out.println("Pin: 0" + res);
            }
            else{
                System.out.println("Pin: " + res);
            }
            res++;
        }
    }
}
