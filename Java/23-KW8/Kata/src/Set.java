import java.util.ArrayList;

public class Set implements BaseCollection{
    private int dimension;
    private int count;

    private int[] numbers;


    public Set(int dimension){
        this.dimension = dimension;
        count = 0;
        numbers = new int[dimension];

    }
    @Override
    public int getNumberOfElem(int index) {
        int returnVal = numbers[index];
        return returnVal;
    }

    @Override
    public boolean isElem(int elem) {
        boolean found = false;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == elem){
                found = true;
            }
        }
        return found;
    }


    @Override
    public void addElem(int object) {
        numbers[count] = object;
        count++;
    }



    public void printElem(){
        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }

    public Set union(Set set2){
        ArrayList<Integer> validUnion = new ArrayList<Integer>();

        for(int i = 0; i < numbers.length; i++){
            if(!validUnion.contains(numbers[i])){
                validUnion.add(numbers[i]);
            }
        }

        for(int i = 0; i < set2.numbers.length; i++){
            if(!validUnion.contains(set2.numbers[i])){
                validUnion.add(set2.numbers[i]);
            }
        }
        Set newS = new Set(validUnion.size());

        for(int i = 0; i < validUnion.size(); i++){
            newS.addElem(validUnion.get(i));
        }
        return newS;
    }

    public Set intersection(Set set2){
        ArrayList<Integer> idKIntersect = new ArrayList<Integer>();
        ArrayList<Integer> validIntersect = new ArrayList<Integer>();

        for(int i = 0; i < numbers.length; i++){
            if(!idKIntersect.contains(numbers[i])) {
                idKIntersect.add(numbers[i]);
            }
        }

        for(int i = 0; i < set2.numbers.length; i++) {
            if (!idKIntersect.contains(set2.numbers[i])) {
                idKIntersect.add(set2.numbers[i]);
            }
        }


       for(int i = 0; i < idKIntersect.size(); i++){
            if(isElem(idKIntersect.get(i)) && set2.isElem(idKIntersect.get(i))){
                validIntersect.add(idKIntersect.get(i));
            }
        }
        Set newS = new Set(validIntersect.size());

        for(int i = 0; i < validIntersect.size(); i++){
            newS.addElem(validIntersect.get(i));
        }
        return newS;

    }

    @Override
    public String toString() {
        toString();

        return null;
    }

}
