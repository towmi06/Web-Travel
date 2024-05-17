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

 Date: 18/05/2024 04:07:27
*/


-- ----------------------------
-- Table structure for ListTourKM
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[ListTourKM]') AND type IN ('U'))
	DROP TABLE [dbo].[ListTourKM]
GO

CREATE TABLE [dbo].[ListTourKM] (
  [MaKM] varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [MaTour] varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[ListTourKM] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of ListTourKM
-- ----------------------------
INSERT INTO [dbo].[ListTourKM] ([MaKM], [MaTour]) VALUES (N'KM001', N'a13')
GO

INSERT INTO [dbo].[ListTourKM] ([MaKM], [MaTour]) VALUES (N'KM001', N'a30')
GO

INSERT INTO [dbo].[ListTourKM] ([MaKM], [MaTour]) VALUES (N'KM001', N'A36')
GO

INSERT INTO [dbo].[ListTourKM] ([MaKM], [MaTour]) VALUES (N'KM001', N'A38')
GO

INSERT INTO [dbo].[ListTourKM] ([MaKM], [MaTour]) VALUES (N'KM002', N'a25')
GO

INSERT INTO [dbo].[ListTourKM] ([MaKM], [MaTour]) VALUES (N'KM002', N'a26')
GO

INSERT INTO [dbo].[ListTourKM] ([MaKM], [MaTour]) VALUES (N'KM002', N'a28')
GO

INSERT INTO [dbo].[ListTourKM] ([MaKM], [MaTour]) VALUES (N'KM002', N'A57')
GO

INSERT INTO [dbo].[ListTourKM] ([MaKM], [MaTour]) VALUES (N'KM003', N'a32')
GO

INSERT INTO [dbo].[ListTourKM] ([MaKM], [MaTour]) VALUES (N'KM003', N'A49')
GO

INSERT INTO [dbo].[ListTourKM] ([MaKM], [MaTour]) VALUES (N'KM003', N'A50')
GO


-- ----------------------------
-- Primary Key structure for table ListTourKM
-- ----------------------------
ALTER TABLE [dbo].[ListTourKM] ADD CONSTRAINT [PK__ListTour__D3C09A686F82C3A9] PRIMARY KEY CLUSTERED ([MaKM], [MaTour])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Foreign Keys structure for table ListTourKM
-- ----------------------------
ALTER TABLE [dbo].[ListTourKM] ADD CONSTRAINT [FK__ListTourKM__MaKM__3A4CA8FD] FOREIGN KEY ([MaKM]) REFERENCES [dbo].[KhuyenMai] ([idKM]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [dbo].[ListTourKM] ADD CONSTRAINT [FK__ListTourK__MaTou__3B40CD36] FOREIGN KEY ([MaTour]) REFERENCES [dbo].[tour] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

