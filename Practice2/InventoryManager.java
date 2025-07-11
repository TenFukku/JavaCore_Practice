import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Product> products;
    
    public InventoryManager() {
        this.products = new ArrayList<>();
    }
    
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Đã thêm sản phẩm: " + product.getName());
    }
    
    public void removeProduct(String productCode) {
        products.removeIf(product -> product.getProductCode().equals(productCode));
        System.out.println("Đã xóa sản phẩm có mã: " + productCode);
    }
    
    public int getTotalInventoryQuantity() {
        return products.stream()
                      .mapToInt(Product::getInventoryQuantity)
                      .sum();
    }
    
    public double getTotalInventoryValue() {
        return products.stream()
                      .mapToDouble(Product::getTotalValue)
                      .sum();
    }
    
    public List<Food> getFoodProducts() {
        List<Food> foodList = new ArrayList<>();
        for (Product product : products) {
            if (product instanceof Food) {
                foodList.add((Food) product);
            }
        }
        return foodList;
    }
    
    public List<Electronics> getElectronicsProducts() {
        List<Electronics> electronicsList = new ArrayList<>();
        for (Product product : products) {
            if (product instanceof Electronics) {
                electronicsList.add((Electronics) product);
            }
        }
        return electronicsList;
    }
    
    public List<Crockery> getCrockeryProducts() {
        List<Crockery> crockeryList = new ArrayList<>();
        for (Product product : products) {
            if (product instanceof Crockery) {
                crockeryList.add((Crockery) product);
            }
        }
        return crockeryList;
    }
    
    public void displayInventoryStatistics() {
        System.out.println("=== THỐNG KÊ KHO HÀNG ===");
        
        List<Food> foods = getFoodProducts();
        List<Electronics> electronics = getElectronicsProducts();
        List<Crockery> crockery = getCrockeryProducts();
        
        int foodQuantity = foods.stream().mapToInt(Product::getInventoryQuantity).sum();
        double foodValue = foods.stream().mapToDouble(Product::getTotalValue).sum();
        System.out.println("Thực phẩm:");
        System.out.println("  - Số loại: " + foods.size());
        System.out.println("  - Tổng số lượng: " + foodQuantity);
        System.out.println("  - Tổng giá trị: " + foodValue + " VNĐ");
        
        int electronicsQuantity = electronics.stream().mapToInt(Product::getInventoryQuantity).sum();
        double electronicsValue = electronics.stream().mapToDouble(Product::getTotalValue).sum();
        System.out.println("Hàng điện tử:");
        System.out.println("  - Số loại: " + electronics.size());
        System.out.println("  - Tổng số lượng: " + electronicsQuantity);
        System.out.println("  - Tổng giá trị: " + electronicsValue + " VNĐ");
        
        int crockeryQuantity = crockery.stream().mapToInt(Product::getInventoryQuantity).sum();
        double crockeryValue = crockery.stream().mapToDouble(Product::getTotalValue).sum();
        System.out.println("Đồ gốm:");
        System.out.println("  - Số loại: " + crockery.size());
        System.out.println("  - Tổng số lượng: " + crockeryQuantity);
        System.out.println("  - Tổng giá trị: " + crockeryValue + " VNĐ");
        
        System.out.println("TỔNG CỘNG:");
        System.out.println("  - Tổng số loại: " + products.size());
        System.out.println("  - Tổng số lượng: " + getTotalInventoryQuantity());
        System.out.println("  - Tổng giá trị: " + getTotalInventoryValue() + " VNĐ");
        System.out.println();
    }
    
    public void displayAllProducts() {
        System.out.println("=== DANH SÁCH TẤT CẢ SẢN PHẨM ===");
        for (Product product : products) {
            product.displayInfo();
        }
    }
    
    public Product findProductByCode(String productCode) {
        return products.stream()
                      .filter(product -> product.getProductCode().equals(productCode))
                      .findFirst()
                      .orElse(null);
    }
    
    public List<Product> getLowInventoryProducts() {
        return products.stream()
                      .filter(product -> product.getInventoryQuantity() < 10)
                      .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
} 