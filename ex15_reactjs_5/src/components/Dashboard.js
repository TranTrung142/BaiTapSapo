import React, { Component } from 'react';
import {Link, Redirect} from 'react-router-dom';

import UserData from '../data/user.json';

class Dashboard extends Component {
    constructor(props){
        super(props);
        let token = localStorage.getItem("token");
        let loggedIn = false;
        if(token === 'ascnascnaosc-12asca-123ascascaasfkgdfh'){
            loggedIn = true;
        }
        this.state = {
            loggedIn
        }
    }
    
    render() {
        if(this.state.loggedIn === false){
            return <Redirect to="/login" />
        }
        let id = this.props.match.params.id;
        id = parseInt(id, 10);
        let ele = UserData.map((user, index)=>{
            if(user.id === id){
                return (
                        <div className="card text-left">
                            <div className="card-header text-center">
                                <h5>
                                {user.userName}
                                </h5>
                            </div>
                            <div className="card-body">
                               
                                <div className="form-body"> <label><h5>Email: </h5></label> {user.email}</div>
                                <div className="form-body"> <label><h5>Phone: </h5></label> {user.phone}</div>
                            </div>
                        </div>
                   )
            }
        })
        return (
            <div>
                <div className="container text-center">
                    <h4 className="my-5">Welcome</h4>
                    <button className="btn btn-warning my-2"><Link to="/logout">logout</Link></button>
                    <div className="row">
                        <div className="col-6">
                            {ele}
                        </div>
                        
                        <div className="col-6">
                            <img className="img-fluid" src="https://png.pngtree.com/png-clipart/20190618/original/pngtree-sitting-sitting-position-notebook-cartoon-png-image_3921017.jpg" />
                        </div>
                    </div>
                    
                </div>
                
            </div>
        );
    }
}

export default Dashboard;