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
		props.show(event.target.parentNode.id)
	}

	return(
		<div id="stepOne">

		<label htmlFor="startDate">Start Date:
		<input type = "date" id="startDate" name="startDate" onChange={handleDateChange}/>
		</label>

		<label htmlFor="endDate">End Date:
		<input type = "date" id="endDate" name="endDate" onChange={handleDateChange}/>
		</label>

		<fieldset >
			<legend>Select Rooms</legend>
			{itemlist(props.bookableItems)}
		</fieldset>

		<button className="next" onClick={stepOneNext}>Next &gt; </button>

		</div>
	)

}

export default FormStepOne;
