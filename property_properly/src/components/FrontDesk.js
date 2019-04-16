import React, { Component } from 'react';
import BookingForm from './bookings/BookingForm'

class FrontDesk extends Component {
	constructor(props){
		super(props);
		this.state ={



		}
	}
	render(){
		return(
			<main>
			<h2 className="page-title">Front Desk</h2>
			<BookingForm bookableItems={this.props.bookableItems}
			customers={this.props.customers}/>
			</main>
		);
	}
}

export default FrontDesk;
