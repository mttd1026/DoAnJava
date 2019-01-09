-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 09, 2019 at 05:04 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.1.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employee`
--

-- --------------------------------------------------------

--
-- Table structure for table `chucvu`
--

CREATE TABLE `chucvu` (
  `MaChucVu` int(11) NOT NULL,
  `TenChucVu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chucvu`
--

INSERT INTO `chucvu` (`MaChucVu`, `TenChucVu`) VALUES
(1, 'ToTruong');

-- --------------------------------------------------------

--
-- Table structure for table `dantoc`
--

CREATE TABLE `dantoc` (
  `MaDanToc` varchar(50) NOT NULL,
  `TenDanToc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dantoc`
--

INSERT INTO `dantoc` (`MaDanToc`, `TenDanToc`) VALUES
('HM', 'Ho Mong'),
('K', 'Kinh'),
('KM', 'KhoMe');

-- --------------------------------------------------------

--
-- Table structure for table `huyen`
--

CREATE TABLE `huyen` (
  `MaHuyen` varchar(50) NOT NULL,
  `TenHuyen` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `huyen`
--

INSERT INTO `huyen` (`MaHuyen`, `TenHuyen`) VALUES
('BH', 'Bien Hoa');

-- --------------------------------------------------------

--
-- Table structure for table `khoi`
--

CREATE TABLE `khoi` (
  `MaKhoi` varchar(50) NOT NULL,
  `TenKhoi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `khoi`
--

INSERT INTO `khoi` (`MaKhoi`, `TenKhoi`) VALUES
('KH', 'kinh doanh'),
('KT', 'Kinh Te'),
('QT', 'Quan Tri');

-- --------------------------------------------------------

--
-- Table structure for table `khuvuc`
--

CREATE TABLE `khuvuc` (
  `MaKhuVuc` varchar(50) NOT NULL,
  `TenKhuVuc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `khuvuc`
--

INSERT INTO `khuvuc` (`MaKhuVuc`, `TenKhuVuc`) VALUES
('HCM', 'Ho Chi Minh'),
('Hue', 'Hue'),
('VT', 'Vung Tau');

-- --------------------------------------------------------

--
-- Table structure for table `loaihopdong`
--

CREATE TABLE `loaihopdong` (
  `MaLoaiHopDong` varchar(50) NOT NULL,
  `TenHopDong` varchar(50) NOT NULL,
  `NgayBatDau` date NOT NULL,
  `NgayKetThuc` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loaihopdong`
--

INSERT INTO `loaihopdong` (`MaLoaiHopDong`, `TenHopDong`, `NgayBatDau`, `NgayKetThuc`) VALUES
('VV', 'Vinh Vien', '1997-09-10', '2045-09-10');

-- --------------------------------------------------------

--
-- Table structure for table `loainhanvien`
--

CREATE TABLE `loainhanvien` (
  `MaLoaiNhanVien` varchar(50) NOT NULL,
  `TenLoaiNhanVien` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loainhanvien`
--

INSERT INTO `loainhanvien` (`MaLoaiNhanVien`, `TenLoaiNhanVien`) VALUES
('CT', 'ChinhThuc');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNhanVien` int(11) NOT NULL,
  `Ho` varchar(50) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `TenTiengAnh` varchar(50) NOT NULL,
  `NgaySinh` date NOT NULL,
  `NgayThayDoi` date NOT NULL,
  `NgayThayDoiCN` date NOT NULL,
  `NgayBatDau` date NOT NULL,
  `NgayKetThuc` date NOT NULL,
  `GioiTinh` bit(1) NOT NULL,
  `DTCty` int(11) NOT NULL,
  `DTNha` int(11) NOT NULL,
  `ECty` varchar(50) NOT NULL,
  `ERieng` varchar(50) NOT NULL,
  `NoiSinh` varchar(50) NOT NULL,
  `NguyenQuan` varchar(50) NOT NULL,
  `TamTru` varchar(50) NOT NULL,
  `ThuongTru` varchar(50) NOT NULL,
  `HonNhan` bit(1) NOT NULL,
  `BaoHiem` varchar(50) NOT NULL,
  `MaLoaiNhanVien` varchar(11) NOT NULL,
  `MaKhoi` varchar(11) NOT NULL,
  `MaTonGiao` varchar(11) NOT NULL,
  `MaQuocTich` varchar(11) NOT NULL,
  `MaDanToc` varchar(11) NOT NULL,
  `MaLoaiHopDong` varchar(11) NOT NULL,
  `MaNoiLamViec` varchar(11) NOT NULL,
  `MaPhongBan` int(11) NOT NULL,
  `MaPhongCN` varchar(11) NOT NULL,
  `MaChucVu` varchar(11) NOT NULL,
  `MaTinhThanh` varchar(11) NOT NULL,
  `MaHuyen` varchar(11) NOT NULL,
  `MaPhuThuoc` int(11) NOT NULL,
  `MaTo` int(11) NOT NULL,
  `Image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNhanVien`, `Ho`, `Ten`, `TenTiengAnh`, `NgaySinh`, `NgayThayDoi`, `NgayThayDoiCN`, `NgayBatDau`, `NgayKetThuc`, `GioiTinh`, `DTCty`, `DTNha`, `ECty`, `ERieng`, `NoiSinh`, `NguyenQuan`, `TamTru`, `ThuongTru`, `HonNhan`, `BaoHiem`, `MaLoaiNhanVien`, `MaKhoi`, `MaTonGiao`, `MaQuocTich`, `MaDanToc`, `MaLoaiHopDong`, `MaNoiLamViec`, `MaPhongBan`, `MaPhongCN`, `MaChucVu`, `MaTinhThanh`, `MaHuyen`, `MaPhuThuoc`, `MaTo`, `Image`) VALUES
(2, 'Nguyen', 'Thai', 'ThaiBuff', '1997-09-10', '2016-09-10', '2017-08-12', '2016-09-12', '2018-03-09', b'1', 342576709, 432187635, 'cty123@gmail.com', 'nguyenleminhthai@gmail.com', 'Ho Chi Minh', 'Quang Tri', 'Tan Binh', 'Tan Binh', b'1', '1523649871', 'CT', 'KT', 'P', 'VN', 'K', 'VV', 'BV', 1, '1', '1', '1', 'BH', 1, 1, ''),
(3, 'Duc', 'Minh', 'MinhBeo', '1997-09-20', '2016-09-10', '2018-01-15', '2017-01-17', '2018-03-09', b'1', 342576708, 358497831, 'cty123@gmail.com', 'ducminhbeo@gmail.com', 'RanhGioiTaiwanVN', 'KhongBiet', 'Quan 5', 'Quan 5', b'0', '1523649878', 'CT', 'KT', 'TC', 'VN', 'HM', 'VV', 'BV', 1, '1', '1', 'BH', 'BH', 1, 1, ''),
(4, 'Mai', 'Thinh', 'ThinhBuffter', '1997-09-21', '2016-09-10', '2017-09-20', '2018-12-02', '2020-02-06', b'1', 342576707, 342576703, 'cty123@gmail.com', 'maithinh@gmail.com', 'Viet Nam', 'HCM', 'Tan Binh', 'Tan Binh', b'1', '1523649872', 'CT', 'KT', 'TC', 'VN', 'HM', 'VV', 'BV', 1, '1', '1', 'BH', 'BH', 1, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `noilamviec`
--

CREATE TABLE `noilamviec` (
  `MaNoiLamViec` varchar(50) NOT NULL,
  `TenNoiLamViec` varchar(50) NOT NULL,
  `MaKhuVuc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `noilamviec`
--

INSERT INTO `noilamviec` (`MaNoiLamViec`, `TenNoiLamViec`, `MaKhuVuc`) VALUES
('BV', 'Benh vien', 'HCM');

-- --------------------------------------------------------

--
-- Table structure for table `phongban`
--

CREATE TABLE `phongban` (
  `MaPhongBan` int(11) NOT NULL,
  `TenPhongBan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phongban`
--

INSERT INTO `phongban` (`MaPhongBan`, `TenPhongBan`) VALUES
(1, 'Nhan su');

-- --------------------------------------------------------

--
-- Table structure for table `phong_tt_cn`
--

CREATE TABLE `phong_tt_cn` (
  `MaPhongCN` int(11) NOT NULL,
  `TenPhongCN` varchar(50) NOT NULL,
  `MaPhuThuoc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phong_tt_cn`
--

INSERT INTO `phong_tt_cn` (`MaPhongCN`, `TenPhongCN`, `MaPhuThuoc`) VALUES
(1, 'Benh vien dong nai', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phuthuocphong_tt_cn`
--

CREATE TABLE `phuthuocphong_tt_cn` (
  `MaPhuThuoc` int(11) NOT NULL,
  `TenPhuThuoc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `phuthuocphong_tt_cn`
--

INSERT INTO `phuthuocphong_tt_cn` (`MaPhuThuoc`, `TenPhuThuoc`) VALUES
(1, 'Benh vien dong nai');

-- --------------------------------------------------------

--
-- Table structure for table `quoctich`
--

CREATE TABLE `quoctich` (
  `MaQuocTich` varchar(50) NOT NULL,
  `TenQuocTich` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quoctich`
--

INSERT INTO `quoctich` (`MaQuocTich`, `TenQuocTich`) VALUES
('HK', 'HongKong'),
('IRA', 'IRAQ'),
('VN', 'VietNam');

-- --------------------------------------------------------

--
-- Table structure for table `tinh_thanh`
--

CREATE TABLE `tinh_thanh` (
  `MaTinhThanh` int(11) NOT NULL,
  `TenTinhThanh` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tinh_thanh`
--

INSERT INTO `tinh_thanh` (`MaTinhThanh`, `TenTinhThanh`) VALUES
(1, 'Bien Hoa');

-- --------------------------------------------------------

--
-- Table structure for table `to`
--

CREATE TABLE `to` (
  `MaTo` int(11) NOT NULL,
  `TenTo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `to`
--

INSERT INTO `to` (`MaTo`, `TenTo`) VALUES
(1, '3');

-- --------------------------------------------------------

--
-- Table structure for table `tongiao`
--

CREATE TABLE `tongiao` (
  `MaTonGiao` varchar(50) NOT NULL,
  `TenTonGiao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tongiao`
--

INSERT INTO `tongiao` (`MaTonGiao`, `TenTonGiao`) VALUES
('DH', 'Dao Hoi'),
('P', 'Phat Giao'),
('TC', 'Thien chua');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`MaChucVu`);

--
-- Indexes for table `dantoc`
--
ALTER TABLE `dantoc`
  ADD PRIMARY KEY (`MaDanToc`);

--
-- Indexes for table `huyen`
--
ALTER TABLE `huyen`
  ADD PRIMARY KEY (`MaHuyen`);

--
-- Indexes for table `khoi`
--
ALTER TABLE `khoi`
  ADD PRIMARY KEY (`MaKhoi`);

--
-- Indexes for table `khuvuc`
--
ALTER TABLE `khuvuc`
  ADD PRIMARY KEY (`MaKhuVuc`);

--
-- Indexes for table `loaihopdong`
--
ALTER TABLE `loaihopdong`
  ADD PRIMARY KEY (`MaLoaiHopDong`);

--
-- Indexes for table `loainhanvien`
--
ALTER TABLE `loainhanvien`
  ADD PRIMARY KEY (`MaLoaiNhanVien`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNhanVien`);

--
-- Indexes for table `noilamviec`
--
ALTER TABLE `noilamviec`
  ADD PRIMARY KEY (`MaNoiLamViec`);

--
-- Indexes for table `phongban`
--
ALTER TABLE `phongban`
  ADD PRIMARY KEY (`MaPhongBan`);

--
-- Indexes for table `phong_tt_cn`
--
ALTER TABLE `phong_tt_cn`
  ADD PRIMARY KEY (`MaPhongCN`);

--
-- Indexes for table `phuthuocphong_tt_cn`
--
ALTER TABLE `phuthuocphong_tt_cn`
  ADD PRIMARY KEY (`MaPhuThuoc`);

--
-- Indexes for table `quoctich`
--
ALTER TABLE `quoctich`
  ADD PRIMARY KEY (`MaQuocTich`);

--
-- Indexes for table `tinh_thanh`
--
ALTER TABLE `tinh_thanh`
  ADD PRIMARY KEY (`MaTinhThanh`);

--
-- Indexes for table `to`
--
ALTER TABLE `to`
  ADD PRIMARY KEY (`MaTo`);

--
-- Indexes for table `tongiao`
--
ALTER TABLE `tongiao`
  ADD PRIMARY KEY (`MaTonGiao`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
