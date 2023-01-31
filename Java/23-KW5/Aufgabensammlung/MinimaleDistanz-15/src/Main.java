public class Main {
    public static int getMinDist(int[] arr){
        int num1 = 0;
        int num2 = 0;
        int index = 0;
        int minDist = 0;
        boolean first = true;

        for(int i = 0; i < arr.length-1; i++){
            int temp1 = arr[i];
            int temp2 = arr[i+1];
            int tempDiff = Math.abs(temp1-temp2);
            if(first || tempDiff < minDist){
                first = false;
                num1 = temp1;
                num2 = temp2;
                minDist = tempDiff;
                index = i;
            }

        }
        System.out.println(minDist + "(=" + num1 + "-" + num2 + ")");

        return index;
    }
    public static void main(String[] args) {
        int index = getMinDist(new int[]{33, 8, 1, 6, 43, 54});
        System.out.println("Index: " + index);
    }
}