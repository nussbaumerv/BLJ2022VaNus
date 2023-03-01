public class Motorcycle extends Vehicle{
    private boolean offRoad;
    public Motorcycle(int id, String producerName, int modelNumber, String color, String vehicleNumber, int minAge, boolean offRoad) {
        super(id, producerName, modelNumber, color, vehicleNumber, minAge);
        this.offRoad = offRoad;
    }
}
