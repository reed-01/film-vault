BEGIN TRANSACTION;

--Drop all db objects in the proper order
DROP TABLE IF EXISTS movies CASCADE;

-- Create the tables and constraints

-- Movies
CREATE TABLE (
    movie_id SERIAL,
    title VARCHAR(200) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    rating VARCHAR(10) NOT NULL,
    release_date VARCHAR(10) NOT NULL,
    description VARCHAR(500) NOT NULL,
    cover_image VARCHAR(200) NOT NULL,
    CONSTRAINT PK_movie PRIMARY KEY (movie_id)
);

COMMIT;