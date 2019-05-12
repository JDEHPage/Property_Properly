import React from 'react';

const Customer = ( props ) => {
	const numBookings = props.customer.bookings.length;
	const mobile = props.customer.mobileNumber || 'not supplied';

	const upcomingBookings = props.customer.bookingsNotInPast.length;

	function deleteCustomer(){
		props.handleDelete("customers", props.customer.id)
	}

	return(
		<tr>
		<td>{props.customer.id}</td>
		<td>{props.customer.name}</td>
		<td>{props.customer.address}</td>
		<td>
			<a href={props.customer.email}>{props.customer.email}</a>
		</td>
		<td>{mobile}</td>
		<td>{numBookings}</td>
		<td>{upcomingBookings}</td>
		<td><button className="delete-btn" onClick={deleteCustomer}>Delete</button></td>
		</tr>
	);
}

export default Customer;
