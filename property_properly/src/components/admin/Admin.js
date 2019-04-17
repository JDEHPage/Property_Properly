import React from 'react';
import PropertiesForm from '../properties/PropertiesForm.js'

const Admin = (props) => {
		return(
			<main>
			<h2 className="page-title">Admin Dashboard</h2>
			<PropertiesForm properties={props.properties}/>
			</main>
		);
	}


export default Admin;
