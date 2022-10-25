#include <stdio.h>
#include "utils.h"

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

    printf("+--------------------+\n");
    printf("|  Enter the number  |\n");
    printf("+--------------------+\n");
}
