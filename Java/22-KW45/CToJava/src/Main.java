import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numbers[] = {1, 4, -1, 2, 7};
        int count_total = 9;
        int counter = 0;
        int countLoop = 0;

        while (count_total > 0)
        {
            if (counter >= 4 - countLoop)
            {
                countLoop++;
                for (int i = 0; i <= 5; i++)
                {
                    //printf("%d\n", numbers[i]);
                }
                counter = 0;
            }
            int a = numbers[counter];
            int b = numbers[counter + 1];
            if (a > b)
            {
                numbers[counter] = b;
                numbers[counter + 1] = a;
            }
            counter++;
            count_total--;
        }
        System.out.println("\n\nThis array was sorted by the bubble Sort algoryth.\nResult: ");

        for (int i = 0; i <= 4; i++)
        {
            System.out.println(numbers[i]);
        }
        System.out.println("\n");
        System.out.println("Enter de Number you want to search: ");
        int find = scan.nextInt();
        boolean keepFind = true;
        int start_point = 0;
        int end_point = 4;
        int middle = 0;


        if(numbers[end_point] < find){
            keepFind = false;
            System.out.println("Your number is to big");
        }

        while(keepFind){
            middle = start_point + end_point / 2;
            System.out.println(" sp"+start_point+" ep"+end_point+" mi"+middle);
            if(numbers[middle] == find){
                keepFind = false;
                System.out.println("Your number: " + numbers[middle] + " is on the " + middle + ". Place in the Index");
            }
            if(numbers[end_point] == find){
                keepFind = false;
                System.out.println("Your number: " + numbers[end_point] + " is on the " + end_point + ". Place in the Index");
                System.out.println(end_point);
            }
            else if(middle < find){
                start_point = middle;
            }
            else if(middle > find){
                end_point = middle;
            }
            else {
                System.out.println("Your number isn't in the Index");
                keepFind = false;
            }
        }



    }
}
