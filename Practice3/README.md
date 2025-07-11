# Practice 3 - Hệ thống quản lý phương tiện giao thông

## Mô tả bài tập

Xây dựng hệ thống quản lý phương tiện giao thông cho ngành cảnh sát bao gồm: ô tô, xe máy, xe tải.

## Yêu cầu Requirement 1

Xây dựng các lớp để quản lý các phương tiện trên một cách hiệu quả bằng kiến thức OOP đã học.

## Yêu cầu Requirement 2

Chương trình thực hiện các nhiệm vụ sau:

1. Thêm phương tiện giao thông
2. Tìm kiếm phương tiện theo biển số xe
3. Tìm phương tiện của chủ xe theo số CCCD
4. Xóa tất cả phương tiện của một nhà sản xuất
5. Chỉ ra nhà sản xuất nào có nhiều phương tiện nhất
6. Sắp xếp phương tiện theo số lượng giảm dần
7. Thống kê từng loại phương tiện

## Quy tắc validation

- Biển số xe phải có định dạng XX-X-XXXXX (2 số + 1 chữ + 5 số) và duy nhất
- Nhà sản xuất chỉ được phép: Honda, Yamaha, Toyota, Suzuki
- Năm sản xuất phải từ 2000 đến năm hiện tại
- CCCD phải có đúng 12 số và duy nhất
- Email phải đúng định dạng

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
- Validation dữ liệu đầu vào
- Thêm/xóa/tìm kiếm phương tiện
- Thống kê theo loại phương tiện
- Tìm kiếm theo biển số hoặc CCCD chủ xe
- Xóa tất cả phương tiện của một nhà sản xuất
- Tìm nhà sản xuất có nhiều phương tiện nhất
- Sắp xếp theo số lượng phương tiện

### 7. ValidationUtils (Kiểm tra dữ liệu)

- Kiểm tra định dạng biển số xe
- Kiểm tra nhà sản xuất hợp lệ
- Kiểm tra năm sản xuất
- Kiểm tra CCCD và tính duy nhất
- Kiểm tra định dạng email
- Hiển thị thông báo lỗi validation

## Tính năng chính

### 1. Quản lý thông tin chung

- Biển số xe, nhà sản xuất, năm sản xuất, màu xe
- Thông tin chủ xe (CCCD, họ tên, email)
- Tính tuổi xe tự động

### 2. Validation dữ liệu

- Kiểm tra định dạng biển số xe (XX-X-XXXXX)
- Kiểm tra nhà sản xuất (Honda, Yamaha, Toyota, Suzuki)
- Kiểm tra năm sản xuất (2000-năm hiện tại)
- Kiểm tra CCCD (12 số, duy nhất)
- Kiểm tra email (định dạng hợp lệ)

### 3. Phân loại phương tiện

- **Ô tô**: Xe con (≤5 ghế), Xe khách nhỏ (6-9 ghế), Xe khách lớn (>9 ghế)
- **Xe máy**: Điện/Đạp máy (≤50cc), Phổ thông (51-125cc), Phân khối nhỏ (126-250cc), Phân khối trung bình (251-500cc), Phân khối lớn (>500cc)
- **Xe tải**: Nhỏ (≤3.5 tấn), Trung bình (3.6-7.5 tấn), Lớn (7.6-16 tấn), Siêu trọng (>16 tấn)

### 4. Kiểm tra yêu cầu bằng lái

- **Xe máy**: Cần bằng lái nếu >50cc
- **Xe tải**: Cần bằng đặc biệt nếu >7.5 tấn

### 5. Tính đa hình (Polymorphism)

- Sử dụng List<Vehicle> để lưu trữ tất cả loại phương tiện
- Gọi phương thức chung trên các đối tượng khác nhau
- Override phương thức displayInfo() cho từng loại

### 6. Quản lý tập trung (PoliceManager)

- Thêm phương tiện với validation
- Tìm kiếm theo biển số hoặc CCCD
- Xóa tất cả phương tiện của một nhà sản xuất
- Tìm nhà sản xuất có nhiều phương tiện nhất
- Sắp xếp theo số lượng phương tiện (giảm dần)
- Thống kê theo loại phương tiện

## Kết quả mong đợi

Chương trình sẽ hiển thị:

1. Thống kê tổng quan số lượng phương tiện
2. Tìm kiếm phương tiện theo biển số
3. Tìm kiếm phương tiện theo CCCD chủ xe
4. Xóa tất cả phương tiện của một nhà sản xuất
5. Tìm nhà sản xuất có nhiều phương tiện nhất
6. Sắp xếp phương tiện theo số lượng (giảm dần)
7. Thống kê theo loại phương tiện
8. Demo validation errors
