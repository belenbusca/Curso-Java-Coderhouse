DROP TABLE CLIENT IF EXISTS;
CREATE TABLE CLIENT(
    client_id INT NOT NULL PRIMARY KEY IDENTITY(1, 1),
    client_name VARCHAR(75) NOT NULL, 
    client_lastname VARCHAR(75) NOT NULL, 
    client_docnumber VARCHAR(11) NOT NULL 
);

DROP TABLE PRODUCT IF EXISTS;
CREATE TABLE PRODUCT(
    prod_id INT NOT NULL PRIMARY KEY IDENTITY(1, 1), 
    prod_description VARCHAR(150) NOT NULL,
    prod_code VARCHAR(50) NOT NULL,
    prod_stock INT NOT NULL,
    prod_price DOUBLE NOT NULL
);

DROP TABLE INVOICE IF EXISTS;
CREATE TABLE INVOICE(
    inv_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    inv_client_id INT NOT NULL,
    inv_created_at DATETIME NOT NULL,
    inv_total DOUBLE NOT NULL,
    CONSTRAINT fk_inv_client FOREIGN KEY (inv_client_id) REFERENCES client (client_id)
);

DROP TABLE INVOICE_DETAIL IF EXISTS;
CREATE TABLE INVOICE_DETAIL(
    inv_detail_id INT NOT NULL PRIMARY KEY IDENTITY(1,1),
    inv_detail_inv_id INT NOT NULL,
    inv_detail_amount INT NOT NULL,
    inv_detail_prod_id INT NOT NULL,
    inv_detail_price DOUBLE NOT NULL,
    CONSTRAINT fk_inv_detail_inv_id FOREIGN KEY (inv_detail_inv_id) REFERENCES invoice (inv_id),
    CONSTRAINT fk_inv_detail_prod_id FOREIGN KEY (inv_detail_prod_id) REFERENCES product (prod_id)
);