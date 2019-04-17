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

  return(
    <>
    <label htmlFor="customer">Customer</label>
    <select name="customer" id="customer" defaultValue onChange={handleCustomerChange}>
    <option value="" readOnly>Pick a A Customer...</option>
    {customerlist(props.customers)}
    </select>
    <CustomerForm handleNewCustomer={props.handleNewCustomer}/>
    </>
  )

}

export default FormStepTwo;
