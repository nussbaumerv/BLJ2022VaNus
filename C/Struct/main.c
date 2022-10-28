#include <stdio.h>
#include "string.h"



typedef struct Customers {
    int id;
    char name[20];
    char username[20];
    char email[20];
} TCustomers;

void printCustomer(TCustomers customer){
    printf("***************** \n");
    printf("Id: %d \n", customer.id);
    printf("Name: %s \n", customer.name);
    printf("Username: %s \n", customer.username);
    printf("Email: %s \n", customer.email);
    printf("***************** \n");
}



int main() {
   char costumersArr[4][4] = {{"1", "Valentin Nussbaumer", "nussbaumerv", "nussbaumerv9@gmail.com"},
                               {"2", "Ha Nussbaumer", "nussbaumerv", "nussbaumerv9@gmail.com"},
                               {"2", "Lol Nussbaumer", "nussbaumerv", "nussbaumerv9@gmail.com"},
                               {"2", "So Nussbaumer", "nussbaumerv", "nussbaumerv9@gmail.com"}};
    for(int i = 0; i < 4; i++){
       // TCustomers customer = {{costumersArr[0][i], costumersArr[1][i], costumersArr[2][i] costumersArr[0][i]};
    }
    TCustomers customer = {0};
    customer.id = 1;
    strcpy(customer.name, "Max Muster");
    strcpy(customer.username, "maxmust");
    strcpy(customer.email, "maxmust@gmail.com");

    printCustomer(customer);

    /*TBook *p_book = &book;
    printf("published: %d \n", (*p_book).published);
    printf("published: %d \n", p_book->published);*/



    return 0;
}