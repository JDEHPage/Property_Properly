import React from 'react';

const Customer = ( { customer } ) => {
	const numBookings = customer.bookings.length;
	const mobile = customer.mobileNumber || 'not supplied';
	
	return(
		<tr>
		<td>{customer.id}</td>
		<td>{customer.name}</td>
		<td>{customer.address}</td>
		<td>
			<a href={customer.email}>{customer.email}</a>
		</td>
		<td>{mobile}</td>
		<td>{numBookings}</td>
		</tr>
	);
}

export default Customer;
