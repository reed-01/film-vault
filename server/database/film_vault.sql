-- -- database film_vault
BEGIN TRANSACTION;

-- -- *************************************************************************************************
-- -- Drop all db objects in the proper order
-- -- *************************************************************************************************
DROP TABLE IF EXISTS movies CASCADE;
DROP TABLE IF EXISTS users CASCADE;

-- -- *************************************************************************************************
-- -- Create the tables and constraints
-- -- *************************************************************************************************

-- movies
CREATE TABLE movies (
	imdb_id VARCHAR(64) UNIQUE NOT NULL,
	title VARCHAR(255) NOT NULL,
	release_year INT,
	rated VARCHAR(10),
	release_date DATE,
	runtime INT,
	plot TEXT,
	language VARCHAR(128),
	country VARCHAR(128),
	awards VARCHAR(512),
	poster TEXT,
	CONSTRAINT PK_movie PRIMARY KEY(imdb_id)
);

-- --users (name is pluralized because 'user' is a SQL keyword)
CREATE TABLE users (
	user_id SERIAL,
	username VARCHAR(50) NOT NULL UNIQUE,
	password_hash VARCHAR(200) NOT NULL,
	role VARCHAR(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

-- -- database film_vault
-- BEGIN TRANSACTION;

-- -- *************************************************************************************************
-- -- Drop all db objects in the proper order
-- -- *************************************************************************************************
-- DROP TABLE IF EXISTS movie_credits CASCADE;
-- DROP TABLE IF EXISTS television_show_credits CASCADE;
-- DROP TABLE IF EXISTS movie_genres CASCADE;
-- DROP TABLE IF EXISTS television_show_genres CASCADE;
-- DROP TABLE IF EXISTS movies CASCADE;
-- DROP TABLE IF EXISTS television_shows CASCADE;
-- DROP TABLE IF EXISTS genres CASCADE;
-- DROP TABLE IF EXISTS people CASCADE;
-- DROP TABLE IF EXISTS users CASCADE;

-- -- *************************************************************************************************
-- -- Create the tables and constraints
-- -- *************************************************************************************************



-- -- television shows
-- CREATE TABLE television_shows (
--     television_show_id SERIAL,
--     title VARCHAR(300) NOT NULL,
--     release_date DATE,
--     overview TEXT,
--     poster_path VARCHAR(500),
--     CONSTRAINT PK_television_show PRIMARY KEY (television_show_id)
-- );

-- -- genres
-- CREATE TABLE genres (
-- 	genre_id SERIAL,
-- 	name VARCHAR(100) UNIQUE NOT NULL,
-- 	CONSTRAINT PK_genre PRIMARY KEY (genre_id)
-- );

-- -- people
-- CREATE TABLE people (
--     person_id SERIAL,
--     name VARCHAR(200) NOT NULL,
--     CONSTRAINT PK_person PRIMARY KEY (person_id)
-- );

-- -- movie genres (JOIN TABLE)
-- CREATE TABLE movie_genres (
-- 	movie_id INT NOT NULL REFERENCES movies(movie_id),
-- 	genre_id INT NOT NULL REFERENCES genres(genre_id),
-- 	CONSTRAINT PK_movie_genres PRIMARY KEY (movie_id, genre_id)
-- );

-- -- television show genres (JOIN TABLE)
-- CREATE TABLE television_show_genres (
--     television_show_id INT NOT NULL REFERENCES television_shows(television_show_id),
--     genre_id INT NOT NULL REFERENCES genres(genre_id),
--     CONSTRAINT PK_television_show_genres PRIMARY KEY (television_show_id, genre_id)
-- );

-- -- movie credits
-- CREATE TABLE movie_credits (
--     movie_id INT NOT NULL REFERENCES movies(movie_id),
--     person_id INT NOT NULL REFERENCES people(person_id),
--     credit_role VARCHAR(50) NOT NULL,
--     character_name VARCHAR(200),
--     CONSTRAINT PK_movie_credits PRIMARY KEY (movie_id, person_id, credit_role)
-- );

-- -- television show credits
-- CREATE TABLE television_show_credits (
--     television_show_id INT NOT NULL REFERENCES television_shows(television_show_id),
--     person_id INT NOT NULL REFERENCES people(person_id),
--     credit_role VARCHAR(50) NOT NULL,
--     character_name VARCHAR(200),
--     CONSTRAINT PK_tv_credits PRIMARY KEY (television_show_id, person_id, credit_role)
-- );
