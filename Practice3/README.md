# Practice 3 - Hệ thống quản lý phương tiện giao thông

## Mô tả bài tập

Xây dựng hệ thống quản lý phương tiện giao thông cho ngành cảnh sát bao gồm: ô tô, xe máy, xe tải.

## Yêu cầu Requirement 1

Xây dựng các lớp để quản lý các phương tiện trên một cách hiệu quả bằng kiến thức OOP đã học.

## Các lớp đã tạo

### 1. VehicleOwner (Chủ xe)

- Thuộc tính: `cccdNumber`, `fullName`, `email`
- Phương thức: `displayInfo()` - hiển thị thông tin chủ xe
- Phương thức: `toString()` - chuỗi biểu diễn chủ xe

### 2. Vehicle (Lớp trừu tượng cơ sở)

- Thuộc tính chung: `vehicleNumber`, `manufacturer`, `yearOfManufacture`, `vehicleColor`, `owner`
- Phương thức trừu tượng: `getVehicleType()` - trả về loại phương tiện
- Phương thức: `getVehicleAge()` - tính tuổi xe
- Phương thức: `displayInfo()` - hiển thị thông tin phương tiện

### 3. Car (Ô tô)

- Kế thừa từ Vehicle
- Thuộc tính bổ sung: `numberOfSeats`, `engineType`
- Phương thức: `getCarCategory()` - phân loại xe (con/khách nhỏ/khách lớn)
- Override: `getVehicleType()` - trả về "Ô tô"

### 4. Motorcycle (Xe máy)

- Kế thừa từ Vehicle
- Thuộc tính bổ sung: `capacity` (dung tích cc)
- Phương thức: `getMotorcycleCategory()` - phân loại xe máy
- Phương thức: `needsLicense()` - kiểm tra cần bằng lái
- Override: `getVehicleType()` - trả về "Xe máy"

### 5. Truck (Xe tải)

- Kế thừa từ Vehicle
- Thuộc tính bổ sung: `tonnage` (tải trọng tấn)
- Phương thức: `getTruckCategory()` - phân loại xe tải
- Phương thức: `needsSpecialLicense()` - kiểm tra cần bằng đặc biệt
- Phương thức: `getMaxPayloadKg()` - tính tải trọng tối đa (kg)
- Override: `getVehicleType()` - trả về "Xe tải"

### 6. PoliceManager (Quản lý tập trung)

- Quản lý danh sách tất cả phương tiện
- Thêm/xóa/tìm kiếm phương tiện
- Thống kê theo loại phương tiện
- Tìm kiếm theo biển số hoặc CCCD chủ xe
- Hiển thị phương tiện cần bằng lái đặc biệt

## Tính năng chính

### 1. Quản lý thông tin chung

- Biển số xe, nhà sản xuất, năm sản xuất, màu xe
- Thông tin chủ xe (CCCD, họ tên, email)
- Tính tuổi xe tự động

### 2. Phân loại phương tiện

- **Ô tô**: Xe con (≤5 ghế), Xe khách nhỏ (6-9 ghế), Xe khách lớn (>9 ghế)
- **Xe máy**: Điện/Đạp máy (≤50cc), Phổ thông (51-125cc), Phân khối nhỏ (126-250cc), Phân khối trung bình (251-500cc), Phân khối lớn (>500cc)
- **Xe tải**: Nhỏ (≤3.5 tấn), Trung bình (3.6-7.5 tấn), Lớn (7.6-16 tấn), Siêu trọng (>16 tấn)

### 3. Kiểm tra yêu cầu bằng lái

- **Xe máy**: Cần bằng lái nếu >50cc
- **Xe tải**: Cần bằng đặc biệt nếu >7.5 tấn

### 4. Tính đa hình (Polymorphism)

- Sử dụng List<Vehicle> để lưu trữ tất cả loại phương tiện
- Gọi phương thức chung trên các đối tượng khác nhau
- Override phương thức displayInfo() cho từng loại

### 5. Quản lý tập trung (PoliceManager)

- Thêm/xóa phương tiện
- Tìm kiếm theo biển số hoặc CCCD
- Thống kê theo loại phương tiện
- Hiển thị phương tiện cần bằng lái đặc biệt

## Cách chạy chương trình

### Biên dịch tất cả các file:

```bash
javac *.java
```

### Chạy chương trình chính:

```bash
java Main
```

### Chạy chương trình demo:

```bash
java Demo
```

## Kết quả mong đợi

Chương trình sẽ hiển thị:

1. Thống kê tổng quan số lượng phương tiện
2. Danh sách phương tiện theo từng loại
3. Phương tiện cần bằng lái đặc biệt
4. Tìm kiếm phương tiện theo biển số
5. Tìm kiếm phương tiện theo CCCD chủ xe
6. Thông tin chi tiết tất cả phương tiện
7. Demo chức năng xóa phương tiện

## Mở rộng có thể thực hiện

- Thêm giao diện người dùng (GUI)
- Thêm lưu trữ dữ liệu vào file/cơ sở dữ liệu
- Thêm chức năng báo cáo vi phạm giao thông
- Thêm chức năng quản lý bằng lái
- Thêm validation dữ liệu đầu vào
- Thêm chức năng xuất báo cáo PDF/Excel
