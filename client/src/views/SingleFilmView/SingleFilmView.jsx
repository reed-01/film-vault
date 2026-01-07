import { useContext, useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { UserContext } from '../../context/user/UserContext';
import FilmService from '../../services/FilmService';
import { useCollection } from '../../context/collection/CollectionContext';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import styles from './SingleFilmView.module.css';

export default function SingleFilmView() {
  const { id } = useParams();
  const [film, setFilm] = useState(null);
  const [isLoading, setIsLoading] = useState(true);

  const { user } = useContext(UserContext);
  const navigate = useNavigate();

  const {
    isInCollection,
    handlePostToCollection,
    handleDeleteFilmFromCollection,
  } = useCollection();

  const inCollection = isInCollection(id);

  function getPageData() {
    FilmService.getFilmById(id)
      .then((response) => {
        setFilm(response.data);
        setIsLoading(false);
      })
      .catch((error) => {
        console.error('Error fetching film', error);
        setIsLoading(false);
      });
  }

  useEffect(() => {
    setTimeout(() => {
      getPageData();
    }, 600);
  }, [id]);

  return (
    <>
      <div className={styles.page}>
        {isLoading ? (
          <p>Loading...</p> // <img src={loadingImg} alt="loading gif" />
        ) : (
          <>
            <div className={styles.layout}>
              <div className={styles.posterColumn}>
                <img
                  src={film.poster}
                  alt={`${film.title} poster`}
                  className={styles.poster}
                />

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
                    onClick={() => handleDeleteFilmFromCollection(film.filmId)}
                    title="Remove from collection"
                  >
                    <FontAwesomeIcon icon="fa-solid fa-trash-can" />
                  </button>
                )}
              </div>

              <div className={styles.detailsColumn}>
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
          </>
        )}
      </div>
    </>
  );
}
