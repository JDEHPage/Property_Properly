import React from 'react';

const Booking = ( { booking } ) => {
	const calculateNumNights = () => {
		return (3);
	}

	const calculateTotalPrice = () => {
		return ('£100');
	}

	return (
		<tr>
		<td>booking id</td>
		<td>start date</td>
		<td>end date</td>
		<td>{calculateNumNights}</td>
		<td>customer name</td>
		<td>room number</td>
		<td>{calculateTotalPrice}</td>
		</tr>
	);
}

export default Booking;
