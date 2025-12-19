import axios from 'axios';

export default {
  getFilmById(filmId) {
    return axios.get(`/film/${filmId}`);
  },

  searchFilmsByTitle(title) {
    return axios.get('/film/search', { params: { title } });
  },
};
