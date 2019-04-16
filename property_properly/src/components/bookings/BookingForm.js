import React, { Component } from "react";

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
  }

    itemlist(){
      const result =  this.props.bookableItems.map((item, index) => {
        const id = `cust${index}`;
        return (
          <span key={index}>
          <input type="checkbox" name="bookableItems[]" id={id}  value={item._links.self.href}/>
          <label htmlFor={id} >{item.name} </label>
          </span>

        )
      })
      return result;
    }

    render(){
      return(
    <form onSubmit= {this.handleSubmit}>
    <label htmlFor="startDate">Start Date </label>
    <input type = "date" id="startDate" name="startDate" onChange={this.handleChange}/>

    <label htmlFor="endDate">End Date </label>
    <input type = "date" id="endDate" name="endDate" onChange={this.handleChange}/>

    <fieldset>
      <legend>Select Rooms</legend>
      <div>
        {this.itemlist()}
      </div>
    </fieldset>

    <label htmlFor="notes">Notes </label>
    <textarea name="notes" id="notes" cols="30" rows="10"></textarea>





    <button type="submit">Save</button>
    </form>
      );
  }
}

export default BookingForm;
