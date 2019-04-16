import React from 'react';
import './Bookings.css';

const Bookings = () => {
	return (
		<main>
		<h2 className="page-title">Bookings</h2>

		<table className="bookings-table" cellPadding="5">
		<tbody>
			<tr>
				<th>ID</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Nights</th>
				<th>Customer</th>
				<th>Room</th>
				<th>Total Price</th>
			</tr>
			<tr>
			</tr>
			</tbody>
		</table>
		</main>
	);
}

export default Bookings;
