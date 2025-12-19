import { Link } from 'react-router-dom';

import styles from './FilmCard.module.css';

export default function FilmCard({ film }) {
  const { filmId, title, poster } = film;

  return (
    <Link to={`/film/${filmId}`} className={styles.card}>
      <div className={styles.posterWrap}>
        <img src={poster} alt={`${title} poster`} className={styles.poster} />
      </div>
      <h3 className={styles.title}>{title}</h3>
    </Link>
  );
}
