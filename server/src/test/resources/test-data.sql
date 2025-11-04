BEGIN TRANSACTION;

-- Users
INSERT INTO users (username, password_hash, role, name, address, city, state_code, zip_code) VALUES ('user1', 'user1', 'ROLE_USER', 'User One', '123 Test Street', 'Testville', 'NY', '12345');
INSERT INTO users (username, password_hash, role, name, address, city, state_code, zip_code) VALUES ('user2', 'user2', 'ROLE_USER', 'User Two', '456 Test Street', 'Coolville', 'NY', '67899');
INSERT INTO users (username, password_hash, role, name, address, city, state_code, zip_code) VALUES ('user3', 'user3', 'ROLE_USER', 'User Three', '789 Test Street', 'Test Town', 'NY', '99876');

-- Movies
INSERT INTO movies (movie_id, title, release_date, overview, poster) VALUES (1, 'title1', '01-01-0101', 'Test1 Description', 'test-1.png');
INSERT INTO movies (movie_id, title, release_date, overview, poster) VALUES (2, 'title2', '02-02-0202', 'Test2 Description', 'test-2.png');
INSERT INTO movies (movie_id, title, release_date, overview, poster) VALUES (3, 'title3', '03-03-0303', 'Test3 Description', 'test-3.png');
INSERT INTO movies (movie_id, title, release_date, overview, poster) VALUES (4, 'title4', '04-04-0404', 'Test4 Description', 'test-4.png');

COMMIT;