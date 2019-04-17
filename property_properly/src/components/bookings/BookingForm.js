import React, { Component } from "react";
import Request from "../../helpers/request"
import FormStepOne from './FormStepOne.js'
import FormStepTwo from './FormStepTwo.js'

class BookingForm extends Component{
  constructor(props){
    super(props);
    this.state = {
      startDate: "",
      endDate: "",
      notes: "",
      bookableItems: [],
      customer: ""
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

  // handleCheckboxChange(event){
  //   console.log(event.target.value)
  //     this.setState({bookableItems: event.target.value})
  //   }

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
        <>
        <FormStepTwo handleChange={this.handleChange} bookableItems={this.props.bookableItems} customers={this.props.customers} handleNewCustomer={this.handleNewCustomer}/>

        <form onSubmit= {this.handleSubmit}>
        <FormStepOne handleChange={this.handleChange} bookableItems={this.props.bookableItems} handleCheckboxChange={this.handleCheckboxChange}/>

        <label htmlFor="notes">Notes </label>
        <textarea name="notes" id="notes" cols="30" rows="10" onChange={this.handleChange}></textarea >

        <button type="submit">Save</button>
        </form>

        </>
      );
    }
  }

  export default BookingForm;
