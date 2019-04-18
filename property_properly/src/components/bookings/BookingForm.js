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
			stepOne: true,
			stepTwo: false,
			stepThree: false
		}
		this.handleChange = this.handleChange.bind(this);
		this.handleCheckboxChange = this.handleCheckboxChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
		this.handleNewCustomer = this.handleNewCustomer.bind(this);
		this.show = this.show.bind(this);
    this.displayCheckboxChange = this.displayCheckboxChange.bind(this);
	}

	handleNewCustomer(newCustomer){
		this.setState({customer: newCustomer._links.self.href})
	}

	handleChange(event){
		this.setState({[event.target.name]: event.target.value})
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



	handleSubmit(event){
		event.preventDefault();
		const request = new Request();
		request.post('/api/customerBookings', this.state).then(() => {
			window.location = '/'
		})
	}

	show(stepToShow){
		let stepOneDiv = document.getElementById("stepOne");
		let stepTwoDiv = document.getElementById("stepTwo");
		let stepThreeDiv = document.getElementById("stepThree");

		if(stepToShow === 'stepOne'){
			this.setState({stepOne: false, stepTwo: true, stepThree: false});
			stepOneDiv.style.cssText="opacity: 0; display:none;";
			stepTwoDiv.style.cssText="opacity: 1; display:flex;";
		} else if(stepToShow === 'stepTwo') {
			this.setState({stepOne: false, stepTwo: false, stepThree: true});
			stepTwoDiv.style.cssText="opacity: 0; display:none;";
			stepThreeDiv.style.cssText="opacity: 1; display:flex;";
		} else {
			this.setState({stepOne: false, stepTwo: false, stepThree: true});
		}

	}

	render(){
		return(
			<section id="new-booking-form">
			<h3>Add a New Booking</h3>

			<div className="current-selection">
				<p><strong>Start Date:</strong> {this.state.startDate}</p>
				<p><strong>End Date:</strong> {this.state.endDate}</p>
				<p><strong>Room/s:</strong> {this.displayCheckboxChange()} </p>
				<p><strong>Customer:</strong> {this.state.customer}</p>
				<p><strong>Notes:</strong> {this.state.notes}</p>
			</div>

			<FormStepTwo
				bookableItems={this.props.bookableItems}
				customers={this.props.customers}
				show={this.show}
				handleChange={this.handleChange}
				handleNewCustomer={this.handleNewCustomer}/>

			<form onSubmit= {this.handleSubmit}>
				<FormStepOne
					handleChange={this.handleChange}
					handleCheckboxChange={this.handleCheckboxChange}
					show={this.show}
					bookableItems={this.props.bookableItems}/>

				<div id="stepThree">
					<label htmlFor="notes">Notes </label>
					<textarea name="notes" id="notes" cols="30" rows="10" onChange={this.handleChange}></textarea >
					<button className="prev"> &lt; Previous </button>
					<button type="submit">Save</button>
				</div>

			</form>

			</section>
		);
	}
}

export default BookingForm;
