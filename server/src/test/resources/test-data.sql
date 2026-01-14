-- data test
BEGIN TRANSACTION;

-- *************************************************************************************************
-- Insert test data
-- *************************************************************************************************

-- movies
INSERT INTO movies (movie_id, title, release_date, overview, poster_path) VALUES (1, 'movie1', '0001-01-01', 'movie1 description', 'movie-1.png');
INSERT INTO movies (movie_id, title, release_date, overview, poster_path) VALUES (2, 'movie2', '0002-02-02', 'movie2 description', 'movie-2.png');
INSERT INTO movies (movie_id, title, release_date, overview, poster_path) VALUES (3, 'movie3', '0003-03-03', 'movie3 description', 'movie-3.png');
INSERT INTO movies (movie_id, title, release_date, overview, poster_path) VALUES (4, 'movie4', '0004-04-04', 'movie4 description', 'movie-4.png');

-- television_shows
INSERT INTO television_shows (television_show_id, title, release_date, overview, poster_path) VALUES (1, 'show1', '0001-01-01', 'show1 description', 'show-1.png');
INSERT INTO television_shows (television_show_id, title, release_date, overview, poster_path) VALUES (2, 'show2', '0002-02-02', 'show2 description', 'show-2.png');
INSERT INTO television_shows (television_show_id, title, release_date, overview, poster_path) VALUES (3, 'show3', '0003-03-03', 'show3 description', 'show-3.png');
INSERT INTO television_shows (television_show_id, title, release_date, overview, poster_path) VALUES (4, 'show4', '0004-04-04', 'show4 description', 'show-4.png');

-- genres
INSERT INTO genres (genre_id, name) VALUES (1, 'genre1');
INSERT INTO genres (genre_id, name) VALUES (2, 'genre2');

-- people
INSERT INTO people (person_id, name) VALUES (1, 'person1');
INSERT INTO people (person_id, name) VALUES (2, 'person2');
INSERT INTO people (person_id, name) VALUES (3, 'person3');
INSERT INTO people (person_id, name) VALUES (4, 'person4');

-- movie genres (JOIN table)
INSERT INTO movie_genres (movie_id, genre_id) VALUES (1, 1);
INSERT INTO movie_genres (movie_id, genre_id) VALUES (1, 2);
INSERT INTO movie_genres (movie_id, genre_id) VALUES (2, 2);

-- television show genres (JOIN table)
INSERT INTO television_show_genres (television_show_id, genre_id) VALUES (1, 1);
INSERT INTO television_show_genres (television_show_id, genre_id) VALUES (2, 1);
INSERT INTO television_show_genres (television_show_id, genre_id) VALUES (2, 2);

-- movie credits
INSERT INTO movie_credits (movie_id, person_id, credit_role, character_name) VALUES (1, 1, 'role1', 'character1');
INSERT INTO movie_credits (movie_id, person_id, credit_role, character_name) VALUES (1, 2, 'role2', 'character2');

-- television show credits
INSERT INTO television_show_credits (television_show_id, person_id, credit_role, character_name) VALUES (1, 1, 'role1', 'character1');
INSERT INTO television_show_credits (television_show_id, person_id, credit_role, character_name) VALUES (1, 2, 'role2', 'character2');

-- users
INSERT INTO users (username, password_hash, role) VALUES ('user1', 'user1', 'ROLE_USER');
INSERT INTO users (username, password_hash, role) VALUES ('user2', 'user2', 'ROLE_USER');
INSERT INTO users (username, password_hash, role) VALUES ('user3', 'user3', 'ROLE_USER');

COMMIT;