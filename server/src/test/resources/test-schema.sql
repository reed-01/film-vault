-- Database film_vault
BEGIN TRANSACTION;

--Drop all db objects in the proper order
DROP TABLE IF EXISTS movies CASCADE;
DROP TABLE IF EXISTS users CASCADE;

-- Create the tables and constraints

--users (name is pluralized because 'user' is a SQL keyword)
CREATE TABLE users (
	user_id SERIAL,
	username VARCHAR(50) NOT NULL UNIQUE,
	password_hash VARCHAR(200) NOT NULL,
	role VARCHAR(50) NOT NULL,
	name VARCHAR(50) NOT NULL,
	address VARCHAR(100) NOT NULL,
	city VARCHAR(50) NOT NULL,
	state_code CHAR(2) NOT NULL,
	zip_code VARCHAR(5) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

-- Movies
CREATE TABLE movies (
    movie_id SERIAL,
    title VARCHAR(200) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    rating VARCHAR(10) NOT NULL,
    release_date VARCHAR(10) NOT NULL,
    overview VARCHAR(1000) NOT NULL,
    poster_path VARCHAR(300) NOT NULL,
    CONSTRAINT PK_movie PRIMARY KEY (movie_id)
);

COMMIT;