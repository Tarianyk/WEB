/***************************************************************/
/*This command connects java WEB-application to database MySQL*/
/*************************************************************/
CONNECT 'jdbc:mysql://localhost:3306/eshop?useSSL=false;user=root;password=root'

/********************************************/
/*SummaryTask4 DB creation script for MySQL*/
/******************************************/
DROP TABLE IF EXISTS `catalog`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `language`;
DROP TABLE IF EXISTS `userban`;

/*********************************/
/*Creates the table of LANGUAGE */
/*******************************/
CREATE TABLE `language` (
--Id has the INTEGER type and it is the primaty key.
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Id`)
);

/********************************/
/*Creates the table of USERBAN */
/******************************/
CREATE TABLE `userban` (
--Id has the INTEGER type and it is the primaty key.
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ban` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
);

/********************************/
/*Creates the table of CATALOG */
/******************************/
CREATE TABLE `catalog` (
--Id has the INTEGER type and it is the primaty key.
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `articul` varchar(100) DEFAULT NULL,
  `desc1` text,
  `desc2` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `LanguageID` int(11) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `LanguageID` (`LanguageID`),
  --The LanguageID is foreign key.
  CONSTRAINT `catalog_ibfk_1` FOREIGN KEY (`LanguageID`) REFERENCES `language` (`Id`)
);

/*******************************/
/*Creates the table of ORDERS */
/*****************************/
CREATE TABLE `orders` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Article` varchar(100) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `TotalAmount` int(11) DEFAULT NULL,
  `Price` decimal(9,2) DEFAULT NULL,
  `TotalPrice` decimal(9,2) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `LangId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `LangId` (`LangId`),
  --The LangId is foreign key.
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`LangId`) REFERENCES `language` (`Id`)
);

/******************************/
/*Creates the table of USERS */
/****************************/
CREATE TABLE `users` (
  `UsersID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Password` varchar(250) DEFAULT NULL,
  `Role` varchar(25) DEFAULT NULL,
  `LanguageID` int(11) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`UsersID`),
  KEY `LanguageID` (`LanguageID`),
  KEY `users_ibfk_2` (`id`),
  --LanguageID and id are foreign keys.
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`LanguageID`) REFERENCES `language` (`Id`),
  CONSTRAINT `users_ibfk_2` FOREIGN KEY (`id`) REFERENCES `userban` (`Id`)
);

/*************************************/
/*Fills all fields in each of tables */
/*************************************/
INSERT INTO `language` VALUES (1,'en'),(2,'ru');

INSERT INTO `userban` VALUES (1,'banned'),
							(2,'not banned');

INSERT INTO `catalog` VALUES (3,'Процессор s-FM2+ AMD A10-7800 X4 BOX','AD7800YBJABOX','Макс. частота памяти - 2133 МГц / Ядро - Kaveri / GPU - AMD Radeon R7 / Техпроцесс - 28 нм / TDP - 65 Втs-FM2+ / Частота ядра (номинальная) - 3,5 ГГц / Частота ядра (максимальная - boost/turbo/TurboBoost) - 3,9 ГГц / Количество ядер - 4 шт.','CPU',32323.12,2,'2016-08-05','/SummaryTask4/resources/images/db/pr2.jpg',15),
							(4,'Processor s-FM2+ AMD A10-7800 X4 BOX','AD7800YBJABOX','Max. memory frequency - 2133 MHz / kernel - Kaveri / GPU - AMD Radeon R7 / Process technology - 28 nm / the TDP - 65 Vts-FM2 + / Core frequency (nominal) - 3.5 GHz / Core frequency (maximum - boost / turbo / TurboBoost) - 3.9 GHz / number of cores - 4 pcs.','CPU',32323.12,1,'2016-08-05','/SummaryTask4/resources/images/db/pr2.jpg',15),
							(5,'Процессор s-FM221 AMD A4-4020 X2 BOX','AD4020OKHLBOX123','s-FM2 / Частота ядра (номинальная) - 3,2 ГГц / Частота ядра (максимальная - boost/turbo/TurboBoost) - 3,4 ГГц / Количество ядер - 2 шт. / Макс. частота памяти - 1333 МГц / Ядро - Richland / GPU - AMD Radeon HD 7480D / Техпроцесс - 32 нм / TDP - 65 Вт','CPU',15024.77,2,'2016-08-14','/SummaryTask4/resources/images/db/pr3.jpg',33),
							(6,'Processor s-FM221 AMD A4-4020 X2 BOX','AD4020OKHLBOX123','s-FM2 / Core frequency (nominal) - 3.2 GHz / Core frequency (maximum - boost / turbo / TurboBoost) - 3,4 GHz / Number of cores -. 2 pcs. / Max memory frequency - 1333 MHz / kernel - Richland / GPU - AMD Radeon HD 7480D / Process technology - 32 nm / the TDP - 65 W ','CPU ',15024.77,1,'2016-08-14','/SummaryTask4/resources/images/db/pr3.jpg',33),
							(7,'Процессор s-FM23 AMD A10-7800 X4 BOX','AD7800YBJABOX123','Макс. частота памяти - 2133 МГц / Ядро - Kaveri / GPU - AMD Radeon R7 / Техпроцесс - 28 нм / TDP - 65 Втs-FM2+ / Частота ядра (номинальная) - 3,5 ГГц / Частота ядра (максимальная - boost/turbo/TurboBoost) - 3,9 ГГц / Количество ядер - 4 шт.','CPU',333.12,2,'2016-08-15','/SummaryTask4/resources/images/db/pr4.jpg',55),
							(8,'Processor s-FM23 AMD A10-7800 X4 BOX','AD7800YBJABOX123','Max. memory frequency - 2133 MHz / kernel - Kaveri / GPU - AMD Radeon R7 / Process technology - 28 nm / the TDP - 65 Vts-FM2 + / Core frequency (nominal) - 3.5 GHz / Core frequency (maximum - boost / turbo / TurboBoost) - 3.9 GHz / number of cores - 4 pcs.','CPU',333.12,1,'2016-08-15','/SummaryTask4/resources/images/db/pr4.jpg',55),
							(9,'Sound Card USB Dynamode C-Media 108 7.1CH 3D RTL White','QE231ERF21','external / USB 2.0 / 7.1 / Bit DAC - 16 bit / Max. DAC frequency (stereo) - 48 kHz','SOUND',123.12,1,'2013-08-04','/SummaryTask4/resources/images/db/sound1.jpg',17),
							(10,'Звуковая карта USB Dynamode C-Media 108 7.1CH 3D RTL White','QE231ERF21','внешняя / USB 2.0 / 7.1 / Разрядность ЦАП - 16 бит / Макс. частота ЦАП (стерео) - 48 кГц','SOUND',123.12,2,'2013-08-04','/SummaryTask4/resources/images/db/sound1.jpg',17),
							(11,'Sound Card USB PrologiX SC-108-6CH 5.1CH','108-6CH1','external / USB 2.0 / 7.1 / Bit DAC - 24 bit / Max. DAC frequency (stereo) - 96 kHz','SOUND',312312.11,1,'2016-01-04','/SummaryTask4/resources/images/db/sound2.jpg',81),
							(12,'Звуковая карта USB PrologiX SC-108-6CH 5.1CH','108-6CH1','внешняя / USB 2.0 / 7.1 / Разрядность ЦАП - 24 бит / Макс. частота ЦАП (стерео) - 96 кГц','SOUND',312312.11,2,'2016-01-04','/SummaryTask4/resources/images/db/sound2.jpg',81),
							(13,'Sound Card USB2.0 Dynamode C-Media 108 7.1CH 3D RTL White','QE231ERF213','external / USB 2.0 / 7.1 / Bit DAC - 16 bit / Max. DAC frequency (stereo) - 48 kHz','SOUND',1213.12,1,'2013-11-04','/SummaryTask4/resources/images/db/sound3.jpg',52),
							(14,'Звуковая карта USB2.0 Dynamode C-Media 108 7.1CH 3D RTL White','QE231ERF213','внешняя / USB 2.0 / 7.1 / Разрядность ЦАП - 16 бит / Макс. частота ЦАП (стерео) - 48 кГц','SOUND',1213.12,2,'2013-11-04','/SummaryTask4/resources/images/db/sound3.jpg',52),
							(15,'Sound Card USB2.0 PrologiX SC-108-6CH 5.1CH','108-6CH2','external / USB 2.0 / 7.1 / Bit DAC - 24 bit / Max. DAC frequency (stereo) - 96 kHz','SOUND',322312.33,1,'2016-11-04','/SummaryTask4/resources/images/db/sound4.jpg',30),
							(16,'Звуковая карта USB2.0 PrologiX SC-108-6CH 5.1CH','108-6CH2','внешняя / USB 2.0 / 7.1 / Разрядность ЦАП - 24 бит / Макс. частота ЦАП (стерео) - 96 кГц','SOUND',322312.33,2,'2016-11-04','/SummaryTask4/resources/images/db/sound4.jpg',30),
							(17,'Drive 3.5 \"FDD 1.44Mb Maiwo K520C','K520C','Type - External drive / format - 3.5 \"/ Color - Black','DRIVE',200.00,1,'2016-08-05','/SummaryTask4/resources/images/db/hd1.jpg',22),
							(18,'Дисковод 3.5\" FDD 1.44Mb Maiwo K520C','K520C','Тип - внешний дисковод / Формат - 3.5\" / Цвет - черный','DRIVE',200.00,2,'2016-08-05','/SummaryTask4/resources/images/db/hd1.jpg',22),
							(19,'Drive 3.5 \"FDD 1.44Mb Gembird FLD-USB','K440C','Type - External drive / format - 3.5 \"/ Color - Black','DRIVE',341.00,1,'2016-06-04','/SummaryTask4/resources/images/db/hd2.jpg',89),
							(20,'Дисковод 3.5\" FDD 1.44Mb Gembird FLD-USB','K440C','Тип - внешний дисковод / Формат - 3.5\" / Цвет - черный','DRIVE',341.00,2,'2016-06-04','/SummaryTask4/resources/images/db/hd2.jpg',89),
							(21,'Drive 3.5 \"FDD 1.44Mb Maiwo K521C','K520C23','Type - External drive / format - 3.5 \"/ Color - Black','DRIVE',2010.00,1,'2013-08-05','/SummaryTask4/resources/images/db/hd3.jpg',77),
							(22,'Дисковод 3.5\" FDD 1.44Mb Maiwo K521C','K520C23','Тип - внешний дисковод / Формат - 3.5\" / Цвет - черный','DRIVE',2010.00,2,'2013-08-05','/SummaryTask4/resources/images/db/hd3.jpg',77),
							(23,'Drive 3.5 \"FDD 1.44Mb Gembird FLD1-USB','K440C12','Type - External drive / format - 3.5 \"/ Color - Black','DRIVE',3411.00,1,'2013-06-04','/SummaryTask4/resources/images/db/hd4.jpg',22),
							(24,'Дисковод 3.5\" FDD 1.44Mb Gembird FLD1-USB','K440C12','Тип - внешний дисковод / Формат - 3.5\" / Цвет - черный','DRIVE',3411.00,2,'2013-06-04','/SummaryTask4/resources/images/db/hd4.jpg',22),
							(25,'Цифровая зеркальная фотокамера Nikon D5300 Kit 18-140 Black','VBA370KV02','24,2 Мп / Тип матрицы - CMOS / Размер матрицы - 23,5x15,6 мм / Очистка матрицы / Макс. разрешение - 6000x4000 / 1920x1080/60+ / Диагональ экрана - 3,2\" / Поворотный экран','CAMERA',4444.20,2,'2016-04-05','/SummaryTask4/resources/images/db/ph1.jpg',32),
							(26,'Digital SLR Camera Nikon D5300 Kit 18-140 Black','VBA370KV02','24.2 Mn / Type of matrix - CMOS / Matrix size - 23,5x15,6 mm / Sensor Cleaning / Max. resolution - 6000x4000 / 1920x1080 / 60 + / Screen size - 3.2 \"/ Swivel screen','CAMERA',4444.20,1,'2016-04-05','/SummaryTask4/resources/images/db/ph1.jpg',32),
							(27,'Цифровая зеркальная фотокамера Nikon D5200 Kit 18-55 VR II Black','VBA350K007','24,71 Мп (24,1 Мп эффективных) / Тип матрицы - CMOS / Размер матрицы - 23,5x15,6 мм / Очистка матрицы / Макс. разрешение - 6000x4000 / 1920x1080/60+ / Диагональ экрана - 3\" / Поворотный экран / Видоискатель - зеркальный','CAMERA',23444.20,2,'2016-04-15','/SummaryTask4/resources/images/db/ph2.jpg',11),
							(28,'Digital SLR Camera Nikon D5200 Kit 18-55 VR II Black','VBA350K007','24.71 megapixels (24.1 effective megapixels) / Type of matrix - CMOS / Matrix size - 23,5x15,6 mm / Sensor Cleaning / Max. resolution - 6000x4000 / 1920x1080 / 60 + / Screen size - 3 \"/ Swivel screen / viewfinder - mirror','CAMERA',23444.20,1,'2016-04-15','/SummaryTask4/resources/images/db/ph2.jpg',11),
							(29,'Цифровая зеркальная фотокамера Nikon D53001 Kit 18-140 Black','VBA370KV0223','24,2 Мп / Тип матрицы - CMOS / Размер матрицы - 23,5x15,6 мм / Очистка матрицы / Макс. разрешение - 6000x4000 / 1920x1080/60+ / Диагональ экрана - 3,2\" / Поворотный экран','CAMERA',6474.20,2,'2016-04-07','/SummaryTask4/resources/images/db/ph3.jpg',36),
							(30,'Digital SLR Camera Nikon D53001 Kit 18-140 Black','VBA370KV0223','24.2 Mn / Type of matrix - CMOS / Matrix size - 23,5x15,6 mm / Sensor Cleaning / Max. resolution - 6000x4000 / 1920x1080 / 60 + / Screen size - 3.2 \"/ Swivel screen','CAMERA',6474.20,1,'2016-04-07','/SummaryTask4/resources/images/db/ph3.jpg',36),
							(31,'Цифровая зеркальная фотокамера Nikon D52001 Kit 18-55 VR II Black','VBA350K00712','24,71 Мп (24,1 Мп эффективных) / Тип матрицы - CMOS / Размер матрицы - 23,5x15,6 мм / Очистка матрицы / Макс. разрешение - 6000x4000 / 1920x1080/60+ / Диагональ экрана - 3\" / Поворотный экран / Видоискатель - зеркальный','CAMERA',234644.20,2,'2016-04-09','/SummaryTask4/resources/images/db/ph4.jpg',36),
							(32,'Digital SLR Camera Nikon D52001 Kit 18-55 VR II Black','VBA350K00712','24.71 megapixels (24.1 effective megapixels) / Type of matrix - CMOS / Matrix size - 23,5x15,6 mm / Sensor Cleaning / Max. resolution - 6000x4000 / 1920x1080 / 60 + / Screen size - 3 \"/ Swivel screen / viewfinder - mirror','CAMERA',234644.20,1,'2016-04-09','/SummaryTask4/resources/images/db/ph4.jpg',36),
							(33,'Объектив Fuji XF-23mm F1.4 R','AQVBA370KV02','широкоугольный / Число элементов - 11 шт. / Число групп элементов - 8 шт. / Асферические элементы - 1 шт. / Совместимость - Fujifilm X Mount / Фокусное расстояние - 23 мм','FLASH',322322.00,2,'2015-04-15','/SummaryTask4/resources/images/db/lens1.jpg',63),
							(34,'Lens Fuji XF-23mm F1.4 R','AQVBA370KV02','Wide Angle / Number of Items - 11 pcs. / The number of elements of groups - 8 pcs. / Aspherical elements - 1 pcs. / Compatibility - Fujifilm X Mount','FLASH',322322.00,1,'2015-04-15','/SummaryTask4/resources/images/db/lens1.jpg',63),
							(35,'Объектив Fuji XF-25mm F1.4 R','AQWWEVBA370KV02','широкоугольный / Число элементов - 11 шт. / Число групп элементов - 8 шт. / Асферические элементы - 1 шт. / Совместимость - Fujifilm X Mount / Фокусное расстояние - 23 мм','FLASH',2322.00,2,'2015-04-15','/SummaryTask4/resources/images/db/lens2.jpg',66),
							(36,'Lens Fuji XF-25mm F1.4 R','AQWWEVBA370KV02','Wide Angle / Number of Items - 11 pcs. / The number of elements of groups - 8 pcs. / Aspherical elements - 1 pcs. / Compatibility - Fujifilm X Mount','FLASH',2322.00,1,'2015-04-15','/SummaryTask4/resources/images/db/lens2.jpg',66),
							(37,'Объектив Fuji XF1-23mm F1.4 R','AQVBA370KV0223','широкоугольный / Число элементов - 11 шт. / Число групп элементов - 8 шт. / Асферические элементы - 1 шт. / Совместимость - Fujifilm X Mount / Фокусное расстояние - 23 мм','FLASH',3322.00,2,'2015-04-13','/SummaryTask4/resources/images/db/lens3.jpg',55),
							(38,'Lens Fuji XF1-23mm F1.4 R','AQVBA370KV0223','Wide Angle / Number of Items - 11 pcs. / The number of elements of groups - 8 pcs. / Aspherical elements - 1 pcs. / Compatibility - Fujifilm X Mount','FLASH',3322.00,1,'2015-04-13','/SummaryTask4/resources/images/db/lens3.jpg',55),
							(39,'Объектив Fuji2 XF-25mm F1.4 R','AQWWEVBA370KV0212','широкоугольный / Число элементов - 11 шт. / Число групп элементов - 8 шт. / Асферические элементы - 1 шт. / Совместимость - Fujifilm X Mount / Фокусное расстояние - 23 мм','FLASH',23322.00,2,'2015-04-14','/SummaryTask4/resources/images/db/lens4.jpg',45),
							(40,'Lens Fuji2 XF-25mm F1.4 R','AQWWEVBA370KV0212','Wide Angle / Number of Items - 11 pcs. / The number of elements of groups - 8 pcs. / Aspherical elements - 1 pcs. / Compatibility - Fujifilm X Mount','FLASH',23322.00,1,'2015-04-14','/SummaryTask4/resources/images/db/lens4.jpg',45),
							(45,'Процессор s-FM2+ AMD A10-7800 X4 BOX33','AD7800YBJABOX33','Макс. частота памяти - 2133 МГц / Ядро - Kaveri / GPU - AMD Radeon R7 / Техпроцесс - 28 нм / TDP - 65 Втs-FM2+ / Частота ядра (номинальная) - 3,5 ГГц / Частота ядра (максимальная - boost/turbo/TurboBoost) - 3,9 ГГц / Количество ядер - 4 шт.','CPU',4442.00,2,'2015-04-14','/SummaryTask4/resources/images/db/pr1.jpg',33),
							(46,'Processor s-FM2+ AMD A10-7800 X4 BOX33','AD7800YBJABOX33','Max. memory frequency - 2133 MHz / kernel - Kaveri / GPU - AMD Radeon R7 / Process technology - 28 nm / the TDP - 65 Vts-FM2 + / Core frequency (nominal) - 3.5 GHz / Core frequency (maximum - boost / turbo / TurboBoost) - 3.9 GHz / number of cores - 4 pcs.','CPU',4442.00,1,'2015-04-14','/SummaryTask4/resources/images/db/pr1.jpg',33);

INSERT INTO `users` VALUES (1,'Anton','Tarianyk','anton@gmail.com','dc 0 7d 8c 9d 90 f8 f 94 1e dc b5 f7 ff e7 d1 fd 8d 80 70 1c f6 42 1c 18 aa df c9 91 2d 23 50','ADMIN',2,2),
							(2,'Vasya','Pupkin','vasya@mail.ru','21 61 d3 a4 98 e5 ea 46 c1 b8 57 cf c1 a3 9b 34 82 4d 8d d5 46 94 76 31 ce 53 4d 77 3e 37 67 d6','USER',1,2),
							(3,'Ekaterina','Robinson','robinson@gmail.com','45 b0 72 14 a2 f4 eb 60 48 22 34 72 b4 91 c7 73 82 72 bc d 4d 1f 67 23 95 8d 91 3f d9 8b d9 45','USER',1,2);

