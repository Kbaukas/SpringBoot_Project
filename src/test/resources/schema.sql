--
CREATE SCHEMA IF NOT EXISTS `dienynas_test` DEFAULT CHARACTER SET utf8;
USE `dienynas_test`;

-- -----------------------------------------------------
-- Table `dienynas`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dienynas_test`.`products`
(
    `id`          INT          NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(100) NOT NULL,
    `description` TEXT         NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 17;

-- -----------------------------------------------------
-- Table `dienynas`.`stores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dienynas_test`.`stores`
(
    `id`      INT          NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(100) NOT NULL,
    `address` VARCHAR(200) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 9;


-- -----------------------------------------------------
-- Table `dienynas`.`products_in_stores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dienynas_test`.`products_in_stores`
(
    `product_id` INT            NOT NULL,
    `store_id`   INT            NOT NULL,
    `price`      DECIMAL(10, 2) NULL DEFAULT NULL,
    `quantity`   INT            NULL DEFAULT NULL
)
    ENGINE = InnoDB;



INSERT INTO dienynas_test.stores (name, address)
VALUES ('Maxima', 'Balbieriškis'),
       ('Rimi', 'Ariogala'),
       ('Iki', 'Babtai'),
       ('Aibė', 'Grikiškės'),
       ('Senukai', 'Garliava');
INSERT INTO dienynas_test.products(name, description)
VALUES ('Duona', NULL),
       ('Pienas', 'Ekologiškas pienas'),
       ('Sūris', NULL),
       ('Varškė', NULL),
       ('Alus', NULL),
       ('Vanduo', NULL),
       ('Dešra', NULL),
       ('Skilandis', NULL),
       ('Salotos', NULL);
INSERT INTO dienynas_test.products_in_stores(product_id, store_id, price, quantity)
VALUES (1, 2, 2.50, 2),
       (2, 2, 2.00, 5),
       (1, 3, 1.50, 4),
       (2, 3, 0.50, 3),
       (3, 3, 3.50, 1),
       (1, 4, 1.50, 2),
       (2, 4, 2.50, 2),
       (3, 4, 3.50, 1),
       (4, 4, 5.50, 1),
       (5, 4, 4.50, 1),
       (6, 4, 6.50, 1),
       (6, 5, 5.50, 2),
       (7, 5, 3.50, 4);