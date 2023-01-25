package ch.noseryoung.blj;

public class Main {
    public static int computeGarmentSize(boolean female, int brustumfang, int groesse){
        brustumfang /= 2;
        if(female){
            brustumfang -= 6;

        }
        return brustumfang;
    }
    public static void main(String[] args) {
        int brustumfang = 100;
        int groesse = 180;
        boolean female = false;

        int Konfektiongroesse = computeGarmentSize(female,brustumfang,groesse);
        System.out.println(Konfektiongroesse);

    }
}
