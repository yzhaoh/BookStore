/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/4/10 12:49:41                           */
/*==============================================================*/

/*    所有值0为“是”1为“否”，0为“男”1为“女”   */
/*    图书评价信息表（appraise）中星级（starlevel）字段值为1、2、3、4、5，评价等级字段（appraisegrade）好评为“3”，中评为“2”，差评为“1”   */


drop database if exists bookstore;

create database bookstore;

use bookstore;

/*==============================================================*/
/* Table: book                                                  */
/*==============================================================*/
create table book
(
   bookid               int not null auto_increment,
   categoryid           int not null,
   bookname             varchar(30) not null,
   author               varchar(30) not null,
   publisher            char(20) not null,
   publishdate          date not null,
   ISBN                 char(15) not null,
   fixedprice           float not null,
   currentprice         float not null,
   contentsummary       text not null,
   image                varchar(30) not null,
   primary key (bookid)
);

alter table book comment '图书信息表';

/*==============================================================*/
/* Table: bookappraise                                          */
/*==============================================================*/
create table bookappraise
(
   orderid              int not null,
   bookid               int not null,
   starlevel            int(1) not null,
   appraisegrade        int(1) not null,
   appraisecontent      varchar(200) not null default '好评！',
   mallanswer           varchar(200),
   appraisetime         datetime not null,
   primary key (orderid, bookid)
);

alter table bookappraise comment '图书评价信息表';

/*==============================================================*/
/* Table: bookcategory                                          */
/*==============================================================*/
create table bookcategory
(
   categoryid           int not null auto_increment,
   onecategory          varchar(20) not null,
   primary key (categoryid)
);

alter table bookcategory comment '图书分类表';

/*==============================================================*/
/* Table: bookcollection                                        */
/*==============================================================*/
create table bookcollection
(
   userid               int not null,
   bookid               int not null,
   primary key (userid, bookid)
);

alter table bookcollection comment '图书收藏表';

/*==============================================================*/
/* Table: booksales                                             */
/*==============================================================*/
create table booksales
(
   bookid               int not null,
   soldnumber           int not null,
   nownumber            int not null,
   salestime            datetime not null,
   primary key (bookid)
);

alter table booksales comment '图书销售表';

/*==============================================================*/
/* Table: deliveryaddress                                       */
/*==============================================================*/
create table deliveryaddress
(
   addressid            int not null auto_increment,
   userid               int not null,
   deliveryperson       varchar(20) not null,
   address              varchar(50) not null,
   postcode             char(6),
   phone                char(11) not null,
   defaultaddress       int(1) not null default 1,
   deleteorupdate		int(1) not null default 1,
   primary key (addressid)
);

alter table deliveryaddress comment '收货地址信息表';

/*==============================================================*/
/* Table: orderbasic                                            */
/*==============================================================*/
create table orderbasic
(
   orderid              int not null auto_increment,
   userid               int not null,
   addressid            int not null,
   orderdate            datetime not null,
   ispayed              int(1) not null,
   paymode              char(10) not null,
   totalprice           float not null,
   primary key (orderid)
);

alter table orderbasic comment '订单基本信息表';

/*==============================================================*/
/* Table: orderdetail                                           */
/*==============================================================*/
create table orderdetail
(
   orderid              int not null,
   bookid               int not null,
   number               int not null,
   primary key (bookid, orderid)
);

alter table orderdetail comment '订单详细信息表';

/*==============================================================*/
/* Table: shoppingcart                                          */
/*==============================================================*/
create table shoppingcart
(
   userid               int not null,
   bookid               int not null,
   number               int not null,
   primary key (userid, bookid)
);

alter table shoppingcart comment '购物车信息表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userid               int not null auto_increment,
   username             varchar(20) not null,
   password             varchar(32) not null,
   name                 char(5),
   sex                  int(1),
   email                varchar(80) not null,
   checkemail           int(1) not null,
   phone                char(11),
   icon                 varchar(30),
   address              varchar(50),
   nologin             int(1),
   primary key (userid)
);

alter table user comment '用户信息表';

alter table book add constraint FK_BookCategory_Book foreign key (categoryid)
      references bookcategory (categoryid) on delete cascade on update cascade;

alter table bookappraise add constraint FK_OrderBasic_BookAppraise foreign key (orderid)
      references orderbasic (orderid) on delete cascade on update cascade;

alter table bookappraise add constraint FK_Book_BookAppraise foreign key (bookid)
      references book (bookid) on delete cascade on update cascade;

alter table bookcollection add constraint FK_User_BookCollection foreign key (userid)
      references user (userid) on delete cascade on update cascade;

alter table bookcollection add constraint FK_Book_BookCollection foreign key (bookid)
      references book (bookid) on delete cascade on update cascade;

alter table booksales add constraint FK_Book_BookSales foreign key (bookid)
      references book (bookid) on delete cascade on update cascade;

alter table deliveryaddress add constraint FK_User_DeliveryAddress foreign key (userid)
      references user (userid) on delete cascade on update cascade;

alter table orderbasic add constraint FK_User_OrderBasic foreign key (userid)
      references user (userid) on delete cascade on update cascade;

alter table orderbasic add constraint FK_DeliveryAddress_OrderBasic foreign key (addressid)
      references deliveryaddress (addressid) on delete cascade on update cascade;

alter table orderdetail add constraint FK_Book_OrderDetail foreign key (bookid)
      references book (bookid) on delete cascade on update cascade;

alter table orderdetail add constraint FK_OrderBasic_OrderDetai foreign key (orderid)
      references orderbasic (orderid) on delete cascade on update cascade;

alter table shoppingcart add constraint FK_User_Shoppingcart foreign key (userid)
      references user (userid) on delete cascade on update cascade;

alter table shoppingcart add constraint FK_Book_ShoppingCart foreign key (bookid)
      references book (bookid) on delete cascade on update cascade;
      

alter table user add unique(username);
alter table user add unique(email);
alter table bookcategory add unique(onecategory);

/*==============================================================*/

insert into user values(null,'若水','dea6054465dbe9f7fb29945c58c01ac2','张明阳',0,'723413782@qq.com',1,'15515868088','ruoshui.jpg','河南省郑州市高新区科学大道166号',0);
insert into deliveryaddress values(null,1,'张明阳','郑州市高新区科学大道郑州轻工业学院','450001','15515868088',0,1);
insert into deliveryaddress values(null,1,'张明阳','郑州市金水区文化路大铺村','450003','15515868088',1,1);
insert into bookcategory values(null,'科技');
insert into bookcategory values(null,'文学');
insert into book values(null,1,'Java编程思想','[美] Bruce Eckel','机械工业出版社','2005-9-1','9787111162209',95.00,92.00,'本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。从本书获得的各项大奖以及来自世界各地的读者评论中，不难看出这是一本经典之作。本书的作者拥有多年教学经验，对C、C++以及Java语言都有独到、深入的见解，以通俗易懂及小而直接的示例解释了一个个晦涩抽象的概念。本书共22章，包括操作符、控制执行流程、访问权限控制、复用类、多态、接口、通过异常处理错误、字符串、泛型、数组、容器深入研究、Java I/O系统、枚举类型、并发以及图形化用户界面等内容。这些丰富的内容，包含了Java语言基础语法以及高级特性，适合各个层次的Java程序员阅读，同时也是高等院校讲授面向对象程序设计语言以及Java语言的绝佳教材和参考书。','book1.jpg');
insert into book values(null,1,'计算机程序设计艺术（第1卷）','[美] Donald E. Knuth','清华大学出版社','2002-9-1','9787302058144',80.00,80.00,'第1卷首先介绍编程的基本概念和技术，然后详细讲解信息结构方面的内容，包括信息在计算机内部的表示方法、数据元素之间的结构关系，以及有效的信息处理方法。此外，书中还描述了编程在模拟、数值方法、符号计算、软件与系统设计等方面的初级应用。此第3版增加了数十项简单但重要的算法和技术，并根据当前研究发展趋势在数学预备知识方面做了大量修改。','book2.jpg');
insert into book values(null,2,'围城','钱锺书','人民文学出版社','1991-2-1','9787020024759',19.00,18.80,'《围城》是钱钟书所著的长篇小说。第一版于1947年由上海晨光出版公司出版。1949年之后，由于政治等方面的原因，本书长期无法在中国大陆和台湾重印，仅在香港出现过盗印本。1980年由作者重新修订之后，在中国大陆地区由人民文学出版社刊印。此后作者又曾小幅修改过几次。《围城》自从出版以来，就受到许多人的推重。由于1949年后长期无法重印，这本书逐渐淡出人们的视野。1960年代，旅美汉学家夏志清在《中国现代小说史》(A History of Modern Chinese Fiction)中对本书作出很高的评价，这才重新引起人们对它的关注。人们对它的评价一般集中在两方面，幽默的语言和对生活深刻的观察。从1990年代开始，也有人提出对本书的不同看法，认为这是一部被“拔高”的小说，并不是一部出色的作品。很多人认为这是一部幽默作品。除了各具特色的人物语言之外，作者夹叙其间的文字也显着机智与幽默。这是本书的一大特色。也有人认为这是作者卖弄文字，语言显得尖酸刻薄。但这一说法并不为大多数人接受。','book3.jpg');
insert into shoppingcart values(1,1,2);
insert into shoppingcart values(1,2,5);
insert into bookcollection values(1,1);
insert into bookcollection values(1,2);
insert into booksales values(1,20,1350,'2015-2-1');
insert into booksales values(2,3,150,'2015-2-8');
insert into orderbasic values(null,1,1,'2015-4-8',0,'货到付款',200.3);
insert into orderbasic values(null,1,2,'2015-4-5',0,'在线支付',20.6);
insert into orderdetail values(1,1,2);
insert into orderdetail values(1,2,3);
insert into orderdetail values(2,2,12);
insert into bookappraise values(1,1,5,3,'很喜欢','欢迎您再次光临！','2015-05-04 14:28:35');
insert into bookappraise values(1,2,3,3,'一般般吧','欢迎您再次光临！','2015-4-15');
