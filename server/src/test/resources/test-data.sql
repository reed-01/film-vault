-- data test
BEGIN TRANSACTION;

-- *************************************************************************************************
-- Insert test data
-- *************************************************************************************************

-- films
INSERT INTO films (imdb_id, film_type, title, release_year, rated, release_date, runtime, genre, director, actors, plot, language, country, awards, poster, imdb_rating) VALUES ('1', 'type1', 'title1', '0101', 'A', '01-01-0101', '111', 'genre1', 'director1', 'actor1', 'plot1', 'language1', 'country1', 'awards1', 'poster1.jpg', '11.11');
INSERT INTO films (imdb_id, film_type, title, release_year, rated, release_date, runtime, genre, director, actors, plot, language, country, awards, poster, imdb_rating) VALUES ('2', 'type2', 'title2', '0202', 'B', '02-02-0202', '222', 'genre2', 'director2', 'actor2', 'plot2', 'language2', 'country2', 'awards2', 'poster2.jpg', '22.22');

-- users
INSERT INTO users (username, password_hash, role) VALUES ('user1', 'user1', 'ROLE_USER');
INSERT INTO users (username, password_hash, role) VALUES ('user2', 'user2', 'ROLE_USER');
INSERT INTO users (username, password_hash, role) VALUES ('user3', 'user3', 'ROLE_USER');

-- user_films
INSERT INTO user_films (user_id, imdb_id) VALUES (1, '1');
INSERT INTO user_films (user_id, imdb_id) VALUES (2, '2');

COMMIT;