import java.time.LocalDate;

public class Food extends Product {
    private LocalDate manufactureDate;
    private LocalDate expirationDate;
    private String supplier;
    
    public Food(String productCode, String name, int inventoryQuantity, double unitPrice,
                LocalDate manufactureDate, LocalDate expirationDate, String supplier) {
        super(productCode, name, inventoryQuantity, unitPrice);
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.supplier = supplier;
        
        if (expirationDate.isBefore(manufactureDate)) {
            System.out.println("Cảnh báo: Ngày hết hạn phải sau hoặc bằng ngày sản xuất!");
        }
    }
    
    public LocalDate getManufactureDate() {
        return manufactureDate;
    }
    
    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
    
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    
    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate.isBefore(manufactureDate)) {
            System.out.println("Ngày hết hạn phải sau hoặc bằng ngày sản xuất!");
            return;
        }
        this.expirationDate = expirationDate;
    }
    
    public String getSupplier() {
        return supplier;
    }
    
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    @Override
    public double getVAT() {
        return 0.05;
    }
    
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
    
    public boolean isNearExpiration() {
        LocalDate sevenDaysFromNow = LocalDate.now().plusDays(7);
        return LocalDate.now().isBefore(expirationDate) && 
               sevenDaysFromNow.isAfter(expirationDate);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("=== THÔNG TIN THỰC PHẨM ===");
        super.displayInfo();
        System.out.println("Ngày sản xuất: " + manufactureDate);
        System.out.println("Ngày hết hạn: " + expirationDate);
        System.out.println("Nhà cung cấp: " + supplier);
        
        if (isExpired()) {
            System.out.println("⚠️  CẢNH BÁO: Sản phẩm đã hết hạn!");
        } else if (isNearExpiration()) {
            System.out.println("⚠️  CẢNH BÁO: Sản phẩm sắp hết hạn!");
        }
        System.out.println();
    }
} 