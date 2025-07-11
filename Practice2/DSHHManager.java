import java.time.LocalDate;
import java.util.Scanner;

public class DSHHManager {
    private Product[] products;
    private int currentSize;
    private static final int MAX_SIZE = 100;
    private Scanner scanner;
    
    public DSHHManager() {
        this.products = new Product[MAX_SIZE];
        this.currentSize = 0;
        this.scanner = new Scanner(System.in);
    }
    
    // Method to add goods to the list
    public boolean addGoods() {
        if (currentSize >= MAX_SIZE) {
            System.out.println("Danh sách đã đầy! Không thể thêm sản phẩm mới.");
            return false;
        }
        
        System.out.println("\n=== THÊM SẢN PHẨM MỚI ===");
        System.out.println("Chọn loại hàng hóa:");
        System.out.println("1. Thực phẩm");
        System.out.println("2. Hàng điện tử");
        System.out.println("3. Đồ gốm");
        System.out.print("Nhập lựa chọn (1-3): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Product newProduct = null;
        
        switch (choice) {
            case 1:
                newProduct = createFoodProduct();
                break;
            case 2:
                newProduct = createElectronicsProduct();
                break;
            case 3:
                newProduct = createCrockeryProduct();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return false;
        }
        
        if (newProduct != null) {
            return addProduct(newProduct);
        }
        
        return false;
    }
    
    // Method to add product with duplicate check
    public boolean addProduct(Product product) {
        // Check for duplicate product code
        if (isDuplicateProductCode(product.getProductCode())) {
            System.out.println("Lỗi: Mã sản phẩm '" + product.getProductCode() + "' đã tồn tại!");
            return false;
        }
        
        products[currentSize] = product;
        currentSize++;
        System.out.println("✅ Đã thêm thành công sản phẩm: " + product.getName());
        return true;
    }
    
    // Check for duplicate product code
    private boolean isDuplicateProductCode(String productCode) {
        for (int i = 0; i < currentSize; i++) {
            if (products[i].getProductCode().equals(productCode)) {
                return true;
            }
        }
        return false;
    }
    
    // Create Food product with user input
    private Food createFoodProduct() {
        System.out.println("\n--- NHẬP THÔNG TIN THỰC PHẨM ---");
        
        System.out.print("Nhập mã sản phẩm: ");
        String productCode = scanner.nextLine();
        
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        
        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        
        System.out.print("Nhập đơn giá: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Nhập nhà cung cấp: ");
        String supplier = scanner.nextLine();
        
        System.out.println("Nhập ngày sản xuất (yyyy-MM-dd): ");
        String manufactureDateStr = scanner.nextLine();
        LocalDate manufactureDate = LocalDate.parse(manufactureDateStr);
        
        System.out.println("Nhập ngày hết hạn (yyyy-MM-dd): ");
        String expirationDateStr = scanner.nextLine();
        LocalDate expirationDate = LocalDate.parse(expirationDateStr);
        
        return new Food(productCode, name, quantity, price, manufactureDate, expirationDate, supplier);
    }
    
    // Create Electronics product with user input
    private Electronics createElectronicsProduct() {
        System.out.println("\n--- NHẬP THÔNG TIN HÀNG ĐIỆN TỬ ---");
        
        System.out.print("Nhập mã sản phẩm: ");
        String productCode = scanner.nextLine();
        
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        
        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        
        System.out.print("Nhập đơn giá: ");
        double price = scanner.nextDouble();
        
        System.out.print("Nhập số tháng bảo hành: ");
        int warrantyMonths = scanner.nextInt();
        
        System.out.print("Nhập công suất (KW): ");
        double capacityKW = scanner.nextDouble();
        
        return new Electronics(productCode, name, quantity, price, warrantyMonths, capacityKW);
    }
    
    // Create Crockery product with user input
    private Crockery createCrockeryProduct() {
        System.out.println("\n--- NHẬP THÔNG TIN ĐỒ GỐM ---");
        
        System.out.print("Nhập mã sản phẩm: ");
        String productCode = scanner.nextLine();
        
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        
        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        
        System.out.print("Nhập đơn giá: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Nhập nhà sản xuất: ");
        String manufacturer = scanner.nextLine();
        
        System.out.println("Nhập ngày nhập kho (yyyy-MM-dd): ");
        String arrivalDateStr = scanner.nextLine();
        LocalDate arrivalDate = LocalDate.parse(arrivalDateStr);
        
        return new Crockery(productCode, name, quantity, price, manufacturer, arrivalDate);
    }
    
    // Display all products
    public void displayAllProducts() {
        if (currentSize == 0) {
            System.out.println("Danh sách hàng hóa trống!");
            return;
        }
        
        System.out.println("\n=== DANH SÁCH HÀNG HÓA ===");
        System.out.println("Tổng số sản phẩm: " + currentSize);
        System.out.println("=".repeat(50));
        
        for (int i = 0; i < currentSize; i++) {
            System.out.println("Sản phẩm " + (i + 1) + ":");
            products[i].displayInfo();
        }
    }
    
    // Search product by code
    public Product findProductByCode(String productCode) {
        for (int i = 0; i < currentSize; i++) {
            if (products[i].getProductCode().equals(productCode)) {
                return products[i];
            }
        }
        return null;
    }
    
    // Remove product by code
    public boolean removeProduct(String productCode) {
        for (int i = 0; i < currentSize; i++) {
            if (products[i].getProductCode().equals(productCode)) {
                // Shift remaining elements
                for (int j = i; j < currentSize - 1; j++) {
                    products[j] = products[j + 1];
                }
                currentSize--;
                System.out.println("✅ Đã xóa sản phẩm có mã: " + productCode);
                return true;
            }
        }
        System.out.println("❌ Không tìm thấy sản phẩm có mã: " + productCode);
        return false;
    }
    
    // Get current size
    public int getCurrentSize() {
        return currentSize;
    }
    
    // Get maximum size
    public int getMaxSize() {
        return MAX_SIZE;
    }
    
    // Display consumption status
    public void displayConsumptionStatus() {
        if (currentSize == 0) {
            System.out.println("Danh sách hàng hóa trống!");
            return;
        }
        
        System.out.println("\n=== ĐÁNH GIÁ MỨC TIÊU THỤ ===");
        for (int i = 0; i < currentSize; i++) {
            Product product = products[i];
            System.out.println("Mã SP: " + product.getProductCode() + 
                             " | Tên: " + product.getName() + 
                             " | Số lượng: " + product.getInventoryQuantity() +
                             " | Đánh giá: " + product.getConsumptionStatus());
        }
    }
    
    // Close scanner
    public void closeScanner() {
        scanner.close();
    }
} 