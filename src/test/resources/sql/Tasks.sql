INSERT INTO Tasks (name, description, priority, date) VALUES ('Read book 1', 'Read Tom Soyer book 1', FLOOR(RAND() * 9999999), CAST( now() AS Date ));
INSERT INTO Tasks (name, description, priority, date) VALUES ('Read book 2', 'Read Tom Soyer book 2', FLOOR(RAND() * 9999999), CAST( now() - 1 AS Date ));
INSERT INTO Tasks (name, description, priority, date) VALUES ('Read book 3', 'Read Tom Soyer book 3', FLOOR(RAND() * 9999999), CAST( now() - 2 AS Date ));
INSERT INTO Tasks (name, description, priority, date) VALUES ('Read book 4', 'Read Tom Soyer book 4', FLOOR(RAND() * 9999999), CAST( now() - 3 AS Date ));
INSERT INTO Tasks (name, description, priority, date) VALUES ('Read book 5', 'Read Tom Soyer book 5', FLOOR(RAND() * 9999999), CAST( now() - 4 AS Date ));