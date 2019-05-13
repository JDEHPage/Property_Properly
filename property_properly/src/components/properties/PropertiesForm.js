import React, { Component } from "react";
import Request from "../../helpers/request"
import './PropertiesForm.css'

class PropertiesForm extends Component{
  constructor(props){
    super(props);
    this.state = {
      name: ""
    }
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.allProperties = this.allProperties.bind(this);
  }

  allProperties(){return this.props.properties.map((property, index) => {
      return <li key={index}>{property.name}</li>
    });}

  // function allRoomsBooked(){
  //   booking.bookableItems.map((item)=>{ return item.name}).join(', ');}

  handleChange(event){
    this.setState({[event.target.name]: event.target.value})
  }

  handleSubmit(event){
    event.preventDefault();
    const request = new Request();
    request.post('/api/properties', this.state)
    window.location = '/admin'
  }

    render(){
      return(
        <React.Fragment>
        <form onSubmit= {this.handleSubmit} className="property-form">
        <label htmlFor="name">Property Name </label>
        <input type = "text" id="name" name="name" onChange={this.handleChange}/>

        <button type="submit">Add</button>
        </form>
        <ul className="property-list">
          {this.allProperties()}
        </ul>
        </React.Fragment>
      );
    }
  }

  export default PropertiesForm;
