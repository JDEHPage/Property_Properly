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
		props.show(event.target.parentNode.id)
	}

	return(
		<div id="stepTwo">
			<label htmlFor="customer">Customer</label>
			<select name="customer" id="customer" defaultValue onChange={handleCustomerChange}>
				<option value="" readOnly>Pick a A Customer...</option>
				{customerlist(props.customers)}
			</select>

			<CustomerForm handleNewCustomer={props.handleNewCustomer}/>

			<button className="prev"> &lt; Previous </button>
			<button className="next" onClick={stepTwoNext}>Next &gt; </button>

		</div>
	)

}

export default FormStepTwo;
