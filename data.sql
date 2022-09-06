-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: shop_demo_1
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (11,'Acer'),(6,'Asus'),(17,'Canon'),(20,'Casper'),(8,'Dell'),(18,'Fujifilm'),(4,'Hitachi'),(12,'HP'),(19,'Ipad'),(2,'Iphone'),(9,'Lenovo'),(14,'LG'),(10,'Macbook'),(13,'MSI'),(7,'Oppo'),(16,'Panasonic'),(1,'SamSung'),(15,'Sharp'),(3,'Sony'),(5,'Xiaomi');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (2,'Điện thoại'),(4,'Máy ảnh'),(1,'Máy tính'),(3,'Smart TV'),(6,'Tablet'),(5,'Tủ lạnh');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_brand`
--

DROP TABLE IF EXISTS `category_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_brand` (
  `brand_id` bigint NOT NULL,
  `category_id` bigint NOT NULL,
  PRIMARY KEY (`brand_id`,`category_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `category_brand_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  CONSTRAINT `category_brand_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_brand`
--

LOCK TABLES `category_brand` WRITE;
/*!40000 ALTER TABLE `category_brand` DISABLE KEYS */;
INSERT INTO `category_brand` VALUES (1,1),(3,1),(6,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(1,2),(2,2),(3,2),(5,2),(6,2),(7,2),(14,2),(1,3),(3,3),(5,3),(14,3),(16,3),(18,3),(20,3),(16,4),(17,4),(1,5),(3,5),(4,5),(15,5),(16,5),(1,6),(5,6),(9,6),(10,6);
/*!40000 ALTER TABLE `category_brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `image` varchar(400) DEFAULT NULL,
  `status` int NOT NULL DEFAULT '1',
  `role_id` bigint NOT NULL DEFAULT '2',
  `email_address` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `UK_9uaghg9t4xiowjt9ndqickscs` (`email_address`),
  UNIQUE KEY `UK_rosd2guvs3i1agkplv5n8vu82` (`phone_number`),
  KEY `customer_ibfk_1` (`role_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imageurl`
--

DROP TABLE IF EXISTS `imageurl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imageurl` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8l1ju32s9wfikyh4ecemyss9u` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imageurl`
--

LOCK TABLES `imageurl` WRITE;
/*!40000 ALTER TABLE `imageurl` DISABLE KEYS */;
INSERT INTO `imageurl` VALUES (24,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/man-hinh-cam-ung-thong-minh-lg-stanby-me-27art10akpl-3.jpg?alt=media&token=85d684c4-46ea-49f6-b1f8-d82a482fd271',34),(23,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/man-hinh-cam-ung-thong-minh-lg-stanby-me-27art10akpl-2.jpg?alt=media&token=7097f50b-bd95-4141-994c-b1dc89677d5d',34),(22,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/man-hinh-cam-ung-thong-minh-lg-stanby-me-27art10akpl-1.jpg?alt=media&token=700ca333-19b9-4694-80f4-d75b1992f25d',34),(25,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/iphone-12-pro-max_3__7.jpg?alt=media&token=075a236f-ad62-4f7c-b64d-f91cac14cdbd',35),(26,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/iphone_12_pro_max_white_1.png?alt=media&token=8b41c0ba-7657-4541-93c9-04bde40ccfca',35),(27,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/iphone-12-pro-max_4__7.jpg?alt=media&token=f1661825-a82d-4f32-a49e-74c8d4f7e01c',35),(28,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/sm-s908_galaxys22ultra_front_green_211119.jpg?alt=media&token=7f2562b7-0b9e-4df4-a637-c41b4b71d4d1',37),(29,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/sm-s908_galaxys22ultra_front_phantomwhite_211119.jpg?alt=media&token=8192e15d-3859-431a-a74c-7a225f890114',37),(30,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/sm-s908_galaxys22ultra_front_burgundy_211119.jpg?alt=media&token=2d42403d-61ec-4d98-8a7b-64abdbfb9315',37),(39,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/6_26_92.jpg?alt=media&token=bc46e390-21b8-4431-b8a4-d56105e2b31f',39),(37,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/9_10_30.jpg?alt=media&token=7a144047-f40d-4077-a213-7f8291dc95dd',39),(38,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/8_12_37.jpg?alt=media&token=38d28df0-b21a-42ff-ab72-4d06e25307f1',39),(40,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/11072_asus_vivobook_15x_oled_m1503_3.jpg?alt=media&token=f5798ccd-7c5f-4926-9117-8b5b1daec89e',40),(41,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/11072_asus_vivobook_15x_oled_m1503_2.jpg?alt=media&token=25facd0a-75fd-4b0e-8305-699ded241118',40),(42,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/11072_asus_vivobook_15x_oled_m1503_logo.jpg?alt=media&token=9ef4d1f2-1bb7-40e5-8a07-9f95148ba057',40),(43,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/9630_dell_alienware_m15_r4_4.jpg?alt=media&token=56880b08-7884-4397-af5f-05b61c36e128',41),(44,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/9630_dell_alienware_m15_r4_5.jpg?alt=media&token=bc280deb-9e01-4e90-aaf5-f6017df1ba8f',41),(45,'https://firebasestorage.googleapis.com/v0/b/image-ee401.appspot.com/o/9630_dell_alienware_m15_r4_3.jpg?alt=media&token=9b84daa7-81ce-4b33-aea0-fac6b574dd88',41);
/*!40000 ALTER TABLE `imageurl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `orders_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_detail_ibfk_1` (`orders_id`),
  KEY `order_detail_ibfk_2` (`product_id`),
  CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `order_detail_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_order` datetime NOT NULL,
  `date_ship` datetime NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `status_exist` int NOT NULL DEFAULT '1',
  `status_order` int NOT NULL DEFAULT '0',
  `customer_id` bigint NOT NULL,
  `status_pay` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `orders_ibfk_1` (`customer_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `amount` int NOT NULL,
  `color` varchar(255) NOT NULL,
  `description` mediumtext NOT NULL,
  `status` int NOT NULL DEFAULT '1',
  `category_id` bigint NOT NULL,
  `brand_id` bigint NOT NULL,
  `discount` int DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `product_ibfk_1` (`category_id`),
  KEY `product_ibfk_2` (`brand_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (34,'4',5,5,'5','5',0,2,2,0),(35,'iPhone 12 Pro Max 128GB I Chính hãng VN/A',25600000,20,'Vàng','Cứ mỗi năm, đến dạo cuối tháng 8 và gần đầu tháng 9 thì mọi thông tin sôi sục mới về chiếc iPhone mới lại xuất hiện. Apple năm nay lại ra thêm một chiếc iPhone mới với tên gọi mới là iPhone 12 Pro Max, đây là một dòng điện thoại mới và mạnh mẽ nhất của nhà Apple năm nay. Mời bạn tham khảo thêm một số mô tả sản phẩm bên dưới để bạn có thể ra quyết định mua sắm.',1,2,2,0),(36,'iPhone 11 128GB I Chính hãng VN/A',12190000,10,'Đỏ','Ngoài phiên bản 128GB, bạn cũng có thể lựa chọn cho mình điện thoại iPhone 11 64GB nếu nhu cầu sử dụng của bạn không quá nhiều.',0,2,2,0),(37,'Samsung Galaxy S22 Ultra (8GB - 128GB)',24900000,10,'Đen','Trước khi chính thức ra mắt cộng đồng những chiếc điện thoại Samsung S22 Series đã có thời gian được thai nghén khá dài để đảm bảo có những tính năng thực sự vượt trội so với phiên bản tiền nhiệm. Để có thể hình dung rõ ràng ta xét đến 2 mẫu Samsung S22 Ultra và S21 Ulta xem dòng flagship mới nhà Samsung có những nâng cấp nổi trội nào nhé!',1,2,1,0),(38,'Apple MacBook Pro 13 Touch Bar M1 256GB 2020',28390000,10,'Bạc','Máy tính bảng Macbook Pro M1 thế hệ mới vừa ra mắt được trang bị vi xử lý M1 do chính Apple tự thiết kế. Hứa hẹn mang đến hiệu năng cực kì mạnh mẽ, thời gian sử dụng cực kì ấn tượng. Dưới đây là những đánh giá chi tiết về sản phẩm.',0,1,10,0),(39,'Laptop HP Envy 13-BA1536TU 4U6M5PA',19000000,10,'Vàng','Với chất liệu kim loại nguyên khối chắc chắn, bền bỉ, laptop HP Envy 13-ba1536TU 4U6M5PA được hoàn thiện bởi các đường viền tỉ mỉ, cho ra một vẻ ngoài đơn giản nhưng hiện đại, lớp vỏ sang trọng hơn nhờ được phủ gam màu đồng, logo HP được đặt ở giữa nắp lưng càng làm tăng tính thẩm mỹ cao hơn cho máy.',1,1,12,0),(40,'Laptop Asus Vivobook 15X OLED',25600000,20,'Đen','Mở rộng tầm nhìn của bạn ra ngoài biên giới và đắm mình trong màn hình tỷ lệ khung hình 16: 9 tuyệt vời của Vivobook 14X/15X OLED. Màn hình NanoEdge ba mặt OLED HDR này siêu sáng và có gam màu 100% DCI-P3 cấp rạp chiếu phim cho màu sắc cực kỳ sống động. Nó cũng được PANTONE ® Kiểm chứng về độ chính xác màu cấp độ chuyên nghiệp và được chứng nhận TÜV Rheinland về phát thải ánh sáng xanh dương thấp. Hãy để Vivobook 15X OLED dẫn đường cho hành trình sáng tạo của bạn, với trải nghiệm hình ảnh hoàn toàn mới.\n ',1,1,6,0),(41,'Dell Alienware M15 R4',30000000,10,'Đen','Quá đẹp',1,1,8,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN',0),(2,'NGƯỜI DÙNG',0);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-05 16:35:43
