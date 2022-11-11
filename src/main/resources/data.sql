-- USERS

INSERT INTO app_user (id, name, username, password)
VALUES (1, 'umur inan', 'umur', '$2a$12$C9C80Iqlo1l1Z8bcEI3pve8c5lF0lMzgti9nrIDImiirv5m8JRRIm');

INSERT INTO app_user (id, name, username, password)
VALUES (2, 'john doe', 'john', '$2a$12$C9C80Iqlo1l1Z8bcEI3pve8c5lF0lMzgti9nrIDImiirv5m8JRRIm');

INSERT INTO app_user (id, name, username, password)
VALUES (3, 'muhyidean l-tarawneh', 'muhyidean', '$2a$12$C9C80Iqlo1l1Z8bcEI3pve8c5lF0lMzgti9nrIDImiirv5m8JRRIm');

INSERT INTO app_user (id, name, username, password)
VALUES (4, 'keith levi', 'keith', '$2a$12$C9C80Iqlo1l1Z8bcEI3pve8c5lF0lMzgti9nrIDImiirv5m8JRRIm');

INSERT INTO app_user (id, name, username, password)
VALUES (5, 'obinna kalu', 'obinna', '$2a$12$C9C80Iqlo1l1Z8bcEI3pve8c5lF0lMzgti9nrIDImiirv5m8JRRIm');

INSERT INTO app_user (id, name, username, password)
VALUES (6, 'tina xing', 'tina', '$2a$12$C9C80Iqlo1l1Z8bcEI3pve8c5lF0lMzgti9nrIDImiirv5m8JRRIm');



-- POSTS

INSERT INTO post (id, title, content, user_id)
VALUES (1, 'Lizards of Louisiana', 'Yere a lizard larry1', 1);

INSERT INTO post (id, title, content, user_id)
VALUES (2, 'Lizards of Louisiana', 'Yere a lizard larry2', 2);

INSERT INTO post (id, title, content, user_id)
VALUES (3, 'Lizards of Louisiana', 'Yere a lizard larry3', 3);



INSERT INTO post (id, title, content, user_id)
VALUES (4, 'Some Awedome title', 'If a body catch a body coming through the rye1', 1);

INSERT INTO post (id, title, content, user_id)
VALUES (5, 'Some Awedome title', 'If a body catch a body coming through the rye2', 2);

INSERT INTO post (id, title, content, user_id)
VALUES (6, 'Some Awedome title', 'If a body catch a body coming through the rye3', 3);



INSERT INTO post (id, title, content, user_id)
VALUES (7, 'it is because', 'I yam byatman1', 1);

INSERT INTO post (id, title, content, user_id)
VALUES (8, 'it is because', 'I yam byatman2', 2);

INSERT INTO post (id, title, content, user_id)
VALUES (9, 'it is because', 'I yam byatman3', 3);






INSERT INTO comment (id, name, post_id)
VALUES (1, 'THIS IS MY AWESOME COMMENT', 2);


INSERT INTO comment (id, name, post_id)
VALUES (2, 'Another Comment on the awesome content', 2);


INSERT INTO comment (id, name, post_id)
VALUES (3, 'What??? Third comment??', 2);


