USE master
GO

CREATE DATABASE [QuanLyNhaHang]
GO

USE [QuanLyNhaHang]
GO

CREATE TABLE [dbo].[KhoHang](
	[MaHangHoa] [nvarchar](15) NOT NULL,
	[TenHangHoa] [nvarchar](50) NOT NULL,
	[NgayNhap] [datetime] NOT NULL,
	[DonVi] [nvarchar](50) NOT NULL,
	[SoLuong] [float] NOT NULL,
	[ChiPhi] [float] NOT NULL,
	[TongChiPhi] [float] NULL,
	PRIMARY KEY (MaHangHoa)
)
GO

CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](5) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[SoDT] [nvarchar](15) NOT NULL,
	[ChucVu] [nvarchar](50) NOT NULL,
	[GioiTinh] [bit] NULL,
	[Avatar] [nvarchar](50) NULL,
	PRIMARY KEY (MaNV)
)	
GO

CREATE TABLE [dbo].[BanAn](
	[MaBan] [int] NOT NULL,
	[LoaiBan] [int] NOT NULL,
	[TrangThai] [nvarchar](50) NOT NULL,
	PRIMARY KEY (MaBan)
)
GO

CREATE TABLE [dbo].[HoaDon](
	[MaHD] [int] IDENTITY(1,1) NOT NULL,
	[NgayTao] [datetime] NULL,
	[MaNV] [nvarchar](5) NOT NULL,
	[MaBan] [int] NOT NULL,
	[TongTien] [float] NOT NULL,
	TrangThai nvarchar(20) not null
	PRIMARY KEY (MaHD),
	CONSTRAINT FK_NhanVienHoaDon FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
	CONSTRAINT FK_BanAnHoaDon FOREIGN KEY (MaBan) REFERENCES BanAn(MaBan)
)
GO

CREATE TABLE [dbo].[ThucDon](
	[MaMon] [nvarchar](15) NOT NULL,
	[TenMon] [nvarchar](50) NOT NULL,
	[GiaTien] [float] NOT NULL,
	[HinhAnh] [nvarchar](50) NOT NULL,
	[Loai] [nvarchar](50) NOT NULL,
	PRIMARY KEY (MaMon),
)
GO

CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaHDCT] [int] IDENTITY(1,1) NOT NULL,
	[MaHD] [int] NOT NULL,
	[MaMon] [nvarchar](15) NOT NULL,
	[SoLuong] [int] Not Null,
	PRIMARY KEY (MaHDCT),
	CONSTRAINT FK_HoaDonHDCT FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
	CONSTRAINT FK_ThucDonHDCT FOREIGN KEY (MaMon) REFERENCES ThucDon(MaMon)
)
GO

CREATE TABLE [dbo].[DatBan](
	[MaDatBan] [nvarchar](15) NOT NULL,
	[TenKH] [nvarchar](50) NOT NULL,
	[SDTKH] [nvarchar](15) NOT NULL,
	[NgayDatBan] [date] NOT NULL,
	[GioDat] [nvarchar](10) NULL,
	[SoNguoi] [int] NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
	[MaNV] [nvarchar](5),
	PRIMARY KEY (MaDatBan),
	CONSTRAINT FK_NhanVienDatBan FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
)
GO
insert into ThucDon
values('TD01',N'Salad trái cây _A_',150000,'saladtraicay.jpg',N'Món khác'),
	  ('TD02',N'Kim chi cải thảo _A_',190000,'kimchi.jpg',N'Món khác'),
	  ('TD03',N'Cơm cuộn Kimbap _A_',150000,'kimbap.jpg',N'Món khác'),
	  ('TD04',N'Bánh hải sản _A_',190000,'banhhaisan.jpg',N'Món khác'),
	  ('TD05',N'Salad rong biển _A_',190000,'saladrongbien.jpg',N'Món khác'),
	  ('TD06',N'Sườn bò tươi nướng _A_',190000,'suonbonuong.jpg',N'Món ăn'),
	  ('TD07',N'Lươn biển nhật _A_', 150000,'luonbien.png',N'Món ăn'),
	  ('TD08',N'Thăn nội bò mỹ _A_', 119000,'thannoibo.jpg',N'Món ăn'),
	  ('TD09',N'Sườn bò rút xương _A_', 150000,'suonborutxuong.jpg',N'Món ăn'),
	  ('TD10',N'Ba chỉ bò _A_', 119000,'bachibo.png',N'Món ăn'),
	  ('TD11',N'Dẻ sườn bò _A_', 150000,'desuon.jpg',N'Món ăn'),
	  ('TD12',N'Trà đào _A_', 119000,'tradao.jpg',N'Món uống'),
	  ('TD13',N'Strawberry tea _A_', 150000,'strawberrytea.jpg',N'Món uống'),
	  ('TD14',N'Soju _A_', 119000,'soju.jpg',N'Món uống'),
	  ('TD15',N'Rượu gạo _A_', 150000,'ruougao.jpg',N'Món uống'),
	  ('TD16',N'Tokbokki _B_',150000,'tokbokki.jpg',N'Món uống'),
	  ('TD17',N'Râu mục chiên giòn _B_',119000,'raumucchien.png',N'Món khác'),
	  ('TD18',N'Mực vòng chiên giòn _B_',150000,'mucvongchien.jpg',N'Món khác'),
	  ('TD19',N'Xúc xích chiên _B_',190000,'xucxich.jpg',N'Món khác'),
	  ('TD20',N'Salad cá ngừ với trứng _B_',150000,'saladcangu.jpg',N'Món khác'),
	  ('TD21',N'Gầu bò cuộn nấm kim châm _B_',150000,'gaubo.jpg',N'Món ăn'),
	  ('TD22',N'Nạm cổ bò _B_', 190000,'namcobo.jpg',N'Món ăn'),
	  ('TD23',N'Lưỡi bò _B_', 150000,'luoibo.jpg',N'Món ăn'),
	  ('TD24',N'Ba chỉ heo _B_', 119000,'bachiheo.jpg',N'Món ăn'),
	  ('TD25',N'Gà sốt cay _B_', 119000,'gasotcay.jpg',N'Món ăn'),
	  ('TD26',N'Nạc dăm heo _B_', 0,'nacdamheo.jpg',N'Món ăn'),
	  ('TD27',N'Lõi cổ bò tươi _B_', 190000,'loicobo.jpg',N'Món ăn'),
	  ('TD28',N'Coca light _B_', 119000,'cocalight.jpg',N'Món uống'),
	  ('TD29',N'Sprite _B_', 190000,'sprite.jpg',N'Món uống'),
	  ('TD30',N'Nước suối _B_', 119000,'nuocsuoi.png',N'Món uống'),
	  ('TD31',N'Bạch tuộc sốt cay _GM_', 190000,N'Món ăn','bachtuocsotcay.jpg'),
	  ('TD32',N'Mực lá sốt cay _GM_', 150000,'mucsotcay.jpg',N'Món ăn'),
	  ('TD33',N'Cá hồi nướng giấy bạc _GM_', 165000,'cahoi.png',N'Món ăn'),
	  ('TD34',N'Tôm sốt Guang yang _GM_', 130000,'tomsot.jpg',N'Món ăn'),
	  ('TD35',N'Tôm lột vỏ sốt tỏi _GM_', 165000,'tomsottoi.png',N'Món ăn'),
	  ('TD36',N'Cơm trộn Hàn Quốc _GM_', 75000,'comtron.jpg',N'Món ăn'),
	  ('TD37',N'Cơm trộn hải sản _GM_', 120000,'comtronhaisan.jpg',N'Món ăn'),
	  ('TD38',N'Cơm trộng bạch tuộc _GM_', 99000,'comtronbachtuoc.jpg',N'Món ăn'),
	  ('TD39',N'Miến lạnh trộn _GM_', 140000,'mienlanh.jpg',N'Món ăn'),
	  ('TD40',N'Mì Udon xào hải sản _GM_', 165000,'miudon.jpg',N'Món ăn'),
	  ('TD41',N'Miến xào hải sản _GM_', 165000,'mienxao.jpg',N'Món ăn'),
	  ('TD42',N'Canh sườn bò Hàn Quốc _GM_', 189000,'canhsuonbo.jpg',N'Món ăn'),
	  ('TD43',N'Canh rong biển _GM_', 119000,'canhrongbien.jpg',N'Món ăn'),
	  ('TD44',N'Canh kim chi hải sản _GM_', 150000,'canhhaisan.jpg',N'Món ăn'),
	  ('TD45',N'Thịt bò xào Bulgogi nồi đất _GM_', 159000,'thitboxao.jpg',N'Món ăn'),
	  (N'TD46', N'Rau càng cua', 80000, N'raucangcua.jpg', N'Khai vị'),
      (N'TD47', N'Salad dầu dấm', 110000, N'saladdaudam.jpg', N'Khai vị'),
	  (N'TD48', N'Salad cá hồi', 100000, N'saladcahoi.jpg', N'Khai vị'),
	  (N'TD49', N'Nộm hải sản ', 99000, N'monhaisan.jpg', N'Khai vị'),
	  (N'TD50', N'Salad rong nha cá ngừ', 130000, N'saladrongnhacangu.jpg', N'Khai vị'),
	  (N'TD51', N'Sashimi Bào Ngư', 220000, N'sashimibaongu.jpg', N'Sashimi'),
	  (N'TD52', N'Sashimi Cá Cơm Hàn Quốc', 250000, N'sashimicacomhanquoc.jpg', N'Sashimi'),
	  (N'TD53', N'Sashimi Cá Hồi', 300000, N'sashimicahoi.jpg', N'Sashimi'),
	  (N'TD54', N'Sashimi Hàu Sữa ', 250000, N'sashimihausua.jpg', N'Sashimi'),
	  (N'TD55', N'Sashimi Tôm Hùm', 1000000, N'sashimitomhum.jpg', N'Sashimi'),
	  (N'TD56', N'Sashimi Tôm Sú', 180000, N'sashimitomsu.jpg', N'Sashimi'),
	  (N'TD57', N'Cua hoàng đế hấp ', 2500000, N'cuahoangdehap.jpg', N'Cua'),
	  (N'TD58', N'Cua rang me', 300000, N'cuarangme.jpg', N'Cua'),
	  (N'TD59', N'Cua sốt ớt Singapo', 350000, N'cuasototsing.jpg', N'Cua'),
	  (N'TD60', N'Cua sốt tiêu đen', 260000, N'cuasottieuden.jpg', N'Cua'),
	  (N'TD61', N'Ghẹ sốt me', 120000, N'ghesotme.jpg', N'Cua'),
	  (N'TD62', N'Lẩu hồng công', 250000, N'laucuahongcong.png', N'Lẩu'),
	  (N'TD63', N'Lẩu cua thái', 250000, N'laucuathai.jpg', N'Lẩu'),
	  (N'TD64', N'Suop Hải Sản', 25000, N'suphaisan.jpg', N'Súp'),
	  (N'TD65', N' Soup Tôm Bắp', 25000, N'suptombap.jpg', N'Súp')
Go
insert into NhanVien 
values('NV001','123','Pham Quang Vu','0338956987',N'Quản lý',1,null),
	(N'NV002', N'123', N'Quang Vu', N'055687954', N'Quản lý', 1, N'')
Go
insert into BanAn 
values(1,1,N'Trống'),
	(2,1,N'Trống'),
	(3,1,N'Trống'),
	(4,1,N'Trống'),
	(5,1,N'Trống'),
	(6,1,N'Trống'),
	(7,1,N'Trống'),
	(8,1,N'Trống'),
	(9,1,N'Trống'),
	(10,1,N'Trống'),
	(11,1,N'Trống'),
	(12,1,N'Trống'),
	(13,1,N'Trống'),
	(14,1,N'Trống')
Go
Insert into KhoHang Values('CHEN01',N'Chén sứ minh long','03/08/2021',N'Cái',100,10000,1000000),
('DIA',N'Dĩa sứ minh long','03/08/2021',N'Cái',100,10000,1000000),
('DUA',N'Đũa nhựa cao cấp','03/08/2021',N'Chiếc',200,10000,2000000),
('NIA',N'Nĩa inox cao cấp','03/08/2021',N'Chiếc',200,10000,2000000),
('GIAY',N'Giấy ăn vuông','03/08/2021',N'Gói',50,100000,5000000),
('BIAHNK',N'Bia Heineken','03/08/2021',N'Thùng',500,600000,300000000)
GO
INSERT INTO HoaDon  VALUES ('2021-08-13', N'NV002', 12, 1060000, N'Đã thanh toán'),
						('2021-08-13' , N'NV002', 2, 1060000, N'Đã thanh toán'),
						('2021-08-13 ' , N'NV002', 3, 1134000, N'Đã thanh toán'),
						('2021-08-13 ' , N'NV002', 11, 1613000, N'Đã thanh toán'),
						('2021-08-13 ' , N'NV002', 14, 1950000, N'Đã thanh toán'),
						('2021-08-13', N'NV002', 11, 870000, N'Đã thanh toán'),
						('2021-08-13' , N'NV002', 5, 870000, N'Đã thanh toán')


go

INSERT INTO ChiTietHoaDon VALUES ( 1, N'TD01', 1),
								( 1, N'TD02', 1),
								( 1, N'TD03', 1),
								( 1, N'TD05', 1),
								( 1, N'TD06', 1),
								( 1, N'TD04', 1),
								( 2, N'TD01', 1),
								( 2, N'TD02', 1),
								( 2, N'TD03', 1),
								( 2, N'TD06', 1),
								( 2, N'TD05', 1),
								( 2, N'TD04', 1),
								( 3, N'TD03', 1),
								( 3, N'TD02', 1),
								( 3, N'TD13', 1),
								( 3, N'TD14', 1),
								( 3, N'TD52', 1),
								( 3, N'TD63', 1),
								( 3, N'TD65', 1),
								( 4, N'TD02', 1),
								( 4, N'TD03', 2),
								( 4, N'TD16', 1),
								(4, N'TD14', 1),
								( 4, N'TD28', 1),
								( 4, N'TD13', 1),
								( 4, N'TD60', 1),
								( 4, N'TD58', 1),
								( 4, N'TD65', 1),
								( 5, N'TD53', 1),
								( 5, N'TD52', 1),
								( 5, N'TD51', 1),
								( 5, N'TD55', 1),
								(5, N'TD56', 1),
								( 6, N'TD01', 1),
								( 6, N'TD02', 1),
								( 6, N'TD03', 1),
								( 6, N'TD06', 1),
								( 6, N'TD05', 1),
								( 7, N'TD03', 2),
								( 7, N'TD02', 1),
								( 7, N'TD06', 1),
								( 7, N'TD05', 1)
GO
CREATE PROCEDURE sp_NVSoBanbyHD (@TrangThai nvarchar(30),@MaBan nvarchar(15))
AS
select MaHD, hd.MaNV ,HoTen, NgayTao, TongTien, MaBan,TrangThai
from HoaDon HD inner join NHANVIEN NV on HD.MaNV = NV.MaNV
where TrangThai like @TrangThai and MaBan = @MaBan
go
create proc sp_SoSanhNgay(@ngayHT nvarchar(50))
as
select MaHD, hd.MaNV, HoTen, NgayTao, TongTien, MaBan,TrangThai
from HoaDon HD inner join NHANVIEN NV on HD.MaNV = NV.MaNV
where TrangThai = N'Đã Thanh Toán'
and NgayTao = @ngayHT
exec sp_SoSanhNgay '2021-08-04'
go
CREATE PROCEDURE sp_NVbyHD (@TrangThai nvarchar(30))
AS
select MaHD, hd.MaNV , HoTen, NgayTao, TongTien, MaBan,TrangThai
from HoaDon HD inner join NHANVIEN NV on HD.MaNV = NV.MaNV
where TrangThai like @TrangThai

select MaHD, hd.MaNV , HoTen, NgayTao, TongTien, MaBan,TrangThai
from HoaDon HD inner join NHANVIEN NV on HD.MaNV = NV.MaNV order by NgayTao desc

