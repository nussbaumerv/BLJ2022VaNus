#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int randomNum;

int getRandomNums(unsigned int n) {
    srand(time(NULL));
    for (int i = 0; i < n; ++i) {
        randomNum = rand() % 100 + 1;
        printf("Number %d: %d\n", (i+1), randomNum);
    }
}
int main() {
    unsigned int *p_n = &randomNum;
    int n = 0;

    *p_n = (int *) malloc( sizeof(int));
    printf("Welcome to my generator\n");
    printf("Enter how many numbers you want to generate:");
    scanf("%d", &n);

    getRandomNums(n);
}