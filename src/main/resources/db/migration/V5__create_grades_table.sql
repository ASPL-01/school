CREATE TABLE `grades` (
  `id`         INT            NOT NULL  AUTO_INCREMENT,
  `version`    INT            NOT NULL  DEFAULT 0,
  `value`      INT            NOT NULL  DEFAULT 0,
  `is_passing` BOOLEAN        NOT NULL  DEFAULT FALSE,
  `student_id` INT            NOT NULL,
  `klass_id`   INT            NOT NULL,
  `created`    TIMESTAMP      NOT NULL  DEFAULT NOW(),
  `modified`   TIMESTAMP      NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`),

  CONSTRAINT `fk_student_id`
  FOREIGN KEY (`student_id`)
  REFERENCES `students` (`id`),

  CONSTRAINT `fk_klass_id`
  FOREIGN KEY (`klass_id`)
  REFERENCES `klasses` (`id`));
