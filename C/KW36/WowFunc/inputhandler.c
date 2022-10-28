/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
#include <stdio.h>
#include <stdlib.h>
int handler(int input){
    int counter = 0;
    if(input == 0){
        printf("Are you 0 Years old for real?\n");
    }
    while(counter < input){
        printf("You were %d \n", counter);
        counter++;
    }
    printf("And now you're %d", input);
}

