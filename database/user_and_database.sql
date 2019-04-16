CREATE DATABASE quiz_app;
CREATE USER 'civicsQuiz'@'localhost' IDENTIFIED BY 'usa';
GRANT ALL PRIVILEGES ON * . * TO 'civicsQuiz'@'localhost';
FLUSH PRIVILEGES;