CREATE TABLE `klasses_students` (
  `student_id` INT            NOT NULL,
  `klass_id`   INT            NOT NULL,

  CONSTRAINT `fk_student_id1`
  FOREIGN KEY (`student_id`)
  REFERENCES `students` (`id`),

  CONSTRAINT `fk_klass_id1`
  FOREIGN KEY (`klass_id`)
  REFERENCES `klasses` (`id`));
