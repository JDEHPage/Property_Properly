import React from 'react';
import Customer from './Customer.js';
import './Customers.css';

const Customers = ( {customers} ) => {
	customers.sort(function(a,b){
		const nameA = a.name.toUpperCase();
  	const nameB = b.name.toUpperCase();
  	if (nameA < nameB) {
    	return -1;
  	}
  	if (nameA > nameB) {
    	return 1;
  	}
  	// names must be equal
  	return 0;
	});

	const allCustomers = customers.map((customer, index) => {
		return <Customer key={index} customer={customer} />
	});

	const arrows = () => {
		return(
			<span className="arrows">
				<img src="../../img/arrow_up.png" alt="arrow up"/>
				<img src="../../img/arrow_down.png" alt="arrow up"/>
			</span>
		);
	}

	return(
		<main>
		<h2 className="page-title">Customers</h2>

		<table className="customers-table" cellPadding="10">
			<thead>
				<tr>
					<th id="id">ID {arrows()}</th>
					<th id="name">Name {arrows()}</th>
					<th>Address</th>
					<th>Email</th>
					<th>Telephone</th>
					<th>Num. Bookings</th>
				</tr>
			</thead>
			<tbody>
			{allCustomers}
			</tbody>
		</table>
		</main>
	);
}

export default Customers;
