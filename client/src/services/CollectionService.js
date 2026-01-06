import axios from 'axios';

export default {
  getUserCollection() {
    return axios.get('/collection');
  },

  postFilmToCollection(film) {
    return axios.post('/collection', film);
  },

  deleteFilmFromCollection(filmId) {
    return axios.delete(`/collection/${filmId}`);
  },
};
