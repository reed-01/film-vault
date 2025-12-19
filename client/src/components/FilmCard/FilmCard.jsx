import { Link } from 'react-router-dom';
import styles from './FilmCard.module.css';

export default function FilmCard({ film }) {
  const { filmId, title, poster } = film;

  const posterSrc =
    poster && poster !== 'N/A'
      ? poster
      : 'https://via.placeholder.com/300x450?text=No+Poster';

  return (
    <Link to={`/film/${filmId}`} className={styles.card}>
      <div className={styles.posterWrap}>
        <img
          src={posterSrc}
          alt={`${title} poster`}
          className={styles.poster}
        />
      </div>
      <h3 className={styles.title}>{title}</h3>
    </Link>
  );
}
