import React from 'react';
import PropertiesForm from '../properties/PropertiesForm.js'
import TypesForm from '../types/TypesForm.js'

const Admin = (props) => {
		return(
			<main>
			<h2 className="page-title">Admin Dashboard</h2>
			<PropertiesForm properties={props.properties}/>
			<TypesForm bookableItemTypes={props.bookableItemTypes}/>
			</main>
		);
	}


export default Admin;
