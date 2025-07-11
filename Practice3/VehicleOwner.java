public class VehicleOwner {
    private String cccdNumber;
    private String fullName;
    private String email;
    
    public VehicleOwner(String cccdNumber, String fullName, String email) {
        this.cccdNumber = cccdNumber;
        this.fullName = fullName;
        this.email = email;
    }
    
    public String getCccdNumber() {
        return cccdNumber;
    }
    
    public void setCccdNumber(String cccdNumber) {
        this.cccdNumber = cccdNumber;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void displayInfo() {
        System.out.println("Thông tin chủ xe:");
        System.out.println("  - Số CCCD: " + cccdNumber);
        System.out.println("  - Họ tên: " + fullName);
        System.out.println("  - Email: " + email);
    }
    
    @Override
    public String toString() {
        return "Chủ xe: " + fullName + " (CCCD: " + cccdNumber + ")";
    }
} 