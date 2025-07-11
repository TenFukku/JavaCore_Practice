public class Truck extends Vehicle {
    private double tonnage;
    
    public Truck(String vehicleNumber, String manufacturer, int yearOfManufacture, 
                 String vehicleColor, VehicleOwner owner, double tonnage) {
        super(vehicleNumber, manufacturer, yearOfManufacture, vehicleColor, owner);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }
    
    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }
    
    @Override
    public String getVehicleType() {
        return "Xe tải";
    }
    
    public String getTruckCategory() {
        if (tonnage <= 3.5) {
            return "Xe tải nhỏ";
        } else if (tonnage <= 7.5) {
            return "Xe tải trung bình";
        } else if (tonnage <= 16) {
            return "Xe tải lớn";
        } else {
            return "Xe tải siêu trọng";
        }
    }
    
    public boolean needsSpecialLicense() {
        return tonnage > 7.5;
    }
    
    public double getMaxPayloadKg() {
        return tonnage * 1000;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tải trọng: " + tonnage + " tấn");
        System.out.println("Tải trọng tối đa: " + getMaxPayloadKg() + " kg");
        System.out.println("Phân loại: " + getTruckCategory());
        System.out.println("Cần bằng lái đặc biệt: " + (needsSpecialLicense() ? "Có" : "Không"));
        System.out.println();
    }
} 