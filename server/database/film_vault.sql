-- database m2_final_project
BEGIN TRANSACTION;

-- *************************************************************************************************
-- Drop all db objects in the proper order
-- *************************************************************************************************
DROP TABLE IF EXISTS movies CASCADE;
DROP TABLE IF EXISTS users CASCADE;

-- *************************************************************************************************
-- Create the tables and constraints
-- *************************************************************************************************

-- movies
CREATE TABLE movies (
	movie_id SERIAL,
	title VARCHAR(300) NOT NULL,
	genre VARCHAR(100),
	release_date DATE,
	overview TEXT,
	poster VARCHAR(500),
	CONSTRAINT PK_movie PRIMARY KEY (movie_id)
);

-- genres
CREATE TABLE genres (
	genre_id SERIAL,
	name VARCHAR(100) UNIQUE NOT NULL,
	CONSTRAINT PK_genre PRIMARY KEY (genre_id)
);

-- movie genres (JOIN TABLE)
CREATE TABLE movie_genres (
	movie_id INT NOT NULL REFERENCES movie(movie_id),
	genre_id INT NOT NULL REFERENCES genres(genre_id)
);

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
	rating INT CHECK (rating BETWEEN 1 AND 5),
	CONSTRAINT FK_users_state FOREIGN KEY (state_code)
    REFERENCES state_sales_tax_rates(state_code),
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

-- *************************************************************************************************
-- Insert some sample starting data
-- *************************************************************************************************
INSERT INTO

COMMIT TRANSACTION;