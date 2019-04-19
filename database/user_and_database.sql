CREATE DATABASE quiz_app;
CREATE USER 'civicsQuiz'@'localhost' IDENTIFIED WITH mysql_native_password BY 'usa';
GRANT ALL PRIVILEGES ON * . * TO 'civicsQuiz'@'localhost';
FLUSH PRIVILEGES;