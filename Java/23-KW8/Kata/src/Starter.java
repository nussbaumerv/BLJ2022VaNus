public class Starter {
    public static void main(String[] args) {
        Set set1 = new Set(6);

        set1.addElem(5);
        set1.addElem(1);
        set1.addElem(6);
        set1.addElem(5);
        set1.addElem(2);
        set1.addElem(9);

        System.out.println("Set 1: ");
        set1.printElem();

        Set set2 = new Set(4);

        set2.addElem(8);
        set2.addElem(2);
        set2.addElem(5);
        set2.addElem(12);

        System.out.println("Set 2: ");
        set2.printElem();


        Set newUnion = set1.union(set2);

        System.out.println("Set Union: ");
        newUnion.printElem();

        Set newIntersect = set1.intersection(set2);

        System.out.println("Set Intersection: ");
        newIntersect.printElem();



    }
}