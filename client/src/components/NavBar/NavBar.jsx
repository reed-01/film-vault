import { useContext } from 'react';
import { Link, NavLink } from 'react-router-dom';
import { UserContext } from '../../context/UserContext';

import styles from './NavBar.module.css';

export default function NavBar() {
  const { user } = useContext(UserContext);

  return (
    <nav>
      <div className={styles.navLeft}>
        <NavLink to="/">Home</NavLink>
        <NavLink to="/collection/:userId">Collection</NavLink>
      </div>

      <div className={styles.navRight}>
        {user ? (
          <Link to="/logout">Logout</Link>
        ) : (
          <NavLink to="/login">Login</NavLink>
        )}
      </div>
    </nav>
  );
}
