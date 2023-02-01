public class Console {
    private String name;
    private String brand;
    private int performanceLevel;

    public Console(String name, String brand, int performanceLevel){
        this.name = name;
        this.brand = brand;
        this.performanceLevel = performanceLevel;
    }
    public void printConsole(){
        System.out.println(brand + " " + name + " (" + performanceLevel + ")");
    }
}
