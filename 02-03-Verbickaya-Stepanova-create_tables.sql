/* Создание таблицы с константами */ 

CREATE TABLE PriceStepSetting(
    step int not null);
    
ALTER TABLE PriceStepSetting
ADD CONSTRAINT PK_step primary key (step);


CREATE TABLE SellingIntervalSetting(
    interv int not null);
    
ALTER TABLE SellingIntervalSetting
ADD CONSTRAINT PK_interv primary key (interv);


/* Создание таблицы с типами пользователей */

CREATE TABLE UserType(
	type varchar2(5 char) not null 
		check (type in ('user','admin','moder')));    

ALTER TABLE UserType
ADD CONSTRAINT PK_type primary key (type);


/* Создание  таблицы с данными пользователей */

CREATE TABLE UserData(
	login varchar2(15 char) not null,
	parole varchar2(15 char) default '1' not null,
	type varchar2(5 char) default 'user' not null,
	online_status varchar2(1 char) default '0' not null
        check (online_status in ('0', '1')),
	blocking_status varchar2(1 char) default '0' not null
        check (blocking_status in ('0', '1')));

ALTER TABLE UserData
ADD CONSTRAINT PK_login primary key (login);

ALTER TABLE UserData
ADD CONSTRAINT FK_User_UserType foreign key (type)
	references UserType(type);

    
/* Создание таблицы с категориями товаров */    
    
CREATE TABLE ProductCategory(
	category varchar2(20 char) not null
		check (category in ('Food','Art','Household chemicals','Electronics',
				'Furniture','Beauty and health','Music','Other')));		
    
ALTER TABLE ProductCategory
ADD CONSTRAINT PK_category primary key (category);


/* Создание таблицы со статусами товаров */

CREATE TABLE ProductStatus(
	status varchar2(7 char) not null
		check (status in ('selling','sold','removed')));
    
ALTER TABLE ProductStatus
ADD CONSTRAINT PK_status primary key (status);


/* Создание таблицы с данными товаров */

CREATE TABLE ProductData(
	id int generated always as identity(start with 1),
	name varchar2(40 char) not null,
	description varchar2(200 char),
	category varchar2(20 char) default 'Other' not null,
	start_price int not null,
	price int not null,
	price_step int not null,
	bet_count int default 0,
	creating_date date not null,
	selling_date date not null,
	selling_interval int not null,
	status varchar2(7 char) default 'selling' not null,
	seller varchar2(15 char));

ALTER TABLE ProductData
ADD CONSTRAINT PK_product_id primary key (id);

ALTER TABLE ProductData
ADD CONSTRAINT FK_Product_ProductCategory foreign key (category)
	references ProductCategory(category);

ALTER TABLE ProductData
ADD CONSTRAINT FK_Product_ProductStatus foreign key (status)
	references ProductStatus(status);

ALTER TABLE ProductData
ADD CONSTRAINT FK_Product_User foreign key (seller)
	references UserData(login);


/* Создание таблицы с данными о сделках */

CREATE TABLE DealJournal(
	id int generated always as identity(start with 1),
	datetime date not null, 
	price int not null,
	product int not null,
	buyer varchar(15));

ALTER TABLE DealJournal
ADD CONSTRAINT PK_deal_id primary key (id);

ALTER TABLE DealJournal
ADD CONSTRAINT FK_Deal_Product foreign key (product)
	references ProductData(id);

ALTER TABLE DealJournal
ADD CONSTRAINT FK_Deal_User foreign key (buyer)
	references UserData(login);

