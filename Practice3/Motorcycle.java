public class Motorcycle extends Vehicle {
    private double capacity;
    
    public Motorcycle(String vehicleNumber, String manufacturer, int yearOfManufacture, 
                      String vehicleColor, VehicleOwner owner, double capacity) {
        super(vehicleNumber, manufacturer, yearOfManufacture, vehicleColor, owner);
        this.capacity = capacity;
    }
    
    public double getCapacity() {
        return capacity;
    }
    
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
    
    @Override
    public String getVehicleType() {
        return "Xe máy";
    }
    
    public String getMotorcycleCategory() {
        if (capacity <= 50) {
            return "Xe máy điện/Xe đạp máy";
        } else if (capacity <= 125) {
            return "Xe máy phổ thông";
        } else if (capacity <= 250) {
            return "Xe máy phân khối nhỏ";
        } else if (capacity <= 500) {
            return "Xe máy phân khối trung bình";
        } else {
            return "Xe máy phân khối lớn";
        }
    }
    
    public boolean needsLicense() {
        return capacity > 50;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Dung tích: " + capacity + " cc");
        System.out.println("Phân loại: " + getMotorcycleCategory());
        System.out.println("Cần bằng lái: " + (needsLicense() ? "Có" : "Không"));
        System.out.println();
    }
} 