-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 04, 2026 lúc 04:54 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlddh_vutiendung`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chuyennganh`
--

CREATE TABLE `chuyennganh` (
  `ID` int(11) NOT NULL,
  `MaChuyenNganh` varchar(20) NOT NULL,
  `TenChuyenNganh` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chuyennganh`
--

INSERT INTO `chuyennganh` (`ID`, `MaChuyenNganh`, `TenChuyenNganh`) VALUES
(1, 'KTPM', 'Kỹ thuật phần mềm'),
(2, 'HTTT', 'Hệ thống thông tin'),
(3, 'ATTT', 'An toàn thông tin'),
(4, 'TKDH', 'Thiết kế đồ họa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giangvien`
--

CREATE TABLE `giangvien` (
  `ID` int(11) NOT NULL,
  `TenDangNhap` varchar(50) NOT NULL,
  `MatKhau` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `giangvien`
--

INSERT INTO `giangvien` (`ID`, `TenDangNhap`, `MatKhau`) VALUES
(1, 'admin', 'admin123'),
(2, 'dungvt', '123456'),
(3, 'truongkhoa', '123'),
(4, 'gv_hung', '123'),
(5, 'gv_lan', '123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lop`
--

CREATE TABLE `lop` (
  `ID` int(11) NOT NULL,
  `MaLop` varchar(20) NOT NULL,
  `TenLop` varchar(100) NOT NULL,
  `KhoaHoc` varchar(20) DEFAULT NULL,
  `MaChuyenNganh` varchar(20) DEFAULT NULL,
  `GVCN` varchar(50) DEFAULT NULL,
  `SDT` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `lop`
--

INSERT INTO `lop` (`ID`, `MaLop`, `TenLop`, `KhoaHoc`, `MaChuyenNganh`, `GVCN`, `SDT`) VALUES
(1, 'TH23A', 'Tin học ứng dụng A', 'K23', 'KTPM', 'TRI', '0912345678'),
(2, 'AT24C', 'An toàn thông tin C', 'K24', 'ATTT', 'DUNG', '0944332211'),
(7, 'DCTT21', 'Android', 'K24', 'KTPM', 'GIANG', '0123654');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sinhvien`
--

CREATE TABLE `sinhvien` (
  `MaSV` varchar(20) NOT NULL,
  `HoTen` varchar(100) NOT NULL,
  `NgaySinh` date DEFAULT NULL,
  `GioiTinh` varchar(10) DEFAULT NULL,
  `SDT` varchar(15) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `MaLop` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sinhvien`
--

INSERT INTO `sinhvien` (`MaSV`, `HoTen`, `NgaySinh`, `GioiTinh`, `SDT`, `DiaChi`, `MaLop`) VALUES
('SV001', 'Nguyễn Văn An', '2005-05-15', 'Nam', '0912345678', 'Thái Bình', 'TH23A'),
('SV002', 'Lê Thị Bình', '2005-10-20', 'Nữ', '0988776655', 'Hà Nội', 'TH23A'),
('SV003', 'Trần Minh Chiến', '2006-01-12', 'Nam', '0944332211', 'Nam Định', 'AT24C'),
('SV004', 'Phạm Hồng Đào', '2006-08-05', 'Nữ', '0977112233', 'Hải Phòng', 'AT24C'),
('SV005', 'Hoàng Gia Bảo', '2005-12-30', 'Nam', '0966554433', 'Quảng Ninh', 'TH23A');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chuyennganh`
--
ALTER TABLE `chuyennganh`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `MaChuyenNganh` (`MaChuyenNganh`);

--
-- Chỉ mục cho bảng `giangvien`
--
ALTER TABLE `giangvien`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `TenDangNhap` (`TenDangNhap`);

--
-- Chỉ mục cho bảng `lop`
--
ALTER TABLE `lop`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `MaLop` (`MaLop`),
  ADD KEY `MaChuyenNganh` (`MaChuyenNganh`);

--
-- Chỉ mục cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`MaSV`),
  ADD KEY `fk_sinhvien_lop` (`MaLop`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chuyennganh`
--
ALTER TABLE `chuyennganh`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `giangvien`
--
ALTER TABLE `giangvien`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `lop`
--
ALTER TABLE `lop`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `lop`
--
ALTER TABLE `lop`
  ADD CONSTRAINT `lop_ibfk_1` FOREIGN KEY (`MaChuyenNganh`) REFERENCES `chuyennganh` (`MaChuyenNganh`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD CONSTRAINT `fk_sinhvien_lop` FOREIGN KEY (`MaLop`) REFERENCES `lop` (`MaLop`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
