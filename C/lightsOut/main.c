#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "utils.h"

#define FIELD_SIZE 5

int main(void) {
    printf("\n+---------------+--------------+\n");
    printf("| Welcome to my Lightsout Game |\n");
    printf("+---------------+--------------+\n");
    srand(time(NULL));
    int field[FIELD_SIZE][FIELD_SIZE] = {
            {rand() % 2, rand() % 2, rand() % 2, rand() % 2, rand() % 2},
            {rand() % 2, rand() % 2, rand() % 2, rand() % 2, rand() % 2},
            {rand() % 2, rand() % 2, rand() % 2, rand() % 2, rand() % 2},
            {rand() % 2, rand() % 2, rand() % 2, rand() % 2, rand() % 2},
            {rand() % 2, rand() % 2, rand() % 2, rand() % 2, rand() % 2},
    };
    int inputX = 0;
    int inputY = 0;
    int win = 0;

    do {
        printField(FIELD_SIZE, field);
        printf("Enter X:");
        scanf(" %d", &inputX);
        printf("Enter Y:");
        scanf(" %d", &inputY);

        if(0 <= inputX && 4 >= inputX && 0 <= inputY && 4 >= inputY) {
            if (-1 < inputY - 1) {
                if (1 == field[inputY - 1][inputX]) {
                    field[inputY - 1][inputX] = 0;
                } else {
                    field[inputY - 1][inputX] = 1;
                }
            }
            if (5 > inputY + 1) {
                if (1 == field[inputY + 1][inputX]) {
                    field[inputY + 1][inputX] = 0;
                } else {
                    field[inputY + 1][inputX] = 1;
                }
            }
            if (-1 < inputX - 1) {
                if (1 == field[inputY][inputX - 1]) {
                    field[inputY][inputX - 1] = 0;
                } else {
                    field[inputY][inputX - 1] = 1;
                }
            }
            if (5 > inputX + 1) {
                if (1 == field[inputY][inputX + 1]) {
                    field[inputY][inputX + 1] = 0;
                } else {
                    field[inputY][inputX + 1] = 1;
                }
            }
            if (1 == field[inputY][inputX]) {
                field[inputY][inputX] = 0;
            } else {
                field[inputY][inputX] = 1;
            }
        }
        else{
            printf("Please enter a valid input. \n");
        }
        inputX = 0;
        inputY = 0;

    } while (win == 0);
    system("pause");

}