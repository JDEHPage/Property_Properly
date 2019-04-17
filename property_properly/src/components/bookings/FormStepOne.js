import React from 'react'

const FormStepOne = (props) => {


	function handleDateChange(event){
		props.handleChange(event)
	}

	function handleCheckboxChange(event){
		props.handleCheckboxChange(event)
	}

	function itemlist(bookableItems){
		const result = bookableItems.map((item, index) => {
			const id = `cust${index}`;
			return (
				<span key={index}>
				<input type="checkbox" name="bookableItems" id={id}  value={item._links.self.href} onChange={handleCheckboxChange}/>
				<label htmlFor={id} >{item.name} </label>
				</span>
			)
		})
		return result;
	}

	function stepOneNext(event){
		event.preventDefault();
		console.log("hide step one and show step two");
	}

	return(
		<div id="step-one">
		<label htmlFor="startDate">Start Date </label>
		<input type = "date" id="startDate" name="startDate" onChange={handleDateChange}/>

		<label htmlFor="endDate">End Date </label>
		<input type = "date" id="endDate" name="endDate" onChange={handleDateChange}/>

		<fieldset >
			<legend>Select Rooms</legend>
			{itemlist(props.bookableItems)}
		</fieldset>

		<button className="next" onClick={stepOneNext}>Next > </button>

		</div>
	)

}

export default FormStepOne;
