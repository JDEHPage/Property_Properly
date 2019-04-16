import React from 'react';
import './Customers.css';

const Customers = () => {
	return(
		<main>
		<h2 className="page-title">Customers</h2>

		<table className="customers-table" cellPadding="5">
		<tbody>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Email</th>
				<th>Telephone</th>
				<th>Num. Bookings</th>
			</tr>
			</tbody>
		</table>
		</main>
	);
}

export default Customers;
