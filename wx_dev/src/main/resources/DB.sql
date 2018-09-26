create database wx_dev;
use wx_dev;
create table tbl_corpinfo(
id int primary key auto_increment,
corpid varchar(50) not null,
corpsecret varchar(50) not null,
corpname varchar(255) not null,
accesstoken varchar(512) not null,
createdate timestamp,
upddate datetime
);
create table tbl_customorganization(
id int primary key auto_increment,
corpid varchar(50) not null,
orgid int not null,
`name` varchar(255) not null,
parentid int not null,
`order` int
);
create table tbl_customuser(
id int primary key auto_increment,
corpid varchar(50) not null,
userid varchar(50) not null,
`name` varchar(255) not null,
department varchar(512) not null,
position varchar(255),
mobile varchar(50),
gender int,
email varchar(255),
weixinid varchar(255),
avatar varchar(255),
`status` int,
extattr varchar(255),
createdate timestamp,
upddate datetime
);

create table tbl_customuser(
id int primary key auto_increment,
corpid varchar(50) not null,
userid varchar(50) not null,
`name` varchar(255) not null,
department varchar(512) not null,
position varchar(255),
mobile varchar(50),
gender int,
email varchar(255),
weixinid varchar(255),
avatar varchar(255),
`status` int,
extattr varchar(255),
createdate timestamp,
upddate datetime
);
create table tbl_deptcsvdata(
id int primary key auto_increment,
cbu varchar(50) not null,
`code` varchar(50) not null,
`name` varchar(255) not null,
createdate timestamp,
upddate datetime
);
create table tbl_employeecsvdata(
id int primary key auto_increment,
`code` varchar(50) not null,
`name` varchar(255) not null,
ptcode varchar(50) not null,
servicestatus int not null,
oldcode varchar(50) not null,
createdate timestamp,
upddate datetime
);
create table tbl_mulitdata(
id int primary key auto_increment,
`count` varchar(50) not null,
mark varchar(255) not null
);
--------------------------------------------
CREATE TABLE `test_user` (
  `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `encryptiontype` varchar(50) NOT NULL,
  `mark` varchar(50) NOT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `upddate` datetime DEFAULT NULL
);
INSERT INTO `test_user` VALUES ('1', 'zzg', 'a8d4f2ae05a29e68ec05b3bf85ef5566', '周志刚', '15295621977', 'szzzg@126.com', '苏州工业园区', 'MD5', 'koc1koc2', '2017-11-10 16:01:22', null);