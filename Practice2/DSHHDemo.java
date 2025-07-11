import java.time.LocalDate;
import java.util.Scanner;

public class DSHHDemo {
    public static void main(String[] args) {
        System.out.println("=== CHƯƠNG TRÌNH QUẢN LÝ DSHH ===");
        System.out.println("(Danh sách hàng hóa sử dụng mảng)\n");
        
        DSHHManager manager = new DSHHManager();
        Scanner scanner = new Scanner(System.in);
        
        // Add some sample products
        System.out.println("Đang thêm dữ liệu mẫu...");
        
        Food milk = new Food("F001", "Sữa tươi Vinamilk", 50, 25000,
                            LocalDate.of(2024, 1, 15), LocalDate.of(2024, 2, 15), "Vinamilk");
        
        Electronics tv = new Electronics("E001", "TV Samsung 55 inch", 10, 15000000,
                                       24, 0.5);
        
        Crockery bowl = new Crockery("C001", "Bát sứ cao cấp", 200, 50000,
                                     "Minh Long", LocalDate.of(2024, 1, 5));
        
        manager.addProduct(milk);
        manager.addProduct(tv);
        manager.addProduct(bowl);
        
        System.out.println("✅ Đã thêm " + manager.getCurrentSize() + " sản phẩm mẫu.\n");
        
        int choice;
        do {
            displayMenu();
            System.out.print("Nhập lựa chọn (0-6): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    manager.addGoods();
                    break;
                case 2:
                    manager.displayAllProducts();
                    break;
                case 3:
                    searchProduct(manager, scanner);
                    break;
                case 4:
                    removeProduct(manager, scanner);
                    break;
                case 5:
                    manager.displayConsumptionStatus();
                    break;
                case 6:
                    displayStatistics(manager);
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
            }
            
            if (choice != 0) {
                System.out.println("\n" + "=".repeat(50));
                System.out.println("Nhấn Enter để tiếp tục...");
                scanner.nextLine();
            }
            
        } while (choice != 0);
        
        manager.closeScanner();
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n=== MENU CHÍNH ===");
        System.out.println("1. Thêm sản phẩm mới");
        System.out.println("2. Hiển thị tất cả sản phẩm");
        System.out.println("3. Tìm kiếm sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Đánh giá mức tiêu thụ");
        System.out.println("6. Thống kê");
        System.out.println("0. Thoát");
    }
    
    private static void searchProduct(DSHHManager manager, Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần tìm: ");
        String productCode = scanner.nextLine();
        
        Product foundProduct = manager.findProductByCode(productCode);
        if (foundProduct != null) {
            System.out.println("✅ Tìm thấy sản phẩm:");
            foundProduct.displayInfo();
        } else {
            System.out.println("❌ Không tìm thấy sản phẩm có mã: " + productCode);
        }
    }
    
    private static void removeProduct(DSHHManager manager, Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String productCode = scanner.nextLine();
        
        manager.removeProduct(productCode);
    }
    
    private static void displayStatistics(DSHHManager manager) {
        System.out.println("\n=== THỐNG KÊ DSHH ===");
        System.out.println("Tổng số sản phẩm: " + manager.getCurrentSize());
        System.out.println("Sức chứa tối đa: " + manager.getMaxSize());
        System.out.println("Còn trống: " + (manager.getMaxSize() - manager.getCurrentSize()) + " vị trí");
    }
} 