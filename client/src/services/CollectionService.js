import axios from 'axios';

export default {
  getUserCollection(userId) {
    return axios.get(`/collection/${userId}`);
  },

  postFilmToCollection(film) {
    return axios.post(`/collection/${film}`);
  },

  getCollectionFilmsByType(filmType) {
    return axios.get(`/collection/${filmType}`);
  },

  getCollectionFilmsByGenre(genre) {
    return axios.get(`/collection/${genre}`);
  },

  getCollectionFilmsByRated(rated) {
    return axios.get(`/collection/${rated}`);
  },

  getCollectionFilmsByReleaseYear(releaseYear) {
    return axios.get(`/collection/${releaseYear}`);
  },

  getCollectionFilmsByActor(actors) {
    return axios.get(`/collection/${actors}`);
  },

  getCollectonFilmsByDirector(director) {
    return axios.get(`collection/${director}`);
  },

  deleteFilmFromCollection(filmId) {
    return axios.delete(`/collection/${filmId}`);
  },
};
