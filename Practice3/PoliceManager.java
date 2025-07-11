import java.util.ArrayList;
import java.util.List;

public class PoliceManager {
    private List<Vehicle> vehicles;
    
    public PoliceManager() {
        this.vehicles = new ArrayList<>();
    }
    
    // Add vehicle to the list
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("✅ Đã thêm phương tiện: " + vehicle.getVehicleType() + " - " + vehicle.getVehicleNumber());
    }
    
    // Remove vehicle by vehicle number
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
    
    // Search vehicle by vehicle number
    public Vehicle findVehicleByNumber(String vehicleNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleNumber().equals(vehicleNumber)) {
                return vehicle;
            }
        }
        return null;
    }
    
    // Search vehicles by owner CCCD
    public List<Vehicle> findVehiclesByOwnerCCCD(String cccdNumber) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getOwner().getCccdNumber().equals(cccdNumber)) {
                result.add(vehicle);
            }
        }
        return result;
    }
    
    // Get all cars
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                cars.add((Car) vehicle);
            }
        }
        return cars;
    }
    
    // Get all motorcycles
    public List<Motorcycle> getAllMotorcycles() {
        List<Motorcycle> motorcycles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Motorcycle) {
                motorcycles.add((Motorcycle) vehicle);
            }
        }
        return motorcycles;
    }
    
    // Get all trucks
    public List<Truck> getAllTrucks() {
        List<Truck> trucks = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) {
                trucks.add((Truck) vehicle);
            }
        }
        return trucks;
    }
    
    // Display all vehicles
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
    
    // Display vehicles by type
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
    
    // Display vehicles that need special license
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
    
    // Get total count
    public int getTotalVehicleCount() {
        return vehicles.size();
    }
    
    // Get count by type
    public int getCarCount() {
        return getAllCars().size();
    }
    
    public int getMotorcycleCount() {
        return getAllMotorcycles().size();
    }
    
    public int getTruckCount() {
        return getAllTrucks().size();
    }
    
    // Display statistics
    public void displayStatistics() {
        System.out.println("\n=== THỐNG KÊ TỔNG QUAN ===");
        System.out.println("Tổng số phương tiện: " + getTotalVehicleCount());
        System.out.println("  - Ô tô: " + getCarCount() + " chiếc");
        System.out.println("  - Xe máy: " + getMotorcycleCount() + " chiếc");
        System.out.println("  - Xe tải: " + getTruckCount() + " chiếc");
    }
} 