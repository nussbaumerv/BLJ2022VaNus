#include <stdio.h>
#include "utils.h"

/**
 * This function prints the given board state in an aesthetically pleasing way.
 *
 * @param size  The size (both width and height) of the board.
 * @param field The board (2D array) to be printed.
 */
void printField(int size, int field[size][size]) {
    char out[1] = "";
    printf("\n    0    1    2    3    4  \n");
    printf("  +----+----+----+----+----+\n");
    for (int row = 0; row < size; row++) {
        printf("%d | ", row);
        for (int col = 0; col < size; col++) {
            if (field[row][col] != 0) {
                printf(" # | ");
            } else {
                printf(" . | ");
            }
        }
        printf("\n  +----+----+----+----+----+\n");
    }

    printf("+---------------+-------------+---------------+----------------+---------+\n");
    printf("| Enter the number                                                       |\n");
    printf("+---------------+-------------+---------------+----------------+---------+\n");
}

/**
 * This function swaps the values of two given variables using their addresses.
 *
 * @param num1  The address of the first variable.
 * @param num2  The address of the second variable.
 */
void swapValues(int *num1, int *num2) {
    int temp = *num1;
    *num1 = *num2;
    *num2 = temp;
}