import React from 'react';
import Request from '../../helpers/request';

const Customer = ( { customer } ) => {
	const numBookings = customer.bookings.length;
	const mobile = customer.mobileNumber || 'not supplied';

	const deleteCustomer = () => {
		const request = new Request();
		const url = `/api/customers/${customer.id}`
		request.delete(url).then(() => {
			window.location = "/customers"
		})
	}

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
		<td><button className="delete-btn" onClick={deleteCustomer}>Delete</button></td>
		</tr>
	);
}

export default Customer;
