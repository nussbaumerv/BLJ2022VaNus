#include <stdio.h>
int isLeapYear(int year);
int daysInMonth(int month, int year);
void printDateInfo(int month, int year);
int main()
{
    int month;
    int year;

    printf("\033[0;31m");
    printf("------------------------------------- \n");
    printf("|   Leap year and month calculator. |\n");
    printf("-------------------------------------\n");
    printf("\033[0;37m");

    printf("\nBitte geben Sie den Monat ein: ");
    scanf("%d", &month);

    fflush(stdin);

    printf("Bitte geben Sie das Jahr ein: ");
    scanf("%d", &year);

    fflush(stdin);

    printDateInfo(month, year);

    return 0;
}
int isLeapYear(int year)
{
    if (year % 4 == 0)
    {
        if (year % 100 == 0)
        {
            if (year % 400 == 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return 1;
        }
    }
    else
    {
        return 0;
    }
}
// todo first
// returns 1 if isLeapYear
// returns 0 if is no LeapYear
int daysInMonth(int month, int year)
{
    if (month == 4 || month == 6 || month == 9 || month == 11)
    {
        return 30;
    }
    else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
    {
        return 31;
    }
    else
    {
        if (month == 2)
        {
            if (isLeapYear(year))
            {
                return 29;
            }
            else
            {
                return 28;
            }
        }
        else
        {
            printf("You entered a wrong number\n\n");
            main();
        }
    }

    // to do second
    // returns 30, 31, 28 or 29
}
void printDateInfo(int month, int year)
{
    int days = daysInMonth(month, year);

    printf("\nDer Monat %d hat im Jahr %d %d Tage. \n", month, year, days);

    printf("Das Jahr %d ist ", year);
    if (!isLeapYear(year))
    {
        printf("kein ");
    }
    else
    {
        printf("ein ");
    }
    printf("Schaltjahr. \n");
}