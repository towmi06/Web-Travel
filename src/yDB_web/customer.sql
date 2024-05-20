-- Tạo bảng customer
CREATE TABLE customer (
    id INT PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address NVARCHAR(255) NOT NULL
);

-- Thêm các khách hàng mới
INSERT INTO customer (id, name, email, phone, address) 
VALUES 
(31, N'Nguyễn Thị Anh', 'thianh@gmail.com', '03456789', N'Hải Bối, Đông Anh, Hà Nội'),
(32, N'Lại Trung Hiếu', 'hieutrung@gmail.com', '0987654321', N'Pham Ngọc Thạch, Đà Nẵng'),
(33, N'Trần Văn Cường', 'cuongtran@gmail.com', '0918765432', N'789 Nguyễn Tất Thành, Thành phố Yên Bái, Yên Bái'),
(34, N'Nguyễn Thị Dung', 'dungnguyen@gmail.com', '0978123456', N'456 Hoàng Diệu, Thành phố Nha Trang, Khánh Hòa'),
(35, N'Phạm Văn Đức', 'ducpham@gmail.com', '0908123456', N'321 Trần Phú, Thành phố Đà Lạt, Lâm Đồng'),
(36, N'Mary Johnson', 'maryjohnson@example.com', '0123456789', N'123 Main St, New York, USA'),
(37, N'John Smith', 'johnsmith@example.com', '0987654321', N'456 Oak Ave, Los Angeles, USA'),
(38, N'Nguyễn Thị Hồng', 'hongnguyen@example.com', '0456123789', N'789 Lê Lợi, Thành phố Hồ Chí Minh'),
(39, N'Peter Brown', 'peterbrown@example.com', '0908765432', N'789 King St, London, UK');

