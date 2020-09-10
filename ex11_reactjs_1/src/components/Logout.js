import React, { Component } from 'react';
import {Link} from 'react-router-dom';


class Logout extends Component {
    constructor(props){
        super(props);
        localStorage.removeItem("token");
    }
    render() {
        return (
            <div>
                <h5>Bạn đã đăng xuất</h5>
                <button className="btn btn-warning my-2"><Link to="/login">Login</Link></button>
            </div>
        );
    }
}

export default Logout;