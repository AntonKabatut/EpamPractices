CREATE DATABASE Practice7;

CREATE TABLE Practice7.`users` (
  `id`    INT                     NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(33)
          CHARACTER SET utf8
          COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`login`)
)
  ENGINE = InnoDB;

CREATE TABLE Practice7.`groups` (
  `id`   INT                     NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(33)
         CHARACTER SET utf8
         COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`name`)
)
  ENGINE = InnoDB;

CREATE TABLE Practice7.`users_groups` (
  `user_id`  INT NOT NULL,
  `group_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `group_id`)
)
  ENGINE = InnoDB;


ALTER TABLE Practice7.`users_groups`
  ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;
ALTER TABLE Practice7.`users_groups`
  ADD FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;
