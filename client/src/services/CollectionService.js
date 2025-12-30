import axios from 'axios';

export default {
  getUserCollection() {
    return axios.get('/collection');
  },

  postFilmToCollection(film) {
    return axios.post('/collection', film);
  },

  getCollectionFilmsByType(filmType) {
    return axios.get(`/collection/type/${filmType}`);
  },

  getCollectionFilmsByGenre(genre) {
    return axios.get(`/collection/genre/${genre}`);
  },

  getCollectionFilmsByRated(rated) {
    return axios.get(`/collection/rated/${rated}`);
  },

  getCollectionFilmsByReleaseYear(releaseYear) {
    return axios.get(`/collection/releaseYear/${releaseYear}`);
  },

  getCollectionFilmsByActor(actors) {
    return axios.get(`/collection/actors/${actors}`);
  },

  getCollectonFilmsByDirector(director) {
    return axios.get(`collection/director/${director}`);
  },

  deleteFilmFromCollection(filmId) {
    return axios.delete(`/collection/${filmId}`);
  },
};
