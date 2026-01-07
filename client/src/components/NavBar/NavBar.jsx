import { useContext, useState } from 'react';
import { Link, NavLink, useNavigate } from 'react-router-dom';
import { UserContext } from '../../context/user/UserContext';

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
