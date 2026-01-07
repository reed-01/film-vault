import { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import FilmService from '../../services/FilmService';
import FilmCard from '../../components/FilmCard/FilmCard';
import styles from './HomeView.module.css';

export default function HomeView() {
  const [params] = useSearchParams();
  const q = params.get('q') || '';

  const [films, setFilms] = useState([]);

  useEffect(() => {
    if (!q.trim()) {
      setFilms([]);
      return;
    }

    FilmService.searchFilmsByTitle(q.trim())
      .then((response) => setFilms(response.data || []))
      .catch(() => setFilms([]));
  }, [q]);

  return (
    <>
      <div className={styles.page}>
        <div className={styles.grid}>
          {films.map((film) => (
            <FilmCard key={film.filmId} film={film} />
          ))}
        </div>
      </div>
    </>
  );
}
