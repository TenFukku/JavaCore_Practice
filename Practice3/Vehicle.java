public abstract class Vehicle {
    protected String vehicleNumber;
    protected String manufacturer;
    protected int yearOfManufacture;
    protected String vehicleColor;
    protected VehicleOwner owner;
    
    public Vehicle(String vehicleNumber, String manufacturer, int yearOfManufacture, 
                   String vehicleColor, VehicleOwner owner) {
        this.vehicleNumber = vehicleNumber;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.vehicleColor = vehicleColor;
        this.owner = owner;
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    
    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
    
    public String getVehicleColor() {
        return vehicleColor;
    }
    
    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }
    
    public VehicleOwner getOwner() {
        return owner;
    }
    
    public void setOwner(VehicleOwner owner) {
        this.owner = owner;
    }
    
    public abstract String getVehicleType();
    
    public int getVehicleAge() {
        return 2024 - yearOfManufacture;
    }
    
    public void displayInfo() {
        System.out.println("=== THÔNG TIN PHƯƠNG TIỆN ===");
        System.out.println("Loại phương tiện: " + getVehicleType());
        System.out.println("Biển số xe: " + vehicleNumber);
        System.out.println("Nhà sản xuất: " + manufacturer);
        System.out.println("Năm sản xuất: " + yearOfManufacture);
        System.out.println("Tuổi xe: " + getVehicleAge() + " năm");
        System.out.println("Màu xe: " + vehicleColor);
        owner.displayInfo();
    }
    
    @Override
    public String toString() {
        return getVehicleType() + " - " + vehicleNumber + " (" + owner.getFullName() + ")";
    }
} 