CREATE TABLE `klasses_students` (
 `klass_id`   INT            NOT NULL,
 `student_id` INT            NOT NULL,

 CONSTRAINT `fk_student_id1`
 FOREIGN KEY (`student_id`)
 REFERENCES `students` (`id`),

 CONSTRAINT `fk_klass_id1`
 FOREIGN KEY (`klass_id`)
 REFERENCES `klasses` (`id`));
