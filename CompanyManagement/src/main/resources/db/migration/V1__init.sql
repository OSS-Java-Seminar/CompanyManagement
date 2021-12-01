CREATE TABLE `customer` (
  `id` binary(255) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `customer_name` varchar(35) NOT NULL,
  `oib` varchar(11) NOT NULL,
  `surname` varchar(35) NOT NULL,
  `telephone` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_l2ogjn7rtd593vcqwv9iiiq36` (`oib`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employee` (
  `id` binary(255) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `employee_name` varchar(35) NOT NULL,
  `oib` bigint NOT NULL,
  `role_id` binary(255) NOT NULL,
  `surname` varchar(35) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_adt071h11ghatxmmab811qea6` (`oib`),
  UNIQUE KEY `UK_ecp6mhmclfffyqi9eet1cb59b` (`role_id`),
  CONSTRAINT `FK3046kvjyysq288vy3lsbtc9nw` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `invoice` (
  `id` binary(255) NOT NULL,
  `customer_id` binary(255) NOT NULL,
  `date_of_issue` varchar(23) NOT NULL,
  `discount` float DEFAULT NULL,
  `due_date` varchar(23) NOT NULL,
  `employee_id` binary(255) NOT NULL,
  `invoice_number` int NOT NULL,
  `payment_method` varchar(15) NOT NULL,
  `payment_status` varchar(10) NOT NULL,
  `total_amount` float NOT NULL,
  `vat` float NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_t6xkdjx1qtd5whp2iljdfn2yj` (`invoice_number`),
  KEY `FK5e32ukwo9uknwhylogvta4po6` (`customer_id`),
  KEY `FKau92vqwrrlsflir3v65262ucw` (`employee_id`),
  CONSTRAINT `FK5e32ukwo9uknwhylogvta4po6` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKau92vqwrrlsflir3v65262ucw` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `invoice_items` (
  `invoice_id` binary(255) NOT NULL,
  `items_id` binary(255) NOT NULL,
  PRIMARY KEY (`invoice_id`,`items_id`),
  KEY `FK6h5w8eu8c10arxcag7sc27yh0` (`items_id`),
  CONSTRAINT `FK6h5w8eu8c10arxcag7sc27yh0` FOREIGN KEY (`items_id`) REFERENCES `item` (`id`),
  CONSTRAINT `FKoxy5jo4jluo0w69ncg5tsitn4` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `item` (
  `id` binary(255) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `item_invoices` (
  `item_id` binary(255) NOT NULL,
  `invoices_id` binary(255) NOT NULL,
  PRIMARY KEY (`item_id`,`invoices_id`),
  KEY `FKpk9jl0304q1o3nt89accbwuum` (`invoices_id`),
  CONSTRAINT `FKg2ju45kh9ciws3bbo7tnk0mx1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  CONSTRAINT `FKpk9jl0304q1o3nt89accbwuum` FOREIGN KEY (`invoices_id`) REFERENCES `invoice` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `role` (
  `id` binary(255) NOT NULL,
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iubw515ff0ugtm28p8g3myt0h` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;