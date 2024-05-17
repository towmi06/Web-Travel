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

 Date: 17/05/2024 01:07:09
*/


-- ----------------------------
-- Table structure for payments
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[payments]') AND type IN ('U'))
	DROP TABLE [dbo].[payments]
GO

CREATE TABLE [dbo].[payments] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [order_id] int  NOT NULL,
  [payment_method] varchar(20) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [total] money  NOT NULL,
  [payment_date] date  NOT NULL,
  [status] varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT 'pending' NULL,
  [created_at] datetime DEFAULT getdate() NULL,
  [updated_at] datetime DEFAULT getdate() NULL
)
GO

ALTER TABLE [dbo].[payments] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of payments
-- ----------------------------
SET IDENTITY_INSERT [dbo].[payments] ON
GO

INSERT INTO [dbo].[payments] ([id], [order_id], [payment_method], [total], [payment_date], [status], [created_at], [updated_at]) VALUES (N'1', N'1', N'credit_card', N'3299000.0000', N'2024-05-01', N'paid', N'2024-05-06 00:47:38.663', N'2024-05-06 00:47:38.663')
GO

INSERT INTO [dbo].[payments] ([id], [order_id], [payment_method], [total], [payment_date], [status], [created_at], [updated_at]) VALUES (N'2', N'2', N'bank_transfer', N'5999000.0000', N'2024-06-15', N'pending', N'2024-05-06 00:47:38.663', N'2024-05-06 00:47:38.663')
GO

INSERT INTO [dbo].[payments] ([id], [order_id], [payment_method], [total], [payment_date], [status], [created_at], [updated_at]) VALUES (N'3', N'3', N'cash', N'1550000.0000', N'2024-04-20', N'failed', N'2024-05-06 00:47:38.663', N'2024-05-06 00:47:38.663')
GO

INSERT INTO [dbo].[payments] ([id], [order_id], [payment_method], [total], [payment_date], [status], [created_at], [updated_at]) VALUES (N'4', N'4', N'debit_card', N'2200000.0000', N'2024-04-01', N'paid', N'2024-05-06 00:47:38.663', N'2024-05-06 00:47:38.663')
GO

INSERT INTO [dbo].[payments] ([id], [order_id], [payment_method], [total], [payment_date], [status], [created_at], [updated_at]) VALUES (N'5', N'5', N'credit_card', N'2099000.0000', N'2024-03-10', N'pending', N'2024-05-06 00:47:38.663', N'2024-05-06 00:47:38.663')
GO

SET IDENTITY_INSERT [dbo].[payments] OFF
GO


-- ----------------------------
-- Auto increment value for payments
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[payments]', RESEED, 5)
GO


-- ----------------------------
-- Checks structure for table payments
-- ----------------------------
ALTER TABLE [dbo].[payments] ADD CONSTRAINT [CK__payments__paymen__619B8048] CHECK ([payment_method]='cash' OR [payment_method]='bank_transfer' OR [payment_method]='debit_card' OR [payment_method]='credit_card')
GO


-- ----------------------------
-- Primary Key structure for table payments
-- ----------------------------
ALTER TABLE [dbo].[payments] ADD CONSTRAINT [PK__payments__3213E83FE927F946] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Foreign Keys structure for table payments
-- ----------------------------
ALTER TABLE [dbo].[payments] ADD CONSTRAINT [FK__payments__order___656C112C] FOREIGN KEY ([order_id]) REFERENCES [dbo].[orders] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

