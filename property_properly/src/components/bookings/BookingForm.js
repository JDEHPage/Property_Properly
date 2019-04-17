import React, { Component } from "react";
import Request from "../../helpers/request"

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
    this.itemlist = this.itemlist.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.handleCheckboxChange = this.handleCheckboxChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  itemlist(){
    const result = this.props.bookableItems.map((item, index) => {
      const id = `cust${index}`;
      return (
        <span key={index}>
        <input type="checkbox" name="bookableItems" id={id}  value={item._links.self.href} onChange={this.handleCheckboxChange}/>
        <label htmlFor={id} >{item.name} </label>
        </span>
      )
    })
    return result;
  }

  customerlist(){
    return this.props.customers.map((item, index) => {
      return <option key={index} value={item._links.self.href}>{item.email}</option>
    })
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
        <form onSubmit= {this.handleSubmit}>
        <label htmlFor="startDate">Start Date </label>
        <input type = "date" id="startDate" name="startDate" onChange={this.handleChange}/>

        <label htmlFor="endDate">End Date </label>
        <input type = "date" id="endDate" name="endDate" onChange={this.handleChange}/>

        <fieldset >
        <legend>Select Rooms</legend>
        <div>
        {this.itemlist()}
        </div>
        </fieldset>

        <label htmlFor="customer">Customer</label>
        <select name="customer" id="customer" defaultValue onChange={this.handleChange}>
        <option value="" readOnly>Pick a A Customer...</option>
        {this.customerlist()}
        </select>

        <label htmlFor="notes">Notes </label>
        <textarea name="notes" id="notes" cols="30" rows="10" onChange={this.handleChange}></textarea >

        <button type="submit">Save</button>
        </form>
      );
    }
  }

  export default BookingForm;
