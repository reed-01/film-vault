import { useContext } from 'react';
import { UserContext } from '../../context/UserContext';
import { NavLink } from 'react-router-dom';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFilm } from '@fortawesome/free-solid-svg-icons';

import styles from './Header.module.css';

export default function Header() {
  const { user } = useContext(UserContext);

  return (
    <header className={styles.header}>
      <NavLink to="/" className={styles.left}>
        <FontAwesomeIcon icon={faFilm} className={styles.logo} />
        <h1 className={styles.title}>Film Vault</h1>
      </NavLink>

      <div className={styles.right}>
        {user ? <p>User: {user.username}</p> : <p>Welcome: Guest</p>}
      </div>
    </header>
  );
}
