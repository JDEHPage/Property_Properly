import React, {Component} from 'react'

class FormStepOne extends Component {

	constructor(props){
		super(props);
		this.state = {
			startDate: '',
			endDate: '',
			roomSelected: false,
			stepCompleted: false
		}
		this.handleDateChange = this.handleDateChange.bind(this);
		this.handleCheckboxChange = this.handleCheckboxChange.bind(this);
		this.itemlist = this.itemlist.bind(this);
		this.stepOneNext = this.stepOneNext.bind(this);
	}

	handleDateChange(event){
		this.setState({[event.target.name]: event.target.value})
		if(event.target.name === "startDate"){
			this.setState({stepCompleted: (event.target.value !== "") && (this.state.endDate !== "") && this.state.roomSelected })
		} else {
			this.setState({stepCompleted: (this.state.startDate !== "") && (event.target.value !== "") && this.state.roomSelected })
		}
		this.props.handleChange(event)
	}

	handleCheckboxChange(event){
		this.setState({roomSelected: event.target.checked})
		this.setState({stepCompleted: (this.state.startDate !== "") && (this.state.endDate !== "") && event.target.checked })

		this.props.handleCheckboxChange(event)
	}

	itemlist(bookableItems){
		const result = bookableItems.map((item, index) => {
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

	stepOneNext(event){
		event.preventDefault();

		let stepOneDiv = document.getElementById("stepOne");
		let stepTwoDiv = document.getElementById("stepTwo");

		stepOneDiv.style.cssText="opacity: 0; height:0;";
		stepTwoDiv.style.cssText="opacity: 1; height: 350px;";
	}

	render(){
	return(
		<div id="stepOne">

		<label htmlFor="startDate">Start Date: &nbsp;
		<input type = "date" id="startDate" name="startDate" onChange={this.handleDateChange}/>
		</label>

		<label htmlFor="endDate">End Date: &nbsp;
		<input type = "date" id="endDate" name="endDate" onChange={this.handleDateChange}/>
		</label>

		<fieldset >
			<legend>Select Rooms</legend>
			{this.itemlist(this.props.bookableItems)}
		</fieldset>

		<div className="nav-btns">
			<button className="next" onClick={this.stepOneNext} disabled={!this.state.stepCompleted}> &gt;&gt; </button>
		</div>

		</div>
	)}

}

export default FormStepOne;
