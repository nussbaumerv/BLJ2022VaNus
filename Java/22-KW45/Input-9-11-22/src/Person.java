public class Person {
    private String name;
    private String favoirteColor;

    public Person(String name, String color){
        this.name = name;
    }
    public void presentYou(){
        System.out.println("Hi, i'm " + name + " and my favorite color is " + favoirteColor);
    }

    public String getName() {
        return name;
    }

    public String getFavoirteColor() {
        return favoirteColor;
    }

    public void setFavoirteColor(String favoirteColor) {
        this.favoirteColor = favoirteColor;
    }
}
