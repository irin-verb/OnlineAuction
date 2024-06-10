SELECT * FROM V$SESSION;


/* Авторизация в системе */
UPDATE UserData
SET online_status = '1'
WHERE login = '?' AND blocking_status <> '1';

/* Деавторизация */
UPDATE UserData
SET online_status = '0'
WHERE login = '?';

/* Добавление нового пользователя */
INSERT INTO UserData(login, parole, type) VALUES ('?', '?', '?');

/* Удаление пользователя */
DELETE
FROM DealJournal
WHERE buyer = '?';

DELETE 
FROM DealJournal
WHERE product IN (
    SELECT id
    FROM ProductData
    WHERE seller = '?' AND (status = 'selling' OR status = 'removed'));

DELETE
FROM ProductData
WHERE seller = '?' AND (status = 'selling' OR status = 'removed');

UPDATE ProductData 
SET seller = NULL
WHERE seller = '?' AND status = 'sold';

DELETE 
FROM UserData
WHERE login = '?';

/* Редактирование данных пользователя */
UPDATE UserData
SET online_status = '0'
WHERE login = '?';

UPDATE UserData
SET blocking_status = '0'
WHERE login = '?';

UPDATE UserData
SET blocking_status = '1'
WHERE login = '?';

/* Блокировка пользователя */
UPDATE UserData
SET blocking_status = '1'
WHERE login = '?';

DELETE 
FROM DealJournal
WHERE buyer = '?' AND product IN (
    SELECT id
    FROM ProductData
    WHERE status = 'selling');
    
UPDATE ProductData
SET status = 'removed'
WHERE seller = '?' AND status = 'selling';

/* Разблокировка пользователя */
UPDATE UserData
SET blocking_status = '0'
WHERE login = '?';

/* Задание срока продажи всех лотов */
UPDATE ProductData
SET selling_interval = ?;

UPDATE ProductData
SET selling_date = creating_date + selling_interval;

UPDATE ProductData
SET status = 'sold'
WHERE bet_count <> 0 AND selling_date <= SYSDATE AND status = 'selling';

UPDATE ProductData
SET status = 'removed'
WHERE bet_count = 0 AND selling_date <= SYSDATE AND status = 'selling';

/* Задание срока продажи лота*/
UPDATE ProductData
SET selling_interval = ?
WHERE id = ?;

UPDATE ProductData
SET status = 'sold'
WHERE bet_count <> 0 AND selling_date <= SYSDATE AND status = 'selling' AND id = ?;

UPDATE ProductData
SET status = 'removed'
WHERE bet_count = 0 AND selling_date <= SYSDATE AND status = 'selling' AND id = ?;

/* Задание шага повышения цены всех лотов */
UPDATE ProductData
SET price_step = ?;

/* Залание шага повышения цены лота */
UPDATE ProductData
SET price_step = ?
WHERE id = ?;

/* Снятие лота с продажи */
UPDATE ProductData
SET status = 'removed'
WHERE id = ? AND status = 'selling';

/* Установка нового описания */
UPDATE ProductData
SET description = 'OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO'
WHERE id = 1;

/* РАБОТА С КОНСТАНТАМИ */

SELECT step
FROM PriceStepSetting;

SELECT interv
FROM SellingIntervalSetting;

DELETE
FROM PriceStepSetting;
INSERT INTO PriceStepSetting VALUES (?);
DELETE
FROM SellingIntervalSetting;
INSERT INTO SellingIntervalSetting VALUES (?);

/* Выставление лота на продажу */

INSERT INTO ProductData(name, description, category, start_price, price, price_step, 
    creating_date, selling_date, selling_interval, seller) VALUES
    ('?', '?', '?', ?,?, ?, 
    SYSDATE, SYSDATE + ?,
    ?, '?');
    
INSERT INTO ProductData(name, description, category, start_price, price, price_step, 
    creating_date, selling_date, selling_interval, seller) VALUES
    ('?', '?', '?', ?,?, (SELECT step FROM PriceStepSetting), 
    SYSDATE, SYSDATE + (SELECT interv FROM SellingIntervalSetting),
    (SELECT interv FROM SellingIntervalSetting), '?');

/* Повышение цены лота на определенный шаг (сделать ставку) */
UPDATE ProductData
SET bet_count = bet_count + 1
WHERE id = ?;

DELETE
FROM DealJournal
WHERE buyer = '?' AND product = ?;

INSERT INTO DealJournal(datetime,price,product,buyer) VALUES
(SYSDATE, (SELECT price FROM ProductData WHERE id = ?), ?, '?');

UPDATE ProductData
SET price = price + price_step
WHERE id = ?;

/* Редактирование данных лота */
UPDATE ProductData
SET description = '?'
WHERE id = ?;

/* Все пользователи*/
SELECT *
FROM UserData;

/* Все авторизованные пользователи */
SELECT *
FROM UserData
WHERE online_status = '1';

/* Все обычные пользователи */
SELECT *
FROM UserData
WHERE type = 'user';

/* Все администраторы */
SELECT *
FROM UserData
WHERE type = 'admin';

/* Все модераторы */
SELECT *
FROM UserData
WHERE type = 'moder';

SELECT *
FROM ProductCategory;

/* Все продающиеся товары по алфавиту */
SELECT *
FROM ProductData
WHERE Status = 'selling'
ORDER BY Name ASC;

/*Все продающиеся товары по алфавиту  */
SELECT *
FROM ProductData
WHERE Status = 'selling'
ORDER BY Name DESC;

/* Все продающиеся товары по дате продажи */
SELECT *
FROM ProductData
WHERE Status = 'selling'
ORDER BY Selling_date ASC;

/* Все продающиеся товары по дате продажи */
SELECT *
FROM ProductData
WHERE Status = 'selling'
ORDER BY Selling_date DESC;

/* Продающиеся товары по категориям */
SELECT *
FROM ProductData
WHERE category = '?' and status = 'selling';

/* "Горячие товары" */
SELECT *
FROM (
    SELECT *
    FROM ProductData
    ORDER BY bet_count DESC)
WHERE ROWNUM <= 5 and status = 'selling';

/* Продающиеся товары определенного пользователя 
или собственные выставленные на продажу товары */
SELECT *
FROM ProductData
WHERE status = 'selling' AND seller = '?';

/* Свои проданные товары */
SELECT *
FROM ProductData
WHERE status = 'sold' AND seller = '?';

/* Свои снятые с продажи товары */
SELECT *
FROM ProductData
WHERE status = 'removed' AND seller = '?';

/* Свои выигранные торги */
SELECT ProductData.id, ProductData.name, ProductData.description, d3.price as final_price
FROM ProductData JOIN 
    (SELECT d1.id, d1.buyer, d1.price, d2.*
    FROM (SELECT id, buyer, product, price
            FROM DealJournal) d1
            JOIN 
        (SELECT product, max(price) as mx_price
            FROM DealJournal
            GROUP BY product) d2
            ON d1.product = d2.product
    WHERE Buyer = '?' and price = mx_price) d3
    ON ProductData.id = d3.product
WHERE ProductData.status = 'sold';

/* Свои проигранные торги */
SELECT ProductData.id, ProductData.name, ProductData.description, d3.price, d3.mx_price as final_price
FROM ProductData JOIN 
    (SELECT d1.id, d1.buyer, d1.price, d2.*
    FROM (SELECT id, buyer, product, price
            FROM DealJournal) d1
            JOIN 
        (SELECT product, max(price) as mx_price
            FROM DealJournal
            GROUP BY product) d2
            ON d1.product = d2.product
    WHERE Buyer = '?' and price <> mx_price) d3
    ON ProductData.id = d3.product
WHERE ProductData.status = 'sold';

/* Собственные текущие торги, где пользователь выигрывает*/
SELECT ProductData.id, ProductData.name, ProductData.description, d3.price
FROM ProductData JOIN 
    (SELECT d1.id, d1.buyer, d1.price, d2.*
    FROM (SELECT id, buyer, product, price
            FROM DealJournal) d1
            JOIN 
        (SELECT product, max(price) as mx_price
            FROM DealJournal
            GROUP BY product) d2
            ON d1.product = d2.product
    WHERE Buyer = '?' and price = mx_price) d3
    ON ProductData.id = d3.product
WHERE ProductData.status = 'selling';

/* Собственные текущие торги, где пользователь проигрывает*/
SELECT ProductData.id, ProductData.name, ProductData.description, d3.price, d3.mx_price as current_price
FROM ProductData JOIN 
    (SELECT d1.id, d1.buyer, d1.price, d2.*
    FROM (SELECT id, buyer, product, price
            FROM DealJournal) d1
            JOIN 
        (SELECT product, max(price) as mx_price
            FROM DealJournal
            GROUP BY product) d2
            ON d1.product = d2.product
    WHERE Buyer = '?' and price <> mx_price) d3
    ON ProductData.id = d3.product
WHERE ProductData.status = 'selling';

