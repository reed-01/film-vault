import { Link } from 'react-router-dom';
import styles from './FilmCard.module.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

export default function FilmCard({ film, showDeleteButton, onDelete }) {
  const { filmId, title, poster, releaseYear } = film;

  return (
    <div className={styles.card}>
      <Link to={`/film/${filmId}`} className={styles.posterWrap}>
        <img src={poster} alt={`${title} poster`} className={styles.poster} />
      </Link>

      {showDeleteButton && (
        <button
          className={styles.deleteButton}
          onClick={() => onDelete(filmId)}
          title="Remove from collection"
        >
          <FontAwesomeIcon icon="fa-solid fa-trash-can" />
        </button>
      )}

      <p className={styles.releaseYear}>{releaseYear}</p>
      <h3 className={styles.title}>{title}</h3>
    </div>
  );
}
