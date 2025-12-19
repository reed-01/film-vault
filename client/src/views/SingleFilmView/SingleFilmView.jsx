import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import FilmService from '../../services/FilmService';
import styles from './SingleFilmView.module.css';

export default function SingleFilmView() {
  const { id } = useParams();
  const [film, setFilm] = useState(null);

  useEffect(() => {
    if (!id) return;

    FilmService.getFilmById(id)
      .then((response) => setFilm(response.data))
      .catch(() => setFilm(null));
  }, [id]);

  if (!film) return <p>Loading…</p>;

  const posterSrc =
    film.poster && film.poster !== 'N/A'
      ? film.poster
      : 'https://via.placeholder.com/300x450?text=No+Poster';

  return (
    <div className={styles.page}>
      <div className={styles.layout}>
        <img
          src={posterSrc}
          alt={`${film.title} poster`}
          className={styles.poster}
        />

        <div className={styles.details}>
          <h1>{film.title}</h1>
          <p>
            <strong>Type:</strong> {film.filmType}
          </p>
          <p>
            <strong>Year:</strong> {film.releaseYear}
          </p>
          <p>
            <strong>Rated:</strong> {film.rated}
          </p>
          <p>
            <strong>Released:</strong> {film.releaseDate}
          </p>
          <p>
            <strong>Runtime:</strong> {film.runtime}
          </p>
          <p>
            <strong>Genre:</strong> {film.genre}
          </p>
          <p>
            <strong>Director:</strong> {film.director}
          </p>
          <p>
            <strong>Actors:</strong> {film.actors}
          </p>
          <p>
            <strong>Plot:</strong> {film.plot}
          </p>
          <p>
            <strong>IMDb Rating:</strong> {film.imdbRating}
          </p>
        </div>
      </div>
    </div>
  );
}
