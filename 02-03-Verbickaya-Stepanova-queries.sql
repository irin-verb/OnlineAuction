SELECT * FROM V$SESSION;


/* ����������� � ������� */
UPDATE UserData
SET online_status = '1'
WHERE login = '?' AND blocking_status <> '1';

/* ������������� */
UPDATE UserData
SET online_status = '0'
WHERE login = '?';

/* ���������� ������ ������������ */
INSERT INTO UserData(login, parole, type) VALUES ('?', '?', '?');

/* �������� ������������ */
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

/* �������������� ������ ������������ */
UPDATE UserData
SET online_status = '0'
WHERE login = '?';

UPDATE UserData
SET blocking_status = '0'
WHERE login = '?';

UPDATE UserData
SET blocking_status = '1'
WHERE login = '?';

/* ���������� ������������ */
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

/* ������������� ������������ */
UPDATE UserData
SET blocking_status = '0'
WHERE login = '?';

/* ������� ����� ������� ���� ����� */
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

/* ������� ����� ������� ����*/
UPDATE ProductData
SET selling_interval = ?
WHERE id = ?;

UPDATE ProductData
SET status = 'sold'
WHERE bet_count <> 0 AND selling_date <= SYSDATE AND status = 'selling' AND id = ?;

UPDATE ProductData
SET status = 'removed'
WHERE bet_count = 0 AND selling_date <= SYSDATE AND status = 'selling' AND id = ?;

/* ������� ���� ��������� ���� ���� ����� */
UPDATE ProductData
SET price_step = ?;

/* ������� ���� ��������� ���� ���� */
UPDATE ProductData
SET price_step = ?
WHERE id = ?;

/* ������ ���� � ������� */
UPDATE ProductData
SET status = 'removed'
WHERE id = ? AND status = 'selling';

/* ��������� ������ �������� */
UPDATE ProductData
SET description = 'OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO'
WHERE id = 1;

/* ������ � ����������� */

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

/* ����������� ���� �� ������� */

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

/* ��������� ���� ���� �� ������������ ��� (������� ������) */
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

/* �������������� ������ ���� */
UPDATE ProductData
SET description = '?'
WHERE id = ?;

/* ��� ������������*/
SELECT *
FROM UserData;

/* ��� �������������� ������������ */
SELECT *
FROM UserData
WHERE online_status = '1';

/* ��� ������� ������������ */
SELECT *
FROM UserData
WHERE type = 'user';

/* ��� �������������� */
SELECT *
FROM UserData
WHERE type = 'admin';

/* ��� ���������� */
SELECT *
FROM UserData
WHERE type = 'moder';

SELECT *
FROM ProductCategory;

/* ��� ����������� ������ �� �������� */
SELECT *
FROM ProductData
WHERE Status = 'selling'
ORDER BY Name ASC;

/*��� ����������� ������ �� ��������  */
SELECT *
FROM ProductData
WHERE Status = 'selling'
ORDER BY Name DESC;

/* ��� ����������� ������ �� ���� ������� */
SELECT *
FROM ProductData
WHERE Status = 'selling'
ORDER BY Selling_date ASC;

/* ��� ����������� ������ �� ���� ������� */
SELECT *
FROM ProductData
WHERE Status = 'selling'
ORDER BY Selling_date DESC;

/* ����������� ������ �� ���������� */
SELECT *
FROM ProductData
WHERE category = '?' and status = 'selling';

/* "������� ������" */
SELECT *
FROM (
    SELECT *
    FROM ProductData
    ORDER BY bet_count DESC)
WHERE ROWNUM <= 5 and status = 'selling';

/* ����������� ������ ������������� ������������ 
��� ����������� ������������ �� ������� ������ */
SELECT *
FROM ProductData
WHERE status = 'selling' AND seller = '?';

/* ���� ��������� ������ */
SELECT *
FROM ProductData
WHERE status = 'sold' AND seller = '?';

/* ���� ������ � ������� ������ */
SELECT *
FROM ProductData
WHERE status = 'removed' AND seller = '?';

/* ���� ���������� ����� */
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

/* ���� ����������� ����� */
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

/* ����������� ������� �����, ��� ������������ ����������*/
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

/* ����������� ������� �����, ��� ������������ �����������*/
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

