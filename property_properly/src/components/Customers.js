import React from 'react';
import './Customers.css';

const Customers = () => {
	return(
		<main>
		<h2 className="page-title">Customers</h2>

		<table className="customers-table" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Email</th>
				<th>Telephone</th>
				<th>Num. Bookings</th>
			</tr>

		</table>
		</main>
	);
}

export default Customers;
