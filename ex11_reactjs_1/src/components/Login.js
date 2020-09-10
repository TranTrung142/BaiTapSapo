import React, { Component } from 'react';
import UserData from '../data/user.json';
import {Redirect, Link} from 'react-router-dom';

class Login extends Component {
    constructor(props){
        super(props);
        this.state = {
            id: 0,
            userName: '',
            password: '',
            loggedIn: false,
            messager:{
                errLogin:false,
                errName:false,
                errPassword:false
            }
        }
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        
    }
    onChange(event){
        let name = event.target.name;
        let value = event.target.value;
        this.setState({
            [name]: value
        })
    }
    onSubmit(event){
        event.preventDefault();
        let {userName, password} = this.state;
        //console.log(userName, ':', password);
        if(userName ===''){
            this.setState({
                messager:{
                    errName: true
                }
            })
            return
        }else {
            if(password === ''){
                this.setState({
                    messager:{
                        errName: false,
                        errPassword: true
                    }
                })
                return ;
            }else{
                this.setState({
                    messager:{
                        errName: false,
                        errPassword: false
                    }
                })
            }
        }
        UserData.map((user, index)=>{
            if(user.userName === userName){
                if(user.password === password){
                    localStorage.setItem("token", this.generate());
                    this.setState({
                        id: user.id,
                        loggedIn: true
                    });
                }
            }
        })
        // let userlocal =JSON.parse(localStorage.getItem("user"));
        // if(userlocal.user === userName && userlocal.password === password){
        //     return this.setState({
        //         id: user.id,
        //         loggedIn: true
        //     })
        // }
        this.setState({
            messager:{
                errLogin: true
            }
        })
    }
    rd(){
        return Math.floor((1+Math.random()) * 0x10000).toString(16).substring(1);
      }
    generate(){
        return this.rd() + this.rd() + '-' + this.rd() + '-' + this.rd() + this.rd() +'-' + this.rd();
    }
    render() {
        let {userName, password, loggedIn, id, messager} = this.state;
        if(loggedIn){
            return (
                <Redirect to={"/dashboard/" + id} />
            );
        }
        let warning = messager.errLogin ? <div class="alert alert-danger text-center">
                                            <strong>Cảnh báo!</strong> Bạn đã đăng nhập sai tên hoặc mật khẩu
                                        </div> : '';
        return (
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
                            <form 
                                className="card-body" 
                                onSubmit={this.onSubmit}
                            >
                                <div className="form-group">
                                    <label htmlFor="ten"><h5> Name :</h5></label>
                                    <input 
                                        id="ten" 
                                        type="text" 
                                        className="form-control" 
                                        name="userName"
                                        value={userName}
                                        onChange={this.onChange}
                                    />
                                    <p>
                                        {messager.errName ? '* Bạn chưa nhập tên!!!': ''}
                                    </p>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="pass"><h5> Password :</h5></label>
                                    <input 
                                        id="pass" 
                                        type="text" 
                                        className="form-control" 
                                        name="password"
                                        value={password}
                                        onChange={this.onChange}
                                    />
                                    <p>
                                        {messager.errPassword ? '* Bạn chưa nhập password!!!': ''}
                                    </p>
                                </div>
                                <br />
                                <div className="text-center">
                                    <div className="row">
                                    <div className="col-6">
                                        <button className="btn btn-outline-primary" style={{width: '110px'}}>
                                            <Link to="/register">
                                                Đăng kí
                                            </Link>
                                        </button>
                                    </div>
                                    <div className="col-6">
                                        <button type="submit" className="btn btn-outline-info" style={{width: '110px'}}>Đăng nhập</button>&nbsp;
                                    </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Login;