import { Link } from 'react-router-dom';
import styles from './FilmCard.module.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useCollection } from '../../context/collection/CollectionContext';

export default function FilmCard({ film }) {
  const {
    isInCollection,
    handlePostToCollection,
    handleDeleteFilmFromCollection,
  } = useCollection();

  const { filmId, title, poster, releaseYear } = film;
  const inCollection = isInCollection(filmId);

  return (
    <div className={styles.card}>
      <Link to={`/film/${filmId}`} className={styles.posterWrap}>
        <img
          src={poster}
          alt={`${title} poster`}
          className={styles.poster}
          title="View film details"
        />
      </Link>

      {!inCollection ? (
        <button
          className={styles.addButton}
          onClick={() => handlePostToCollection(film)}
          title="Add to collection"
        >
          +
        </button>
      ) : (
        <button
          className={styles.deleteButton}
          onClick={() => handleDeleteFilmFromCollection(filmId)}
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
