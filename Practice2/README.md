# Practice 2 - Hệ thống quản lý kho siêu thị

## Mô tả bài tập

Xây dựng hệ thống quản lý kho siêu thị với 3 loại hàng hóa: thực phẩm, hàng điện tử và đồ gốm.

## Các lớp đã tạo

### 1. Product (Lớp trừu tượng cơ sở)

- Thuộc tính: `productCode`, `name`, `inventoryQuantity`, `unitPrice`
- Phương thức trừu tượng: `getVAT()` - tính thuế VAT
- Phương thức trừu tượng: `getConsumptionStatus()` - đánh giá mức tiêu thụ
- Phương thức: `getTotalValue()` - tính tổng giá trị (có VAT)
- Phương thức: `displayInfo()` - hiển thị thông tin sản phẩm

### 2. Food (Thực phẩm)

- Kế thừa từ Product
- Thuộc tính bổ sung: `manufactureDate`, `expirationDate`, `supplier`
- VAT: 5%
- Đánh giá tiêu thụ: "Khó bán" nếu còn hàng và đã hết hạn
- Tính năng: kiểm tra hết hạn, cảnh báo sắp hết hạn
- Validation: ngày hết hạn phải sau hoặc bằng ngày sản xuất

### 3. Electronics (Hàng điện tử)

- Kế thừa từ Product
- Thuộc tính bổ sung: `warrantyMonths`, `capacityKW`
- VAT: 10%
- Đánh giá tiêu thụ: "Đã bán" nếu số lượng < 3
- Validation: thời gian bảo hành >= 0, công suất >= 0
- Tính năng: tính ngày hết bảo hành

### 4. Crockery (Đồ gốm)

- Kế thừa từ Product
- Thuộc tính bổ sung: `manufacturer`, `arrivalDate`
- VAT: 10%
- Đánh giá tiêu thụ: "Bán chậm" nếu số lượng > 50 và lưu kho > 10 ngày
- Tính năng: tính số ngày đã nhập

### 5. InventoryManager (Quản lý kho)

- Quản lý danh sách tất cả sản phẩm
- Thống kê theo từng loại hàng hóa
- Tìm kiếm sản phẩm theo mã
- Hiển thị sản phẩm có số lượng thấp
- Tính tổng giá trị kho hàng
- **Tính năng mới**: Đánh giá mức tiêu thụ cho tất cả sản phẩm

## Tính năng đánh giá mức tiêu thụ (Requirement 2)

### Quy tắc đánh giá:

1. **Hàng điện tử**: Nếu số lượng < 3 → "Đã bán"
2. **Thực phẩm**: Nếu còn hàng và đã hết hạn → "Khó bán"
3. **Đồ gốm**: Nếu số lượng > 50 và lưu kho > 10 ngày → "Bán chậm"
4. **Các trường hợp còn lại**: "Không đánh giá"

### Phương thức mới:

- `getConsumptionStatus()` - trả về trạng thái tiêu thụ
- `displayConsumptionStatus()` - hiển thị đánh giá tất cả sản phẩm
- `getProductsByConsumptionStatus()` - lọc sản phẩm theo trạng thái

## Tính năng chính

### 1. Quản lý sản phẩm

- Thêm/xóa sản phẩm
- Hiển thị thông tin chi tiết từng loại
- Validation dữ liệu đầu vào

### 2. Thống kê kho hàng

- Số lượng và giá trị theo từng loại
- Tổng số lượng và giá trị toàn kho
- Sản phẩm có số lượng thấp

### 3. Tính thuế VAT

- Thực phẩm: 5%
- Hàng điện tử: 10%
- Đồ gốm: 10%

### 4. Đánh giá mức tiêu thụ

- Tự động đánh giá theo quy tắc
- Hiển thị danh sách theo trạng thái
- Cảnh báo sản phẩm có vấn đề

### 5. Tính năng đặc biệt

- Cảnh báo thực phẩm hết hạn/sắp hết hạn
- Tính ngày hết bảo hành cho hàng điện tử
- Theo dõi thời gian nhập kho đồ gốm

## Kết quả mong đợi

Chương trình sẽ hiển thị:

1. Thống kê tổng quan kho hàng
2. Đánh giá mức tiêu thụ tất cả sản phẩm
3. Danh sách sản phẩm theo trạng thái tiêu thụ
4. Danh sách chi tiết tất cả sản phẩm
5. Tìm kiếm sản phẩm theo mã
6. Danh sách sản phẩm có số lượng thấp
