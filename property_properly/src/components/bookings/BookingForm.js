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
			success_message: ""
		}

		this.handleChange = this.handleChange.bind(this);
		this.handleCheckboxChange = this.handleCheckboxChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
		this.handleNewCustomer = this.handleNewCustomer.bind(this);
    this.displayCheckboxChange = this.displayCheckboxChange.bind(this);
		this.displayCustomerChange = this.displayCustomerChange.bind(this);
	}

	handleNewCustomer(newCustomer){
		// add customer to Booking Form state
		this.setState({customer: newCustomer._links.self.href})

		// display the new customer in the booking form page
		this.displayCustomerChange()

		// add the customer to the Main component's customers state
		this.props.addNewCustomerToState(newCustomer);
	}

	handleChange(event){
		this.setState({[event.target.name]: event.target.value})
		this.displayCustomerChange()
	}

	handleCheckboxChange(event){
    const stateItems = this.state.bookableItems;
    if (event.target.checked === true) {
      var newArray1 = stateItems.slice();
  		newArray1.push(event.target.value);
  		this.setState({bookableItems:newArray1})

      this.displayCheckboxChange()
    } else {
      for( var i = 0; i < stateItems.length; i++){
        if ( stateItems[i] === event.target.value) {
          stateItems.splice(i, 1,);
          var newArray2 = stateItems;
          this.setState({bookableItems:newArray2})
          }
        }
      }
	   }

  displayCheckboxChange(){
    const arr1 = this.props.bookableItems;
    const arr2 = this.state.bookableItems;
    var ret = [];
    arr1.sort();
    arr2.sort();
        for(var i = 0; i < arr1.length; i += 1) {
            if(arr2.indexOf(arr1[i]._links.self.href) > -1){
                ret.push(arr1[i].name + ", ");
            }
       }
     return ret;
    };


		displayCustomerChange(){
			const arr1 = this.props.customers;
	    const name = this.state.customer;
	    var ret = "";
	    arr1.sort();
	        for(var i = 0; i < arr1.length; i += 1) {
	            if(name === arr1[i]._links.self.href){
	                ret = arr1[i].name;
	            }
	       }

			 if (ret !== "") {
			 	return ret;
			} else {
				return "New Customer";
			}
	    };

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
				<p><strong>Room/s:</strong> {this.displayCheckboxChange()} </p>
				<p><strong>Customer:</strong> {this.displayCustomerChange()}</p>
				<p><strong>Notes:</strong> {this.state.notes}</p>
			</div>

			<div className="notifications"><span className="success">{this.state.success_message}</span></div>

			<section id="new-booking-form">

				<CSSTransitionGroup
				transitionName="booking"
				transitionAppear={true}
	      transitionAppearTimeout={500}
	      transitionEnter={false}
	      transitionLeave={true}
				transitionLeaveTimeout={300}>

				<FormStepTwo
					customers={this.props.customers}
					customer={this.state.customer}
					handleChange={this.handleChange}
					handleNewCustomer={this.handleNewCustomer}/>

				<form onSubmit= {this.handleSubmit}>

					<FormStepOne
						handleChange={this.handleChange}
						handleCheckboxChange={this.handleCheckboxChange}
						bookableItems={this.props.bookableItems}
						startDate={this.state.startDate}
						endDate={this.state.endDate}/>

					<FormStepThree handleChange={this.handleChange}/>

				</form>

				</CSSTransitionGroup>

			</section>
			</React.Fragment>
		);
	}
}

export default BookingForm;
