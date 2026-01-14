-- database film_vault
BEGIN TRANSACTION;

-- *************************************************************************************************
-- Drop all db objects in the proper order
-- *************************************************************************************************

DROP TABLE IF EXISTS user_films CASCADE;
DROP TABLE IF EXISTS films CASCADE;
DROP TABLE IF EXISTS users CASCADE;

-- *************************************************************************************************
-- Create the tables and constraints
-- *************************************************************************************************

-- films
CREATE TABLE films (
	imdb_id VARCHAR(64) NOT NULL,
	film_type VARCHAR(16) NOT NULL,
	title VARCHAR(255) NOT NULL,
	release_year VARCHAR(10),
	rated VARCHAR(10),
	release_date VARCHAR(32) ,
	runtime VARCHAR(10),
	genre TEXT,
	director VARCHAR(128),
	actors TEXT,
	plot TEXT,
	language VARCHAR(128),
	country VARCHAR(128),
	awards VARCHAR(512),
	poster TEXT,
	imdb_rating VARCHAR(5),
	CONSTRAINT PK_film PRIMARY KEY(imdb_id)
);

-- users (name is pluralized because 'user' is a SQL keyword)
CREATE TABLE users (
	user_id SERIAL,
	username VARCHAR(50) NOT NULL UNIQUE,
	password_hash VARCHAR(200) NOT NULL,
	role VARCHAR(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

-- user_films
CREATE TABLE user_films (
	user_id INT NOT NULL,
	imdb_id VARCHAR(64) NOT NULL,
	CONSTRAINT PK_user_films PRIMARY KEY (user_id, imdb_id),
	CONSTRAINT FK_user_films_user FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_user_films_film FOREIGN KEY (imdb_id) REFERENCES films (imdb_id)
);

COMMIT;