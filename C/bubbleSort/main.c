/*
 * File:   main.c
 * Author: surber
 *
 * Created on 7. September 2022, 10:29
 */

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    int numbers[5] = {1, 4, -1, 2, 3};
    int count_total = 9;
    int counter = 0;
    int countLoop = 0;

    while (count_total)
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
        //printf("a=%d b=%d an=%d bn=%d c=%d ct=%d\n", a, b, numbers[counter], numbers[counter + 1], counter, count_total);
        counter++;
        count_total--;
    }
    printf("This array was sorted by the bubble Sort algoryth.\nResult: ");

    for (int i = 0; i <= 4; i++)
    {
        printf("%d", numbers[i]);
    }
    printf("\n");
    system("pause");

    return (EXIT_SUCCESS);
}
