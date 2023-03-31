package ch.noseryoung.blj.memoryfx;

public class Memory {
    String id;
    String icon;
    boolean state;

    public Memory(String id, String icon){
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
