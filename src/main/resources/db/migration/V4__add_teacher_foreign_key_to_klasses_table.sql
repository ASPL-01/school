ALTER TABLE klasses ADD teacher_id INT NOT NULL;
ALTER TABLE klasses ADD CONSTRAINT fk_teacher_id FOREIGN KEY (teacher_id) REFERENCES teachers(id);
