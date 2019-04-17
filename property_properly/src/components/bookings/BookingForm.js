import React, { Component } from "react";
import Request from "../../helpers/request"
import FormStepOne from './FormStepOne.js'
import FormStepTwo from './FormStepTwo.js';
import './BookingForm.css';


class BookingForm extends Component{
	constructor(props){
		super(props);
		this.state = {
			startDate: "",
			endDate: "",
			notes: "",
			bookableItems: [],
			customer: "",
			steps: {
				stepOne: true,
				stepTwo: false,
				stepThree: false
			}
		}
		this.handleChange = this.handleChange.bind(this);
		this.handleCheckboxChange = this.handleCheckboxChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
		this.handleNewCustomer = this.handleNewCustomer.bind(this);
	}

	handleNewCustomer(newCustomer){
		this.setState({customer: newCustomer._links.self.href})
	}

	handleChange(event){
		this.setState({[event.target.name]: event.target.value})
	}

	handleCheckboxChange(event){
		var newArray = this.state.bookableItems.slice();
		newArray.push(event.target.value);
		this.setState({bookableItems:newArray})
	}

	handleSubmit(event){
		event.preventDefault();
		const request = new Request();
		request.post('/api/customerBookings', this.state).then(() => {
			window.location = '/'
		})
	}

	render(){
		return(
			<section id="new-booking-form">
			<h3>Add a New Booking</h3>

			<div className="current-selection">
				<p><strong>Start Date:</strong> {this.state.startDate}</p>
				<p><strong>End Date:</strong> {this.state.endDate}</p>
				<p><strong>Room/s:</strong> {this.state.bookableItems}</p>
				<p><strong>Customer:</strong> {this.state.customer}</p>
				<p><strong>Notes:</strong> {this.state.notes}</p>
			</div>

			<FormStepTwo
				bookableItems={this.props.bookableItems}
				customers={this.props.customers}
				handleChange={this.handleChange}
				handleNewCustomer={this.handleNewCustomer}/>

			<form onSubmit= {this.handleSubmit}>
				<FormStepOne handleChange={this.handleChange} bookableItems={this.props.bookableItems} handleCheckboxChange={this.handleCheckboxChange}/>

				<div id="step-three">
					<label htmlFor="notes">Notes </label>
					<textarea name="notes" id="notes" cols="30" rows="10" onChange={this.handleChange}></textarea >
					<button type="submit">Save</button>
				</div>

			</form>

			</section>
		);
	}
}

export default BookingForm;
