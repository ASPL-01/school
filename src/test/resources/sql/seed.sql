use schoolt;

set FOREIGN_KEY_CHECKS = 0;
truncate table students;
truncate table klasses;
truncate table teachers;
set FOREIGN_KEY_CHECKS = 1;

insert into students (email) values
  ('aaa@aol.com'),
  ('bbb@aol.com'),
  ('ccc@aol.com'),
  ('ddd@aol.com');

insert into teachers (name, age, gender) values
  ('t1', 35, 'MALE'),
  ('t2', 21, 'FEMALE'),
  ('t3', 68, 'FEMALE');

insert into klasses (credits, department, fee, name, semester, teacher_id) values
  (4, 'SCIENCE', 500.0, 'Physics 101', '2017-01-25 00:00:00', 1),
  (3, 'ENGINEERING', 550.0, 'Electrical Engineering 101', '2018-01-25 00:00:00', 2),
  (2, 'SCIENCE', 430.0, 'Calculus 101', '2019-01-25 00:00:00', 2);
