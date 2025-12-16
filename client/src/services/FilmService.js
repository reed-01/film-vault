import axios from 'axios';

export default {
  getFilmByTitle(title) {
    return axios.get('/film', { params: { title } });
  },
};
