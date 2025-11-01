BEGIN TRANSACTION;

-- Movies
INSERT INTO movies (movie_id, title, genre, rating, release_date, description, cover_image) VALUES (1, 'title1', 'genre1', 'A', '01-01-0101', 'Test1 Description', 'test-1.png');
INSERT INTO movies (movie_id, title, genre, rating, release_date, description, cover_image) VALUES (2, 'title2', 'genre2', 'B', '02-02-0202', 'Test2 Description', 'test-2.png');
INSERT INTO movies (movie_id, title, genre, rating, release_date, description, cover_image) VALUES (3, 'title3', 'genre3', 'C', '03-03-0303', 'Test3 Description', 'test-3.png');
INSERT INTO movies (movie_id, title, genre, rating, release_date, description, cover_image) VALUES (4, 'title4', 'genre4', 'D', '04-04-0404', 'Test4 Description', 'test-4.png');

COMMIT;