import React, {Component} from 'react';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link,
  } from "react-router-dom";

import './App.css';
import Login from './components/Login';
import Dashboard from './components/Dashboard';
import Logout from './components/Logout';


class App extends Component {

    render(){

        return (
            <Router>
                <Switch>
                    <Route exact path="/login" >
                        <Login />
                    </Route>
                    <Route path="/dashboard/:id" component={Dashboard}/>
                    <Route path="/logout" component={Logout}/>
                    <Route >
                        <Login />
                    </Route>
                </Switch>
            </Router>
        );
    }
}


export default App;