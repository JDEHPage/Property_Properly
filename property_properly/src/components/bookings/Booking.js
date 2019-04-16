import React from 'react';

const Booking = ( { booking } ) => {
	const calculateNumNights = () => {
		return (3);
	}

	const calculateTotalPrice = () => {
		return ('£100');
	}

	const allRoomsBooked = booking.bookableItems.map((item)=>{ return item.name}).join(', ');

	return (
		<tr>
		<td>{booking.id}</td>
		<td>{booking.startDate}</td>
		<td>{booking.endDate}</td>
		<td>{calculateNumNights()}</td>
		<td>{booking.customer.name}</td>
		<td>{allRoomsBooked}</td>
		<td>{calculateTotalPrice()}</td>
		</tr>
	);
}

export default Booking;
