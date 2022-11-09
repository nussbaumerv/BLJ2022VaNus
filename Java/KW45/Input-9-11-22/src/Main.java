public class Main {
    public static void main(String[] args) {
        Person tim = new Person("Tim", "Red");
        tim.setFavoirteColor("red");
        tim.presentYou();

        Person tim2 = tim;
        tim.presentYou();

    }
}
