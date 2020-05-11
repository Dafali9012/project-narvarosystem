-- ****************** SqlDBM: MySQL ******************;
-- ***************************************************;

CREATE DATABASE IF NOT EXISTS `narvarosystem` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `narvarosystem`;


-- ************************************** `Role`

CREATE TABLE `Role`
(
 `RoleID`    int NOT NULL AUTO_INCREMENT ,
 `Name`      varchar(10) NULL ,
 `Setting 1` boolean NOT NULL ,
 `Setting 2` boolean NOT NULL ,

PRIMARY KEY (`RoleID`),
UNIQUE KEY `AK1_Order_OrderNumber` (`Name`)
) AUTO_INCREMENT=1 COMMENT='Order information
like Date, Amount';






-- ************************************** `User`

CREATE TABLE `User`
(
 `UserID`            int NOT NULL AUTO_INCREMENT ,
 `CustomerFirstName` varchar(40) NOT NULL ,
 `CustomerLastName`  varchar(45) NOT NULL ,
 `Phone`             varchar(20) NOT NULL ,
 `SIN`               varchar(45) NOT NULL ,
 `Address`           varchar(200) NOT NULL ,
 `Email`             varchar(80) NOT NULL ,
 `RoleID`            int NOT NULL ,

PRIMARY KEY (`UserID`),
UNIQUE KEY `AK1_Customer_CustomerName` (`CustomerFirstName`),
KEY `fkIdx_160` (`RoleID`),
CONSTRAINT `FK_160` FOREIGN KEY `fkIdx_160` (`RoleID`) REFERENCES `Role` (`RoleID`) ON DELETE CASCADE ON UPDATE CASCADE
) AUTO_INCREMENT=1 COMMENT='Basic information 
about Customer';






-- ************************************** `Education`

CREATE TABLE `Education`
(
 `EdID`   int NOT NULL AUTO_INCREMENT ,
 `Name`   varchar(45) NOT NULL ,
 `Point`  double NOT NULL ,
 `Leader` int NOT NULL ,

PRIMARY KEY (`EdID`),
KEY `fkIdx_163` (`Leader`),
CONSTRAINT `FK_163` FOREIGN KEY `fkIdx_163` (`Leader`) REFERENCES `User` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
);






-- ************************************** `Course`

CREATE TABLE `Course`
(
 `CourseID`   int NOT NULL AUTO_INCREMENT ,
 `CourseName` varchar(45) NOT NULL ,
 `StartDate`  date NOT NULL ,
 `EndDate`    date NOT NULL ,
 `Point`      double NOT NULL ,
 `EdID`       int NOT NULL ,
 `Teacher`    int NOT NULL ,

PRIMARY KEY (`CourseID`),
KEY `fkIdx_154` (`EdID`),
CONSTRAINT `FK_154` FOREIGN KEY `fkIdx_154` (`EdID`) REFERENCES `Education` (`EdID`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `fkIdx_166` (`Teacher`),
CONSTRAINT `FK_166` FOREIGN KEY `fkIdx_166` (`Teacher`) REFERENCES `User` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
);






-- ************************************** `Class`

CREATE TABLE `Class`
(
 `ClassID`   int unsigned NOT NULL AUTO_INCREMENT ,
 `Name`      varchar(45) NOT NULL ,
 `StartDate` date NOT NULL ,
 `EndDate`   date NOT NULL ,
 `EdID`      int NOT NULL ,

PRIMARY KEY (`ClassID`),
KEY `fkIdx_151` (`EdID`),
CONSTRAINT `FK_151` FOREIGN KEY `fkIdx_151` (`EdID`) REFERENCES `Education` (`EdID`) ON DELETE CASCADE ON UPDATE CASCADE
);






-- ************************************** `Student`

CREATE TABLE `Student`
(
 `UserID`    int NOT NULL ,
 `StudentID` int NOT NULL AUTO_INCREMENT ,
 `ClassID`   int unsigned NOT NULL ,

PRIMARY KEY (`StudentID`),
KEY `fkIdx_187` (`UserID`),
CONSTRAINT `FK_187` FOREIGN KEY `fkIdx_187` (`UserID`) REFERENCES `User` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `fkIdx_190` (`ClassID`),
CONSTRAINT `FK_190` FOREIGN KEY `fkIdx_190` (`ClassID`) REFERENCES `Class` (`ClassID`) ON DELETE CASCADE ON UPDATE CASCADE
);






-- ************************************** `Lecture`

CREATE TABLE `Lecture`
(
 `LectureID` int NOT NULL AUTO_INCREMENT ,
 `Date`      date NOT NULL ,
 `CourseID`  int NOT NULL ,

PRIMARY KEY (`LectureID`),
KEY `fkIdx_204` (`CourseID`),
CONSTRAINT `FK_204` FOREIGN KEY `fkIdx_204` (`CourseID`) REFERENCES `Course` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE
);






-- ************************************** `Attendance`

CREATE TABLE `Attendance`
(
 `Status`    varchar(45) NOT NULL ,
 `StudentID` int NOT NULL ,
 `LectureID` int NOT NULL ,

PRIMARY KEY (`Status`),
KEY `fkIdx_198` (`StudentID`),
CONSTRAINT `FK_198` FOREIGN KEY `fkIdx_198` (`StudentID`) REFERENCES `Student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE,
KEY `fkIdx_207` (`LectureID`),
CONSTRAINT `FK_207` FOREIGN KEY `fkIdx_207` (`LectureID`) REFERENCES `Lecture` (`LectureID`) ON DELETE CASCADE ON UPDATE CASCADE
);





