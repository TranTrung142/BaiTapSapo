import React, { Component } from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom';

class Register extends Component {
    constructor(props){
        super(props);
        this.state = {
            userName:'',
            password:'',
            notifi: false,
            messager: {
                errName: false,
                errPassword: false
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
        });
    }
    onSubmit(event){
        event.preventDefault();
        let {userName, password} = this.state;
        if (userName === '') {
            this.setState({
                messager: {
                    errName: true
                }
            })
            return
        } else {
            if (password === '') {
                this.setState({
                    messager: {
                        errName: false,
                        errPassword: true
                    }
                })
                return;
            } else {
                this.setState({
                    messager: {
                        errName: false,
                        errPassword: false
                    }
                })
            }
        }
        axios.post("/register", {userName, password})
                .then((resp)=>{
                    console.log(resp.data);
                    this.setState({
                        notifi: true
                    })
                    return resp.data;
                })
                .catch((err)=>{
                    console.log(err);
                    return err;
                });
        setTimeout(()=>{
            window.location = "http://localhost:3000/login"
        },2000);
    }
    onReset = () => {
        this.setState({
            userName:'',
            password:'',
            notifi: false
        })
    }
    render() {
        let {userName, password, notifi, messager } = this.state;
        return (
            <div className="container">
                {notifi ? <div className="alert alert-danger text-center">
                                    <strong>Thông báo:</strong> Bạn đã đăng kí thành công !
                            </div> : ''}
                <Link to="/login">
                    <button className="btn btn-primary my-3 float-right">Đăng nhập</button>
                </Link>
                <Link to="/login">
                    <button 
                        className="btn btn-primary my-3"
                    >Trở lại</button>
                </Link>
                <div className="row">
                    
                    <div className="col-2"></div>
                    <div className="col-8">
                        <form className="card my-5" onSubmit={this.onSubmit}>
                            <div className="card-header">
                                <h4>Đăng kí</h4>
                            </div>
                            <div className="card-body">
                                <div className="form-body">
                                    <div className="form-group">
                                        <label htmlFor="name"><h6>Name:</h6></label>
                                        <input 
                                            className="form-control" 
                                            type="text" 
                                            placeholder="Nhập tên"
                                            name="userName"
                                            value={userName}
                                            onChange={this.onChange}
                                        />
                                        <p>
                                            {messager.errName ? '* Bạn chưa nhập tên!!!' : ''}
                                        </p>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="name"><h6>Password:</h6></label>
                                        <input 
                                            className="form-control" 
                                            type="password" 
                                            placeholder="password"
                                            name="password"
                                            value={password}
                                            onChange={this.onChange}
                                        />
                                        <p>
                                            {messager.errPassword ? '* Bạn chưa nhập password!!!' : ''}
                                        </p>
                                    </div>
                                    <button 
                                        type="reset" 
                                        className="btn btn-outline-info my-2 float-left" 
                                        style={{width: '110px'}}
                                        onClick={this.onReset}
                                    >Hủy</button>&nbsp;
                                    <button 
                                        type="submit" 
                                        className="btn btn-outline-info my-2 float-right" 
                                        style={{width: '110px'}}
                                    >Đăng kí</button>&nbsp;
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default Register;