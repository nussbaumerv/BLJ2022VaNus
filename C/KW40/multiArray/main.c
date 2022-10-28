#include <stdio.h>
#include <stdlib.h>

#define ARRAYLENGTH 4


int main() {
    int whichFunc = 0;
    int keepDoing = 1;
    int x = 0;
    int y = 0;
    int saveValue = 0;
    int arr[ARRAYLENGTH][ARRAYLENGTH] = {{0}};
    do {
        printf("What feauture do you want to use?\n");
        printf("1 -> Add Value\n");
        printf("2 -> Remove Value\n");
        scanf("%d", &whichFunc);
        fflush(stdin);

        printf("X Value:");
        scanf("%d", &x);

        printf("Y Value:");
        scanf("%d", &y);

        if (1 == whichFunc) {
            printf("Save Value:");
            scanf("%d", &saveValue);
            fflush(stdin);

            if (arr[x][y] == 0) {
                arr[x][y] = saveValue;
                printf("The Number %d got Added\n", saveValue);
            } else {
                printf("The Number already has a value reset it first.\n");
            }
        } else if (2 == whichFunc) {
            if (0 == arr[x][y]) {
                printf("The number is already reseted\n");
            } else {
                arr[x][y] = 0;
                printf("The number got reseted\n");
            }
        }
        printf("\nYour array So far:\n");
        printf("--------------------------------------------------------\n");
        for(int c = 0; c < ARRAYLENGTH; c++) {
            for (int i = 0; i < ARRAYLENGTH; i++) {
                printf("| %d ", arr[c][i]);
            }
            printf("|\n");
            printf("--------------------------------------------------------\n");
        }
        printf("\nDo you want to do id again?\nType 1 if you want to:");
        scanf("%d", &keepDoing);
    } while (keepDoing == 1);

    system("pause");
}
