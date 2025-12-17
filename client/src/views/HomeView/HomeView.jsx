import FilmService from '../../services/FilmService';
import { useState } from 'react';

import styles from './HomeView.module.css';

export default function HomeView() {
  const [film, setFilm] = useState(null);
  const [title, setTitle] = useState('');

  function fetchFilm(e) {
    e.preventDefault();

    FilmService.getFilmByTitle(title).then((response) => {
      setFilm(response.data);
      setTitle('');
    });
  }

  return (
    <>
      <h1>Home</h1>
      <br />

      <p>Welcome to the Film Vault!</p>
      <p>Find your favorite films.</p>
      <br />

      <div>
        <form onSubmit={fetchFilm}>
          <input
            type="text"
            id="searchBox"
            placeholder="Enter Film Title..."
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />

          <button type="submit">Search</button>
        </form>

        {film && (
          <>
            <div>
              <p>Title: {film.Title}</p>
              <p>Year: {film.Year}</p>
              <p>Rated: {film.Rated}</p>
              <p>Release Date: {film.Released}</p>
              <p>Runtime: {film.Runtime}</p>
              <p>Genre: {film.Genre}</p>
              <p>Director: {film.Director}</p>
              <p>Actors: {film.Actors}</p>
              <p>Plot: {film.Plot}</p>
              <p>Language: {film.Language}</p>
              <p>Country: {film.Country}</p>
              <p>Awards: {film.Awards}</p>
              <p>IMDb Rating: {film.imdbRating}</p>
              <img src={film.Poster} alt="film poster" />
            </div>
          </>
        )}
      </div>
    </>
  );
}
