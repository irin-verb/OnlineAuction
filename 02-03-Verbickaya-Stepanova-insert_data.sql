/* «аполнение таблиц с константами */

INSERT INTO PriceStepSetting VALUES (50);
INSERT INTO SellingIntervalSetting VALUES (120);


/* «аполнение таблицы с типами пользователей */

INSERT INTO UserType VALUES ('user');
INSERT INTO UserType VALUES ('admin');
INSERT INTO UserType VALUES ('moder');


/* «аполнение  таблицы с данными пользователей */

INSERT INTO UserData(login) VALUES ('red_pepper');
INSERT INTO UserData(login, blocking_status) VALUES ('blue_sky', 1);
INSERT INTO UserData(login) VALUES ('green_glass');
INSERT INTO UserData(login) VALUES ('pink_cloud');
INSERT INTO UserData(login) VALUES ('white_rabbit');
INSERT INTO UserData(login) VALUES ('black_swan');
INSERT INTO UserData(login, type) VALUES ('Blue_moon', 'moder');
INSERT INTO UserData(login, type) VALUES ('Blue_sea', 'moder');
INSERT INTO UserData(login, type) VALUES ('DARK_HORSE', 'admin');
INSERT INTO UserData(login, type) VALUES ('DARK_GLOOM', 'admin');


/* «аполнение таблицы с категори€ми товаров */ 

INSERT INTO ProductCategory VALUES ('Food');
INSERT INTO ProductCategory VALUES ('Art');
INSERT INTO ProductCategory VALUES ('Household chemicals');
INSERT INTO ProductCategory VALUES ('Electronics');
INSERT INTO ProductCategory VALUES ('Furniture');
INSERT INTO ProductCategory VALUES ('Beauty and health');
INSERT INTO ProductCategory VALUES ('Music');
INSERT INTO ProductCategory VALUES ('Other');


/* «аполнение таблицы со статусами товаров */

INSERT INTO ProductStatus VALUES ('selling');
INSERT INTO ProductStatus VALUES ('sold');
INSERT INTO ProductStatus VALUES ('removed');


/* «аполнение таблицы с данными товаров */

INSERT INTO ProductData(name, description, category, start_price, price, price_step, 
    bet_count, creating_date, selling_date, selling_interval, status, seller) VALUES
    ('Gusli', 'We found these wonderful harps in the attic', 'Music', 250,600,50,7, 
    TO_DATE('2023.09.28', 'yyyy.mm.dd'), TO_DATE('2024.01.30', 'yyyy.mm.dd'), 124, 'selling', 'green_glass');
    
INSERT INTO ProductData(name, description, category, start_price, price, price_step, 
    bet_count, creating_date, selling_date, selling_interval, status, seller) VALUES
    ('Portrait of Lyudmila Petrovna', 'Portrait of an unknown teacher found at a flea market', 'Art', 1000,1500,100,5,
    TO_DATE('2023.09.28', 'yyyy.mm.dd'), TO_DATE('2024.01.30', 'yyyy.mm.dd'), 124, 'selling', 'red_pepper');
    
INSERT INTO ProductData(name, description, category, start_price, price, price_step, 
    bet_count, creating_date, selling_date, selling_interval, status, seller) VALUES
    ('Portrait of Vitaly Vitalievich', 'Portrait rescued from a pack of dogs in Anapa', 'Art', 1000,1500,100,5,
    TO_DATE('2023.09.28', 'yyyy.mm.dd'), TO_DATE('2023.10.10', 'yyyy.mm.dd'), 12, 'sold', 'red_pepper');
    
INSERT INTO ProductData(name, description, category, start_price, price, price_step, 
    bet_count, creating_date, selling_date, selling_interval, status, seller) VALUES
    ('Portrait of Alexander Alexandrovich', 'Portrait purchased from a city madwoman in Rybinsk', 'Art', 1000,1500,100,5,
    TO_DATE('2023.09.28', 'yyyy.mm.dd'), TO_DATE('2023.10.10', 'yyyy.mm.dd'), 12, 'sold', 'red_pepper');
    
INSERT INTO ProductData(name, description, category, start_price, price, price_step, 
    bet_count, creating_date, selling_date, selling_interval, status, seller) VALUES
    ('Music box with Shrek', 'The box plays the song "All star" by the group "Smash Mouth"', 'Music', 250,250,50,0,
    TO_DATE('2023.09.28', 'yyyy.mm.dd'), TO_DATE('2023.10.10', 'yyyy.mm.dd'), 12, 'removed', 'green_glass');
    
INSERT INTO ProductData(name, description, category, start_price, price, price_step, 
    bet_count, creating_date, selling_date, selling_interval, status, seller) VALUES
    ('20th century canned food', 'Bon appetit!', 'Food', 50,100,50,1,
    TO_DATE('2023.09.28', 'yyyy.mm.dd'), TO_DATE('2024.01.30', 'yyyy.mm.dd'), 124, 'removed', 'blue_sky');


/* «аполнение таблицы с данными о сделках */

INSERT INTO DealJournal(datetime, price, product, buyer) VALUES
(TO_DATE('2023.09.28 14:00', 'yyyy.mm.dd hh24:mi'), 450, 1, 'red_pepper');
INSERT INTO DealJournal(datetime,price,product,buyer) VALUES
(TO_DATE('2023.09.28 15:30', 'yyyy.mm.dd hh24:mi'), 500, 1, 'white_rabbit');
INSERT INTO DealJournal(datetime,price,product,buyer) VALUES
(TO_DATE('2023.09.29 12:00', 'yyyy.mm.dd hh24:mi'), 550, 1, 'black_swan');

INSERT INTO DealJournal(datetime,price,product,buyer) VALUES
(TO_DATE('2023.09.30 12:00', 'yyyy.mm.dd hh24:mi'), 1300, 2, 'black_swan');
INSERT INTO DealJournal(datetime,price,product,buyer) VALUES
(TO_DATE('2023.09.30 12:30', 'yyyy.mm.dd hh24:mi'), 1400, 2, 'white_rabbit');

INSERT INTO DealJournal(datetime,price,product,buyer) VALUES
(TO_DATE('2023.09.28 12:00', 'yyyy.mm.dd hh24:mi'), 1200, 3, 'pink_cloud');
INSERT INTO DealJournal(datetime,price,product,buyer) VALUES
(TO_DATE('2023.09.29 12:00', 'yyyy.mm.dd hh24:mi'), 1300, 3, 'white_rabbit');
INSERT INTO DealJournal(datetime,price,product,buyer) VALUES
(TO_DATE('2023.09.30 12:00', 'yyyy.mm.dd hh24:mi'), 1400, 3, 'black_swan');

INSERT INTO DealJournal(datetime,price,product,buyer) VALUES
(TO_DATE('2023.09.28 14:00', 'yyyy.mm.dd hh24:mi'), 1200, 4, 'pink_cloud');
INSERT INTO DealJournal(datetime,price,product,buyer) VALUES
(TO_DATE('2023.09.29 14:30', 'yyyy.mm.dd hh24:mi'), 1300, 4, 'black_swan');
INSERT INTO DealJournal(datetime,price,product,buyer) VALUES
(TO_DATE('2023.09.30 15:00', 'yyyy.mm.dd hh24:mi'), 1400, 4, 'white_rabbit');

