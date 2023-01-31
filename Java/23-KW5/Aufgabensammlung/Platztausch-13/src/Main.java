public class Main {
    public static int[] sortArrays(int[] arr){
        for(int i = 0; i < (int)(arr.length / 2); i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        int newArr[] = sortArrays(new int[]{1,2,3,4,5,6,7,8});
        for(int i = 0; i < newArr.length; i++){
            System.out.println(newArr[i]);
        }

    }
}