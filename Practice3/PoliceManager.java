import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PoliceManager {
    private List<Vehicle> vehicles;
    
    public PoliceManager() {
        this.vehicles = new ArrayList<>();
    }
    
    public boolean addVehicle(Vehicle vehicle) {
        // Validate vehicle number
        if (!ValidationUtils.isValidVehicleNumber(vehicle.getVehicleNumber())) {
            ValidationUtils.displayValidationError("Biển số xe", "Phải có định dạng XX-X-XXXXX (2 số + 1 chữ + 5 số)");
            return false;
        }
        
        if (!ValidationUtils.isVehicleNumberUnique(vehicle.getVehicleNumber(), vehicles)) {
            ValidationUtils.displayValidationError("Biển số xe", "Biển số xe đã tồn tại");
            return false;
        }
        
        if (!ValidationUtils.isValidManufacturer(vehicle.getManufacturer())) {
            ValidationUtils.displayValidationError("Nhà sản xuất", "Chỉ được phép: Honda, Yamaha, Toyota, Suzuki");
            return false;
        }
        
        if (!ValidationUtils.isValidYearOfManufacture(vehicle.getYearOfManufacture())) {
            ValidationUtils.displayValidationError("Năm sản xuất", "Phải từ 2000 đến " + ValidationUtils.getCurrentYear());
            return false;
        }
        
        if (!ValidationUtils.isValidCCCD(vehicle.getOwner().getCccdNumber())) {
            ValidationUtils.displayValidationError("CCCD", "Phải có đúng 12 số");
            return false;
        }
        
        if (!ValidationUtils.isCCCDUnique(vehicle.getOwner().getCccdNumber(), vehicles)) {
            ValidationUtils.displayValidationError("CCCD", "CCCD đã tồn tại");
            return false;
        }
        
        if (!ValidationUtils.isValidEmail(vehicle.getOwner().getEmail())) {
            ValidationUtils.displayValidationError("Email", "Email không đúng định dạng");
            return false;
        }
        
        vehicles.add(vehicle);
        System.out.println("✅ Đã thêm phương tiện: " + vehicle.getVehicleType() + " - " + vehicle.getVehicleNumber());
        return true;
    }
    
    public boolean removeVehicle(String vehicleNumber) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getVehicleNumber().equals(vehicleNumber)) {
                Vehicle removed = vehicles.remove(i);
                System.out.println("✅ Đã xóa phương tiện: " + removed.getVehicleType() + " - " + vehicleNumber);
                return true;
            }
        }
        System.out.println("❌ Không tìm thấy phương tiện có biển số: " + vehicleNumber);
        return false;
    }
    
    public int deleteVehiclesByManufacturer(String manufacturer) {
        int count = 0;
        List<Vehicle> toRemove = new ArrayList<>();
        
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getManufacturer().equalsIgnoreCase(manufacturer)) {
                toRemove.add(vehicle);
                count++;
            }
        }
        
        vehicles.removeAll(toRemove);
        System.out.println("✅ Đã xóa " + count + " phương tiện của nhà sản xuất: " + manufacturer);
        return count;
    }
    
    public Vehicle findVehicleByNumber(String vehicleNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleNumber().equals(vehicleNumber)) {
                return vehicle;
            }
        }
        return null;
    }
    
    public List<Vehicle> findVehiclesByOwnerCCCD(String cccdNumber) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getOwner().getCccdNumber().equals(cccdNumber)) {
                result.add(vehicle);
            }
        }
        return result;
    }
    
    public String findManufacturerWithMostVehicles() {
        Map<String, Long> manufacturerCount = vehicles.stream()
            .collect(Collectors.groupingBy(Vehicle::getManufacturer, Collectors.counting()));
        
        if (manufacturerCount.isEmpty()) {
            return "Không có phương tiện nào";
        }
        
        return manufacturerCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(entry -> entry.getKey() + " (" + entry.getValue() + " phương tiện)")
            .orElse("Không xác định");
    }
    
    public void sortVehiclesByManufacturerCount() {
        Map<String, Long> manufacturerCount = vehicles.stream()
            .collect(Collectors.groupingBy(Vehicle::getManufacturer, Collectors.counting()));
        
        System.out.println("\n=== SẮP XẾP THEO SỐ LƯỢNG PHƯƠNG TIỆN (GIẢM DẦN) ===");
        manufacturerCount.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(entry -> {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " phương tiện");
                // Display vehicles of this manufacturer
                vehicles.stream()
                    .filter(v -> v.getManufacturer().equals(entry.getKey()))
                    .forEach(v -> System.out.println("  - " + v.getVehicleNumber() + " (" + v.getVehicleType() + ")"));
            });
    }
    
    public void displayVehicleTypeStatistics() {
        long carCount = vehicles.stream().filter(v -> v instanceof Car).count();
        long motorcycleCount = vehicles.stream().filter(v -> v instanceof Motorcycle).count();
        long truckCount = vehicles.stream().filter(v -> v instanceof Truck).count();
        
        System.out.println("\n=== THỐNG KÊ THEO LOẠI PHƯƠNG TIỆN ===");
        System.out.println("Ô tô: " + carCount + " chiếc");
        System.out.println("Xe máy: " + motorcycleCount + " chiếc");
        System.out.println("Xe tải: " + truckCount + " chiếc");
        System.out.println("Tổng cộng: " + vehicles.size() + " phương tiện");
    }
    
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                cars.add((Car) vehicle);
            }
        }
        return cars;
    }
    
    public List<Motorcycle> getAllMotorcycles() {
        List<Motorcycle> motorcycles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Motorcycle) {
                motorcycles.add((Motorcycle) vehicle);
            }
        }
        return motorcycles;
    }
    
    public List<Truck> getAllTrucks() {
        List<Truck> trucks = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) {
                trucks.add((Truck) vehicle);
            }
        }
        return trucks;
    }
    
    public void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("Danh sách phương tiện trống!");
            return;
        }
        
        System.out.println("\n=== DANH SÁCH TẤT CẢ PHƯƠNG TIỆN ===");
        System.out.println("Tổng số phương tiện: " + vehicles.size());
        System.out.println("=".repeat(60));
        
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println("Phương tiện " + (i + 1) + ":");
            vehicles.get(i).displayInfo();
        }
    }
    
    public void displayVehiclesByType() {
        List<Car> cars = getAllCars();
        List<Motorcycle> motorcycles = getAllMotorcycles();
        List<Truck> trucks = getAllTrucks();
        
        System.out.println("\n=== THỐNG KÊ THEO LOẠI PHƯƠNG TIỆN ===");
        
        System.out.println("Ô TÔ (" + cars.size() + " chiếc):");
        for (Car car : cars) {
            System.out.println("  - " + car.getVehicleNumber() + " (" + car.getCarCategory() + ")");
        }
        
        System.out.println("\nXE MÁY (" + motorcycles.size() + " chiếc):");
        for (Motorcycle moto : motorcycles) {
            System.out.println("  - " + moto.getVehicleNumber() + " (" + moto.getMotorcycleCategory() + ")");
        }
        
        System.out.println("\nXE TẢI (" + trucks.size() + " chiếc):");
        for (Truck truck : trucks) {
            System.out.println("  - " + truck.getVehicleNumber() + " (" + truck.getTruckCategory() + ")");
        }
    }
    
    public void displayVehiclesNeedingSpecialLicense() {
        System.out.println("\n=== PHƯƠNG TIỆN CẦN BẰNG LÁI ĐẶC BIỆT ===");
        
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Motorcycle) {
                Motorcycle moto = (Motorcycle) vehicle;
                if (moto.needsLicense()) {
                    System.out.println("  - " + moto.getVehicleNumber() + " (Xe máy >50cc)");
                    found = true;
                }
            } else if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                if (truck.needsSpecialLicense()) {
                    System.out.println("  - " + truck.getVehicleNumber() + " (Xe tải >7.5 tấn)");
                    found = true;
                }
            }
        }
        
        if (!found) {
            System.out.println("Không có phương tiện nào cần bằng lái đặc biệt.");
        }
    }
    
    public int getTotalVehicleCount() {
        return vehicles.size();
    }
    
    public int getCarCount() {
        return getAllCars().size();
    }
    
    public int getMotorcycleCount() {
        return getAllMotorcycles().size();
    }
    
    public int getTruckCount() {
        return getAllTrucks().size();
    }
    
    public void displayStatistics() {
        System.out.println("\n=== THỐNG KÊ TỔNG QUAN ===");
        System.out.println("Tổng số phương tiện: " + getTotalVehicleCount());
        System.out.println("  - Ô tô: " + getCarCount() + " chiếc");
        System.out.println("  - Xe máy: " + getMotorcycleCount() + " chiếc");
        System.out.println("  - Xe tải: " + getTruckCount() + " chiếc");
        
        System.out.println("Nhà sản xuất có nhiều phương tiện nhất: " + findManufacturerWithMostVehicles());
    }
} 