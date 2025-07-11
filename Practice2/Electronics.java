public class Electronics extends Product {
    private int warrantyMonths;
    private double capacityKW;
    
    public Electronics(String productCode, String name, int inventoryQuantity, double unitPrice,
                      int warrantyMonths, double capacityKW) {
        super(productCode, name, inventoryQuantity, unitPrice);
        this.warrantyMonths = warrantyMonths;
        this.capacityKW = capacityKW;
        
        if (warrantyMonths < 0) {
            System.out.println("Cảnh báo: Số tháng bảo hành phải >= 0!");
        }
        
        if (capacityKW < 0) {
            System.out.println("Cảnh báo: Công suất phải >= 0!");
        }
    }
    
    public int getWarrantyMonths() {
        return warrantyMonths;
    }
    
    public void setWarrantyMonths(int warrantyMonths) {
        if (warrantyMonths >= 0) {
            this.warrantyMonths = warrantyMonths;
        } else {
            System.out.println("Số tháng bảo hành phải >= 0");
        }
    }
    
    public double getCapacityKW() {
        return capacityKW;
    }
    
    public void setCapacityKW(double capacityKW) {
        if (capacityKW >= 0) {
            this.capacityKW = capacityKW;
        } else {
            System.out.println("Công suất phải >= 0");
        }
    }
    
    @Override
    public double getVAT() {
        return 0.10;
    }
    
    public String getWarrantyEndDate() {
        if (warrantyMonths == 0) {
            return "Không có bảo hành";
        }
        java.time.LocalDate warrantyEnd = java.time.LocalDate.now().plusMonths(warrantyMonths);
        return warrantyEnd.toString();
    }
    
    @Override
    public String getConsumptionStatus() {
        if (inventoryQuantity < 3) {
            return "Đã bán (số lượng < 3)";
        }
        return "Không đánh giá";
    }
    
    @Override
    public void displayInfo() {
        System.out.println("=== THÔNG TIN HÀNG ĐIỆN TỬ ===");
        super.displayInfo();
        System.out.println("Thời gian bảo hành: " + warrantyMonths + " tháng");
        System.out.println("Công suất: " + capacityKW + " KW");
        System.out.println("Ngày hết bảo hành: " + getWarrantyEndDate());
        System.out.println();
    }
} 