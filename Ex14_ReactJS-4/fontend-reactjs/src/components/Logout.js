import React, { Component } from 'react';
import {Link} from 'react-router-dom';

class Logout extends Component {
    onClick = () =>{
        localStorage.removeItem('token');
        localStorage.removeItem('user');
    }
    render() {
        return (
            <div className="float-right">
                <Link to="/login">
                    <button 
                        className="btn btn-secondary" 
                        style={{width:"100px"}}
                        onClick={this.onClick}
                    >Logout</button>
                </Link>
            </div>
        );
    }
}

export default Logout;