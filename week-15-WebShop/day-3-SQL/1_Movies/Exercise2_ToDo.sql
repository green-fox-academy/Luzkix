CREATE DATABASE todos;
USE todos;

CREATE TABLE IF NOT EXISTS todos (
	id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    checked BOOLEAN DEFAULT FALSE,
    taskDescr TEXT NOT NULL,
    dateChecked DATE DEFAULT NULL
);

INSERT INTO todos (checked, taskDescr, DateChecked)
VALUES (true, "vynest kos", '20.5.2020'),
(false, "koupit kytku", null),
(false, "vysat dum", null ),
(false, "nakoupit jidlo", null ),
(true, "servis auta", '22.10.2020');

SELECT *
FROM todos;