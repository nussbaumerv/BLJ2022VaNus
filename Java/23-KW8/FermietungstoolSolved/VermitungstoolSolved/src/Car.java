public class Car extends Vehicle{
    private boolean automatic;
    public Car(int id, String producerName, int modelNumber, String color, String vehicleNumber, int minAge, boolean automatic) {
        super(id, producerName, modelNumber, color, vehicleNumber, minAge);
        this.automatic = automatic;

    }

    public boolean isAutomatic() {
        return automatic;
    }
}
