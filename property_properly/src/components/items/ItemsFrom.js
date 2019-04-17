import React, { Component } from "react";
import Request from "../../helpers/request"


class ItemsForm extends Component{
  constructor(props){
    super(props);
    this.state = {
      name: ""
    }
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.allitems = this.allitems.bind(this);
  }

  allitems(){return this.props.items.map((property, index) => {
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
    request.post('/api/items', this.state)
    window.location = '/admin'
  }

    render(){
      return(
        <>
        <form onSubmit= {this.handleSubmit}>
        <label htmlFor="name">Property Name </label>
        <input type = "text" id="name" name="name" onChange={this.handleChange}/>

        <button type="submit">Save</button>
        </form>
        <ul>
          {this.allitems()}
        </ul>
        </>
      );
    }
  }

  export default ItemsForm;
