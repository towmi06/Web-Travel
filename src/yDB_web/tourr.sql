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

 Date: 15/05/2024 19:47:55
*/


-- ----------------------------
-- Table structure for tour
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[tour]') AND type IN ('U'))
	DROP TABLE [dbo].[tour]
GO

CREATE TABLE [dbo].[tour] (
  [id] varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [tourName] nvarchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [image] varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [date] nvarchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [price] money  NOT NULL,
  [journeys] nvarchar(max) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [description1] nvarchar(max) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [cateID] int  NOT NULL,
  [sell_ID] int  NOT NULL
)
GO

ALTER TABLE [dbo].[tour] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of tour
-- ----------------------------
INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'A10', N'Sóc Trăng', N'a10.jpg', N'3 ngày 2 đêm', N'3299000.0000', N'Cà Mau - Nam Căn - Đất Mũi - Bạc Liêu - Sóc Trăng', N'**NGÀY 1 | TP. HCM – CÀ MAU**

**Tối (21H00):** Hướng Dẫn Viên đón khách tại điểm hẹn – Khởi hành đi Cà Mau.

**NGÀY 2 | CÀ MAU – NĂM CĂN – ĐẤT MŨI – BẠC LIÊU (Ăn sáng, trưa, chiều)**

**Sáng:** Dùng bữa sáng tại nhà hàng.
- Khởi hành về Năm Căn – thị trấn Cực Nam giàu có nguồn tài nguyên thủy hải sản.
- Tham quan mốc tọa độ quốc gia, Tượng đài Anh hùng - Liệt sỹ Phan Ngọc Hiển.
- Panô biểu tượng mũi Cà Mau.
- Lên Vọng Lâm Đài cao trên 20m để ngắm nhìn tòan cảnh Mũi Cà Mau.
- Tham quan mô hình thu nhỏ Làng Rừng kháng chiến.
  
**Trưa:** Dùng cơm trưa. Đoàn trở về thị trấn Năm Căn, đến thăm, mua sắm tại chợ Năm Căn.
  
**Chiều:** Sau khi dùng cơm chiều du khách có thời gian tự do nghỉ ngơi và khám phá thành phố về đêm. Nghỉ đêm khách sạn tại Cà Mau.

**NGÀY 3 | CÀ MAU – BẠC LIÊU – SÓC TRĂNG – TP.HCM (Ăn sáng, trưa)**

**Sáng:** Dùng bữa sáng tại nhà hàng.
- Đoàn đến viếng thăm Nhà thờ Tắc Sậy (Nhà thờ Cha Trương Bửu Diệp) ở Bạc Liêu.
- Tham quan Nhà công tử Bạc Liêu và Khu lưu niệm nhạc sĩ Cao Văn Lầu.
- Đến Sóc Trăng, viếng Chùa Mã Tộc (Chùa Dơi) và chùa Đất Sét (Bửu Sơn Tự).
  
**Trưa:** Dùng cơm trưa. Đoàn khởi hành về TP.HCM, trên đường chiêm ngưỡng vẻ đẹp cầu Cần Thơ.
  
Về đến TP.HCM, đưa Quý khách về điểm đón ban đầu. Chia tay Quý khách và hẹn gặp lại.', N'3', N'1')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'a11', N'Bình Dương', N'a11.jpg', N'2 ngày 1 dêm', N'2200000.0000', N'TP.HCM - Nhà thờ Chánh tòa Phú Cường - Chùa Hội Khánh - Chùa Tây Tạng - Làng sơn mài Tương Bình Hiệp . Công viên Thành phố mới Bình Dương - Khu du lịch Đại Nam - Hồ Bình An - Sài Gòn', N'**Ngày 1: **
- Sáng sớm, xuất phát từ Sài Gòn.
- Đến Nhà thờ Chánh tòa Phú Cường để chiêm ngưỡng kiến trúc độc đáo và tinh tế.
- Tiếp tục hành trình đến Chùa Hội Khánh để tìm hiểu về đời sống tâm linh và văn hóa Phật giáo.
- Ghé thăm Chùa Tây Tạng để trải nghiệm không khí thanh tịnh và tôn nghiêm.
- Chiều, thăm Làng sơn mài Tương Bình Hiệp để hiểu về nghề truyền thống của người dân địa phương.
- Tối, trở về Sài Gòn nghỉ ngơi và chuẩn bị cho ngày tiếp theo.
Ngày 2:
- Sáng sớm, khám phá Công viên Thành phố mới Bình Dương, nơi mang lại không gian xanh mát và thoáng đãng.
- Tiếp tục tham quan Khu du lịch Đại Nam để khám phá văn hóa và lịch sử đặc sắc của vùng đất này.
- Trưa, dừng chân tại Hồ Bình An để thư giãn và thưởng ngoạn cảnh đẹp.
- Chiều, trở về Sài Gòn và kết thúc chuyến đi.', N'3', N'2')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'a13', N'Hà Tiên', N'a13.jpg', N'3 ngày 3 đêm', N'5600000.0000', N'Hà Nội - Cần Thơ - Rạch Giá - Nam Du- Cần Thơ - Hà Nội
', N'"NGÀY 01 | HÀ NỘI – CẦN THƠ  – RẠCH GIÁ (ĂN TRƯA/TỐI)
Sáng: Xe và hướng dẫn viên (HDV) Vietnam Booking đón du khách tại điểm hẹn Công viên Thống Nhất. Đoàn khởi hành đi sân bay Nội Bài đáp chuyến bay đi Cần Thơ, bắt đầu hành trình tour du lịch Nam Du 4 ngày 3 đêm giá rẻ.

Trưa: Đến sân bay Cần Thơ, xe và HDV địa phương đón đoàn đi ăn trưa tại nhà hàng.

Chiều: Xe khởi hành đi Rạch Giá. Đến nơi, đoàn nhận phòng khách sạn nghỉ ngơi.

Tối: Quý khách ăn tối, tự do vui chơi tại khu lấn biển nổi tiếng của du lịch Miền Tây. Nghỉ đêm tại khách sạn ở Rạch Giá.

NGÀY 02 | RẠCH GIÁ – ĐẢO NAM DU (ĂN SÁNG/TRƯA/TỐI)
Sáng: Quý khách ăn sáng tại khách sạn, sau đó làm thủ tục trả phòng.

Đoàn lên xe di chuyển ra bến tàu cao tốc Rạch Giá làm thủ tục đi Nam Du. Quý khách được chiêm ngưỡng Hòn Tre, Hòn Sơn.

Sau 2h30'' tàu cập cảng Nam Du, đoàn về khách sạn/nhà nghỉ trên đảo nhận phòng nghỉ ngơi.

Trưa: Đoàn ăn trưa tại nhà hàng địa phương trên đảo.

Chiều: Quý khách lên tàu tham gia hành trình như một ngư dân thực thụ - câu cá, bắt nhum, ngắm san hô tại Hòn Mấu. 

Hòn Mấu: Một trong những hòn sở hữu những bãi biển rất đẹp, cát trắng mịn, nước biển trong xanh. Ở đây có hai bãi biển nổi tiếng đó là Bãi Chướng và Bãi Đá Đen.
Bãi Chướng: Sở hữu phong cảnh đẹp, nhiều du khách đến đây tắm biển và chụp hình.
Bãi Đá Đen: Quý khách tha hồ bắt Nhum, sau khi bắt xong quý khách có thể đem về nhà nghỉ để nhờ người chế biến hoặc quý khách tự chế biến.
Dinh Ông Miếu – Miếu thờ ông Nam Hải: Là cơ sở tín ngưỡng của người dân nơi đây.
Tham quan làng cá bè Hòn Ngang, trung tâm hành chính của đảo.
Tàu dừng chân cho Quý khách tự do lặn ngắm san hô nhiều màu sắc tại Hòn Bờ Đập.
Thưởng thức món cháo Nhum đặc sản nóng hổi ngay trên tàu.
Tàu đưa đoàn về Hòn Lớn (Hòn Củ Tron) trên đường thưởng thức hải sản mà mình câu được.
Tàu sẽ đưa quý khách về lại nhà nghỉ, cùng thưởng thức bữa tiệc BBQ hải sản.

Tối: Đoàn tự do khám phá đảo Củ Tron về đêm.

Quý khách nghỉ đêm tại khách sạn/ nhà nghỉ trên đảo.

NGÀY 03 | KHÁM PHÁ QUẦN ĐẢO NAM DU (ĂN SÁNG/TRƯA/TỐI)
Sáng: Du khách dùng điểm tâm sáng với các món ăn do người dân chế biến.

Đoàn tiếp tục chương trình tour du lịch Nam Du khám phá hòn Củ Tron bằng xe máy:

Thắp nhang, cầu phúc tại Miếu bà Chúa Xứ trên đảo.
Khám phá Bãi Đá Sỏi đầy sỏi rất đẹp thu hút rất nhiều bạn trẻ đến đây chụp hình.
Đài Rada: Ngắm toàn cảnh quần đảo Nam Du.
Dốc Ông Tình: Quý khách ngắm toàn cảnh Bãi Ngự từ trên cao.
Bãi Ngự, giếng Ngự: Tham quan nơi một thời vua Gia Long từng nương náu.
Bãi Mến: Tự do tắm biển chụp hình tại bãi biển đẹp nhất Nam Du.
Chụp hình hướng Ba Hòn thơ mộng.
Tham quan đền thờ Dinh Ông Nam Hải.
Trưa: Quý khách làm thủ tục trả phòng, ăn trưa tại nhà hàng địa phương.

Tàu đưa quý khách trở về Rạch Giá trên chuyến 11h00.

13h30 về đến Cảng Rạch Giá, Quý khách lên xe khởi hành đi du lịch Cần Thơ.

Chiều: Đến thành phố Cần Thơ, quý khách về nhận phòng khách sạn nghỉ ngơi.

Tối: Đoàn tập trung lên xe đi ăn tối tại Du thuyền Cần Thơ. Quý khách vừa thưởng thức ẩm tực miền Tây, vừa nghe nhạc Bolero hấp dẫn.

Sau bữa tối đoàn tự do khám phá thành phố Cần Thơ. Nghỉ đêm tại khách sạn Cần Thơ.

NGÀY 04 | CẦN THƠ – HÀ NỘI (ĂN SÁNG/TRƯA)
Sáng: Quý khách dậy sớm, xe đưa đoàn ra bến thuyền đi:

Chợ Nổi Cái Răng: Một nét đặc trưng của sông nước miền Tây, quý khách thăm miệt vườn thưởng thức trái cây và lựa chọn những loại hoa quả ngon nhất để mua về làm quà. Ghé lò hủ tiếu của người dân, cùng tìm hiểu công đoạn làm Hủ tiếu của đồng bào Nam Bộ.
Đoàn quay lại trung tâm thành phố trả phòng khách sạn.

Xe và HDV đón khách đi tham quan: 

Thiền Viện Trúc Lâm Phương Nam: Được coi là Thiền Viện lớn nhất của vùng Tây Nam Bộ. Quý khách lễ Phật, vãn cảnh.
Nhà cổ Bình Thủy Cần Thơ: Ngôi nhà được xây dựng từ năm 1870 thuộc sở hữu của nhà họ Dương. Đây là một trong số ít những căn nhà cổ còn nguyên vẹn cho đến ngày nay, có giá trị lớn trong việc tìm hiểu văn hóa của người dân đồng bằng sông Cửu Long thời kì giao thoa giữa hai thế kỉ.
Trưa: Xe đưa đoàn đi ăn trưa tại nhà hàng.

12h00 xe đưa đoàn ra sân bay Cần Thơ, đáp chuyến bay về Hà Nội

Khoảng 15h55 hoặc16h55 Đoàn về đến Hà Nội, kết thúc tour Nam Du 4 ngày 3 đêm hấp dẫn. HDV chia tay và hẹn gặp lại du khách trong các tour du lịch giá rẻ tiếp theo."
', N'1', N'2')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'a16', N'Đồng Tháp', N'a16.jpg', N'2 ngày 1 dêm', N'2099000.0000', N'Đồng Tháp - KDL Gáo Giồng - Vườn Quýt Hồng Lai Vung - Làng Hoa Sa Đéc', N'NGÀY 1 | TP. HCM – ĐỒNG THÁP – KDL GÁO GIỒNG (Ăn sáng, trưa, chiều)

Sáng:
- 6h00: Đoàn tập trung tại điểm hẹn.
- Khởi hành đi Mỹ Tho.
- Dùng bữa sáng tại Trung Lương.

Trưa:
- Tiếp tục hành trình đến thành phố Cao Lãnh, Đồng Tháp.
- Tham quan khu du lịch sinh thái Gáo Giồng.
- Dùng cơm trưa, thưởng thức đặc sản miền đồng bằng sông Cửu Long.

Chiều:
- Đến khu du lịch sinh thái Mỹ Phước Thành, check-in và thư giãn.
- Dùng cơm chiều.
- Tự do khám phá Cao Lãnh về đêm.
- Nghỉ đêm tại khách sạn Đồng Tháp.

NGÀY 2 | ĐỒNG THÁP – LÀNG HOA SA ĐÉC – VƯỜN QUÝT HỒNG LAI VUNG (Ăn sáng, trưa)

Sáng:
- Dùng bữa sáng tại khách sạn.
- Tham quan Làng hoa Kiểng Tân Quy Đông - Làng hoa Sa Đéc.
- Ghé thăm Vườn Hồng Tư Tôn.

Trưa:
- Dùng cơm trưa với các món ăn đặc sản miền Tây.
- Tiếp tục hành trình đến Vườn Quýt Hồng Lai Vung, thưởng thức quýt hồng và các sản phẩm từ quýt.

Chiều:
- Tham quan Chùa Phật Ngọc Xá Lợi tại Vĩnh Long.
- Khởi hành về TP.HCM, dừng chân mua đặc sản địa phương.
- Kết thúc chuyến đi và chia tay đoàn.', N'2', N'3')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'a17', N'Đồng Nai', N'a17.jpg', N'2 ngày 1 dêm', N'1950000.0000', N'TP.HCM - ĐỒNG NAI - VQG NAM CÁT TIÊN- KDL SUỐI MƠ - TP.HCM', N'Ngày 1. TP.HCM - ĐỒNG NAI - VQG NAM CÁT TIÊN
---
**Sáng:**
- Quý khách tập trung tại địa chỉ: 82 - 84 Calmette, phường Nguyễn Thái Bình, quận 1.
- Điểm tâm sáng tại nhà hàng.

**Trưa:**
- Dùng cơm trưa tại nhà hàng khu resort. Nhận phòng nghỉ ngơi.

**Chiều:**
- Xe đưa Quý khách đến bến thuyền qua khúc sông Đạ Huoai dài độ khoảng 100m đến Vườn Quốc Gia Cát Tiên.
- Tham quan các điểm đi ngang trên đường: nhà bè trên sông La Ngà, quần thể đá Ba Chồng Định Quán, núi lửa 117, rừng cây Giá Tỵ…
- Tham quan Vườn Quốc Gia Nam Cát Tiên.
- Dùng cơm tối tại nhà hàng.

**Buổi tối:**
- Tham gia tour xem thú đêm bằng xe Jeep (chi phí tự túc).
- Quý khách quay về trung tâm vườn.
- Nghỉ đêm tại Nam Cát Tiên.

Ngày 2. VQG NAM CÁT TIÊN - KDL SUỐI MƠ - TP.HCM
---
**Sáng:**
- Dùng bữa sáng tại nhà hàng và tận hưởng không khí trong lành tại vườn Nam Cát Tiên.
- Trả phòng và di chuyển KDL Suối Mơ.

**Trưa:**
- Ăn trưa tại nhà hàng Công viên Suối Mơ.

**Chiều:**
- Tắm tại Hồ Bơi Thiên Nhiên của KDL Suối Mơ.
- Khởi hành về TP.HCM.

**Kết thúc chương trình:** 
- Về đến TP.HCM. Trả khách tại điểm hẹn ban đầu.
- HDV du lịch Bến Thành chia tay và hẹn gặp lại Quý khách trong những hành trình sau.', N'2', N'1')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'a19', N'Bình Phước', N'a19.jpg', N'2 ngày 1 dêm', N'2099000.0000', N'BÙ GIA MẬP – BÀ RÁ – THÁC MƠ – MỸ LỆ', N'**Ngày 1: TPHCM – Bù Gia Mập (Ăn Sáng – Trưa – Tối) **
- 05h00: Xe và HDV du lịch Xanh đón khách tại điểm hẹn khởi hành đi Bình Phước.
- 06h30: Dừng chân dùng bữa sáng tại BD. Tiếp tục hành trình, thưởng ngoạn thắng cảnh đẹp trên đường đi.
- 10h00: Đến vườn quốc gia Bù Gia Mập, khám phá Trạm 9 và khu vực Giếng Trời. Tham gia chương trình giăng lưới bắt cá suối.
- 12h00: Dùng bữa trưa dân dã với các món ăn đặc sản.
- 13h30: Di chuyển đến khu vực thác Đăk Bô, ngắm nhìn sự hung vĩ của thác nước.
- 14h30: Khởi hành trở về khu bảo tồn VQG Bù Gia Mập để nhận phòng nghỉ ngơi.
- 18h00: Dùng bữa tối với thực đơn dân dã phong phú tại nhà hàng khu vực VQG. Sau đó, nghỉ ngơi tại nhà nghỉ của VQG.
**Ngày 2: VQG Bù Gia Mập – Núi Bà Rá – Thác Mơ - TP. Hồ Chí Minh**
(Ăn Sáng - Trưa)
- 7h00: Ăn sáng tại nhà hàng khu vực.
- 8h00: Khởi hành đi khu du lịch Núi Bà Rá. Tham quan Thác Mơ.
- 10h00: Thăm quan Thác Mơ, nơi cung cấp nguồn điện cho vùng Đông Nam Bộ.
- 11h30: Khởi hành đến KDL Mỹ Lệ, dùng cơm trưa và tham quan khu trung tâm và vườn trái cây Nam Bộ.
- 15h00: Quay về TP. Hồ Chí Minh, dừng chân mua sắm quà về cho người thân và gia đình.
- 18h30: Về đến TP. HCM, kết thúc chương trình. HDV thay mặt công ty gửi lời cảm ơn và hẹn gặp lại.', N'3', N'1')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'a20', N'Bến Tre', N'a20.jpg', N'2 ngày 1 dêm', N'1500000.0000', N'Sài Gòn - Bến Tre', N'**Ngày 1: Thành phố Hồ Chí Minh – Mỹ Tho – Bến Tre (Ăn trưa) **
07h00: Xe và HDV đón quý khách tại điểm hẹn (đối diện công viên 23/9, quận 1) và khởi hành đi Tiền Giang, bắt đầu chuyến hành trình khám phá miền Tây trong 2 ngày 1 đêm.
Trên đường đi, quý khách sẽ dừng chân tại trạm dừng chân Mekong Restop để thưởng thức điểm tâm sáng với đặc sản ""Hủ Tiếu Mỹ Tho"" (Chi phí tự túc).
09h00: Đến chùa Vĩnh Tràng ở Tiền Giang, một ngôi chùa cổ hơn 100 năm tuổi mang vẻ đẹp hài hoà giữa kiến trúc Đông - Tây. Quý khách sẽ có cơ hội tham quan và tìm hiểu về nét văn hóa tâm linh của địa phương.
Tiếp theo, quý khách sẽ đến bến tàu Mỹ Tho và lên thuyền để tiếp tục hành trình trên sông Tiền. Trên đường đi, quý khách sẽ được ngắm cảnh 4 cù lao Long, Lân, Qui, Phụng và thăm các điểm du lịch như Cồn Thới Sơn.
Trong chuyến tham quan, quý khách sẽ trải nghiệm cuộc sống dân dã và tham gia các hoạt động như thưởng thức trà mật ong, làm kẹo dừa truyền thống, và trải nghiệm cảm giác đi xe ngựa truyền thống.
Trưa: Dùng cơm trưa tại nhà hàng Cồn Phụng với các món đặc sản địa phương.
Chiều: Sau khi tham quan xong Cồn Phụng, quý khách sẽ trở về TP. Cần Thơ và nhận phòng tại khách sạn. Buổi chiều tự do để quý khách thư giãn hoặc khám phá thành phố.
Tối: Dùng cơm tối tại nhà hàng với các món đặc sản địa phương. Sau đó, quý khách có thể tự do dạo chơi tại bến Ninh Kiều và thưởng thức ẩm thực đường phố. (Chi phí tự túc).
**Ngày 2: Chợ nổi Cái Răng – Khu du lịch Mỹ Khánh – TP. Hồ Chí Minh (Ăn Sáng, trưa, chiều) **
Sáng: Dùng điểm tâm sáng và làm thủ tục trả phòng khách sạn.
7h00: Xe và HDV đưa quý khách tới bến Ninh Kiều để lên thuyền du lịch tham quan chợ nổi Cái Răng – một trong những chợ nổi lớn nhất và sầm uất nhất miền Tây. Tại đây, quý khách sẽ có cơ hội mua sắm đặc sản và thưởng thức ẩm thực đặc trưng của vùng sông nước.
Tiếp theo, quý khách sẽ thăm quan Khu du lịch Mỹ Khánh, nơi có vườn trái cây, vườn hoa Mỹ Khánh, động chim yến, hồ cá sấu, và vườn thú hoang dã.
12h00: Dùng cơm trưa tại nhà hàng KDL Mỹ Khánh.
Chiều: Sau khi trải nghiệm xong tại Mỹ Khánh, quý khách sẽ tham quan Coffee – phim trường Căn nhà màu tím Cần Thơ và trải nghiệm những hoạt động giải trí thú vị tại đây (vé tự túc).
14h30: Xe và HDV đưa quý khách trở về TP. Hồ Chí Minh.
18h00: Đến TP. HCM. Kết thúc chuyến hành trình tham quan. HDV thay mặt công ty chia tay và hẹn gặp lại quý khách trong những chuyến đi sau', N'3', N'1')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'a25', N'Đồng Tháp', N'a25.jpg', N'2 ngày 1 dêm', N'2099000.0000', N'Đồng Tháp - KDL Gáo Giồng - Vườn Quýt Hồng Lai Vung - Làng Hoa Sa Đéc', N'**NGÀY 1 | TP.HCM – ĐỒNG THÁP – KDL GÁO GIỒNG (Ăn sáng, trưa, chiều)**

Sáng: 6h00, xe và Hướng Dẫn Viên Công Ty Du Lịch Việt đón Quý khách tại điểm hẹn và khởi hành đi Mỹ Tho. Quý khách dùng bữa sáng tại Trung Lương. Tiếp tục đến thành phố Cao Lãnh thuộc tỉnh Đồng Tháp.

Trưa: Dùng cơm trưa và thưởng thức những món ăn miệt đồng theo mùa tại khu du lịch sinh thái Gáo Giồng.

Chiều: Đoàn đến khu du lịch sinh thái Mỹ Phước Thành. Check-in và dùng cơm chiều. Nghỉ đêm tại khách sạn tại Đồng Tháp.

Tối: Quý khách tự do khám phá những nét đặc trưng của thành phố Cao Lãnh về đêm và thưởng thức đặc sản Đồng Tháp.

**NGÀY 2 | ĐỒNG THÁP – LÀNG HOA SA ĐÉC – VƯỜN QUÝT HỒNG LAI VUNG (Ăn sáng, trưa)**

Sáng: Dùng bữa sáng và tiếp tục hành trình đến Làng hoa Kiểng Tân Quy Đông - Làng hoa Sa Đéc.

Trưa: Quý khách dùng cơm trưa với các món ăn đặc sản miền Tây. Tiếp tục đến Vườn Quýt Hồng Lai Vung, thưởng thức quýt hồng và các sản phẩm từ quýt.

**Chiều:** Tham quan Chùa Phật Ngọc Xá Lợi tại Vĩnh Long. Đoàn khởi hành về TP.HCM, dừng chân mua đặc sản địa phương trên đường về. Kết thúc chuyến đi và chia tay đoàn.

Lịch trình trên sẽ giúp khách hàng dễ dàng theo dõi và hiểu rõ hơn về các hoạt động và địa điểm tham quan trong hành trình du lịch.', N'3', N'3')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'a26', N'An Giang', N'a26.jpg', N'3 ngày 2 đêm', N'329000.0000', N'Mỹ Tho - Cần Thơ - Châu Đốc - Rừng Tràm Trà Sư', N'**NGÀY 1 | TP. HCM – CHÂU ĐỐC (Ăn sáng, trưa, chiều)**
Sáng: Xuất phát từ TP. HCM, dừng chân ở Trung Lương để dùng bữa sáng, tiếp tục hành trình đến Châu Đốc.
Trưa: Thưởng thức cơm trưa và di chuyển tham quan Rừng Tràm Trà Sư, nơi có cảnh quan thiên nhiên tuyệt vời.
Chiều: Tham quan Núi Cấm và khám phá các danh lam thắng cảnh tại đây trước khi trở về và nghỉ đêm tại Châu Đốc.
**NGÀY 2 | CHÂU ĐỐC – CẦN THƠ (Ăn sáng, trưa, chiều)**
Sáng: Viếng thăm các điểm du lịch tâm linh như Tây An Cổ Tự, Lăng Thoại Ngọc Hầu và Miếu Bà Chúa Xứ Núi Sam.
Trưa: Dùng cơm trưa trước khi di chuyển đến Cần Thơ và viếng Thiền Viện Trúc Lâm Phương Nam.
Chiều: Tiếp tục tham quan các điểm du lịch ở Cần Thơ trước khi dùng cơm chiều và nghỉ đêm tại đây.
**NGÀY 3 | CẦN THƠ – TIỀN GIANG – TP. HCM (Ăn sáng, trưa)**
Sáng: Thăm chợ nổi Cái Răng trước khi quay lại khách sạn dùng bữa sáng. Tiếp tục hành trình đến Tiền Giang và thăm chùa Vĩnh Tràng.
Trưa: Dùng cơm trưa trước khi khởi hành về TP. HCM, dừng chân thăm các điểm du lịch ở Bến Tre và trải nghiệm các hoạt động như tham quan lò kẹo dừa và Cồn Phụng.
Chiều: Kết thúc chuyến hành trình, chia tay và hẹn gặp lại.
Lịch trình này cung cấp một trải nghiệm đa dạng về văn hóa và thiên nhiên của miền Tây Nam Bộ, từ rừng tràm đến núi non và các di tích lịch sử, đồng thời cũng cho phép thưởng thức ẩm thực địa phương độc đáo.', N'2', N'2')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'a28', N'Bạc Liêu', N'a28.jpg', N'4 ngày 3 đêm', N'5999000.0000', N'Mỹ Tho - Cần Thơ - Cà Mau - Năm Căn - Đất Mũi - Bạc Liêu - Sóc Trăng', N'1. **Cần Thơ**:
   - **Muong Thanh Luxury Can Tho Hotel**: Nằm ở trung tâm thành phố Cần Thơ, gần các điểm tham quan như chợ nổi Cái Răng và Thiền Viện Trúc Lâm Phương Nam. Đây là một lựa chọn lý tưởng cho sự tiện nghi và dịch vụ chất lượng.
2. **Cà Mau**:
   - **Hotel Sao Mai**: Nằm ở trung tâm thành phố Cà Mau, gần Nhà thờ Tắc Sậy và điểm xuất phát để tham quan Mũi Cà Mau. Khách sạn này cung cấp các tiện nghi cơ bản và phù hợp cho một đêm nghỉ thoải mái.
3. **Bạc Liêu**:
   - **Bạc Liêu Hotel**: Nằm ở trung tâm thành phố Bạc Liêu, gần Nhà công tử Bạc Liêu và Khu lưu niệm nhạc sĩ Cao Văn Lầu. Đây là một lựa chọn phù hợp cho những ai muốn khám phá các điểm tham quan lịch sử và văn hóa của thành phố.
Hãy đặt trước phòng khách sạn của bạn để đảm bảo bạn có một chỗ ở thoải mái và tiện lợi trong suốt chuyến du lịch của mình!', N'3', N'4')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'a30', N'Hậu Giang', N'a30.jpg', N'6 ngày 5 đêm', N'7000000.0000', N'TP.HCM - Miền Tây', N'NGÀY 01: TP. HỒ CHÍ MINH - LONG AN - TIỀN GIANG - VĨNH LONG (Ăn sáng, trưa, chiều)
- Thăm làng cổ Phước Lộc Thọ và làng nổi Tân Lập ở Long An.
- Viếng Thiền viện Trúc Lâm Chánh Giác ở Tiền Giang.
- Tham quan Văn Thành Miếu ở Vĩnh Long.
- Tham gia chương trình tái hiện lại cảnh đốt đuốc đi xem hát bội tại Đình làng của người dân Vĩnh Long ngày xưa. 
NGÀY 02: VĨNH LONG - HẬU GIANG - CẦN THƠ - CỒN SƠN (Ăn sáng, trưa, chiều)
- Thăm lò gạch Mang Thích và khu tưởng niệm Phạm Hùng.
- Đi thuyền đến cồn Sơn ở Cần Thơ, trải nghiệm cuộc sống bình dị của cư dân miền sông nước Nam Bộ.
- Tham quan bè cá, khu vườn cây ăn trái và thưởng thức các loại trái cây.
- Vui chơi tại công viên giải trí Kittyd & Minnied ở Hậu Giang.
NGÀY 03: CẦN THƠ - BẠC LIÊU (Ăn sáng, trưa, chiều)
- Thăm chợ nổi Cái Răng ở Cần Thơ.
- Ghé thăm vườn dâu Thiên Ân.
- Tham quan khu lưu niệm nhạc sỹ Cao Văn Lầu ở Bạc Liêu.
NGÀY 04: BẠC LIÊU - CÀ MAU - U MINH HẠ (Ăn sáng, trưa, chiều)
- Thăm khu dinh thự Công tử Bạc Liêu.
- Đến U Minh Hạ ở Cà Mau, trải nghiệm cuộc sống của người dân ở rừng U Minh.
- Tham quan chùa Monivongsa Bopharam.
NGÀY 05: CÀ MAU - ĐẤT MŨI - SÓC TRĂNG (Ăn sáng, trưa, chiều)
- Thăm Mũi Cà Mau.
- Viếng nhà thờ Tắc Sậy và nơi an nghỉ của Linh mục Trương Bửu Diệp ở Sóc Trăng.
NGÀY 06: SÓC TRĂNG - HỒ CHÍ MINH (Ăn sáng, trưa)
- Thăm 3 ngôi chùa đa dạng về văn hóa tôn giáo ở Sóc Trăng.
- Tham quan quy trình sản xuất bánh pía và mua đặc sản tại Cơ sở sản xuất bánh Pía.
Lưu ý: Chương trình có thể thay đổi tùy theo điều kiện thực tế và yêu cầu của đoàn.', N'3', N'2')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'a32', N'Long An', N'a32.jpg', N'1 ngày 0 dêm', N'3000000.0000', N'Tour Gia đình cho 8 khách: Công viên Kỳ Quan Thế Giới - Làng Nổi Tân Lập - Con đường xuyên rừng tràm đẹp nhất Việt Nam', N'**NGÀY 1 | Công Viên Kỳ Quan Thế Giới - Làng Nổi Tân Lập - Con Đường Xuyên Rừng Tràm Đẹp Nhất Việt Nam

**Sáng:**
- Xe và Hướng Dẫn Viên Công Ty Du Lịch Việt đón Quý khách tại điểm hẹn.
- Khởi hành đi Long An, trên đường nghe thuyết minh về những địa danh nổi tiếng của vùng đất Long An như rượu đế Gò Đen, gạo nàng thơm Chợ Đào, Bến Lức, …
- Dừng chân dùng bữa sáng (chi phí tự túc).

**Trưa:**
- Quý khách dùng bữa trưa với các đặc sản độc đáo của vùng nước nổi.
- Đoàn ngồi xuồng ba lá len lỏi vào rừng tràm, tận hưởng cảm giác lênh đênh trên sông nước, thưởng ngoạn không khí yên bình nơi đây.

**Buổi chiều:**
- Ghé Công Viên Kỳ Quan Thế Giới – điểm “check-in vàng” với các công trình kiến trúc nổi tiếng thế giới thu nhỏ tinh xảo.
- Khởi hành về TP.HCM và kết thúc chuyến đi.

Chia tay đoàn và hẹn gặp lại Quý khách.', N'3', N'3')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'A36', N'Quảng Ninh', N'A36.jpg', N'3 ngày 2 đêm', N'6880000.0000', N'Tour Quang Ninh', N'* NGÀY 1: HÀ NỘI - VỊNH HẠ LONG ( ĂN TRƯA, TỐI)
08h00-08h30: Xe và hướng dẫn viên đón Quý khách tại các khách sạn khu vực trung tâm phố Cổ và Nhà hát lớn khởi hành cho chuyến đi thăm Vịnh Hạ Long với hành trình tuyến 2 hấp dẫn giống với hành trình của những con tàu ngủ đêm trên Vịnh.

11h30-12h00: Đến cảng tàu Hạ Long, Đoàn tập trung tại nhà chờ theo sự hướng dẫn của hướng dẫn viên đợi mua vé và phát vé cho Quý khách để lên tàu bắt đầu hành trình khám phá Vịnh. Tàu sẽ đi qua rất nhiều các hòn đảo lớn nhỏ với nhiều hình dáng khác nhau có những tên gọi đặc biệt như: Hòn Gà Chọi, hòn Chó Đá… Quý khách thưởng thức bữa trưa trên tàu.
14h00: Đến đảo Bồ Hòn. Quý khách thăm quan Hang Sửng Sốt - Một trong những hang động đẹp nhất vịnh Hạ Long. Tiếp theo, Quý khách sẽ chèo Kayak hoặc đi thuyền nan thăm Hang Luồn (chi phí chèo kayak hoặc ngồi thuyền nan chưa bao gồm). Sau 30 phút chèo Kayak, Quý khách lên tàu để đến với đảo Titop.
Quý khách có thể tắm biển tại bãi tắm Titop với bãi cát trắng, hoặc thử trekking leo lên đỉnh núi Titop ngắm nhìn toàn cảnh Vịnh Hạ Long.
16h30: Quý khách quay trở lại tàu. Tàu sẽ di chuyển đưa Quý khách về lại Cảng. Quý khách có thể tắm nắng trên boong tàu, nghe nhạc và thư giãn, hòa mình vào thiên nhiên của Vịnh Hạ Long. 

17h30: Tàu cập cảng. Xe ô tô đón Quý khách đưa về khách sạn nhận phòng, nghỉ ngơi.

19h00: Ăn tối. Buổi tối tự do vui chơi khám phá Chợ Đêm, Phố ẩm thực... Nghỉ đêm tại Hạ Long.

NGÀY 2: HẠ LONG FREE DAY ( ĂN SÁNG, TRƯA, TỐI)
Cả ngày Quý khách tự do vui chơi. Các bữa ăn sáng, trưa, tối được sắp xếp bố trí tại khách sạn.

Gợi ý các điểm thăm quan: 

Sáng: Quý khách tự do tắm biển Bãi Cháy.
NGÀY 3: HẠ LONG - YÊN TỬ - HÀ NỘI ( ĂN SÁNG, TRƯA)
06h30: Quý khách ăn sáng tại khách sạn. Sau đó trả phòng.

07h00-07h15: Xe ô tô đón Quý khách đi Yên Tử. Tới Yên Tử,hướng dẫn viên đưa quý khách quý khách đi chiêm ngưỡng cảnh rừng đại ngàn Yên Tử. Quý khách thăm quan Tháp tổ (nơi lưu giữ xá lợi của Phật Hoàng Trần Nhân Tông), chùa Hoa Yên, chùa Một Mái. Quý khách đến nhà ga Cáp treo để đi hệ  thống cáp thứ 2. Chiêm bái Tượng An Kỳ Sinh, bia Phật... Tiếp tục chinh phục đỉnh chùa Đồng (nằm ở độ cao 1068m so với mặt nước biển), lễ Phật và thưởng ngoạn cảnh đại ngàn Yên Tử từ trên đỉnh núi.
11h30: Ăn trưa tại nhà hàng. Sau bữa trưa, Quý khách lên xe về Hà Nội.

17h00: Đoàn về đến Hà Nội. Kết thúc chương trình. Hẹn gặp lại quý khách!', N'1', N'5')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'A38', N'Hạ Long ', N'A38.jpg', N'2 ngày 1 dêm', N'8600000.0000', N'Hà Nội - Hạ Long  Du Thuyền 5 Sao Dora Cruise', N'****NGÀY 01: HÀ NỘI – CẢNG TUẦN CHÂU – DU THUYỀN DORA ( ĂN TRƯA, TỐI)
8h30-9h00: Xe Limousine sẽ đón quý khách tại Nhà hát lớn Hà Nội, di chuyển đi Hạ Long. Xe sẽ đưa quý khách qua đường cao tốc Hải Phòng.12h45: Đoàn thủy thủ và nhân viên chào mừng quý khách đã lên du thuyền Dora Cruise – bắt đầu cho hành trình Du ngoạn Vịnh Hạ Long – Lan Hạ 2 ngày 1 đêm và nghỉ đêm thượng hạng trên Du thuyền 5 sao. 13h00: Quý khách thưởng thức bữa trưa tại nhà hàng trên Du thuyền Dora, trong khi du thuyền đang di chuyển trên Vịnh Hạ Long - Lan Hạ tráng lệ, chiêm ngưỡng những cảnh quan tuyệt đẹp trên Vịnh. 17h30: Quý khách quay trở lại du thuyền tự do giải trí, ngắm hoàng hôn và thưởng thức trà chiều, trái cây tươi hoặc tắm bể bơi trên du thuyền. 19h00: Quý khách thưởng thức bữa tối với Buffet hải sản tự chọn.
20h30: Tham gia hát karaoke tự chọn bài hát với âm thanh cực chuẩn trên du thuyền Dora.
**NGÀY 02: VỊNH LAN HẠ - TRÀ BÁU – CẢNG TUẦN CHÂU – HÀ NỘI ( ĂN SÁNG, TRƯA)
7h00: Quý khách ngắm bình minh trên Vịnh và ăn sáng buffe tự chọn. 
8h15: Du thuyền đưa Quý khách đến thăm quan khu vực Trà Báu, đây chính là địa điểm quay bộ phim Kong Skull Island (King Kong) nổi tiếng ở Quảng Ninh năm 2018. 
9h00: Du khách về phòng nghỉ ngơi, tận hưởng kì nghỉ tuyệt vời trên vịnh và chuẩn bị làm thủ tục trả phòng.
9h45: Khách làm thủ tục check-out phòng.
10h00: Bắt đầu ăn trưa trên du thuyền và thanh toán các dịch vụ phát sinh nếu có.
10h30: Ăn trưa set menu trên du thuyền.
11h15: Quý khách chào tạm biệt thuỷ thủ đoàn, lên tàu chuyển tải di chuyển về bến Tuần Châu
12h00: Quý khách có mặt tại Cảng Tuần Châu. Xe Limousine sẽ đón quý khách về lại Hà Nội.
15h00: Về tới Hà Nội. Kết thúc chương trình Trải nghiệm Dịch vụ 5 sao trên du thuyền Dora Cruise trong hành trình 2 ngày 1 đêm. Hẹn gặp lại quý khách trong những hành trình sắp tới.

Lưu ý: Chương trình có thể thay đổi tùy theo điều kiện thực tế và yêu cầu của đoàn.', N'1', N'1')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'A41', N'Tây Bắc', N'A41.jpg', N'3 ngày 2 đêm', N'7900000.0000', N'Hà Nội - sapa - Điện Biên - Lai Châu - Mộc Châu', N'ĐÊM 01: HÀ NỘI - SAPA
21h30: Quý khách có mặt tại 160 Trần Quang Khải lên xe Cabin VIP khởi hành đi Sapa (trường hợp nếu booking đặt quá cận ngày mà xe Cabin VIP không còn, chúng tôi sẽ bố trí đi xe giường nằm). 

Lưu ý: Xe có thể đón Quý khách tại sân bay Nội Bài từ 23h00 - 23h30 với chi phí đón trong sân bay là 50.000đ/nhóm. Hoặc đón tại Ngã 3 Kim Anh (đầu cao tốc) cũng trong khoảng 23h00 -23h30.

06h00: Tới Sapa, hướng dẫn viên đón Quý khách xe, đưa về văn phòng đại diện tại Sapa để vệ sinh cá nhân buổi sáng và nghỉ ngơi.
NGÀY 1: SAPA - CẦU KÍNH RỒNG MÂY - LAI CHÂU - ĐIỆN BIÊN ( ĂN SÁNG, TRƯA, TỐI)
06h30: Quý khách ăn sáng tại khách sạn và nghỉ ngơi. Nhâm nhi ly cafe buổi sáng tại nhà hàng.

07h00: Xe và hướng dẫn đón Quý khách đi thăm quan khu du lịch Cầu kính Rồng Mây trên khu vực cổng trời Ô Quy Hồ thuộc về địa phận huyện Tam Đường tỉnh Lai Châu. Hướng dẫn viên sẽ hướng dẫn để Quý khách tự túc mua vé thăm quan và vui chơi với các lựa chọn như sau:

- Thang máy Cầu Kính
Các trò chơi: Cầu độc mộc, Zipline tốc độ, Xích đu tử thần, Giường vô cực

- Sau khi dời Cầu Kính, Quý khách tiếp trục chinh phục con đèo Ô Quy Hồ để dẫn tới huyện Tam Đường ngắm cảnh bên núi bên sông vô cùng đẹp mắt. Chụp hình với Tượng đài thành phố Lai Châu, vượt qua mảnh đất Phong Thổ với những cung đường đẹp như tranh vẽ; băng qua những mảnh đất mà nhiều người chỉ biết đến qua trang sách đó là thượng nguồn Sông Đà, huyện Sìn Hồ rồi dòng sông Nậm Na và sau đó là tới trung tâm của huyện Mường Lay với lớp lớp những ngôi nhà sàn của người Thái đen trong ngút tầm mắt.
15h00: Tới thành phố Điện Biên Phủ, xe đưa Quý khách đi thăm quan
18h00: Nhận phòng khách sạn, nghỉ ngơi.

19h00: Ăn tối. Buổi tối tự do nghỉ ngơi. Nếu có nhu cầu, Đoàn có thể yêu cầu được đi ăn tối giao lưu tại bản Thái đen tại Điện Biên có thể đề nghị và tự túc chi trả các chi phí phát sinh liên quan. Nghỉ đêm tại Điện Biên
NGÀY 2: ĐIỆN BIÊN - MỘC CHÂU - CẦU KÍNH BẠCH LONG ( ĂN SÁNG, TRƯA, TỐI)
07h30: Đoàn lên xe đi Mộc Châu. Trên đường đi sẽ được hướng dẫn viên giới thiệu về Mường Phăng, địa danh lịch sử với trung tâm chỉ huy chiến dịch Điện Biên Phủ do cố Đại tướng Võ Nguyên Giáp trực tiếp chỉ huy trong chiến dịch Điện Biên Phủ 1954
Thác Dải Yếm - Một thác nước tuy nhỏ nhưng mang một vẻ đẹp quyến rũ. Tương truyền, dòng thác này là dải yếm của người con gái cứu chàng trai thoát khỏi dòng nước lũ. 
Vườn hoa Happy Land - Happy land có diện tích gần 5ha, nằm giữa một thung lũng rộng lớn ở bản Lùn, xã Mường Sang. Đến đây, du khách sẽ được đón chào bởi những thảm hoa được trồng từ nhiều loại hoa khác nhau, trong đó có những loài hoa đặc trưng của vùng Tây Bắc).
NGÀY 3: MỘC CHÂU - MAI CHÂU - HÀ NỘI ( ĂN SÁNG, TRƯA )
07h00: Xe bắt đầu đưa Quý khách đi thăm quan:

- Đồi chè Trái tim, có lẽ đây không chỉ là đồi chè đẹp nhất của Cao nguyên Mộc Châu mà còn là đồi chè đẹp nhất của Việt Nam bởi những luống chè xanh mởn tròn trịa và uốn lượn xa ngút tầm mắt đưa đến một cảm giác lãng mạn và bình yên. Đây cũng chính là vùng nguyên liệu để sản xuất ra thương hiệu nổi tiếng chính là Ô Long trà.
 Thung lũng mận Nà Ka với phong cảnh hoang sơ đầy mới lạ. Đặc biệt vào mùa hoa mận trắng tinh khôi hoặc vào mùa thu trái chín thì dường như Nà Ka khoác lên cho mình những tấm áo lộng lẫy đẹp diệu kỳ (Lưu ý: điểm Nà Ka chỉ đi vào khi vào mùa hoa mận hoặc vào hái quả, khi không phải mùa hoa hoặc mùa quả thì hướng dẫn viên sẽ dành thời gian cho các điểm thăm quan khác được dài hơn).
 Mộc Châu các mùa hoa trái: Tùy vào từng thời điểm, hướng dẫn viên sẽ đưa Quý khách đi chụp hình với những vườn hoa, vườn quả đặc trưng của Mộc Châu. Chắc chắn Quý khách sẽ ngỡ ngàng và ấn tượng trước những vẻ đẹp đầy sức sống và lôi cuốn ấy (Lưu ý: các vườn hoa vườn cây này như thế nào là hoàn toàn phụ thuộc vào thời tiết và kế hoạch trồng của người dân). 
15h00: Quý khách lên xe về Hà Nội. Trên đường về ghé dừng nghỉ ngơi tại đặc sản sữa Ba Vì mua đồ về làm quà cho bạn bè và người.

19h00: Xe đưa quý khách tới Hà Nội. Kết thúc chương trình. Hẹn gặp lại Quý khách!', N'2', N'1')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'A50', N'Sapa', N'A50.jpg', N'2 ngày 1 đêm', N'5600000.0000', N'Khám Phá Sapa - Moana - Nhà Thờ Đá', N'NGÀY 1: HÀ NỘI – SAPA – BẢN CÁT CÁT ( ĂN TRƯA, TỐI) 
6h30: Xe đón quý khách tại điểm đón 204 hoặc 160 Trần Quang Khải để khởi hành đi sapa. Sau đó khởi hành đi Sa Pa bằng xe Limosine Dcar 9 chỗ.Xe dừng chân dọc đường cao tốc Nội Bài – Lào Cai để quý khách nghỉ ngơi ăn sáng (Chi phí ăn sáng tự túc)
Trưa: Xe đến thị trấn Sa Pa nơi có rất nhiều dân tộc sinh sống như H’mong, Dao, Tày,… HDV sẽ đưa Quý khách về khách sạn, ăn trưa sau đó nhận phòng và nghỉ ngơi.
Thăm Bản Cát Cát nơi sinh sống của người H’mong đen, một nơi phòng cảnh hữu tình tại thung lũng nằm dưới chân đỉnh Phanxipang hùng vĩ. Quý khách vui chơi chụp hình lưu niệm
Tối: Quý khách dùng bữa tối. Sau đó tự do khám phá thị trấn Sapa về đêm: Thăm nhà thờ đá Sapa, đi chợ ẩm thực Sapa và thưởng thức những món nướng đặc trưng của vùng đất này,… Ngủ đêm tại Sapa
NGÀY 02: SAPA – MOANA SAPA – HÀ NỘI ( ĂN SÁNG, TRƯA)
Sáng: Quý khách dùng bữa sáng tại khách sạn.
Khu Moana Sapa là một điểm đến ở Sapa được lấy cảm hứng từ cổng trời của thành phố Bali xinh đẹp. Đến đây, bạn vừa được chụp hình thỏa thích, vừa được ngắm bức tranh lãng đãng mây trời đầy huyền ảo của Sapa.
Trưa: Quý khách quay về thị trấn và dùng bữa trưa tại khách sạn. Sau khi trả phòng quý khách tự do mua sắm đặc sản địa phương về làm quà cho người thân.
Chiều: Quý khách lên xe khởi hành về lại Hà Nội. Về đến Hà Nội. Xe đưa Quý khách về tại điểm đón trả của nhà xe, kết thúc hành trình khám phá thị trấn trong sương 2 ngày 1 đêm đầy thú vị. Tạm biệt và hẹn gặp lại Quý khách trong những hành trình du lịch lần sau', N'3', N'3')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'A52', N'Hạ Long ', N'A52.jpg', N'1 ngày', N'1880000.0000', N'Hà Nội - Hạ Long', N'**6h40-7h00: Limousine đón từ Hà Nội, đi Hạ Long. Sáng chuẩn bị đồ ăn tự túc.
10h00-10h30: Đến Cảng Tuần Châu
Du thuyền La Casta 5 sao mang lại hành trình sang trọng trên Vịnh Hạ Long, với phòng ốc xa hoa, ẩm thực đặc sắc và dịch vụ cao cấp
Quý khách thưởng thức bữa trưa buffet cao cấp với những món ăn hải sản tươi ngon nổi tiếng của Quảng Ninh cũng như các món ăn truyền thống của Việt Nam. 
Trưa: Khám phá Hang Sửng Sốt, vịnh Hạ Long: Leo bậc đá, trải nghiệm leo núi và ngắm cảnh vịnh hùng vĩ. Ai không thăm hang có thể thưởng thức đồ uống trên tàu.
Chiều: Du khách tham gia Sunset party và thư giãn trong bể sục jaccuzi trên du thuyền, nhâm nhi trà, cà phê và snack, trái cây trên sundeck, ngắm hoàng hôn yên bình trên Vịnh Hạ Long.
17h30: Tàu về cảng Tuần Châu, kết thúc 8h tham quan Vịnh Hạ Long. Limousine đưa về Hà Nội qua cao tốc.
20h00-20h30: Đến Hà Nội, chương trình kết thúc.
 Hẹn gặp lại quý khách trong những hành trình sắp tới', N'1', N'3')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'A57', N'Đà Nẵng', N'A57.jpg', N'3 ngày 2 dêm', N'6000000.0000', N'Đà Nẵng - Rừng Dừa Bảy Mẫu - Hội An - Bà Nà Hills', N'"NGÀY 1: HCM - ĐÀ NẴNG - BÁN ĐẢO SƠN TRÀ - RỪNG DỪA BẢY MẪU - HỘI AN (ĂN SÁNG, TRƯA)
Sáng: Khởi hành từ sân bay Tân Sơn Nhất đi Đà Nẵng. Chuyến bay VJ622 SGNDAD 07:00 - 08:25.
Đến Đà Nẵng, Dùng bữa sáng sau đó tham quan:
Bán Đảo Sơn Trà - Quà tặng thiên nhiên cho Đà Nẵng, nổi bật với bãi biển trong và rừng xanh mát, là điểm tham quan yên bình và xinh đẹp.
Du khách bách bộ tham quan Phố Cổ Hội An với Chùa Cầu Nhật Bản, Nhà Cổ, Hội Quán Phước Kiến và xưởng thủ công mỹ nghệ.
NGÀY 2: ĐÀ NẴNG - BÀ NÀ HILLS - TẮM BIỂN MỸ KHÊ (ĂN SÁNG, TỐI)
Sáng: Quý khách dùng bữa điểm tâm sáng tại nhà hàng.
Sau đó xe sẽ đưa đoàn đi tham quan chương trình Khám Phá Bà Nà HillS. Trải nghiệm cáp treo Bà Nà, ngắm nhìn cảnh quan núi rừng mây phủ, và thăm quan. (Chi phí tự túc)
15h00: Trở về khách sạn, dừng chân tại Cầu Rồng và Cầu Tình Yêu, thưởng thức không gian yên bình bên sông Hàn.
NGÀY 3: ĐÀ NẴNG - CÔNG VIÊN KÌ QUAN THẾ GIỚI - NGŨ HÀNH SƠN - TP. HCM (ĂN SÁNG, TRƯA)
Sáng: Thưởng thức bữa sáng và thời gian tự do tắm biển Mỹ Khê hoặc hồ bơi khách sạn.
10h00: Trả phòng và khám phá Công viên Kỳ Quan Thế Giới tại Hòa Bình Green, nơi quy tụ các kỳ quan nổi tiếng thế giới.
Đến giờ hẹn đoàn ra sân bay Đà Nẵng, bay chuyến VJ633 DADSGN 17:40 - 19:05 về Hồ Chí Minh. Kết thúc tour Đà Nẵng 3 ngày 2 đêm', N'3', N'4')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'A59', N'Đà nẵng', N'A59.jpg', N'4 ngày 3 dêm', N'1250000.0000', N'Cố Đô Huế - Lăng Cô - Lập An - Đà Nẵng - Hội An', N'**NGÀY 1: SG - HUẾ (ĂN TRƯA)
05h00: HDV đón Quý khách tại sân bay Tân Sơn Nhất, trường đoàn hỗ trợ làm thủ tục khởi hành đi Huế.
11h00: Tới Huế, Đoàn ghé tham quan Lăng Minh Mạng - Khám phá vẻ đẹp truyền thống qua lăng tẩm của vị vua nhà Nguyễn.
**NGÀY 2: HUẾ - ĐÀ NẴNG - PHỐ CỔ HỘI AN (ĂN SÁNG, TRƯA, TỐI)
Đoàn dùng điểm tâm tại khách sạn. Trả phòng, khởi hành đi Đà Nẵng, trên đường đi đoàn ghé chợ Đông Ba - Khu chợ truyền thống có bề dày lịch sử và văn hóa cao, tham quan và mua sắm quà cho người thân.
**NGÀY 3: ĐÀ NẴNG - BÀ NÀ HILL (ĂN SÁNG, TỐI)
Dùng điểm tâm sáng tại khách sạn. Quý khách tự do tắm biển Mỹ Khê.
Qúy Khách có thể chọn Option lên Bà Nà Hills - Thiên đường nghỉ dưỡng với cáp treo dài nhất thế giới, thăm Đồi Vọng Nguyệt, chùa Linh Ứng, Thích Ca Phật Đài, cây Cầu Vàng, và nhiều điểm thú vị khác, trải nghiệm bốn mùa trong một ngày. (Chi phí tự túc)
**NGÀY 4: ĐÀ NẴNG -HCM (ĂN SÁNG, TRƯA)
Quý khách dùng bữa sáng, trả phòng.
Tham quan Bán đảo Sơn Trà - Một món quà lớn mà thiên nhiên ưu ái ban tặng cho thành phố Đà Nẵng.
Viếng Linh Ứng Tự - Nơi có tượng Phật Bà 65m cao nhất Việt Nam
Qúy khách thăm quan và mua sắm tại Siêu thị Đặc sản miền trung hoặc Chợ hàn.
Sau đó xe và HDV tiễn đoàn ra sân bay Đà Nẵng, làm thủ tục về lại HCM. Đến nơi, trường đoàn chào tạm biệt và hẹn gặp lại quý khách trong các chương trình tiếp theo.', N'2', N'4')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'a7', N'Cần Thơ', N'a7.jpg', N'3 ngày 2 dêm', N'3299000.0000', N'Mỹ Tho - Cần Thơ - Châu Ðốc - Rang Tràm Trà Su', N'**NGÀY 1 | TP. HCM – CHÂU Ð?C (An sáng, trua, chi?u)**
*Sáng:* 
- Xe và Hu?ng D?n Viên Công Ty Du L?ch Vi?t dón Quý khách t?i di?m h?n.
- Kh?i hành di Châu Ð?c, d?ng chân dùng b?a sáng t?i Trung Luong.
*Trua:* 
- Dùng com trua.
- Tham quan R?ng Tràm Trà Su, c?nh d?p c?a r?ng tràm và h?n thiêng c?a mi?n Tây.
*Chi?u:* 
- Tham Núi C?m, noi có c?nh d?p hùng vi và không khí mát m?.
- Dùng com chi?u và ngh? dêm t?i Châu Ð?c.
**NGÀY 2 | CHÂU Ð?C – C?N THO (An sáng, trua, chi?u)**
*Sáng:* 
- Dùng b?a sáng.
- Vi?ng Tây An C? T? (Chùa Tây An Núi Sam) và Lang Tho?i Ng?c H?u.
*Trua:* 
- Dùng com trua.
- Hành huong t?i Mi?u Bà Chúa X? Núi Sam.
*Chi?u:* 
- Dùng com chi?u.
- Tham Thi?n Vi?n Trúc Lâm Phuong Nam và ngh? dêm t?i C?n Tho.
**NGÀY 3 | C?N THO – TI?N GIANG – TP. HCM (An sáng, trua)**
*Sáng:* 
- Tham quan ch? n?i Cái Rang t?i b?n Ninh Ki?u.
*Trua:* 
- Dùng b?a sáng và kh?i hành d?n Ti?n Giang.
- Tham chùa Vinh Tràng và c?nh d?p c?a sông nu?c mi?n Tây.
*Chi?u:* 
- Tham quan cù lao Th?i Son và lò k?o d?a n?i ti?ng B?n Tre.
- Dùng com trua.
- Kh?i hành v? TP.HCM, k?t thúc hành trình tour và chào t?m bi?t.', N'3', N'5')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'a8', N'Côn Đảo', N'a8.jpg', N'2 ngày 1 đêm', N'6550000.0000', N'Hoang Sơ - Côn Đảo', N'**NGÀY 1 | TP. HCM – CÔN ĐẢO (Ăn trưa, chiều) **
Sáng: Quý khách có mặt tại ga quốc nội, sân bay Tân Sơn Nhất trước giờ bay ít nhất một tiếng ba mươi phút. Đại diện công ty Du Lịch Việt đón và hỗ trợ làm thủ tục đón chuyến bay đi Côn Đảo.
Trưa: Đến Côn Sơn, quý khách sẽ được nghe thuyết minh về các điểm trên đường như làng Cỏ Ống, Lò Vôi, Nghĩa trang Hàng Keo, cụm đảo nhỏ phía ngoài khơi, đời sống văn hóa và lịch sử về Côn Đảo. 
Chiều: Đến thị trấn, dùng cơm trưa và nhận phòng khách sạn. Sau đó, xe và hướng dẫn viên sẽ đưa quý khách tham quan các điểm:
- Miếu bà Phi Yến: hay còn có tên chữ là An Sơn Miếu, là thánh địa linh thiêng của người dân Côn Đảo.
- Chùa Núi Một: Hay còn gọi là Vân Sơn Tự, nơi có thể ngắm toàn cảnh đẹp Côn Đảo từ trên cao.
- Nghĩa trang Hàng Dương: Nơi yên nghỉ của gần 2000 chiến sĩ, đồng thời viếng đền thờ Côn Đảo.
- Tham quan khu nuôi cấy ngọc trai Côn Đảo.
Tối: Tắm biển, tận hưởng không khí dạo phố biển và viếng mộ cô Sáu, một trong những nét văn hóa đặc trưng của Côn Đảo.
**NGÀY 2 | KHÁM PHÁ CÔN ĐẢO (Ăn sáng, trưa) **
Sáng: Dùng bữa sáng và lựa chọn một trong hai điểm tham quan:
- Bảo tàng Côn Đảo: nơi trưng bày các hiện vật chiến tranh và lịch sử của Côn Đảo.
- Dinh Chúa Đảo: Nơi sống và làm việc của 52 đời chúa đảo qua các thời kì thực dân pháp và Việt Nam Cộng Hòa.
Tiếp tục tham quan các điểm như Trại Phú Hải, Chuồng cọp kiểu Pháp, Chuồng cọp kiểu Mỹ và mua sắm đặc sản tại Côn Đảo.
Trưa: Dùng cơm trưa và chuẩn bị ra sân bay làm thủ tục trở về TP.HCM.
Khởi hành về TP.HCM chia tay và hẹn gặp lại.', N'1', N'3')
GO

INSERT INTO [dbo].[tour] ([id], [tourName], [image], [date], [price], [journeys], [description1], [cateID], [sell_ID]) VALUES (N'a9', N'Châu Đốc', N'a9.jpg', N'3 ngày 2 đêm', N'3299000.0000', N'Mỹ Tho - Cần Thơ - Châu Đốc - Rừng Tràm Trà Sư', N'**NGÀY 1:
Sáng , đoàn khởi hành từ TP.HCM với sự đón tiếp của xe và hướng dẫn viên từ Công Ty Du Lịch Việt. Trên đường đi Châu Đốc (An Giang), quý khách sẽ dừng lại tại Trung Lương để thưởng thức bữa sáng. Sau đó, hành trình tiếp tục đến Châu Đốc.
Trưa, sau khi đoàn đã di chuyển đến, quý khách sẽ được thưởng thức bữa trưa. Tiếp theo là chuyến tham quan Rừng Tràm Trà Sư, nổi tiếng là khu rừng ngập nước đặc biệt của vùng Tây sông Hậu. Tại đây, du khách sẽ được trải nghiệm chèo xuồng qua những con rạch, ngắm cảnh rừng tràm xanh mướt, cùng nghe tiếng chim hót và tiếng sóng nước êm đềm.
Buổi chiều, đoàn sẽ khám phá Núi Cấm hay còn được biết đến với tên gọi Thiên Cẩm Sơn, nơi có độ cao 705m so với mặt nước biển. Núi Cấm mang vẻ đẹp hùng vĩ, kết hợp với kiến trúc của các công trình như Chùa Vạn Linh, chùa Phật Lớn, tượng Phật Di Lặc, hồ Thủy Liêm.
Chiều về, đoàn sẽ dùng cơm chiều và nghỉ đêm tại khách sạn tại Châu Đốc.
**NGÀY 2
Sáng, đoàn sẽ viếng thăm các điểm du lịch nổi tiếng như chùa Tây An Núi Sam, Lăng Thoại Ngọc Hầu, và Miếu Bà Chúa Xứ Núi Sam. 
Trưa, sau khi dùng cơm trưa, đoàn sẽ khởi hành đến Cần Thơ để tham quan Thiền Viện Trúc Lâm Phương Nam.
Chiều về, đoàn sẽ dùng cơm chiều và nghỉ đêm tại khách sạn tại Cần Thơ.
**NGÀY 3:
Sáng, đoàn sẽ đến bến Ninh Kiều để tham quan chợ nổi Cái Răng ở miền Tây Nam Bộ. Tiếp theo, đoàn sẽ tham quan các điểm du lịch tại Tiền Giang như chùa Vĩnh Tràng và cồn Phụng. 
Trưa, sau khi dùng cơm trưa, đoàn sẽ khởi hành về TP.HCM, đánh dấu kết thúc hành trình tour.', N'3', N'1')
GO


-- ----------------------------
-- Primary Key structure for table tour
-- ----------------------------
ALTER TABLE [dbo].[tour] ADD CONSTRAINT [PK__tour__3213E83FBEF6FFF9] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

