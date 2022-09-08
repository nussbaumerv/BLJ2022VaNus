/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: nussb
 *
 * Created on 2. September 2022, 09:48
 */

#include <stdio.h>
#include <stdlib.h>
#include "inputhandler.h"

/*
 * 
 */
int main(int argc, char** argv) {
    int firstNumber;
    int secondNumber;
    int number;
    
    printf("Enter the first number: ");
    scanf("%d", &firstNumber);
    
      printf("Enter the second number: ");
    scanf("%d", &secondNumber);
    
      printf("Enter the number: ");
    scanf("%d", &secondNumber);
    
    handler(firstNumber, secondNumber);
    return (EXIT_SUCCESS);
}

