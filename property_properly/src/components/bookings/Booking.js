import React from 'react';

const Booking = ( { booking } ) => {
	const calculateNumNights = (booking) => {
		return (3);
	}

	const calculateTotalPrice = (booking) => {
		// add up the room rates
		const rates = booking.bookableItems.map((item)=>{ return item.rate});
		const totalRates = rates.reduce((acc, item) => {
			return acc + item;
		});
		// multiply by number of nights
		return calculateNumNights() * totalRates;
	}

	const allRoomsBooked = booking.bookableItems.map((item)=>{ return item.name}).join(', ');

	return (
		<tr>
		<td>{booking.id}</td>
		<td>{booking.startDate}</td>
		<td>{booking.endDate}</td>
		<td>{calculateNumNights(booking)}</td>
		<td>{booking.customer.name}</td>
		<td>{allRoomsBooked}</td>
		<td>£{calculateTotalPrice(booking)}</td>
		</tr>
	);
}

export default Booking;
