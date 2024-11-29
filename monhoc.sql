Create database MonHoc
use MonHoc123
GO
CREATE TABLE Subjects (
    id INT PRIMARY KEY IDENTITY(1,1),  -- Cột ID tự tăng
    mon_hoc NVARCHAR(255) NOT NULL,   -- Tên môn học (cho phép ký tự Unicode)
    ngay_nhap DATE DEFAULT GETDATE()  -- Ngày nhập, mặc định là ngày hiện tại
);
GO
INSERT INTO Subjects (mon_hoc) VALUES
('Toán học'),
('Văn học'),
('Lịch sử'),
('Ngoại ngữ'),
('Tin học'),
('Vật lý'),
('Hóa học'),
('Sinh học');
GO
SELECT * FROM Subjects;
GO