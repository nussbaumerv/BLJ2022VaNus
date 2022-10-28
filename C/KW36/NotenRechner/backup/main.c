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
    float marks[25] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    printf("\nNumber of grades: ");
    scanf("%d", &num_mark);
    fflush(stdin);

    if(num_mark < 1 || num_mark > 25){
        printf("Sorry my programm only supports numbers between 1 and 25. \nThe default of 5. Grades will be used\n");
        num_mark = 5;
    }

    for (int i = 0; i < num_mark; i++)
    {
        printf("Enter your %d. number: ", i+1);
        scanf("%f", &input);
        fflush(stdin);
        if (input <= 6 && input >= 1)
        {
            marks[i] = input;
        }
        else{
            printf("\nYou entered a Invaild number\n");
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

    float result = 0;
    for (int i = 0; i <= num_mark; i++)
    {
        float grade = marks[i];
        result += grade;
    }
    float average = result / num_mark;
    printf("You're averga grade is: %.2f\n", average);
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
