#include <stdio.h>
int drawClock(int arr[15][15]){
    for(int row = 0; row < 15; row++) {
        for (int col = 0; col < 15; col++) {
            if(arr[row][col] > 1){
                if(arr[row][col] == 2){
                    printf("    ");
                }
                else{
                    printf("-%d-", arr[row][col]);
                }
            }
            else {
                if (arr[row][col] == 1) {
                    printf("++++");
                }
                else if (arr[row][col] == 0) {
                    printf("----");
                }
            }
        }
        printf("\n");
    }
}
int generateArr(double time){
    int arr[15][15] = {{2,2,2,2,0,0,0,60,0,0,0,2,2,2,2},
                       {2,2,2,0,0,0,0,0,0,0,0,0,2,2,2},
                       {2,2,0,0,0,0,0,0,0,0,0,0,0,2,2},
                       {2,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                       {45,0,0,0,0,0,0,1,0,0,0,0,0,0,15},
                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                       {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                       {2,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                       {2,2,0,0,0,0,0,0,0,0,0,0,0,2,2},
                       {2,2,2,0,0,0,0,0,0,0,0,0,2,2,2},
                       {2,2,2,2,0,0,0,30,0,0,0,2,2,2,2},
    };
    if(time <= 60 && time >= 0) {
        printf("\nYour time: \n");
        if ((time < 3.75 && time >= 0) || (time > 56.25 && time <= 60)) {
            for (int i = 0; i < 7; i++) {
                arr[i][7] = 1;
            }
        }
        if (time < 11.25 && time >= 3.75) {
            int col = 14;
            for (int i = 0; i < 7; i++) {
                if(arr[i][col] == 0) {
                    arr[i][col] = 1;
                }
                col--;
            }
        }
        if (time < 18.75 && time >= 11.25) {
            for (int i = 7; i < 15; i++) {
                arr[7][i] = 1;
            }
        }
        if (time < 26.25 && time >= 18.75) {
            int col = 7;
            for (int i = 7; i < 15; i++) {
                if(arr[i][col] == 0) {
                    arr[col][i] = 1;
                }
                col++;
            }
        }
        if (time < 33.75 && time >= 26.25) {
            for (int i = 7; i < 15; i++) {
                arr[i][7] = 1;
            }
        }
        if (time < 41.25 && time >= 33.75) {
            int col = 7;
            for (int i = 7; i < 15; i++) {
                if(arr[i][col] == 0) {
                    arr[i][col] = 1;
                }
                col--;
            }
        }
        if (time < 48.75 && time >= 41.25) {
            for (int i = 0; i < 7; i++) {
                arr[7][i] = 1;
            }
        }
        if (time < 56.25 && time >= 48.75) {
            int col = 0;
            for (int i = 0; i < 7; i++) {
                if(arr[i][col] == 0) {
                    arr[i][col] = 1;
                }
                col++;
            }

        }
        drawClock(arr);
    }
    else{
        printf("Your input isn't valid!\n");
    }

}

int main() {
    double time = 0;
    int keepDoing = 1;
    printf("Welcome to my clock!\n");
    do {
        printf("Enter the time in minutes:");
        scanf("%lf", &time);
        generateArr(time);
        printf("\nDo you want to do it again?\n");
        printf("   1: Yes\n");
        printf("   0: No\n");
        printf("Enter specific number:");
        scanf("%d", &keepDoing);
        printf("\n\n");
    }
    while(keepDoing == 1);
    printf("Thanks for using my program");
    return 0;
}
