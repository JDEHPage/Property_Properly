import React from 'react'

const FormStepOne = (props) => {

	const handleDateChange = (event) => {
		props.handleChange(event)
	}

	const handleCheckboxChange = (event) => {
		props.handleCheckboxChange(event)
	}

	const itemlist = (bookableItems) => {
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



	const stepOneNext = (event) => {
		event.preventDefault();

		let stepOneDiv = document.getElementById("stepOne");
		let stepTwoDiv = document.getElementById("stepTwo");

		stepOneDiv.style.cssText="opacity: 0; height:0;";
		stepTwoDiv.style.cssText="opacity: 1; height: 350px;";
	}

	return(
		<div id="stepOne">

		<label htmlFor="startDate">Start Date: &nbsp;
		<input type = "date" id="startDate" name="startDate" onChange={handleDateChange}/>
		</label>

		<label htmlFor="endDate">End Date: &nbsp;
		<input type = "date" id="endDate" name="endDate" onChange={handleDateChange}/>
		</label>

		<fieldset >
			<legend>Select Rooms</legend>
			{itemlist(props.bookableItems)}
		</fieldset>

		<div className="nav-btns">
			<button className="next" onClick={stepOneNext} disabled> &gt;&gt; </button>
		</div>

		</div>
	)

}

export default FormStepOne;
