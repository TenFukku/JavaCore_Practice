public class Car extends Vehicle {
    private int numberOfSeats;
    private String engineType;
    
    public Car(String vehicleNumber, String manufacturer, int yearOfManufacture, 
               String vehicleColor, VehicleOwner owner, int numberOfSeats, String engineType) {
        super(vehicleNumber, manufacturer, yearOfManufacture, vehicleColor, owner);
        this.numberOfSeats = numberOfSeats;
        this.engineType = engineType;
    }
    
    // Getters and Setters
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    
    public String getEngineType() {
        return engineType;
    }
    
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
    
    @Override
    public String getVehicleType() {
        return "Ô tô";
    }
    
    // Method to determine car category based on number of seats
    public String getCarCategory() {
        if (numberOfSeats <= 5) {
            return "Xe con";
        } else if (numberOfSeats <= 9) {
            return "Xe khách nhỏ";
        } else {
            return "Xe khách lớn";
        }
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Số ghế ngồi: " + numberOfSeats);
        System.out.println("Loại động cơ: " + engineType);
        System.out.println("Phân loại: " + getCarCategory());
        System.out.println();
    }
} 