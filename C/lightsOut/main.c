#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "utils.h"

#define FIELD_SIZE 5

int main(void) {
    srand(time(NULL));
    int field[FIELD_SIZE][FIELD_SIZE] = {
            {rand() % 2, rand() % 2, rand() % 2, rand() % 2, rand() % 2},
            {rand() % 2, rand() % 2, rand() % 2, rand() % 2, rand() % 2},
            {rand() % 2, rand() % 2, rand() % 2, rand() % 2, rand() % 2},
            {rand() % 2, rand() % 2, rand() % 2, rand() % 2, rand() % 2},
            {rand() % 2, rand() % 2, rand() % 2, rand() % 2, rand() % 2},
    };
    int blankFieldX = 0;
    int blankFieldY = 0;
    int inputX = 0;
    int inputY = 0;

    do {
        printField(FIELD_SIZE, field);
        printf("Enter X:");
        scanf(" %d", &inputX);
        printf("Enter Y:");
        scanf(" %d", &inputY);

        if (-1 < inputY - 1) {
            printf("1 OK\n");
            if (1 == field[inputY - 1][inputX]) {
                field[inputY - 1][inputX] = 0;
            } else {
                field[inputY - 1][inputX] = 1;
            }
        }
        if (5 > inputY + 1) {
            printf("2 OK\n");
            if (1 == field[inputY + 1][inputX]) {
                field[inputY + 1][inputX] = 0;
            } else {
                field[inputY + 1][inputX] = 1;
            }
        }
        if (-1 < inputX - 1) {
            printf("3 OK\n");
            if (1 == field[inputY][inputX - 1]) {
                field[inputY][inputX - 1] = 0;
            } else {
                field[inputY][inputX -1] = 1;
            }
        }
        if (5 > inputX + 1) {
            printf("4 OK\n");
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



    } while (inputX != -1);
    system("pause");

}