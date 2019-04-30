import React from 'react'
import CustomerForm from "../customers/CustomerForm.js"

const FormStepTwo = (props) => {

	function handleCustomerChange(event){
		props.handleChange(event)
	}

	function customerlist(customers){
		console.log("Customers",customers);
		return customers.map((item, index) => {
			return <option key={index} value={item._links.self.href}>{item.email}</option>
		})
	}

	const toggleFocus = (event) => {
		event.preventDefault();
		if(event.target.id === "customer"){
			const newCustomerSubmit = document.querySelector('#new-customer-form > button[type="submit"]');
			newCustomerSubmit.setAttribute("disabled", "disabled");
		}
	}

	const toggleBlur = (event) => {
		event.preventDefault();
		if(event.target.id === "customer" && event.target.value === ""){
			const newCustomerSubmit = document.querySelector('#new-customer-form > button[type="submit"]');
			newCustomerSubmit.removeAttribute("disabled");
		}
	}

	const stepTwoNext = (event) => {
		event.preventDefault();

		let stepTwoDiv = document.getElementById("stepTwo");
		let stepThreeDiv = document.getElementById("stepThree");

		stepTwoDiv.style.cssText="opacity: 0; height:0;";
		stepThreeDiv.style.cssText="opacity: 1; height:350px;";
	}

	const stepTwoPrev = (event) => {
		event.preventDefault();
		let stepOneDiv = document.getElementById("stepOne");
		let stepTwoDiv = document.getElementById("stepTwo");

		stepTwoDiv.style.cssText="opacity: 0;  height:0;";
		stepOneDiv.style.cssText="opacity: 1;  height:350px;";
	}

	return(
		<div id="stepTwo">
			<label htmlFor="customer">Current Customer: &nbsp;
				<select name="customer" id="customer" defaultValue onChange={handleCustomerChange} onFocus={toggleFocus} onBlur={toggleBlur}>
					<option value="" readOnly>Pick a Customer...</option>
					{customerlist(props.customers)}
				</select>
			</label>

			<CustomerForm handleNewCustomer={props.handleNewCustomer}/>

			<div className="nav-btns">
				<button className="prev" onClick={stepTwoPrev}> &lt;&lt; </button>
				<button className="next" onClick={stepTwoNext} disabled={!props.customer}> &gt;&gt; </button>
			</div>
		</div>
	)

}

export default FormStepTwo;
