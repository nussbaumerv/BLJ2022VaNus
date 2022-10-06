#include <stdio.h>

int main() {

    char input[5] = "a";
    printf("a) schreibt Hallo\n");
    printf("b) schreibt Hi\b");
    printf("sonst schreibt Goodbye\n");
    //scanf("%c", &input);
    //fflush(stdin);
    switch (input) {
        case 'A':
        case 'a':
            printf("Hallo\n");
            break;
        case 'B':
        case 'b':
            printf("Hi\n");
            break;
        default:
            printf("Goodbye\n");
    }
    return 0;
}
