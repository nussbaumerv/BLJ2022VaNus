#include <stdio.h>
int isLeapYear(int year);
int daysInMonth(int days, int year);
void printDateInfo(int month, int year);
int main() {
    int month = 10;
    int year = 1997;
    // todo get user input for month and year 
    // todo third
    printDateInfo(month, year);
    
    return 0;
}
int isLeapYear(int year){
    // todo first
    // returns 1 if isLeapYear
    // returns 0 if is no LeapYear
}
int daysInMonth(int days, int year){
    // to do second
    // returns 30, 31, 28 or 29
}
void printDateInfo(int month, int year){
    int days = daysInMonth(month, year);
    
    printf("Der Monat %d hat im Jahr %d %d Tage. \n", month, year, days);
    
    printf("Das Jahr %d ist ", year);
    if(!isLeapYear(year)){
        printf("kein ");
    }else{
        printf("ein ");
    }
    printf("Schaltjahr. \n");
}