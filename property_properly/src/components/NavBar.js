import React from "react";
import { Link } from "react-router-dom";
import './NavBar.css';

const NavBar = () => (
	<React.Fragment>
	<section className="header">
		<h1>Property Properly</h1>
		<nav>
		  <ul>
		    <li>
		      <Link to="/">Front Desk</Link>
		    </li>
		    <li>
		      <Link to="/bookings">Bookings</Link>
		    </li>
		    <li>
		      <Link to="/customers">Customers</Link>
		    </li>
				<li>
		      <Link to="/availability">Availability</Link>
		    </li>
				<li>
		      <Link to="/admin">Admin</Link>
		    </li>
		  </ul>
		</nav>
	</section>
	</React.Fragment>
);

export default NavBar;
