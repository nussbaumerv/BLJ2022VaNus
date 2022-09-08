/*
 * File:   main.c
 * Author: surber
 *
 * Created on 7. September 2022, 10:29
 */

#include <stdio.h>
#include <stdlib.h>

#define NUM_MARKS 5

int main(int argc, char **argv)
{

    printf("-----------------------\n");
    printf("Average Mark Calculator\n");
    printf("-----------------------\n");

    int num_mark;
    float input;
    float multiplier;
    float marks[25] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    float weight[25] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    printf("\nNumber of grades: ");
    scanf("%d", &num_mark);
    fflush(stdin);

    if(num_mark < 1 || num_mark > 25){
        printf("Sorry my programm only supports numbers between 1 and 25. \nThe default of 5. Grades will be used\n");
        num_mark = 5;
    }

    for (int i = 0; i < num_mark; i++)
    {
        printf("\nEnter your %d. number: ", i+1);
        scanf("%f", &input);
        fflush(stdin);

        printf("Enter the weight between 1 and 100: ");
        scanf("%f", &multiplier);
        fflush(stdin);
        if (input <= 6 && input >= 1 && multiplier <= 100 && multiplier >= 1)
        {
            marks[i] = input;
            weight[i] = multiplier;
        }
        else{
            printf("\nYou entered a Invaild number and or weight\n");
            i--;
        }
    }
    fflush(stdin);

    /*
     * TODO - Read as many marks as defined in NUM_MARKS.
     *      - Save read marks in an array of length NUM_MARKS.
     */

    printf("-----------------------\n");

    /*
     * TODO - Calculate and store the sum of all marks.
     */
    float grade_weight = 0;
    float weight_result;
    for (int i = 0; i <= num_mark; i++)
    {
        float grade = marks[i];
        float weight_cache = weight[i];

        float cache = grade * weight_cache;
        grade_weight += cache;
        weight_result += weight_cache;
    }
    float average = grade_weight / weight_result;
    printf("You're averge grade is: %.2f\n", average);
    /*
     * TODO - Calculate and print the average mark.
     */

    /*
     * TODO - Extra tasks, implement only after completing all previous TODOs.
     *      - Round the calculated average to 2 decimal places (output only).
     *      - While inputting, only allow values between 1.0 and 6.0.
     *      - For every mark, input a weight and calculate the average accordingly.
     *      - Allow for the manipulation of individual marks, using the index.
     */
    system("pause");

    return (EXIT_SUCCESS);
}
