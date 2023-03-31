package ch.noseryoung.blj.memoryfx;

import javafx.scene.image.Image;

public class Memory {
    String id;
    Image icon;
    boolean state;

    public Memory(String id, Image icon){
        this.id = id;
        this.icon = icon;
        state = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
