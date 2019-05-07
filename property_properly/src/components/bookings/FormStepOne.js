import React, {Component} from 'react'

class FormStepOne extends Component {

	constructor(props){
		super(props);
		this.state = {
			roomSelected: false,
			stepCompleted: false
		}
		this.handleDateChange = this.handleDateChange.bind(this);
		this.handleCheckboxChange = this.handleCheckboxChange.bind(this);
		this.itemlist = this.itemlist.bind(this);
		this.stepOneNext = this.stepOneNext.bind(this);
	}

	handleDateChange(event){
		if(event.target.name === "startDate"){
			this.setState({stepCompleted: (event.target.value !== "") && (this.props.endDate !== "") && this.state.roomSelected })
		} else {
			this.setState({stepCompleted: (this.props.startDate !== "") && (event.target.value !== "") && this.state.roomSelected })
		}
		this.props.handleChange(event)
	}

	handleCheckboxChange(event){
		this.setState({roomSelected: event.target.checked})
		this.setState({stepCompleted: (this.props.startDate !== "") && (this.props.endDate !== "") && event.target.checked })

		this.props.handleCheckboxChange(event)
	}


	 
	itemlist(bookableItems, startDate, endDate){
		console.log(bookableItems);
		console.log(startDate);
		console.log(endDate);

		if (startDate !== "" && endDate !== "") {
			console.log("Hello I work");

			const result = bookableItems.map((item, index) => {
				const id = `item${index}`;

				const itemBookings = item.bookings.map((booking) => {
					return booking
				})
				
				const passFail = []

					for (const booking of itemBookings) {
						console.log(booking.startDate);
						
						if (
						
							(startDate >= booking.startDate && endDate <= booking.endDate) ||
							(startDate <= booking.startDate && endDate >= booking.endDate) ||
							(startDate <= booking.startDate && endDate > booking.endDate) ||
							(startDate < booking.startDate && endDate >= booking.endDate) ||
							(startDate >= booking.startDate && startDate < booking.endDate && endDate > booking.endDate) 

						) {
							passFail.push(false)
						} else {
							passFail.push(true)
						}
					}
				
				console.log(passFail);

			const check = passFail.every((item) => {
				return item === true
			}) 
			
			console.log(check);
			
			if (check === true) {
				return (
					<span key={index}>
					<input type="checkbox" name="bookableItems" id={id}  value={item._links.self.href} onChange={this.handleCheckboxChange}/>
					<label htmlFor={id} >{item.name} </label>
					</span>
				)
			} else {
				return null
			}
			
			})
				return result;
		}

	}



	

	stepOneNext(event){
		event.preventDefault();

		let stepOneDiv = document.getElementById("stepOne");
		let stepTwoDiv = document.getElementById("stepTwo");

		stepOneDiv.style.cssText="opacity: 0; height:0;";
		stepTwoDiv.style.cssText="opacity: 1; height: 350px;";
	}

	todayAsString(){
		let today = new Date();
		let options = { year: 'numeric', month: 'numeric', day: 'numeric'};
		let dateFormatter = new Intl.DateTimeFormat('en-GB', options);
		// return dateFormatter.format(today).replace(/\//g,'-');
		let dateString = dateFormatter.format(today);
		return dateString.substr(6, 4)+"-"+dateString.substr(3, 2)+"-"+dateString.substr(0, 2);
	}

	render(){
	return(
		<div id="stepOne">

		<label htmlFor="startDate">Start Date: &nbsp;
		<input type = "date" min={this.todayAsString()} id="startDate" name="startDate" onChange={this.handleDateChange}/>
		</label>

		<label htmlFor="endDate">End Date: &nbsp;
		<input type="date" min={this.todayAsString()} id="endDate" name="endDate" onChange={this.handleDateChange}/>
		</label>

		<fieldset >
			<legend>Select Rooms</legend>
			{this.itemlist(this.props.bookableItems,this.props.startDate, this.props.endDate)}
		</fieldset>

		<div className="nav-btns">
			<button className="next" onClick={this.stepOneNext} disabled={!this.state.stepCompleted}> &gt;&gt; </button>
		</div>

		</div>
	)}

}

export default FormStepOne;
