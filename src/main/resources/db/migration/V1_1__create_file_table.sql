CREATE TABLE IF NOT EXISTS `file` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `name` varchar(50) NOT NULL,
      `path` varchar(255) NOT NULL,
      `created` DATETIME,
      `updated` DATETIME,
      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;