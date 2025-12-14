import { useContext } from 'react';
import { UserContext } from '../../context/UserContext';

export default function CollectionView() {

  const { user } = useContext(UserContext);

  return (
    <div>
      <h1>Film Collection</h1>
      <br/>
      <p>Hello, {user.username}! </p>
    </div>
  );
}