import java.util.regex.Pattern;

public class ValidationUtils {
    // Valid manufacturers
    private static final String[] VALID_MANUFACTURERS = {"Honda", "Yamaha", "Toyota", "Suzuki"};
    
    // Current year
    private static final int CURRENT_YEAR = 2024;
    
    // Validation patterns
    private static final Pattern VEHICLE_NUMBER_PATTERN = Pattern.compile("^[0-9]{2}[A-Z]-[0-9]{5}$");
    private static final Pattern CCCD_PATTERN = Pattern.compile("^[0-9]{12}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    
    // Validate vehicle number (exactly 5 characters after dash)
    public static boolean isValidVehicleNumber(String vehicleNumber) {
        if (vehicleNumber == null || vehicleNumber.trim().isEmpty()) {
            return false;
        }
        return VEHICLE_NUMBER_PATTERN.matcher(vehicleNumber).matches();
    }
    
    // Validate manufacturer
    public static boolean isValidManufacturer(String manufacturer) {
        if (manufacturer == null || manufacturer.trim().isEmpty()) {
            return false;
        }
        for (String validManufacturer : VALID_MANUFACTURERS) {
            if (validManufacturer.equalsIgnoreCase(manufacturer.trim())) {
                return true;
            }
        }
        return false;
    }
    
    // Validate year of manufacture
    public static boolean isValidYearOfManufacture(int year) {
        return year >= 2000 && year <= CURRENT_YEAR;
    }
    
    // Validate CCCD (exactly 12 numbers)
    public static boolean isValidCCCD(String cccd) {
        if (cccd == null || cccd.trim().isEmpty()) {
            return false;
        }
        return CCCD_PATTERN.matcher(cccd.trim()).matches();
    }
    
    // Validate email format
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }
    
    // Check if vehicle number is unique
    public static boolean isVehicleNumberUnique(String vehicleNumber, java.util.List<Vehicle> existingVehicles) {
        for (Vehicle vehicle : existingVehicles) {
            if (vehicle.getVehicleNumber().equals(vehicleNumber)) {
                return false;
            }
        }
        return true;
    }
    
    // Check if CCCD is unique
    public static boolean isCCCDUnique(String cccd, java.util.List<Vehicle> existingVehicles) {
        for (Vehicle vehicle : existingVehicles) {
            if (vehicle.getOwner().getCccdNumber().equals(cccd)) {
                return false;
            }
        }
        return true;
    }
    
    // Get valid manufacturers list
    public static String[] getValidManufacturers() {
        return VALID_MANUFACTURERS.clone();
    }
    
    // Get current year
    public static int getCurrentYear() {
        return CURRENT_YEAR;
    }
    
    // Display validation error message
    public static void displayValidationError(String field, String error) {
        System.out.println("❌ Lỗi validation cho " + field + ": " + error);
    }
    
    // Display validation success message
    public static void displayValidationSuccess(String field) {
        System.out.println("✅ " + field + " hợp lệ");
    }
} 