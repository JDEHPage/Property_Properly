import React, { Component } from "react";
import Request from "../../helpers/request"


class CustomerForm extends Component{
  constructor(props){
    super(props);
    this.state = {
      address: "",
      name: "",
      email: "",
      mobileNumber: ""
    }
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event){
    this.setState({[event.target.name]: event.target.value})
  }

  handleNewCustomer(customer){
    this.props.handleNewCustomer(customer)
  }

  handleSubmit(event){
    event.preventDefault();
    const request = new Request();
    request.post('/api/customers', this.state)
    .then((response) => response.json())
    .then((customer) => {this.handleNewCustomer(customer)})
  }

    render(){
      return(
        <form id="new-customer-form" onSubmit= {this.handleSubmit}>
        <label htmlFor="name">Name </label>
        <input type = "text" id="name" name="name" onChange={this.handleChange}/>

        <label htmlFor="email">Email </label>
        <input type = "email" id="email" name="email" onChange={this.handleChange}/>

        <label htmlFor="mobileNumber">Contact Number </label>
        <input type = "tel" id="mobileNumber" name="mobileNumber" onChange={this.handleChange}/>

        <label htmlFor="address">Address </label>
        <input type = "text" id="address" name="address" onChange={this.handleChange}/>

        <button type="submit">Create New Customer</button>
        </form>
      );
    }
  }

  export default CustomerForm;
