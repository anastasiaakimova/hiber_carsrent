create database car_service;

use car_service;

CREATE TABLE `car_service`.`client`
(

    `id`           INT          NOT NULL AUTO_INCREMENT,

    `first_name`   VARCHAR(120) NULL,

    `last_name`    VARCHAR(120) NULL,

    `password`     VARCHAR(120) NULL,

    `address`      VARCHAR(150) NULL,

    `phone_number` VARCHAR(120) NULL,

    PRIMARY KEY (`id`)
);

CREATE TABLE `car_service`.`manager`
(

    `id`           INT          NOT NULL AUTO_INCREMENT,

    `first_name`   VARCHAR(120) NULL,

    `last_name`    VARCHAR(120) NULL,

    `phone_number` VARCHAR(120) NULL,

    PRIMARY KEY (`id`)
);

CREATE TABLE `car_service`.`contract`
(

    `id`             INT           NOT NULL AUTO_INCREMENT,

    `car`            INT           NULL,
    `client`         INT           NULL,

    `manager`        INT           NULL,

    `date`           DATE          NULL,

    `amount_of_days` INT           NULL,

    `cost`           DECIMAL(7, 3) NULL,

    PRIMARY KEY (`id`)
);

CREATE TABLE `car_service`.`car`
(

    `id`           INT           NOT NULL AUTO_INCREMENT,

    `model`        VARCHAR(120)  NULL,

    `color`        VARCHAR(120)  NULL,

    `price`        DECIMAL(7, 3) NULL,

    `availability` TINYINT       NULL,

    PRIMARY KEY (`id`)
);

ALTER TABLE `car_service`.`contract`
    ADD CONSTRAINT `fk_manager`
        FOREIGN KEY (`manager`)
            REFERENCES `car_service`.`manager` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    ADD CONSTRAINT `fk_car`
        FOREIGN KEY (`car`)
            REFERENCES `car_service`.`car` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT `fk_client`
        FOREIGN KEY (`client`)
            REFERENCES `car_service`.`client` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

INSERT INTO `car_service`.`client` (`id`, `first_name`, `last_name`, `password`, `address`, `phone_number`)
VALUES ('1', 'Ника', 'Тарбеева', '1234', 'Московский 15', '+375297856423');
INSERT INTO `car_service`.`client` (`id`, `first_name`, `last_name`, `password`, `address`, `phone_number`)
VALUES ('2', 'Максим', 'Кулеш', '4567', 'Правды 45', '+812563423221');
INSERT INTO `car_service`.`client` (`id`, `first_name`, `last_name`, `password`, `address`, `phone_number`)
VALUES ('3', 'Кишкурная', 'Ангелина', '0987', 'Победы 45', '+512347867123');
