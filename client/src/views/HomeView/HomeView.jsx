import { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import FilmService from '../../services/FilmService';
import FilmCard from '../../components/FilmCard/FilmCard';
import styles from './HomeView.module.css';

export default function HomeView() {
  const [params] = useSearchParams();
  const q = params.get('q') || '';
  const [films, setFilms] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    if (!q.trim()) {
      setFilms([]);
      setIsLoading(false);
      return;
    }

    setIsLoading(true);

    setTimeout(() => {
      FilmService.searchFilmsByTitle(q.trim())
        .then((response) => {
          setFilms(response.data || []);
          setIsLoading(false);
        })
        .catch(() => {
          setFilms([]);
          setIsLoading(false);
        });
    }, 600);
  }, [q]);

  return (
    <>
      <div className={styles.page}>
        {!q.trim() ? (
          <h3 className={styles.helperText}>
            Search for a film above to view details and add it to your
            collection.
          </h3>
        ) : isLoading ? (
          <p>Loading...</p>
        ) : films.length === 0 ? (
          <h3 className={styles.helperText}>
            No films found. Try a different title.
          </h3>
        ) : (
          <div className={styles.grid}>
            {films.map((film) => (
              <FilmCard key={film.filmId} film={film} />
            ))}
          </div>
        )}
      </div>
    </>
  );
}
