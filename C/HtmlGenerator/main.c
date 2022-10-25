#include <stdio.h>
void generateTable(int columns, int rows){
    printf("<table>\n");
    for(int i = 1; i < rows+1; i++){
        printf("   <tr>\n");
        for(int c = 1; c < columns+1; c++){
            if(i == 1){
                printf("\t<th>Titel: %d</th>\n", c);
            }
            else {
                printf("\t<td>%d/%d</td>\n", i, c);
            }

        }
        printf("   </tr>\n");
    }
    printf("\n</table>");
}

int main() {
    int columns = 0;
    int rows = 0;
    int body = 0;
    char output[100] = "old";
    printf("Welcome to my HTML table generator!\n");
    printf("Enter collums:");
    scanf("%d", &columns);
    printf("Enter rows:");
    scanf("%d", &rows);
    printf("Enter 1 if you want to also generate a body:");
    scanf("%d", &body);
    fflush(stdin);
    printf("\n\nYour generated HTML: \n");
    if(body == 1){
        printf(""
               "<!DOCTYPE html>\n"
               "<html lang=\"en\">\n"
               "<head>\n"
               "    <meta charset=\"UTF-8\">\n"
               "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
               "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
               "    <title>Generated Table</title>\n"
               "</head>\n"
               "<body>\n");
        generateTable(columns, rows);
        printf(""
               "\n</body>\n"
               "</html>");

    }
    else {
        generateTable(columns, rows);
    }
    FILE *file = fopen("generated.html", "w");

    int results = fputs(output, file);
    if (results == EOF) {
        printf("Something went wrong.");
    }
    fclose(file);

    return 0;
}
