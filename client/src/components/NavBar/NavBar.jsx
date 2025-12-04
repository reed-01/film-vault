import { useContext } from 'react';
import { UserContext } from "../../context/UserContext"
import { NavLink } from 'react-router-dom';

import styles from './NavBar.module.css';

export default function NavBar() {

	const { user } = useContext(UserContext);

	return (
		<nav>
			<ul>
				<li>
					<NavLink to='/home'>Home</NavLink>
				</li>

				<li>
					<NavLink to='/collection'>Collection</NavLink>
				</li>

				
			</ul>
		</nav>
	)
}