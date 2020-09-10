import React, {Component} from 'react';
import './App.css';
import {
    BrowserRouter as Router,
    Switch,
    Route
  } from "react-router-dom";

import CategoryList from './components/CategoryList';
import CategoryItem from './components/CategoryItem';
import CategoryDetail from './components/CategoryDetail'

class App extends Component {

    render(){

        return (
            <Router>
                <Switch>
                    <Route exact path="/categories" component={CategoryList}/>
                    <Route exact path="/category/:id" component={CategoryDetail}/>
                    <Route component={CategoryList}/>
                </Switch>
            </Router>
        );
    }
}


export default App;
