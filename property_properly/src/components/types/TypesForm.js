import React, { Component } from "react";
import Request from "../../helpers/request"
import './TypesForm.css'

class TypesForm extends Component{
  constructor(props){
    super(props);
    this.state = {
      name: ""
    }
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.alltypes = this.alltypes.bind(this);
  }

  alltypes(){return this.props.bookableItemTypes.map((types, index) => {
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
    request.post('/api/bookableItemTypes', this.state)
    window.location = '/admin'
  }

    render(){
      return(
        <React.Fragment>
        <form className="item-type-form" onSubmit= {this.handleSubmit}>
        <label htmlFor="name">Room Types </label>
        <input type = "text" id="name" name="name" onChange={this.handleChange}/>

        <button type="submit">Add</button>
        </form>
        <ul className="types-list">
          {this.alltypes()}
        </ul>
        </React.Fragment>
      );
    }
  }

  export default TypesForm;
