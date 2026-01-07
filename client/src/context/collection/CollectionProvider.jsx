import { useContext, useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import CollectionService from '../../services/CollectionService';
import { CollectionContext } from './CollectionContext';
import { UserContext } from '../user/UserContext';

export function CollectionProvider({ children }) {
  const navigate = useNavigate();
  const { user } = useContext(UserContext);

  const [notification, setNotification] = useState(null);
  const [collectionFilmIds, setCollectionFilmIds] = useState([]);

  // Load collection when user changes (login/logout)
  useEffect(() => {
    if (!user) {
      setCollectionFilmIds([]);
      return;
    }

    CollectionService.getUserCollection()
      .then((response) => {
        // response.data is your films array from /collection
        const ids = response.data.map((f) => f.filmId);
        setCollectionFilmIds(ids);
      })
      .catch((error) => {
        console.error(error);
        setCollectionFilmIds([]);
      });
  }, [user]);

  function isInCollection(filmId) {
    return collectionFilmIds.includes(filmId);
  }

  function handlePostToCollection(film) {
    if (!user) {
      navigate('/login');
      return;
    }

    return CollectionService.postFilmToCollection(film)
      .then(() => {
        // update shared state so buttons switch everywhere
        setCollectionFilmIds([...collectionFilmIds, film.filmId]);

        setNotification({ type: 'success', message: 'Added to Collection.' });
      })
      .catch((error) => {
        console.error(error);
        setNotification({
          type: 'error',
          message: 'Could not add to Collection.',
        });
      });
  }

  function handleDeleteFilmFromCollection(filmId) {
    return CollectionService.deleteFilmFromCollection(filmId)
      .then(() => {
        // update shared state so buttons switch everywhere
        setCollectionFilmIds(collectionFilmIds.filter((id) => id !== filmId));

        setNotification({ type: 'success', message: 'Film removed.' });
      })
      .catch((error) => {
        console.error(error);
        setNotification({ type: 'error', message: 'Action failed.' });
      });
  }

  return (
    <CollectionContext.Provider
      value={{
        collectionFilmIds,
        isInCollection,
        handlePostToCollection,
        handleDeleteFilmFromCollection,
        notification,
        setNotification,
      }}
    >
      {children}
    </CollectionContext.Provider>
  );
}
