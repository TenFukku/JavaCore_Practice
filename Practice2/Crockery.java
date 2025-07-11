import java.time.LocalDate;

public class Crockery extends Product {
    private String manufacturer;
    private LocalDate arrivalDate;
    
    public Crockery(String productCode, String name, int inventoryQuantity, double unitPrice,
                    String manufacturer, LocalDate arrivalDate) {
        super(productCode, name, inventoryQuantity, unitPrice);
        this.manufacturer = manufacturer;
        this.arrivalDate = arrivalDate;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public LocalDate getArrivalDate() {
        return arrivalDate;
    }
    
    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    
    @Override
    public double getVAT() {
        return 0.10;
    }
    
    public long getDaysSinceArrival() {
        return java.time.LocalDate.now().toEpochDay() - arrivalDate.toEpochDay();
    }
    
    @Override
    public void displayInfo() {
        System.out.println("=== THÔNG TIN ĐỒ GỐM ===");
        super.displayInfo();
        System.out.println("Nhà sản xuất: " + manufacturer);
        System.out.println("Ngày nhập kho: " + arrivalDate);
        System.out.println("Số ngày đã nhập: " + getDaysSinceArrival() + " ngày");
        System.out.println();
    }
} 