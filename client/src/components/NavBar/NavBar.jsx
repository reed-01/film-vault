// import FilmService from '../../services/FilmService';
// import { useState } from 'react';
// import { useContext } from 'react';
// import { Link, NavLink } from 'react-router-dom';
// import { UserContext } from '../../context/UserContext';

// import styles from './NavBar.module.css';

// export default function NavBar() {
//   const { user } = useContext(UserContext);
//   const [film, setFilm] = useState(null);
//   const [title, setTitle] = useState('');

//   function fetchFilm(e) {
//     e.preventDefault();

//     FilmService.getFilmByTitle(title).then((response) => {
//       setFilm(response.data);
//       setTitle('');
//     });
//   }

//   return (
//     <nav className={styles.navBar}>
//       <ul className={styles.navLinks}>
//         <li className={styles.navLeft}>
//           <NavLink to="/">Home</NavLink>
//           <NavLink to="/collection/:userId">Collection</NavLink>
//         </li>

//         <li className={styles.navRight}>
//           {user ? (
//             <Link to="/logout">Logout</Link>
//           ) : (
//             <NavLink to="/login">Login</NavLink>
//           )}
//         </li>
//       </ul>

//       <form onSubmit={fetchFilm}>
//         <input
//           type="text"
//           id="searchBox"
//           placeholder="Enter Film Title..."
//           value={title}
//           onChange={(e) => setTitle(e.target.value)}
//         />

//         <button type="submit">Search</button>
//       </form>
//     </nav>
//   );
// }

import { useContext, useState } from 'react';
import { Link, NavLink, useNavigate } from 'react-router-dom';
import { UserContext } from '../../context/UserContext';

import styles from './NavBar.module.css';

export default function NavBar() {
  const { user } = useContext(UserContext);
  const [query, setQuery] = useState('');
  const navigate = useNavigate();

  function handleSubmit(e) {
    e.preventDefault();
    if (!query.trim()) return;
    navigate(`/?q=${encodeURIComponent(query.trim())}`);
    setQuery('');
  }

  return (
    <nav className={styles.navBar}>
      <div className={styles.left}>
        <NavLink to="/" className={styles.link}>
          Home
        </NavLink>

        {user && (
          <NavLink to={`/collection/${user.id}`} className={styles.link}>
            Collection
          </NavLink>
        )}
      </div>

      <form onSubmit={handleSubmit} className={styles.searchForm}>
        <input
          value={query}
          onChange={(e) => setQuery(e.target.value)}
          placeholder="Search films…"
          className={styles.searchInput}
        />
        <button type="submit" className={styles.searchBtn}>
          Search
        </button>
      </form>

      <div className={styles.right}>
        {user ? (
          <Link to="/logout" className={styles.link}>
            Logout
          </Link>
        ) : (
          <NavLink to="/login" className={styles.link}>
            Login
          </NavLink>
        )}
      </div>
    </nav>
  );
}
