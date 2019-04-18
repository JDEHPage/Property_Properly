import React, { Component } from "react";
import { CSSTransitionGroup } from 'react-transition-group';
import Request from "../../helpers/request"
import FormStepOne from './FormStepOne.js'
import FormStepTwo from './FormStepTwo.js';
import FormStepThree from './FormStepThree.js';
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
			error_message: "",
			success_message: ""
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
		console.log("clicked the Submit Booking button");
		const request = new Request();
		request.post('/api/customerBookings', this.state)
		.then((res) => {
			if(res.status === 409){
				this.setState({error_message: "Please make sure that a Start Date, End Date, Room and Customer have been selected before saving the new booking."});
				this.setState({success_message: ""});
			} else {
				this.setState({success_message: "New booking created"});
				this.setState({error_message: ""});

			}
		})

	}

	render(){
		return(
			<React.Fragment>
			<h3>Add a New Booking</h3>

			<div className="current-selection">
				<p><strong>Start Date:</strong> {this.state.startDate}</p>
				<p><strong>End Date:</strong> {this.state.endDate}</p>
				<p><strong>Room/s:</strong> {this.state.bookableItems}</p>
				<p><strong>Customer:</strong> {this.state.customer}</p>
				<p><strong>Notes:</strong> {this.state.notes}</p>
			</div>

			<div className="notifications"><span className="error">{this.state.error_message}</span><span className="success">{this.state.success_message}</span></div>

			<section id="new-booking-form">

				<CSSTransitionGroup
				transitionName="booking-stepTwo"
				transitionAppear={true}
	      transitionAppearTimeout={500}
	      transitionEnter={false}
	      transitionLeave={true}
				transitionLeaveTimeout={300}>

				<FormStepTwo
					customers={this.props.customers}
					handleChange={this.handleChange}
					handleNewCustomer={this.handleNewCustomer}/>

				</CSSTransitionGroup>

				<form onSubmit= {this.handleSubmit}>
					<CSSTransitionGroup
					transitionName="booking-stepOne"
					transitionAppear={true}
		      transitionAppearTimeout={500}
		      transitionEnter={false}
		      transitionLeave={true}
					transitionLeaveTimeout={300}>

					<FormStepOne
						handleChange={this.handleChange}
						handleCheckboxChange={this.handleCheckboxChange}
						bookableItems={this.props.bookableItems}/>

					</CSSTransitionGroup>

					<CSSTransitionGroup
					transitionName="booking-stepThree"
					transitionAppear={true}
		      transitionAppearTimeout={500}
		      transitionEnter={false}
		      transitionLeave={true}
					transitionLeaveTimeout={300}>

					<FormStepThree handleChange={this.handleChange}/>

					</CSSTransitionGroup>

				</form>

			</section>
			</React.Fragment>
		);
	}
}

export default BookingForm;
