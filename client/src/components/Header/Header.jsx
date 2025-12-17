import { useContext } from 'react';
import { UserContext } from '../../context/UserContext';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFilm } from '@fortawesome/free-solid-svg-icons';

import styles from './Header.module.css';

export default function Header() {
  const { user } = useContext(UserContext);

  return (
    <header>
      <div className={styles.leftHeader}>
        <FontAwesomeIcon icon={faFilm} className={styles.logo} />
        <h1 className={styles.title}>Film Vault</h1>
      </div>

      <div className={styles.rightHeader}>
        {user ? (
          <p className={styles.greeting}>Welcome: {user.username}</p>
        ) : (
          <p>Login to create a collection.</p>
        )}
      </div>
    </header>
  );
}
