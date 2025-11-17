-- database film_vault
BEGIN TRANSACTION;

-- *************************************************************************************************
-- Drop all db objects in the proper order
-- *************************************************************************************************
DROP TABLE IF EXISTS movie_credits CASCADE;
DROP TABLE IF EXISTS television_show_credits CASCADE;
DROP TABLE IF EXISTS movie_genres CASCADE;
DROP TABLE IF EXISTS television_show_genres CASCADE;
DROP TABLE IF EXISTS movies CASCADE;
DROP TABLE IF EXISTS television_shows CASCADE;
DROP TABLE IF EXISTS genres CASCADE;
DROP TABLE IF EXISTS people CASCADE;
DROP TABLE IF EXISTS users CASCADE;

-- *************************************************************************************************
-- Create the tables and constraints
-- *************************************************************************************************

-- movies
CREATE TABLE movies (
	movie_id SERIAL,
	title VARCHAR(300) NOT NULL,
	release_date DATE,
	overview TEXT,
	poster_path VARCHAR(500),
	CONSTRAINT PK_movie PRIMARY KEY (movie_id)
);

-- television shows
CREATE TABLE television_shows (
    television_show_id SERIAL,
    title VARCHAR(300) NOT NULL,
    release_date DATE,
    overview TEXT,
    poster_path VARCHAR(500),
    CONSTRAINT PK_television_show PRIMARY KEY (television_show_id)
);

-- genres
CREATE TABLE genres (
	genre_id SERIAL,
	name VARCHAR(100) UNIQUE NOT NULL,
	CONSTRAINT PK_genre PRIMARY KEY (genre_id)
);

-- people
CREATE TABLE people (
    person_id SERIAL,
    name VARCHAR(200) NOT NULL,
    CONSTRAINT PK_person PRIMARY KEY (person_id)
);

-- movie genres (JOIN TABLE)
CREATE TABLE movie_genres (
	movie_id INT NOT NULL REFERENCES movies(movie_id),
	genre_id INT NOT NULL REFERENCES genres(genre_id),
	CONSTRAINT PK_movie_genres PRIMARY KEY (movie_id, genre_id)
);

-- television show genres (JOIN TABLE)
CREATE TABLE television_show_genres (
    television_show_id INT NOT NULL REFERENCES television_shows(television_show_id),
    genre_id INT NOT NULL REFERENCES genres(genre_id),
    CONSTRAINT PK_television_show_genres PRIMARY KEY (television_show_id, genre_id)
);

-- movie credits
CREATE TABLE movie_credits (
    movie_id INT NOT NULL REFERENCES movies(movie_id),
    person_id INT NOT NULL REFERENCES people(person_id),
    credit_role VARCHAR(50) NOT NULL,
    character_name VARCHAR(200),
    CONSTRAINT PK_movie_credits PRIMARY KEY (movie_id, person_id, credit_role)
);

-- television show credits
CREATE TABLE television_show_credits (
    television_show_id INT NOT NULL REFERENCES television_shows(television_show_id),
    person_id INT NOT NULL REFERENCES people(person_id),
    credit_role VARCHAR(50) NOT NULL,
    character_name VARCHAR(200),
    CONSTRAINT PK_tv_credits PRIMARY KEY (television_show_id, person_id, credit_role)
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
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

-- *************************************************************************************************
-- Insert some sample starting data
-- *************************************************************************************************

-- movies
INSERT INTO
	movies (title, release_date, overview, poster_path)
VALUES
	('The Matrix', '1999-03-31', 'A computer hacker learns about the true nature of his reality and his role in the war against its controllers.', 'matrix.jpg'),
	('Inception', '2010-07-16', 'A thief who steals corporate secrets through dream-sharing technology is given a chance at redemption.', 'inception.jpg');

-- television shows
INSERT INTO 
	television_shows (title, release_date, overview, poster_path) 
VALUES
	('Stranger Things', '2016-07-15', 'A group of kids uncover supernatural mysteries in their small town.', 'stranger_things.jpg'),
	('Breaking Bad', '2008-01-20', 'A chemistry teacher turns to making meth to secure his family''s future.', 'breaking_bad.jpg');

-- genres
INSERT INTO 
	genres (name) 
VALUES 
	('Action'), 
	('Science Fiction'), 
	('Drama'), 
	('Comedy'), 
	('Thriller');

-- people
INSERT INTO
	people (name) 
VALUES
	('Keanu Reeves'),             
	('Carrie-Anne Moss'),         
	('Laurence Fishburne'),       
	('Lana Wachowski'),           
	('Lilly Wachowski'),          
	('Leonardo DiCaprio'),        
	('Joseph Gordon-Levitt'),     
	('Christopher Nolan'),        
	('Millie Bobby Brown'),       
	('David Harbour'),            
	('Winona Ryder'),             
	('Matt Duffer'),              
	('Ross Duffer');

-- movie genres
INSERT INTO 
	movie_genres (movie_id, genre_id) 
VALUES
	(1, 1), 
	(1, 2), 
	(2, 1), 
	(2, 2), 
	(2, 5); 

-- television show genres
INSERT INTO 
	television_show_genres (television_show_id, genre_id) 
VALUES
	(1, 2), 
	(1, 5), 
	(2, 3);

-- movie credits
INSERT INTO 
	movie_credits (movie_id, person_id, credit_role, character_name) 
VALUES
	(1, 1, 'Actor', 'Neo'),             
	(1, 2, 'Actor', 'Trinity'),         
	(1, 3, 'Actor', 'Morpheus'),        
	(1, 4, 'Director', NULL),           
	(1, 5, 'Director', NULL),           
	(2, 6, 'Actor', 'Dom Cobb'),        
	(2, 7, 'Actor', 'Arthur'),          
	(2, 8, 'Director', NULL);

-- television show credits
INSERT INTO 
	television_show_credits (television_show_id, person_id, credit_role, character_name) 
VALUES
	(1, 9,  'Actor', 'Eleven'),
	(1, 10, 'Actor', 'Jim Hopper'),
	(1, 11, 'Actor', 'Joyce Byers'),
	(1, 12, 'Director', NULL),
	(1, 13, 'Director', NULL),
	(2, 10, 'Actor', 'Hank Schrader'),
	(2, 12, 'Director', NULL);

COMMIT TRANSACTION;


