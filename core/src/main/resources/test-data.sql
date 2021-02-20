INSERT INTO student(id, account_name, bank_card_number, email, name, password, surname) VALUES (99, 'first acc', 123456, 'jelena@gmail.com', 'jelena', 'ADM07LXL4KQ', 'surlan');
INSERT INTO student(id, account_name, bank_card_number, email, name, password, surname) VALUES (100, 'second acc', 234567, 'jovana@gmail.com', 'jovana', 'CJL27XOJ7RE', 'surlan');
INSERT INTO student(id, account_name, bank_card_number, email, name, password, surname) VALUES (101, 'third acc', 345678, 'milos@gmail.com', 'milos', 'SBZ18QGZ2UL', 'surlan');
INSERT INTO student(id, account_name, bank_card_number, email, name, password, surname) VALUES (102, 'fourth acc', 456789, 'marko@gmail.com', 'marko', 'QHU71WMR7MX', 'surlan');
INSERT INTO student(id, account_name, bank_card_number, email, name, password, surname) VALUES (103, 'fifth acc', 654321, 'milica@gmail.com', 'milica', 'GGN28NMW2AZ', 'surlan');

INSERT INTO teacher(id, teacher_email, teacher_name, teacher_surname) VALUES (99, 'sandra@gmail.com', 'sandra', 'surlan');
INSERT INTO teacher(id, teacher_email, teacher_name, teacher_surname) VALUES (100, 'snezana@gmail.com', 'snezana', 'surlan');
INSERT INTO teacher(id, teacher_email, teacher_name, teacher_surname) VALUES (101, 'matija@gmail.com', 'matija', 'surlan');
INSERT INTO teacher(id, teacher_email, teacher_name, teacher_surname) VALUES (102, 'dusan@gmail.com', 'dusan', 'surlan');
INSERT INTO teacher(id, teacher_email, teacher_name, teacher_surname) VALUES (103, 'sonja@gmail.com', 'sonja', 'surlan');

INSERT INTO developer_course(id, classes_per_week, cost_per_class, developer_course_name) VALUES (99, 2, 20, 'Android kurs');
INSERT INTO developer_course(id, classes_per_week, cost_per_class, developer_course_name) VALUES (100, 3, 120, 'Angular kurs');
INSERT INTO developer_course(id, classes_per_week, cost_per_class, developer_course_name) VALUES (101, 2, 28, 'Java kurs');
INSERT INTO developer_course(id, classes_per_week, cost_per_class, developer_course_name) VALUES (102, 1, 25, 'Spring kurs');
INSERT INTO developer_course(id, classes_per_week, cost_per_class, developer_course_name) VALUES (103, 2, 50, 'iOS kurs');
INSERT INTO developer_course(id, classes_per_week, cost_per_class, developer_course_name) VALUES (104, 2, 20, 'Python kurs');
INSERT INTO developer_course(id, classes_per_week, cost_per_class, developer_course_name) VALUES (105, 3, 50, '.NET kurs');

-- student with id 1
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (101, 2, 99, 99);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (102, 3, 100, 99);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (103, 1, 101, 99);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (104, 1, 102, 9);

-- student with id 2
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (105, 1, 99, 100);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (106, 1, 100, 100);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (107, 1, 101, 100);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (108, 1, 102, 100);

-- student with id 3
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (109, 1, 99, 101);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (110, 1, 100, 101);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (111, 1, 101, 101);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (112, 1, 102, 101);

-- student with id 4
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (113, 1, 100, 102);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (114, 1, 101, 102);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (115, 1, 102, 102);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (116, 1, 103, 102);


-- student with id 5
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (117, 1, 99, 103);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (118, 2, 100, 103);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (119, 3, 101, 103);
INSERT INTO student_developer_course(id, classes_bought, developer_course_id, student_id) VALUES (120, 3, 102, 103);


-- teacher with id 1
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (101, 99, 99);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (102, 100, 99);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (103, 101, 99);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (104, 102, 99);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (105, 103, 99);


-- teacher with id 2
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (106, 99, 100);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (107, 100, 100);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (108, 101, 100);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (109, 102, 100);


-- teacher with id 3
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (110, 99, 101);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (111, 100, 101);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (112, 103, 101);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (113, 102, 101);


-- teacher with id 4
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (114, 100, 102);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (115, 101, 102);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (116, 102, 102);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (117, 103, 102);


-- teacher with id 5
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (118, 99, 103);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (119, 101, 103);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (120, 101, 103);
INSERT INTO public.teacher_developer_course(id, developer_course_id, teacher_id) VALUES (121, 102, 103);



