INSERT INTO CATEGORY(id, name) VALUES (1, 'Eurogames');
INSERT INTO CATEGORY(id, name) VALUES (2, 'Ameritrash');
INSERT INTO CATEGORY(id, name) VALUES (3, 'Familiar');

INSERT INTO AUTHOR(id, name, nationality) VALUES (1, 'Alan R. Moon', 'US');
INSERT INTO AUTHOR(id, name, nationality) VALUES (2, 'Vital Lacerda', 'PT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (3, 'Simone Luciani', 'IT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (4, 'Perepau Llistosella', 'ES');
INSERT INTO AUTHOR(id, name, nationality) VALUES (5, 'Michael Kiesling', 'DE');
INSERT INTO AUTHOR(id, name, nationality) VALUES (6, 'Phil Walker-Harding', 'US');
INSERT INTO AUTHOR(id, name, nationality) VALUES (7, 'Corey Konieczka', 'PL');

INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (1, 'On Mars', '14', 1, 2);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (2, 'Aventureros al tren', '8', 3, 1);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (3, '1920: Wall Street', '12', 1, 4);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (4, 'Barrage', '14', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (5, 'Los viajes de Marco Polo', '12', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (6, 'Azul', '8', 3, 5);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (7, 'Las Mansiones de La Locura', '13', 2, 7);

INSERT INTO CUSTOMER(id, name) VALUES (1, 'Pablo Fernández López');
INSERT INTO CUSTOMER(id, name) VALUES (2, 'Carlos Gómez Pérez');
INSERT INTO CUSTOMER(id, name) VALUES (3, 'Vicente Leal Backend');

INSERT INTO LOAN(id, game_id, customer_id, loan_date, end_date) VALUES (1, 1, 1, '2016-01-02', '2016-01-17');
INSERT INTO LOAN(id, game_id, customer_id, loan_date, end_date) VALUES (2, 7, 1, '2016-01-10', '2016-01-25');
INSERT INTO LOAN(id, game_id, customer_id, loan_date, end_date) VALUES (3, 4, 2, '2020-03-20', '2020-04-04');
INSERT INTO LOAN(id, game_id, customer_id, loan_date, end_date) VALUES (4, 2, 3, '2021-04-01', '2021-04-14');
INSERT INTO LOAN(id, game_id, customer_id, loan_date, end_date) VALUES (5, 3, 1, '2015-01-04', '2015-12-17');
INSERT INTO LOAN(id, game_id, customer_id, loan_date, end_date) VALUES (6, 1, 2, '2022-08-04', '2022-08-17');
