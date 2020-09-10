import React, { Component } from 'react';
import UserData from '../data/user.json';
import { Redirect } from 'react-router-dom';

import FormLogin from './FormLogin';
import {LoginContext} from '../contexts/LoginContext';

class Login extends Component {
    constructor (props) {
        super(props);
        this.state = {
            id: 0,
            user: {
                userName: '',
                password: ''
            },
            loggedIn: false,
            messager: {
                errLogin: false,
                errName: false,
                errPassword: false
            }
        }
        
    }
    onSubmitLogin = (user) => {
        let {userName, password} = user;
        this.setState(state => ({
            user: {
                userName: userName,
                password: password
            }
        }));
        
        UserData.map((user, index) => {
            if (user.userName === userName) {
                if (user.password === password) {
                    localStorage.setItem("token", "ascnascnaosc-12asca-123ascascaasfkgdfh");
                    this.setState({
                        id: user.id,
                        loggedIn: true
                    });
                }
            }
        })
        this.setState({
            messager: {
                errLogin: true
            }
        })
    }
    render() {
        let { loggedIn, id, messager } = this.state;

        if (loggedIn) {
            return (
                <Redirect to={"/dashboard/" + id} />
            );
        }
        let warning = messager.errLogin ? <div class="alert alert-danger text-center">
            <strong>Cảnh báo!</strong> Bạn đã đăng nhập sai tên hoặc mật khẩu
                                        </div> : '';
        return (
            <LoginContext.Provider value={{
                onSubmitLogin: this.onSubmitLogin
            }}>
                <div className="container padding">
                    {warning}
                    <div className="header ">
                        <h2 className="my-5 text-center">Page Login</h2>
                        <hr />
                    </div>
                    <div className="row welcome">
                        <div className="col-3" />
                        <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                            <div className="card text-left">
                                <div className="card-header text-center">
                                    <h4>
                                        Login
                                </h4>
                                </div>
                                <FormLogin />
                            </div>
                        </div>
                    </div>
                </div>

            </LoginContext.Provider>
        );
    }
}

export default Login;