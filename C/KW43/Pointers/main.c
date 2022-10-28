#include <stdio.h>

int makeUppercase(int lowInt){
   if(lowInt >= 97 && lowInt <= 122){
       printf("The value: %c will get converted\n", lowInt);
       int highInt = lowInt - 32;
       printf("Your entered letter in Uppercase: %c\n", highInt);
   }
   else if(lowInt >= 65 && lowInt <= 89){
       printf("Please enter a Lowercase letter\n");
   }
   else{
       printf("Please enter letter\n");
   }

}

int main() {
    printf("Welcome to my Uppercase generator\n");
    char input = 'l';
    makeUppercase(input);

    return 0;
}
