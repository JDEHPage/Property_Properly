import React, { Component } from "react";
import Request from "../../helpers/request"
import './ItemsForm.css'


class ItemsForm extends Component{
  constructor(props){
    super(props);
    this.state = {
      property: [],
      name: "",
      type: [],
      rate: "",
      capacity: "",
      paymentOptions: [],
      amenities: []
    }
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.allitems = this.allitems.bind(this);
  }

  allitems(){return this.props.bookableItems.map((types, index) => {
      return <li key={index}>{types.name}</li>
    });}

  // function allRoomsBooked(){
  //   booking.bookableItems.map((item)=>{ return item.name}).join(', ');}

  handleChange(event){
    this.setState({[event.target.name]: event.target.value})
  }

  handleSubmit(event){
    event.preventDefault();
    const request = new Request();
    request.post('/api/bookableItems', this.state)
    window.location = '/admin'
  }


  allProperties(){return this.props.properties.map((property, index) => {
      return <li key={index}>{property.name}</li>
    });}

  propertylist(){
    return this.props.properties.map((property, index) => {
      return <option key={index} value={property._links.self.href}>{property.name}</option>
    })
  }

  typelist(){
    return this.props.bookableItemTypes.map((type, index) => {
      return <option key={index} value={type._links.self.href}>{type.name}</option>
    })
  }

    render(){
      return(
        <>
        <form className="item-type-form" onSubmit= {this.handleSubmit}>

        <label htmlFor="property">Associated Property</label>
        <select name="property" id="property" defaultValue onChange={this.handleChange}>
        <option value="" readOnly>Select a Type...</option>
        {this.propertylist()}
        </select>

        <label htmlFor="type">Associated Type </label>
        <select name="type" id="type" defaultValue onChange={this.handleChange}>
        <option value="" readOnly>Select a Type...</option>
        {this.typelist()}
        </select>

        <label htmlFor="name">Name </label>
        <input type = "text" id="name" name="name" onChange={this.handleChange}/>

        <label htmlFor="rate">Rate </label>
        <input type = "text" id="rate" name="rate" onChange={this.handleChange}/>

        <label htmlFor="capacity">Capacity </label>
        <input type = "text" id="capacity" name="capacity" onChange={this.handleChange}/>



        <button type="submit">Save</button>
        </form>
        <ul className="allitems-list">
          {this.allitems()}
        </ul>
        </>
      );
    }
  }

  export default ItemsForm;
