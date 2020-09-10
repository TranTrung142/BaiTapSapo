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
import Login from './components/Login';
import Register from './components/Register';
import NewCategory from './components/NewCategory';

class App extends Component {

    render(){

        return (
            <Router>
                <Switch>
                    <Route exact path="/categories" component={CategoryList}/>
                    {/* <Route to="/categories">
                        <CategoryList />
                    </Route> */}
                    <Route exact path="/login" component={Login} />
                    {/* <Route to="/login">
                        <Login />
                    </Route> */}
                    <Route exact path="/register" component={Register} />
                    {/* <Route to="/register">
                        <Register />
                    </Route> */}
                    <Route exact path="/category/:id" component={CategoryDetail}/>
                    {/* <Route to="/category/:id">
                        <CategoryDetail />
                    </Route> */}
                    <Route exact path="/newcategory" component={NewCategory}/>
                    {/* <Route to="/newcategory">
                        <NewCategory />
                    </Route> */}
                    <Route component={Login}/>
                </Switch>
            </Router>
        );
    }
}


export default App;
