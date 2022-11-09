#include <stdio.h>

int main() {
    int width = 8;
    int height = 8;
    printf("Welcome to my Program\n");
    printf("Enter width:");
    scanf("%d", &width);

    printf("Enter height:");
    scanf("%d", &height);

    fflush(stdin);

    printf(""
           "The color options:\n"
           "    0: Enter HEX Data\n"
           "    1: Red\n"
           "    2: Blue\n"
           "    3: Green\n"
           "");


    int color = 0;
    int r = 0;
    int g = 0;
    int b = 0;

    char arrayHeader[] = {
            0x42, 0x4D,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00,
            0x00, 0x00,
            0x36, 0x00, 0x00, 0x00,

            0x28, 0x00, 0x00, 0x00,
            0x8, 0x00, 0x00, 0x00,
            0x8, 0x00, 0x00, 0x00,
            0x01, 0x00,
            0x18, 0x00,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00,
    };
    FILE *fp = fopen("file.bmp","wb");
    fwrite(&arrayHeader,sizeof(arrayHeader), 1, fp);
    for(int i = 1; i < width+1; i++){
        printf("\nEnter option for the %d row:", i);
        scanf("%d", &color);
        if(color == 0) {
            printf("\nEnter R:");
            scanf("%d", &r);

            printf("\nEnter G:");
            scanf("%d", &g);

            printf("\nEnter B:");
            scanf("%d", &b);
        }
        else if(color == 1){
            //red
            r = 0xFF;
            g = 0x00;
            b = 0x00;
        }
        else if(color == 2){
            //blue
            r = 0x00;
            g = 0x00;
            b = 0xFF;
        }
        else if(color == 3){
            //green
            r = 0x00;
            g = 0xFF;
            b = 0x00;
        }
        char arr[] = {b, g, r};
        for(int i =0; i < height; i++){
            fwrite(&arr, sizeof(arr), 1, fp);
        }
        if(width % 4 == 1){
            char arr[] = {00};
            fwrite(&arr,sizeof(arr), 1, fp);
        } else if(width % 4 == 2){
            char arr[] = {00, 00};
            fwrite(&arr,sizeof(arr), 1, fp);
        }else if(width % 4 == 3){
            char arr[] = {00, 00, 00};
            fwrite(&arr,sizeof(arr), 1, fp);
        }

    }
    fclose(fp);
    return 0;
}
