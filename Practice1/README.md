# Practice 1 - Shape Inheritance

## Mô tả bài tập

Tạo hệ thống kế thừa cho các hình học cơ bản trong Java.

## Các lớp đã tạo

### 1. Shape (Lớp cơ sở)

- Thuộc tính: `width`, `height`
- Constructor nhận width và height
- Phương thức `displayInfo()` để hiển thị thông tin

### 2. Rectangle (Kế thừa từ Shape)

- Phương thức `getArea()`: tính diện tích = width × height
- Phương thức `getPerimeter()`: tính chu vi = 2 × (width + height)
- Override `displayInfo()` để hiển thị thông tin chi tiết

### 3. Circle (Kế thừa từ Shape)

- Thuộc tính `radius`
- Phương thức `getArea()`: tính diện tích = π × r²
- Phương thức `getCircumference()`: tính chu vi = 2 × π × r
- Override `displayInfo()` để hiển thị thông tin chi tiết

### 4. Triangle (Lớp bổ sung)

- Phương thức `getArea()`: tính diện tích = (base × height) / 2
- Phương thức `getPerimeter()`: tính chu vi (giả sử tam giác vuông)
- Override `displayInfo()` để hiển thị thông tin chi tiết

## Kết quả mong đợi

Chương trình sẽ hiển thị:

1. Thông tin của Shape cơ bản
2. Thông tin của Rectangle với diện tích và chu vi
3. Thông tin của Circle với diện tích và chu vi
4. Thông tin của Triangle với diện tích và chu vi
5. Demo tính đa hình (polymorphism) với mảng các Shape
