CREATE DATABASE comp;
USE comp;

Create Table Shopping_cart(
CartID varchar(20) NOT NULL,
ProductQuantity int(3) NOT NULL,
ProductPrice varchar(10) NOT NULL,
TotalPrice varchar(45) DEFAULT NULL);
insert into Shopping_cart values('C001','1','300',ProductQuantity*ProductPrice);
insert into Shopping_cart values('C002','2','100',ProductQuantity*ProductPrice);
insert into Shopping_cart values('C003','15','10',ProductQuantity*ProductPrice);
insert into Shopping_cart values('C004','1','2000',ProductQuantity*ProductPrice);
insert into Shopping_cart values('C005','2','270',ProductQuantity*ProductPrice);
insert into Shopping_cart values('C006','1','800',ProductQuantity*ProductPrice);
insert into Shopping_cart values('C007','20','3',ProductQuantity*ProductPrice);
insert into Shopping_cart values('C008','5','20',ProductQuantity*ProductPrice);
insert into Shopping_cart values('C009','1','175',ProductQuantity*ProductPrice);
insert into Shopping_cart values('C010','2','50',ProductQuantity*ProductPrice);


Create Table Administrator(
 `adminID` varchar(20) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `emailA` varchar(20) NOT NULL,
  `PasswordA` varchar(20) NOT NULL,
  PRIMARY KEY (`adminID`)
);
insert into Administrator values('51128d','ZHANG Dawen','335338@gmail.com','51128');
insert into Administrator values('51129d','ZHANG Daqiang','335339@gmail.com','51129');
insert into Administrator values('51130d','LI Dawen','335340@gmail.com','51130');
insert into Administrator values('51131d','WANG Xiaomei','335341@gmail.com','51131');
insert into Administrator values('51132d','LIU Ping','335342@gmail.com','51132');
insert into Administrator values('51133d','LI Wen','335343@gmail.com','51133');
insert into Administrator values('51134d','WANG Ping','335344@gmail.com','51134');
insert into Administrator values('51135d','ZHAO Lei','335345@gmail.com','51135');
insert into Administrator values('51136d','SUN Hongli','335346@gmail.com','51136');
insert into Administrator values('51137d','WANG Lili','335347@gmail.com','51137');

CREATE TABLE Inventories(
  `InventoryID` varchar(20) NOT NULL,
  `stocklevel` int NOT NULL,
  `productCategory` varchar(45) NOT NULL,
  PRIMARY KEY (`InventoryID`)
) ;
insert into Inventories values('S001','1','clothes');
insert into Inventories values('S002','2','fruits');
insert into Inventories values('S003','2','clothes');
insert into Inventories values('S004','3','stationary');
insert into Inventories values('S005','2','fruits');
insert into Inventories values('S006','1','fruits');
insert into Inventories values('S007','1','toys');
insert into Inventories values('S008','2','stationary');
insert into Inventories values('S009','3','clothes');
insert into Inventories values('S010','1','toys');

CREATE TABLE Customer_supports(
  `supportID` varchar(20) NOT NULL,
  `issueState` varchar(20) NOT NULL,
  `createDate` date NOT NULL,
  `issue` varchar(45) NOT NULL,
  PRIMARY KEY (`supportID`)
);
insert into Customer_supports values('A123','Progressing',DATE'2023-1-1','1');
insert into Customer_supports values('A124','Complete',DATE'2023-1-15','4');
insert into Customer_supports values('A125','Complete',DATE'2023-2-19','4');
insert into Customer_supports values('A126','Progressing',DATE'2023-3-3','6');
insert into Customer_supports values('A127','Complete',DATE'2023-4-1','5');
insert into Customer_supports values('A128','Complete',DATE'2023-4-5','3');
insert into Customer_supports values('A129','Progressing',DATE'2023-5-10','5');
insert into Customer_supports values('A130','Progressing',DATE'2023-5-15','5');
insert into Customer_supports values('A131','Complete',DATE'2023-6-9','9');
insert into Customer_supports values('A132','Complete',DATE'2023-6-23','4');

CREATE TABLE Order_tracking(
  `trackingID` varchar(20) NOT NULL,
  `trackingStatus` varchar(45) NOT NULL,
  `updateDate` varchar(45) NOT NULL,
  PRIMARY KEY (`trackingID`)
);
insert into Order_tracking values('T001','The express has been delivered',DATE'2023-11-15');
insert into Order_tracking values('T002','The express has been delivered',DATE'2023-11-19');
insert into Order_tracking values('T003','The express has been delivered',DATE'2023-11-20');
insert into Order_tracking values('T004','The express has been delivered',DATE'2023-11-21');
insert into Order_tracking values('T005','The express is in transit',DATE'2023-11-23');
insert into Order_tracking values('T006','The express is in transit',DATE'2023-11-23');
insert into Order_tracking values('T007','The express is in transit',DATE'2023-11-24');
insert into Order_tracking values('T008','The express is in transit',DATE'2023-11-25');
insert into Order_tracking values('T009','The express not delivered',DATE'2023-11-26');
insert into Order_tracking values('T010','The express not delivered',DATE'2023-11-27');

CREATE TABLE User_Account(
  `UserID` varchar(20) NOT NULL,
  `PasswordA` varchar(20) NOT NULL,
  `JoinDate` date NOT NULL,
  `FirstName` varchar(10) NOT NULL,
  `LastName` varchar(10) NOT NULL,
  `Email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`UserID`));
insert into User_Account values('111111','123456',DATE'2023-1-1', 'Yifan','Qi','123456789@gmail.com');
insert into User_Account values('111112','123457',DATE'2023-1-2', 'Ruojia', 'Zhu','123456788@gmail.com');
insert into User_Account values('111113','123458',DATE'2023-1-2','Yuhan','Hu','123456787@gmail.com');
insert into User_Account values('111114','123459',DATE'2023-1-3','Si','Li','123456786@gmail.com');
insert into User_Account values('111115','123460',DATE'2023-1-4','San','Zhang','123456785@gmail.com');
insert into User_Account values('111116','123461',DATE'2023-1-5','Wu','Wang','123456784@gmail.com');
insert into User_Account values('111117','1234562',DATE'2023-3-18','Mei','Xiao','12345683@gmail.com');
insert into User_Account values('111118','1234563',DATE'2023-3-20','Qiang','Xiao','123456782@gmail.com');
insert into User_Account values('111119','1234564',DATE'2023-3-23','Hong','Xiao','123456781@gmail.com');
insert into User_Account values('111120','1234565',DATE'2023-4-1','Lihong','Wang','123456780@gmail.com');

CREATE TABLE Products (
  `ProductID` varchar(20) NOT NULL,
  `Specification` varchar(45) NOT NULL,
  `ProductName` varchar(45) NOT NULL,
  `Reviews` varchar(45) NOT NULL,
  `Category` varchar(45) NOT NULL,
  `Price` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`ProductID`));
insert into Products values('P1','s','A1003','4.4/5','Clothes','$300','Spring clothes');
insert into Products values('P2','m','A1004','4.5/5','Clothes','$400','Summer dress');
insert into Products values('P3','l','A1005','4.2/5','Clothes','$500','Autumn shirt');
insert into Products values('P4','m','A1006','3.5/5','Clothes','$600','Down jacket');
insert into Products values('P5','xl','A1007','4.0/5','Clothes','$250','trousers');
insert into Products values('P6','m','A1008','4.9/5','Clothes','$350','T-shirt');
insert into Products values('P7','l','A1009','4.5/5','Clothes','$450','shirt');
insert into Products values('P8','s','A1010','4.6/5','Clothes','$500','trousers');
insert into Products values('P9','xxl','A1011','3.9/5','Clothes','$350','coat');
insert into Products values('P10','m','A1012','4.4/5','Clothes','$450','dress');

CREATE TABLE Address (
  `RecipientName` varchar(45) NOT NULL,
  `Postal` int NOT NULL,
  `Country` varchar(20) NOT NULL,
  `State` varchar(20) NOT NULL,
  `City` varchar(45) NOT NULL,
  `Street` varchar(45) DEFAULT NULL
);
insert into Address values('A','75000','France','Europe','Paris','Rue de la Tour Eiffel');
insert into Address values('B','30290','France', 'Europe','Laudun','Rue du commerce');
insert into Address values('C','30200','France', 'Europe','Bagnols', 'Rue de la republique');
insert into Address values('D','99230','Hong Kong', 'Asia', 'Hong Kong', 'Nathan road');
insert into Address values('E','31000','France', 'Europe', 'Toulouse', 'Allee des sciences appliquees');
insert into Address values('F','26000','France', 'Europe', 'Valence', 'Rue Rabelais');
insert into Address values('G','38000','France', 'Europe', 'Grenoble', 'Rue Raoul Blanchard');
insert into Address values('H','34000','France', 'Europe', 'Montpellier', 'Rue Seigneurs');
insert into Address values('I','69000','France', 'Europe', 'Lyon', 'Boulevard de la Croix-Rousse');
insert into Address values('J','33000','France', 'Europe', 'Bordeaux', 'Rue Bradley');

CREATE TABLE Orders (
  `OrderID` int NOT NULL AUTO_INCREMENT,
  `Payment` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `OrderDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`OrderID`)
);
INSERT INTO orders VALUES ('01', 'Alipay', 'Paid', '2023-11-27');
INSERT INTO orders VALUES ('02', 'WeChat Pay', 'Pending', '2023-11-28');
INSERT INTO orders VALUES ('03', 'Credit Card', 'Paid', '2023-11-29');
INSERT INTO orders VALUES ('04','Alipay' , 'Pending', '2023-11-30');
INSERT INTO orders VALUES ('05', 'Alipay', 'Paid', '2023-12-01');
INSERT INTO orders VALUES ('06', 'PayPal', 'Paid', '2023-12-02');
INSERT INTO orders VALUES ('07', 'WeChat Pay', 'Paid', '2023-12-03');
INSERT INTO orders VALUES ('08', 'WeChat Pay', 'Paid', '2023-12-04');
INSERT INTO orders VALUES ('09', 'Alipay','Paid', '2023-12-05');
INSERT INTO orders VALUES ('10', 'Alipay', 'Paid', '2023-12-06');

CREATE TABLE Report(
ReportID varchar(10) NOT NULL,
ReportDate date NOT NULl);

insert into Report values('R100','2023-01-31');
insert into Report values('R101','2023-02-28');
insert into Report values('R102','2023-03-31');
insert into Report values('R103','2023-04-30');
insert into Report values('R104','2023-05-31');
insert into Report values('R105','2023-06-30');
insert into Report values('R106','2023-07-31');
insert into Report values('R107','2023-08-31');
insert into Report values('R108','2023-09-30');
insert into Report values('R109','2023-010-31');

CREATE TABLE Watchlist(
ListDate date NOT NULL);
insert into Watchlist values('2023-1-20');
insert into Watchlist values('2023-2-20');
insert into Watchlist values('2023-4-20');
insert into Watchlist values('2023-6-20');
insert into Watchlist values('2023-7-20');
insert into Watchlist values('2023-8-20');
insert into Watchlist values('2023-9-20');
insert into Watchlist values('2023-9-21');
insert into Watchlist values('2023-9-22');
insert into Watchlist values('2023-9-23');