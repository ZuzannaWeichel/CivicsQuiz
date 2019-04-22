CREATE DATABASE quiz_app;
SET GLOBAL time_zone = '+3:00';
CREATE USER 'civicsQuiz'@'localhost' IDENTIFIED WITH mysql_native_password BY 'usa';
GRANT ALL PRIVILEGES ON * . * TO 'civicsQuiz'@'localhost';
FLUSH PRIVILEGES;