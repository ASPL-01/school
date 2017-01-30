use schoolt;

set FOREIGN_KEY_CHECKS = 0;
truncate table students;
truncate table klasses;
set FOREIGN_KEY_CHECKS = 1;

insert into students (email) values
  ('aaa@aol.com'),
  ('bbb@aol.com'),
  ('ccc@aol.com'),
  ('ddd@aol.com');

insert into klasses (credits, department, fee, name, semester) values
  (4, 'SCIENCE', 500.0, 'Physics 101', '2017-01-25 00:00:00'),
  (3, 'ENGINEERING', 550.0, 'Electrical Engineering 101', '2018-01-25 00:00:00'),
  (2, 'SCIENCE', 430.0, 'Calculus 101', '2019-01-25 00:00:00');
