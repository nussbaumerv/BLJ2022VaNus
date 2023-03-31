package ch.noseryoung.blj.memoryfx;

import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class MemoryManager {
    int filedWidth = 4;
    int fieldHeight = 4;
    Memory[][] memoryField;

    Image[] icons;

    public MemoryManager(){
        memoryField = new Memory[fieldHeight][filedWidth];
        Image[] icons = initializeIcons();
        Image[] shuffledIcons = shuffleIcons(icons);
        int counter = 0;
        for(int r = 0; r < fieldHeight; r++){
            for (int c = 0; c < filedWidth; c++){
                Memory memory = new Memory("r" + r + "c" + c, shuffledIcons[counter]);
                memoryField[r][c] = memory;
                counter++;
            }
        }
    }

    public Image[] initializeIcons(){
        Image[] icons = new Image[filedWidth*fieldHeight];
        for(int r = 0; r < (fieldHeight * filedWidth); r+=2){
            Image img = new Image("https://picsum.photos/200");
            icons[r] = img;
            icons[r+1] = img;
        }
        return icons;
    }

    private Image[] shuffleIcons(Image[] array)
    {
        int index;
        Image temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public int getFiledWidth() {
        return filedWidth;
    }

    public void setFiledWidth(int filedWidth) {
        this.filedWidth = filedWidth;
    }

    public int getFieldHeight() {
        return fieldHeight;
    }

    public void setFieldHeight(int fieldHeight) {
        this.fieldHeight = fieldHeight;
    }

    public Memory[][] getMemoryField() {
        return memoryField;
    }

    public void setMemoryField(Memory[][] memoryField) {
        this.memoryField = memoryField;
    }

    public Memory getMemory(String id){
        Memory memory = null;
        for(int r = 0; r < fieldHeight; r++){
            for (int c = 0; c < filedWidth; c++){
                if(memoryField[r][c].getId().equals(id)){
                    memory = memoryField[r][c];
                }
            }
        }
        return memory;
    }

    public int getR(Memory memory){
        char[] id = memory.getId().toCharArray();
        return Integer.parseInt(String.valueOf(id[1]));
    }

    public int getC(Memory memory){
        char[] id = memory.getId().toCharArray();
        return Integer.parseInt(String.valueOf(id[3]));
    }

    public int getFiledSize(){
        return filedWidth * fieldHeight;
    }
}
