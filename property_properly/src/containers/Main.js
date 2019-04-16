import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import NavBar from "../components/NavBar";
import FrontDesk from "../components/FrontDesk";
import Bookings from "../components/bookings/Bookings";
import Customers from "../components/Customers";
import Availability from "../components/Availability";
import Admin from "../components/Admin";
import ErrorPage from "../components/ErrorPage";
import Request from '../helpers/request';

class Main extends Component{
	constructor(props){
		super(props);
		this.state = {
			bookings: [],
			customers: [],
			bookableItems: []
		}
	}

	componentDidMount(){
		const request = new Request();

		const bookingsPromise = request.get('/api/bookings');
		const customersPromise = request.get('/api/customers');
		const bookableItemsPromise = request.get('/api/bookableItems');

		const promises = [bookingsPromise, customersPromise, bookableItemsPromise]

		Promise.all(promises)
		.then(data => {
			this.setState({
				bookings: data[0]._embedded.customerBookings,
				customers: data[1]._embedded.customers,
				bookableItems: data[2]._embedded.bookableItems
			});
		});

	}

	render (){
		return(
			<Router>
				<NavBar />
				<Switch>
					<Route exact path="/" render={() => {
						return <FrontDesk bookableItems={this.state.bookableItems} />
					}} />
					<Route exact path="/bookings" render={() => {
						return <Bookings bookings={this.state.bookings} />
					}} />
					<Route exact path="/customers" render={() => {
						return <Customers customers={this.state.customers} />
					}} />
					<Route exact path="/availability" component={Availability} />
					<Route exact path="/admin" component={Admin} />
					<Route component={ErrorPage}/>
				</Switch>
			</Router>
		);
	}
}

export default Main;
