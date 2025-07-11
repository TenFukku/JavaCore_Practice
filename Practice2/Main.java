import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HỆ THỐNG QUẢN LÝ KHO SIÊU THỊ ===\n");
        
        InventoryManager manager = new InventoryManager();
        
        Food milk = new Food("F001", "Sữa tươi Vinamilk", 50, 25000,
                            LocalDate.of(2024, 1, 15), LocalDate.of(2024, 2, 15), "Vinamilk");
        
        Food bread = new Food("F002", "Bánh mì", 30, 15000,
                             LocalDate.of(2024, 1, 20), LocalDate.of(2024, 1, 25), "ABC Bakery");
        
        Food rice = new Food("F003", "Gạo ST25", 100, 35000,
                            LocalDate.of(2024, 1, 10), LocalDate.of(2025, 1, 10), "Rice Corp");
        
        Electronics tv = new Electronics("E001", "TV Samsung 55 inch", 10, 15000000,
                                       24, 0.5);
        
        Electronics fridge = new Electronics("E002", "Tủ lạnh LG", 8, 12000000,
                                           36, 1.2);
        
        Electronics laptop = new Electronics("E003", "Laptop Dell", 15, 25000000,
                                           12, 0.8);
        
        Crockery bowl = new Crockery("C001", "Bát sứ cao cấp", 200, 50000,
                                     "Minh Long", LocalDate.of(2024, 1, 5));
        
        Crockery plate = new Crockery("C002", "Đĩa sứ trang trí", 150, 75000,
                                      "Bát Tràng", LocalDate.of(2024, 1, 8));
        
        Crockery cup = new Crockery("C003", "Tách trà gốm", 100, 35000,
                                    "Gốm Việt", LocalDate.of(2024, 1, 12));
        
        manager.addProduct(milk);
        manager.addProduct(bread);
        manager.addProduct(rice);
        manager.addProduct(tv);
        manager.addProduct(fridge);
        manager.addProduct(laptop);
        manager.addProduct(bowl);
        manager.addProduct(plate);
        manager.addProduct(cup);
        
        System.out.println("\n" + "=".repeat(50));
        
        manager.displayInventoryStatistics();
        
        System.out.println("=".repeat(50));
        
        manager.displayConsumptionStatus();
        
        System.out.println("=".repeat(50));
        
        System.out.println("Sản phẩm đã bán (số lượng < 3):");
        for (Product product : manager.getProductsByConsumptionStatus("Đã bán (số lượng < 3)")) {
            System.out.println("- " + product.getName() + " (Mã: " + product.getProductCode() + ")");
        }
        
        System.out.println("\nSản phẩm khó bán (đã hết hạn):");
        for (Product product : manager.getProductsByConsumptionStatus("Khó bán (đã hết hạn)")) {
            System.out.println("- " + product.getName() + " (Mã: " + product.getProductCode() + ")");
        }
        
        System.out.println("\nSản phẩm bán chậm (số lượng > 50 và lưu kho > 10 ngày):");
        for (Product product : manager.getProductsByConsumptionStatus("Bán chậm (số lượng > 50 và lưu kho > 10 ngày)")) {
            System.out.println("- " + product.getName() + " (Mã: " + product.getProductCode() + ")");
        }
        
        System.out.println("\n" + "=".repeat(50));
        
        manager.displayAllProducts();
        
        System.out.println("=".repeat(50));
        
        System.out.println("Tìm kiếm sản phẩm có mã F001:");
        Product foundProduct = manager.findProductByCode("F001");
        if (foundProduct != null) {
            foundProduct.displayInfo();
        } else {
            System.out.println("Không tìm thấy sản phẩm!");
        }
        
        System.out.println("=".repeat(50));
        
        System.out.println("Sản phẩm có số lượng thấp (< 10):");
        for (Product product : manager.getLowInventoryProducts()) {
            System.out.println("- " + product.getName() + " (Mã: " + product.getProductCode() + 
                             ", Số lượng: " + product.getInventoryQuantity() + ")");
        }
        
        System.out.println("\n=== CHƯƠNG TRÌNH KẾT THÚC ===");
    }
} 