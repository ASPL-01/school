INSERT INTO students (email) VALUES
  ('bob@aol.com'),
  ('sam@aol.com'),
  ('ace@aol.com');

INSERT INTO teachers (name, age, gender) VALUES
  ('Alice', 35, 'MALE'),
  ('Johnn', 21, 'FEMALE'),
  ('Timbr', 68, 'FEMALE');

INSERT INTO klasses (credits, department, fee, name, semester, teacher_id) VALUES
  (4, 'SCIENCE', 500.0, 'Physics 101', '2017-01-25 00:00:00', 1),
  (3, 'ENGINEERING', 550.0, 'Electrical Engineering 101', '2018-01-25 00:00:00', 2),
  (2, 'SCIENCE', 430.0, 'Calculus 101', '2019-01-25 00:00:00', 2);

INSERT INTO registrations (klass_id, student_id) VALUES
  (1, 1),
  (1, 2),
  (2, 1),
  (2, 2),
  (2, 3),
  (3, 1);
