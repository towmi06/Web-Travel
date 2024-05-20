
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[orders]') AND type IN ('U'))
	DROP TABLE [dbo].[orders]
GO

CREATE TABLE [dbo].[orders] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [customer_id] int  NOT NULL,
  [tour_id] varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [booking_date] date  NOT NULL,
  [total_price] money  NOT NULL,
  [status] varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS DEFAULT 'pending' NULL,
  [created_at] datetime DEFAULT getdate() NULL,
  [updated_at] datetime  NULL,
  [sell_ID] int  NULL
)
GO

ALTER TABLE [dbo].[orders] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of orders
-- ----------------------------
SET IDENTITY_INSERT [dbo].[orders] ON
GO

INSERT INTO [dbo].[orders] ([id], [customer_id], [tour_id], [booking_date], [total_price], [status], [created_at], [updated_at], [sell_ID]) VALUES (N'1', N'31', N'a26', N'2024-05-01', N'3299000.0000', N'completed', N'2024-05-05 18:07:15.123', NULL, N'2')
GO

INSERT INTO [dbo].[orders] ([id], [customer_id], [tour_id], [booking_date], [total_price], [status], [created_at], [updated_at], [sell_ID]) VALUES (N'2', N'32', N'a28', N'2024-06-15', N'5999000.0000', N'pending', N'2024-05-05 18:07:15.123', NULL, N'2')
GO

INSERT INTO [dbo].[orders] ([id], [customer_id], [tour_id], [booking_date], [total_price], [status], [created_at], [updated_at], [sell_ID]) VALUES (N'3', N'33', N'a20', N'2024-04-20', N'1550000.0000', N'canceled', N'2024-05-05 18:07:15.123', NULL, N'1')
GO

INSERT INTO [dbo].[orders] ([id], [customer_id], [tour_id], [booking_date], [total_price], [status], [created_at], [updated_at], [sell_ID]) VALUES (N'4', N'34', N'a11', N'2024-04-01', N'2200000.0000', N'completed', N'2024-05-05 18:07:15.123', NULL, N'2')
GO

INSERT INTO [dbo].[orders] ([id], [customer_id], [tour_id], [booking_date], [total_price], [status], [created_at], [updated_at], [sell_ID]) VALUES (N'5', N'35', N'a19', N'2024-03-10', N'2099000.0000', N'completed', N'2024-05-05 18:07:15.123', NULL, N'1')
GO

INSERT INTO [dbo].[orders] ([id], [customer_id], [tour_id], [booking_date], [total_price], [status], [created_at], [updated_at], [sell_ID]) VALUES (N'7', N'36', N'A59', N'2024-05-20', N'697433.0000', N'completed', N'2024-05-20 02:06:09.983', NULL, N'2')
GO

INSERT INTO [dbo].[orders] ([id], [customer_id], [tour_id], [booking_date], [total_price], [status], [created_at], [updated_at], [sell_ID]) VALUES (N'8', N'37', N'a10', N'2024-04-20', N'32990000.0000', N'completed', N'2024-05-20 02:08:15.010', NULL, N'1')
GO

INSERT INTO [dbo].[orders] ([id], [customer_id], [tour_id], [booking_date], [total_price], [status], [created_at], [updated_at], [sell_ID]) VALUES (N'9', N'38', N'a30', N'2024-03-18', N'7000000.0000', N'completed', N'2024-05-20 02:09:32.997', NULL, N'2')
GO

INSERT INTO [dbo].[orders] ([id], [customer_id], [tour_id], [booking_date], [total_price], [status], [created_at], [updated_at], [sell_ID]) VALUES (N'10', N'39', N'A36', N'2024-05-25', N'6880000.0000', N'completed', N'2024-05-20 02:11:33.460', NULL, N'3')
GO

INSERT INTO [dbo].[orders] ([id], [customer_id], [tour_id], [booking_date], [total_price], [status], [created_at], [updated_at], [sell_ID]) VALUES (N'11', N'33', N'A41', N'2024-05-26', N'7900000.0000', N'pending', N'2024-05-20 02:19:08.080', NULL, N'1')
GO

SET IDENTITY_INSERT [dbo].[orders] OFF
GO


-- ----------------------------
-- Auto increment value for orders
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[orders]', RESEED, 11)
GO


-- ----------------------------
-- Primary Key structure for table orders
-- ----------------------------
ALTER TABLE [dbo].[orders] ADD CONSTRAINT [PK__orders__3213E83F5215BCF5] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Foreign Keys structure for table orders
-- ----------------------------
ALTER TABLE [dbo].[orders] ADD CONSTRAINT [FK__orders__sell_ID__accounts] FOREIGN KEY ([sell_ID]) REFERENCES [dbo].[accounts] ([ID]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [dbo].[orders] ADD CONSTRAINT [FK__orders__customer__5DCAEF64] FOREIGN KEY ([customer_id]) REFERENCES [dbo].[customer] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [dbo].[orders] ADD CONSTRAINT [FK__orders__tour_id__5EBF139D] FOREIGN KEY ([tour_id]) REFERENCES [dbo].[tour] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

