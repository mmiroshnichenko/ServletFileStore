CREATE TABLE IF NOT EXISTS `event` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `userId` int(11) NOT NULL,
      `fileId` int(11) NOT NULL,
      `created` DATETIME NOT NULL,
      `type` enum('CREATE', 'UPDATE', 'DELETE') COLLATE utf8_unicode_ci NOT NULL DEFAULT 'CREATE',
      PRIMARY KEY (`id`),
      CONSTRAINT `event_user_fk` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
      CONSTRAINT `event_file_fk` FOREIGN KEY (`fileId`) REFERENCES `file` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;