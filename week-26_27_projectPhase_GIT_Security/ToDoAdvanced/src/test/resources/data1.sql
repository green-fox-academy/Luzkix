INSERT INTO todo_owner (id, password, login, role_id) VALUES (7, '$2a$10$foepraoNZXTt974aygcvkei6TRM..izWmu3deoZBlcpXpHwycWAPy', 'zdenek', 1);
INSERT INTO todo_owner (id, password, login, role_id) VALUES (2, '$2a$10$HYV0yjstVQR.c0EQUQY4S.8AJNkyUzl87F3E1VVw6aeY5d2G6nbC.', 'luzki', 1);
INSERT INTO todo_owner (id, password, login, role_id) VALUES (4, '$2a$10$Ip1CwmbBWUNANskmoqahrOhou/g/AWjLEo3UYyysNYgyuCjzAvd7m', 'luzkix', 2);
INSERT INTO todo_owner (id, password, login, role_id) VALUES (5, '$2a$10$7nt6YMWmX9mnduJKaxr.gOLlus1WbdkIRxrPx6ZV/Yn.eTB/q60va', 'petr', 2);
INSERT INTO todo_owner (id, password, login, role_id) VALUES (6, '$2a$10$ITJl0lrKQ7.5RmIKtiZDIeHwlFL0rxoZx5NpKeY5KPexRWrEf/dCC', 'ahmed', 2);

INSERT INTO todo (id, content, creation_date, due_date, title, urgent, completed, completition_date, owner_id) VALUES (1, 'Reinstall Windows', '2021-01-05', '2021-05-04', 'Repair PC', false, null, null, 7);
INSERT INTO todo (id, content, creation_date, due_date, title, urgent, completed, completition_date, owner_id) VALUES (2, 'Buy big house with 3 floors for good price', '2021-01-05', '2021-08-20', 'Buy house', true, null, null, 5);
INSERT INTO todo (id, content, creation_date, due_date, title, urgent, completed, completition_date, owner_id) VALUES (3, 'Call your mother', '2021-01-05', '2021-01-20', 'Call home', false, null, null, 2);
INSERT INTO todo (id, content, creation_date, due_date, title, urgent, completed, completition_date, owner_id) VALUES (4, 'Marry christmas letter to Jack', '2021-01-05', null, 'Send a letter', false, true, '2021-01-05', 5);
INSERT INTO todo (id, content, creation_date, due_date, title, urgent, completed, completition_date, owner_id) VALUES (26, 'Marry christmas letter to Jack', '2021-01-06', '2020-12-31', 'Send a letter', true, false, null, 4);
INSERT INTO todo (id, content, creation_date, due_date, title, urgent, completed, completition_date, owner_id) VALUES (27, 'Buy big house with 3 floors for good price', '2021-01-06', '2021-08-20', 'Buy house', true, false, null, 6);
INSERT INTO todo (id, content, creation_date, due_date, title, urgent, completed, completition_date, owner_id) VALUES (28, 'Buy big house with 3 floors for good price', '2021-01-06', '2021-08-20', 'Buy house', true, true, '2021-01-08', 6);
INSERT INTO todo (id, content, creation_date, due_date, title, urgent, completed, completition_date, owner_id) VALUES (30, 'Reinstall Windows and Office', '2021-01-06', '2021-06-22', 'Repair PC', true, true, '2021-01-05', 2);
INSERT INTO todo (id, content, creation_date, due_date, title, urgent, completed, completition_date, owner_id) VALUES (33, 'Reinstall Windows', '2021-01-06', null, 'updated title - Reinstall PC2', false, false, null, 7);
INSERT INTO todo (id, content, creation_date, due_date, title, urgent, completed, completition_date, owner_id) VALUES (34, 'Call your brother', '2021-01-06', '2021-01-20', 'Call brother', false, true, '2020-12-31', 4);
INSERT INTO todo (id, content, creation_date, due_date, title, urgent, completed, completition_date, owner_id) VALUES (36, 'apply token', '2021-01-12', '2021-01-13', 'Try bearer token', true, false, null, 2);
INSERT INTO todo (id, content, creation_date, due_date, title, urgent, completed, completition_date, owner_id) VALUES (38, 'apply token', '2021-01-13', '2021-01-13', 'Try bearer token', true, false, null, 2);
INSERT INTO todo (id, content, creation_date, due_date, title, urgent, completed, completition_date, owner_id) VALUES (39, 'apply token', '2021-01-14', '2021-01-13', 'Test Todo', true, false, null, 2);
INSERT INTO todo (id, content, creation_date, due_date, title, urgent, completed, completition_date, owner_id) VALUES (40, 'apply token', '2021-01-14', '2021-01-13', 'Test Todo', true, false, null, 2);

INSERT INTO role_table (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role_table (id, name) VALUES (2, 'ROLE_USER');
