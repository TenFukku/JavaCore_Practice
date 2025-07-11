
public abstract class Product {
    protected String productCode;
    protected String name;
    protected int inventoryQuantity;
    protected double unitPrice;
    
    public Product(String productCode, String name, int inventoryQuantity, double unitPrice) {
        this.productCode = productCode;
        this.name = name;
        this.inventoryQuantity = inventoryQuantity;
        this.unitPrice = unitPrice;
    }
    
    public String getProductCode() {
        return productCode;
    }
    
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getInventoryQuantity() {
        return inventoryQuantity;
    }
    
    public void setInventoryQuantity(int inventoryQuantity) {
        if (inventoryQuantity >= 0) {
            this.inventoryQuantity = inventoryQuantity;
        } else {
            System.out.println("Số lượng tồn kho phải >= 0");
        }
    }
    
    public double getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public abstract double getVAT();
    
    public double getTotalValue() {
        return (unitPrice * inventoryQuantity) * (1 + getVAT());
    }
    
    public abstract String getConsumptionStatus();
    
    public void displayInfo() {
        System.out.println("Mã SP: " + productCode);
        System.out.println("Tên SP: " + name);
        System.out.println("Số lượng: " + inventoryQuantity);
        System.out.println("Đơn giá: " + unitPrice + " VNĐ");
        System.out.println("Thuế VAT: " + (getVAT() * 100) + "%");
        System.out.println("Tổng giá trị (có VAT): " + getTotalValue() + " VNĐ");
        System.out.println("Đánh giá tiêu thụ: " + getConsumptionStatus());
    }
} 