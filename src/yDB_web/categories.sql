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

 Date: 18/05/2024 04:08:04
*/


-- ----------------------------
-- Table structure for categories
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[categories]') AND type IN ('U'))
	DROP TABLE [dbo].[categories]
GO

CREATE TABLE [dbo].[categories] (
  [id] int  NOT NULL,
  [name] nvarchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [description] nvarchar(max) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [created_at] datetime DEFAULT getdate() NULL,
  [updated_at] datetime  NULL
)
GO

ALTER TABLE [dbo].[categories] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of categories
-- ----------------------------
INSERT INTO [dbo].[categories] ([id], [name], [description], [created_at], [updated_at]) VALUES (N'1', N'Biển', N'Các tour du lịch tới các địa điểm biển của Việt Nam', N'2024-05-06 12:17:09.790', NULL)
GO

INSERT INTO [dbo].[categories] ([id], [name], [description], [created_at], [updated_at]) VALUES (N'2', N'Thiên nhiên', N'Các tour du lịch tại các điểm thiên nhiên đẹp của Việt Nam', N'2024-05-06 12:17:09.790', NULL)
GO

INSERT INTO [dbo].[categories] ([id], [name], [description], [created_at], [updated_at]) VALUES (N'3', N'Tham quan', N'Các tour du lịch tham quan các điểm du lịch nổi tiếng của Việt Nam', N'2024-05-06 12:17:09.790', NULL)
GO


-- ----------------------------
-- Triggers structure for table categories
-- ----------------------------
CREATE TRIGGER [dbo].[update_categories_updated_at]
ON [dbo].[categories]
WITH EXECUTE AS CALLER
FOR UPDATE
AS
BEGIN
    UPDATE categories
    SET updated_at = GETDATE()
    FROM inserted
    WHERE categories.id = inserted.id;
END;
GO


-- ----------------------------
-- Uniques structure for table categories
-- ----------------------------
ALTER TABLE [dbo].[categories] ADD CONSTRAINT [UQ__categori__72E12F1B76575607] UNIQUE NONCLUSTERED ([name] ASC)
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table categories
-- ----------------------------
ALTER TABLE [dbo].[categories] ADD CONSTRAINT [PK__categori__3213E83F1F849F06] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

