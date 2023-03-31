package ch.noseryoung.blj.memoryfx;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class MemoryManager {
    int filedWidth = 4;
    int fieldHeight = 4;
    Memory[][] memoryField;

    String[] icons = {"*", "*", "#", "#", "$", "$", "%", "%", "@", "@", ":", ":", "?", "?", "/", "/"};

    public MemoryManager(){
        memoryField = new Memory[fieldHeight][filedWidth];
        String[] shuffledIcons = shuffleIcons(icons);
        int counter = 0;
        for(int r = 0; r < fieldHeight; r++){
            for (int c = 0; c < filedWidth; c++){
                Memory memory = new Memory("r" + r + "c" + c, shuffledIcons[counter]);
                memoryField[r][c] = memory;
                counter++;
            }
        }
    }

    private String[] shuffleIcons(String[] array)
    {
        int index;
        String temp;
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

    public void setMemory(Memory memory, String newValue){
        memoryField[getR(memory)][getC(memory)].setIcon(newValue);
    }
}
