/*
 Navicat SQL Server Dump SQL

 Source Server         : tour
 Source Server Type    : SQL Server
 Source Server Version : 16001000 (16.00.1000)
 Source Host           : localhost:1433
 Source Catalog        : tour
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 16001000 (16.00.1000)
 File Encoding         : 65001

 Date: 18/05/2024 04:07:36
*/


-- ----------------------------
-- Table structure for KhuyenMai
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[KhuyenMai]') AND type IN ('U'))
	DROP TABLE [dbo].[KhuyenMai]
GO

CREATE TABLE [dbo].[KhuyenMai] (
  [idKM] varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [TenChuongTrinh] nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [LoaiChuongTrinh] nvarchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [DieuKien] nvarchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [NgayBatDau] date  NOT NULL,
  [NgayKetThuc] date  NOT NULL
)
GO

ALTER TABLE [dbo].[KhuyenMai] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of KhuyenMai
-- ----------------------------
INSERT INTO [dbo].[KhuyenMai] ([idKM], [TenChuongTrinh], [LoaiChuongTrinh], [DieuKien], [NgayBatDau], [NgayKetThuc]) VALUES (N'KM001', N'Giảm giá mùa hè', N'Siêu ưu đãi mùa hè 2024', N'Giảm 20% cho các tour du lịch mùa hè', N'2024-01-01', N'2024-12-31')
GO

INSERT INTO [dbo].[KhuyenMai] ([idKM], [TenChuongTrinh], [LoaiChuongTrinh], [DieuKien], [NgayBatDau], [NgayKetThuc]) VALUES (N'KM002', N'Khuyến mại du lịch 2/9', N'Quà tặng Quốc Khánh', N'Tặng quà cho các tour du lịch trong dịp Quốc Khánh', N'2024-08-25', N'2024-09-25')
GO

INSERT INTO [dbo].[KhuyenMai] ([idKM], [TenChuongTrinh], [LoaiChuongTrinh], [DieuKien], [NgayBatDau], [NgayKetThuc]) VALUES (N'KM003', N'Giảm giá mùa thu', N'Giảm giá giữa năm', N'Giảm 15% cho các tour du lịch mùa thu', N'2024-09-01', N'2024-11-30')
GO


-- ----------------------------
-- Primary Key structure for table KhuyenMai
-- ----------------------------
ALTER TABLE [dbo].[KhuyenMai] ADD CONSTRAINT [PK__KhuyenMa__9DB871736A452FC3] PRIMARY KEY CLUSTERED ([idKM])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

