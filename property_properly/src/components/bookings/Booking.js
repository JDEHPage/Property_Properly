import React from 'react';
import Request from '../../helpers/request';

const Booking = ( { booking } ) => {

	const getEndDate = () => {
		return booking.endDate.replace('00:00:00 BST', '');
	}

	const getStartDate = () => {
		let date = new Date(booking.startDate);
		return date.toDateString();
	}

	const calculateNumNights = (booking) => {

		const date2 = new Date(getEndDate());
		const date1 = new Date(booking.startDate);
		const timeDiff = Math.abs(date2.getTime() - date1.getTime());
		const dayDifference = Math.ceil(timeDiff / (1000 * 3600 * 24));
		return dayDifference;
	}

	const calculateTotalPrice = (booking) => {
		// add up the room rates
		const rates = booking.bookableItems.map((item)=>{ return item.rate});
		const totalRates = rates.reduce((acc, item) => {
			return acc + item;
		});
		// multiply by number of nights
		return calculateNumNights(booking) * totalRates;
	}

	const allRoomsBooked = booking.bookableItems.map((item)=>{ return item.name}).join(', ');

	const deleteBooking = () => {
		const request = new Request();
		const url = `/api/customerBookings/${booking.id}`
		request.delete(url).then(() => {
			window.location = "/bookings"
		})
	}

	return (
		<tr>
		<td>{booking.id}</td>
		<td>{getStartDate()}</td>
		<td>{getEndDate()}</td>
		<td>{calculateNumNights(booking)}</td>
		<td>{booking.customer.name}</td>
		<td>{allRoomsBooked}</td>
		<td>£{calculateTotalPrice(booking)}</td>

		<td><button className="delete-btn" onClick={deleteBooking}>Delete</button></td>
		</tr>
	);
}

export default Booking;
