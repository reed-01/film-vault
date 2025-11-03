import styles from "./Header.module.css";

export default function Header() {
  return (
    <header className={styles.header}>
      <div className={styles.brand}>
        <h1 className={styles.title}>Film Vault</h1>
      </div>
    </header>
  );
}
