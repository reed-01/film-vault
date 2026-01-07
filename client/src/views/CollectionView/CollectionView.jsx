import { useContext, useEffect, useState } from 'react';
import { UserContext } from '../../context/user/UserContext';
import CollectionService from '../../services/CollectionService';
import FilmCard from '../../components/FilmCard/FilmCard';
import { useCollection } from '../../context/collection/CollectionContext';

import styles from './CollectionView.module.css';

export default function CollectionView() {
  const [isLoading, setIsLoading] = useState(true);
  const { user } = useContext(UserContext);
  const [films, setFilms] = useState([]);
  const { handlePostToCollection, handleDeleteFilmFromCollection } =
    useCollection();

  function getPageData() {
    setIsLoading(true);
    CollectionService.getUserCollection()
      .then((response) => {
        setFilms(response.data);
        setIsLoading(false);
      })
      .catch((error) => {
        const errorMessage = error.response
          ? error.response.data.message
          : error.message;
        console.error(errorMessage);
        setIsLoading(false);
      });
  }

  useEffect(() => {
    setTimeout(() => {
      getPageData();
    }, 600);
  }, []);

  return (
    <>
      <div className={styles.collectionHeader}>
        <h2>{user.username}'s Collection</h2>
      </div>

      <div>
        {isLoading ? (
          <p>Loading...</p> // <img src={loadingImg} alt="loading gif" />
        ) : films.length === 0 ? (
          <h3 className={styles.emptyMessage}>Your collection is empty.</h3>
        ) : (
          <>
            <div className={styles.page}>
              <div className={styles.grid}>
                {films.map((film) => (
                  <FilmCard key={film.filmId} film={film} />
                ))}
              </div>
            </div>
          </>
        )}
      </div>
    </>
  );
}
