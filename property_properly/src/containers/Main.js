import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import NavBar from '../components/NavBar';
import FrontDesk from '../components/FrontDesk';
import Bookings from '../components/Bookings';
import Customers from '../components/Customers';
import Availability from '../components/Availability';
import Admin from '../components/Admin';

class Main extends Component{
	constructor(props){
		super(props);
		this.state = {

		}
	}

	render (){
		return(
			<Router>
				<NavBar />
				<Switch>
					<Route exact path="/" component={FrontDesk} />
					<Route exact path="/bookings" component={Bookings} />
					<Route exact path="/customers" component={Customers} />
					<Route exact path="/availability" component={Availability} />
					<Route exact path="/admin" component={Admin} />
				</Switch>
			</Router>
		);
	}
}

export default Main;
