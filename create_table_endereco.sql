SELECT * FROM aulaweb.endereco;CREATE TABLE `endereco` (
  `id` int NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `pessoa_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pessoa_endereco_idx` (`pessoa_id`),
  CONSTRAINT `fk_pessoa_endereco` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;