import { Link } from 'react-router-dom';
import styles from './FilmCard.module.css';

export default function FilmCard({ film }) {
  const { filmId, title, poster, releaseYear } = film;

  return (
    <Link to={`/film/${filmId}`} className={styles.card}>
      <div className={styles.posterWrap}>
        <img
          src={film.poster}
          alt={`${title} poster`}
          className={styles.poster}
        />
      </div>
      <h3 className={styles.title}>{title}</h3>
      <p className={styles.releaseYear}>{releaseYear}</p>
    </Link>
  );
}
