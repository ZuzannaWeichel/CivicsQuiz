delete from quiz;
SET GLOBAL time_zone = '+3:00';

insert into quiz (id, question, answer) values
(1,'What is the supreme law of the land?', 'the Constitution' ),
(2, 'What does the Constitution do?', 'sets up the government, defines the government, protects basic rights of Americans'),
(3, 'The idea of self-government is in the first three words of the Constitution. What are these words?', 'We the People'),
(4,'What is an amendment?', 'a change (to the Constitution), an addition (to the Constitution)' ),
(5,'What do we call the first ten amendments to the Constitution?', 'the Bill of Rights' );
