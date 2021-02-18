DROP TABLE IF EXISTS teacher;

CREATE TABLE teacher (
    id INT AUTO_INCREMENT NOT NULL,
    teacher_name VARCHAR(250) NOT NULL,
    teacher_surname VARCHAR(250) NOT NULL,
    teacher_email VARCHAR(250) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (teacher_email)
);

DROP TABLE IF EXISTS student;

CREATE TABLE student (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(250) NOT NULL,
    surname VARCHAR(250) NOT NULL,
    account_name VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    bank_card_number INT(16) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (account_name, email)
);

DROP TABLE IF EXISTS developer_course;

CREATE TABLE developer_course (
    id INT AUTO_INCREMENT NOT NULL,
    developer_course_name VARCHAR(250) NOT NULL,
    cost_per_class INT NOT NULL,
    classes_per_week INT NOT NULL,
    PRIMARY KEY (id),
    KEY developer_course_teacher_fk_idx (developer_course_teacher_fk)
);

DROP TABLE IF EXISTS teacher_developer_course;

CREATE TABLE teacher_developer_course (
    id INT AUTO_INCREMENT NOT NULL,
    developer_course_id INT NOT NULL,
    teacher_id INT NOT NULL,
    PRIMARY KEY (id),
    KEY teacher_developer_course_teacher_idx (teacher_id),
    KEY teacher_developer_course_developer_course_idx (developer_course_id),
    CONSTRAINT teacher_developer_course_teacher FOREIGN KEY (teacher_id) REFERENCES teacher (id),
    CONSTRAINT teacher_developer_course_developer_course FOREIGN KEY (developer_course_id) REFERENCES developer_course (id)
);

DROP TABLE IF EXISTS student_developer_course;

CREATE TABLE student_developer_course (
    id INT AUTO_INCREMENT NOT NULL,
    student_id INT NOT NULL,
    developer_course_id INT NOT NULL,
    classes_bought INT NOT NULL,
    PRIMARY KEY (id),
    KEY student_developer_course_student_idx (student_id),
    KEY student_developer_course_developer_course_idx (developer_course_id),
    CONSTRAINT student_developer_course_student FOREIGN KEY (student_id) REFERENCES student (id),
    CONSTRAINT student_developer_course_developer_course FOREIGN KEY (developer_course_id) REFERENCES developer_course (id)
);