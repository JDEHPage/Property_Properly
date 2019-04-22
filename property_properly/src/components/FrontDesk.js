import React from 'react';
import BookingForm from './bookings/BookingForm'

const FrontDesk = (props) => {

		return(
			<main>
			<h2 className="page-title">Front Desk</h2>
			<BookingForm bookableItems={props.bookableItems}
			customers={props.customers} addNewCustomerToState={props.addNewCustomerToState}/>
			</main>
		);

}

export default FrontDesk;
