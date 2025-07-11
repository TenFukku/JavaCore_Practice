public class Main {
    public static void main(String[] args) {
        System.out.println("=== HỆ THỐNG QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG ===");
        System.out.println("Ngành cảnh sát - Practice 3 - Requirement 2\n");
        
        PoliceManager policeManager = new PoliceManager();
        
        VehicleOwner owner1 = new VehicleOwner("079204018888", "Đỗ Nguyễn Thiên Phúc", "phuc.do@email.com");
        VehicleOwner owner2 = new VehicleOwner("079204018889", "Vũ Minh Hiếu", "hieu.vu@email.com");
        VehicleOwner owner3 = new VehicleOwner("079204018890", "Châu Trần Vỹ Linh", "linh.chau@email.com");
        VehicleOwner owner4 = new VehicleOwner("079204018891", "Nguyễn Thị Lan Anh", "anh.nguyen@email.com");
        
        System.out.println("Đang thêm dữ liệu mẫu...\n");
        
        Car car1 = new Car("30A-12345", "Toyota", 2020, "Trắng", owner1, 5, "Xăng");
        Car car2 = new Car("51B-67890", "Honda", 2018, "Đen", owner2, 7, "Diesel");
        Car car3 = new Car("29C-11111", "Toyota", 2021, "Xanh", owner3, 9, "Xăng");
        
        Motorcycle moto1 = new Motorcycle("29A-22222", "Honda", 2022, "Đỏ", owner3, 125);
        Motorcycle moto2 = new Motorcycle("30B-33333", "Yamaha", 2021, "Xanh", owner4, 50);
        Motorcycle moto3 = new Motorcycle("51C-44444", "Suzuki", 2020, "Đen", owner1, 155);
        
        Truck truck1 = new Truck("29D-55555", "Honda", 2019, "Trắng", owner1, 5.0);
        Truck truck2 = new Truck("51E-66666", "Toyota", 2020, "Xanh", owner2, 12.0);
        Truck truck3 = new Truck("30F-77777", "Yamaha", 2018, "Vàng", owner4, 3.5);
        
        policeManager.addVehicle(car1);
        policeManager.addVehicle(car2);
        policeManager.addVehicle(car3);
        policeManager.addVehicle(moto1);
        policeManager.addVehicle(moto2);
        policeManager.addVehicle(moto3);
        policeManager.addVehicle(truck1);
        policeManager.addVehicle(truck2);
        policeManager.addVehicle(truck3);
        
        System.out.println("\n" + "=".repeat(60));
        
        policeManager.displayStatistics();
        
        System.out.println("=".repeat(60));
        
        System.out.println("\n=== TÌM KIẾM PHƯƠNG TIỆN THEO BIỂN SỐ ===");
        Vehicle foundVehicle = policeManager.findVehicleByNumber("30A-12345");
        if (foundVehicle != null) {
            System.out.println("Tìm thấy phương tiện:");
            foundVehicle.displayInfo();
        } else {
            System.out.println("Không tìm thấy phương tiện có biển số: 30A-12345");
        }
        
        System.out.println("=".repeat(60));
        
        System.out.println("\n=== TÌM PHƯƠNG TIỆN THEO CCCD CHỦ XE ===");
        var ownerVehicles = policeManager.findVehiclesByOwnerCCCD("079204018888");
        if (!ownerVehicles.isEmpty()) {
            System.out.println("Tìm thấy " + ownerVehicles.size() + " phương tiện của chủ xe:");
            for (Vehicle vehicle : ownerVehicles) {
                System.out.println("  - " + vehicle.getVehicleType() + " - " + vehicle.getVehicleNumber());
            }
        } else {
            System.out.println("Không tìm thấy phương tiện nào của CCCD: 079204018888");
        }
        
        System.out.println("=".repeat(60));
        
        System.out.println("\n=== XÓA TẤT CẢ PHƯƠNG TIỆN CỦA NHÀ SẢN XUẤT ===");
        int deletedCount = policeManager.deleteVehiclesByManufacturer("Toyota");
        System.out.println("Đã xóa " + deletedCount + " phương tiện của Toyota");
        
        System.out.println("\nThống kê sau khi xóa:");
        policeManager.displayStatistics();
        
        System.out.println("=".repeat(60));
        
        System.out.println("\n=== NHÀ SẢN XUẤT CÓ NHIỀU PHƯƠNG TIỆN NHẤT ===");
        String topManufacturer = policeManager.findManufacturerWithMostVehicles();
        System.out.println("Kết quả: " + topManufacturer);
        
        System.out.println("=".repeat(60));
        
        policeManager.sortVehiclesByManufacturerCount();
        
        System.out.println("=".repeat(60));
        
        policeManager.displayVehicleTypeStatistics();
        
        System.out.println("=".repeat(60));
        
        policeManager.displayAllVehicles();
        
        System.out.println("=".repeat(60));
        
        System.out.println("\n=== DEMO VALIDATION ERRORS ===");
        
        Car invalidCar = new Car("30A-123", "Toyota", 2020, "Trắng", owner1, 5, "Xăng");
        policeManager.addVehicle(invalidCar);
        
        Car invalidManufacturer = new Car("30A-12346", "Ford", 2020, "Trắng", owner1, 5, "Xăng");
        policeManager.addVehicle(invalidManufacturer);
        
        Car invalidYear = new Car("30A-12347", "Toyota", 1999, "Trắng", owner1, 5, "Xăng");
        policeManager.addVehicle(invalidYear);
        
        VehicleOwner invalidOwner = new VehicleOwner("123", "Test", "test@email.com");
        Car invalidCCCD = new Car("30A-12348", "Toyota", 2020, "Trắng", invalidOwner, 5, "Xăng");
        policeManager.addVehicle(invalidCCCD);
        
        VehicleOwner invalidEmailOwner = new VehicleOwner("079204018892", "Test", "invalid-email");
        Car invalidEmail = new Car("30A-12349", "Toyota", 2020, "Trắng", invalidEmailOwner, 5, "Xăng");
        policeManager.addVehicle(invalidEmail);
        
        System.out.println("\n=== CHƯƠNG TRÌNH KẾT THÚC ===");
    }
} 