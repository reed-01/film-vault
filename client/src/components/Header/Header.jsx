import { useContext } from 'react';
import { UserContext } from '../../context/UserContext';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFilm } from '@fortawesome/free-solid-svg-icons';

import styles from './Header.module.css';

export default function Header() {
  const { user } = useContext(UserContext);

  return (
    <header className={styles.header}>
      <div className={styles.left}>
        <FontAwesomeIcon icon={faFilm} />
        <h1 className={styles.title}>Film Vault</h1>
      </div>

      <div className={styles.right}>
        {user ? (
          <p>Welcome: {user.username}</p>
        ) : (
          <p>Login to create a collection.</p>
        )}
      </div>
    </header>
  );
}
