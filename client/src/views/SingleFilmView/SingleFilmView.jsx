import { useContext, useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { UserContext } from '../../context/UserContext';

import FilmService from '../../services/FilmService';
import CollectionService from '../../services/CollectionService';
import Notification from '../../components/Notification/Notification';

import styles from './SingleFilmView.module.css';

export default function SingleFilmView() {
  const [notification, setNotification] = useState(null);
  const { id } = useParams();
  const [film, setFilm] = useState(null);
  const [isLoading, setIsLoading] = useState(true);

  const { user } = useContext(UserContext);
  const navigate = useNavigate();

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

  function handleAddToCollection(film) {
    if (!user) {
      navigate('/login');
      return;
    }

    CollectionService.postFilmToCollection(film)
      .then(() =>
        setNotification({ type: 'success', message: 'Added to Collection.' })
      )
      .catch((error) => {
        const errorMessage = error.response
          ? error.response.data.message
          : error.message;
        console.error(errorMessage);
        setNotification({
          type: 'error',
          message: 'Could not add to Collection.',
        });
      });
  }

  return (
    <>
      <Notification
        notification={notification}
        clearNotification={() => setNotification(null)}
      />

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

                <button
                  type="button"
                  className={styles.collectionButton}
                  onClick={() => handleAddToCollection(film)}
                >
                  Add to Collection
                </button>
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
