import axios from 'axios';

export default {
  getFilmById(filmId) {
    return axios.get(`/film/${filmId}`);
  },

  getFilmByTitle(title) {
    return axios.get('/film/search', { params: { title } });
  },
};
