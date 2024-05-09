CREATE DATABASE library;
USE library;

CREATE TABLE book (
                      book_id INT PRIMARY KEY AUTO_INCREMENT,
                      book_name VARCHAR(255),
                      author VARCHAR(255),
                      description TEXT,
                      quantity INT
);

CREATE TABLE student (
                         student_id INT PRIMARY KEY AUTO_INCREMENT,
                         full_name VARCHAR(255),
                         class VARCHAR(50)
);

CREATE TABLE borrow_card (
                             borrow_id varchar(255) UNIQUE,
                             book_id INT,
                             student_id INT,
                             borrow_status BOOLEAN,
                             borrow_date DATE,
                             return_date DATE,
                             FOREIGN KEY (book_id) REFERENCES book(book_id),
                             FOREIGN KEY (student_id) REFERENCES student(student_id),
                             CONSTRAINT chk_return_date CHECK (return_date >= borrow_date)
);
-- Chèn dữ liệu vào bảng "book"
INSERT INTO book (book_name, author, description, quantity) VALUES
                                                                ('Book 1', 'Author 1', 'Description 1', 10),
                                                                ('Book 2', 'Author 2', 'Description 2', 8),
                                                                ('Book 3', 'Author 3', 'Description 3', 15),
                                                                ('Book 4', 'Author 4', 'Description 4', 20),
                                                                ('Book 5', 'Author 5', 'Description 5', 12);

-- Chèn dữ liệu vào bảng "student"
INSERT INTO student (full_name, class) VALUES
                                           ('Student 1', 'Class A'),
                                           ('Student 2', 'Class B'),
                                           ('Student 3', 'Class A'),
                                           ('Student 4', 'Class C'),
                                           ('Student 5', 'Class B');

-- Chèn dữ liệu vào bảng "borrow_card"
INSERT INTO borrow_card (book_id, student_id, borrow_status, borrow_date, return_date) VALUES
                                                                                           (1, 1, TRUE, '2024-05-10', '2024-06-10'),
                                                                                           (2, 3, TRUE, '2024-05-11', '2024-06-11'),
                                                                                           (3, 2, TRUE, '2024-05-12', '2024-06-12'),
                                                                                           (4, 5, TRUE, '2024-05-13', '2024-06-13'),
                                                                                           (5, 4, TRUE, '2024-05-14', '2024-06-14');


