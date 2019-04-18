import React from 'react'
import CustomerForm from "../customers/CustomerForm.js"

const FormStepTwo = (props) => {

	function handleCustomerChange(event){
		props.handleChange(event)
	}

	function customerlist(customers){
		return customers.map((item, index) => {
			return <option key={index} value={item._links.self.href}>{item.email}</option>
		})
	}

	const stepTwoNext = (event) => {
		event.preventDefault();

		let stepTwoDiv = document.getElementById("stepTwo");
		let stepThreeDiv = document.getElementById("stepThree");

		stepTwoDiv.style.cssText="opacity: 0; height:0;";
		stepThreeDiv.style.cssText="opacity: 1; height:300px;";
	}

	const stepTwoPrev = (event) => {
		event.preventDefault();
		let stepOneDiv = document.getElementById("stepOne");
		let stepTwoDiv = document.getElementById("stepTwo");

		stepTwoDiv.style.cssText="opacity: 0;  height:0;";
		stepOneDiv.style.cssText="opacity: 1;  height:300px;";
	}

	return(
		<div id="stepTwo">
			<label id="existing-customer" htmlFor="customer">Current Customer: &nbsp;
				<select name="customer" id="customer" defaultValue onChange={handleCustomerChange}>
					<option value="" readOnly>Pick a Customer...</option>
					{customerlist(props.customers)}
				</select>
			</label>

			<CustomerForm handleNewCustomer={props.handleNewCustomer}/>

			<div className="nav-btns">
				<button className="prev" onClick={stepTwoPrev}> &lt;&lt; </button>
				<button className="next" onClick={stepTwoNext}> &gt;&gt; </button>
			</div>
		</div>
	)

}

export default FormStepTwo;
