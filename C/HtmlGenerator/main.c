#include <stdio.h>
#include <string.h>
#include <stdlib.h>



void generateTable(int columns, int rows){
    printf("<table>\n");
    for(int i = 0; i < rows+1; i++){
        printf("   <tr>\n");
        for(int c = 1; c < columns+1; c++){
            if(i == 0){
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
void generateCSS(char path[]){
    strncat(path, "style.css", 100);
    FILE *fs;
    fs = fopen(path, "w");
    fprintf(fs,""
               "        body{\n"
               "            background-color: rgb(167, 203, 212);\n"
               "            margin:0px;\n"
               "            font-family: arial;\n"
               "            text-align: center;\n"
               "        }\n"
               "        table{\n"
               "            width:100%;\n"
               "\n"
               "        }\n"
               "        th{\n"
               "            background-color: gray;\n"
               "            padding:10px;\n"
               "            border:solid;\n"
               "            border-color:black;\n"
               "        }\n"
               "        td{\n"
               "            background-color: rgb(199, 199, 199);\n"
               "            padding:7px;\n"
               "            border:solid;\n"
               "            border-color:black;\n"
               "        }");
    fclose(fs);
}
void generateHTML(int columns, int rows){
    char choosePath = 1;
    char name[100] = "";
    char inputPath[100] = "";
    char absolutePath[100] = "";
    printf("Enter filename:");
    scanf("%s", &name);
    strncat(name, ".html", 6);
    printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    printf("Where should your file get stored?\n");
    printf("  1: In this directory\n");
    printf("  2: Custom directory\n");
    printf("Enter the specific number:");
    scanf("%d", &choosePath);
    printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

    if(choosePath == 2){
        printf("Enter Path (without filename at the end):");
        scanf("%s", &inputPath);
        printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        strncat(absolutePath, inputPath, 100);
        strncat(absolutePath, name, 100);
        //C:/Users/nussb/Desktop/
    }
    else {
        strncat(absolutePath, name, 100);
    }
    FILE *fl;
    fl = fopen(absolutePath, "w");
    fprintf(fl, ""
                "<!DOCTYPE html>\n"
                "<html lang=\"en\">\n"
                "<head>\n"
                "    <meta charset=\"UTF-8\">\n"
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                "    <title>Generated Table</title>\n"
                "    <link rel=\"stylesheet\" href=\"style.css\">\n"
                "</head>\n"
                "<body>\n"
                "<table>");
    fprintf(fl, "\n");
    for (int i = 0; i < rows + 1; i++) {
        fprintf(fl, "   <tr>\n");
        for (int c = 1; c < columns + 1; c++) {
            if (i == 0) {
                fprintf(fl, "\t<th>Titel: %d</th>\n", c);
            } else {
                fprintf(fl, "\t<td>(%d,%d)</td>\n", i, c);
            }

        }
        fprintf(fl, "   </tr>\n");
    }
    fprintf(fl, ""
                "</table>"
                "\n</body>\n"
                "</html>");
    fclose(fl);

    int css = 0;
    printf("Do you also want to create a CSS file?\n");
    printf("  1: Yes\n");
    printf("  2: No\n");
    printf("Enter the specific number:");
    scanf("%d", &css);
    printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    fflush(stdin);
    if(css == 1) {
        generateCSS(inputPath);
    }
    printf("\n---------------------------\n");
    printf("| Your file got generated |\n");
    printf("---------------------------\n");

    char cmd[] = "START ";
    strncat(cmd, absolutePath, 100);
    system(cmd);


}

int main() {
    int columns = 0;
    int rows = 0;
    int body = 0;
    printf("---------------------------------------\n");
    printf("| Welcome to my HTML table generator! |\n");
    printf("---------------------------------------\n");
    printf("Enter columns:");
    scanf("%d", &columns);
    printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    printf("Enter rows:");
    scanf("%d", &rows);
    printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    printf("What feature do you want to use?\n");
    printf("  1: Generate a HTML file with the table\n");
    printf("  2: Output just the generated table\n");
    printf("  3: Output the generated table with a body\n");
    printf("Enter the specific number:");
    scanf("%d", &body);
    printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    fflush(stdin);

    if (body == 1) {
        generateHTML(columns, rows);

    } else if(body == 3) {
        printf("\n\nYour generated HTML:\n");
        printf(""
               "<!DOCTYPE html>\n"
               "<html lang=\"en\">\n"
               "<head>\n"
               "    <meta charset=\"UTF-8\">\n"
               "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
               "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
               "    <title>Generated Table</title>\n"
               "    <link rel=\"stylesheet\" href=\"mystyle.css\">\n"
               "</head>\n"
               "<body>\n");
        generateTable(columns, rows);
        printf(""
               "\n</body>\n"
               "</html>");
    }
    else if(body == 2){
        printf("\n\nYour generated HTML:\n");
        generateTable(columns, rows);
    }
    else{
        printf("Your Input isn't valid");
    }
    return 0;
}