#include <stdio.h>
#include <stdlib.h>
#include "utils.h"

#define FIELD_SIZE 4

/**
 * This programm depicts an all-time classic, the sliding puzzle. The one and
 * only 0 represents the empty slot in the sliding puzzle. Moves (sliding up,
 * down, left, right) are always made relative to the empty slot e.g. in the
 * case of the initial state of the field, only the moves left (swap 0 with 15)
 * and up (swap 0 with 8) can be made. This programm doesn't detect whether the
 * field is sorted. It runs as long as the user doesn't enter a 0.
 *
 * @return 0 if the programm was successfully run.
 */
int main(void) {
    int field[FIELD_SIZE][FIELD_SIZE] = {
            { 0, 14,  1, 13},
            { 8,  5,  2,  3},
            {15,  7,  4,  9},
            {10, 11,  6, 12},
    };
    int blankFieldX = 0;
    int blankFieldY = 0;
    int input = 0;

    do {
        printField(FIELD_SIZE, field);
        scanf("%d", &input);

        if (input == 1) {
            if (blankFieldX < FIELD_SIZE - 1) {
                swapValues(&field[blankFieldY][blankFieldX], &field[blankFieldY][blankFieldX + 1]);
                blankFieldX ++;
            }
            else{
                printf("This Step isn't Possible choose another one");
            }
        }else if(input == 4){
            if(blankFieldX > 0) {
                swapValues(&field[blankFieldY][blankFieldX], &field[blankFieldY][blankFieldX - 1]);
                blankFieldX --;
            }
            else{
                printf("This Step isn't Possible choose another one");
            }
        }else if(input == 2){
            if(blankFieldY < FIELD_SIZE - 1){
                swapValues(&field[blankFieldY][blankFieldX], &field[blankFieldY + 1][blankFieldX]);
                blankFieldY ++;
            }
            else{
                printf("This Step isn't Possible choose another one");
            }
        }else if(input == 3){
            if(blankFieldY > 0){
                swapValues(&field[blankFieldY][blankFieldX], &field[blankFieldY - 1][blankFieldX]);
                blankFieldY --;
            }
            else{
                printf("This Step isn't Possible choose another one");
            }
        }
    } while (input != 0);
    system("pause");

}
