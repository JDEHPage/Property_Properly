import React from 'react';
import Booking from './Booking.js';
import './Bookings.css';

const Bookings = ( { bookings } ) => {
	const allBookings = bookings.map((booking, index) => {
		return <Booking key={index} booking={booking} />
	});

	return (
		<main>
		<h2 className="page-title">Bookings</h2>

		<table className="bookings-table" cellPadding="10">
			<thead>
				<tr>
					<th>ID</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Nights</th>
					<th>Customer</th>
					<th>Room</th>
					<th>Total Price</th>
				</tr>
			</thead>
			<tbody>
				{allBookings}
			</tbody>
		</table>
		</main>
	);
}

export default Bookings;
