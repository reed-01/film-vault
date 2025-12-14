import axios from "axios";

export default {

  saveFilmToCollection(film) {
    return axios.post(`/collection/${film}`);
  },

  deleteFilmFromCollection(filmId) {
    return axios.delete(`/collection/${filmId}`);
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
  }
}