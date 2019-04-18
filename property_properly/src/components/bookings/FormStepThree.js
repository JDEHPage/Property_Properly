import React from 'react';

const FormStepThree = (props) => {
	const stepThreePrev = (event) => {
		event.preventDefault();
		let stepTwoDiv = document.getElementById("stepTwo");
		let stepThreeDiv = document.getElementById("stepThree");

		stepThreeDiv.style.cssText="opacity: 0; height:0;";
		stepTwoDiv.style.cssText="opacity: 1; height:350px;";
	}

	const handleNotesChange = (event) => {
		props.handleChange(event)
	}

	return(
		<div id="stepThree">
			<label htmlFor="notes">Notes: </label>
			<textarea name="notes" id="notes" cols="30" rows="10" onChange={handleNotesChange}></textarea >

			<button type="submit">Save Booking</button>

			<div className="nav-btns">
				<button className="prev" onClick={stepThreePrev}> &lt;&lt; </button>
			</div>

		</div>
	);
}

export default FormStepThree;
