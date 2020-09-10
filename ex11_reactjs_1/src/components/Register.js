import React, { Component } from 'react';

//page Register chưa hoàn thiện do thiếu API
class Register extends Component {
    constructor(props){
        super(props);
        this.state = {
            name:'',
            password:'',
            email:'',
            phone:''
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
        let data = JSON.stringify(this.state);
        //console.log(data);
        localStorage.setItem("user", data);
        //fs.writeFileSync(require('../data/user.json'), data);

    }
    render() {
        let {name, password, email, phone} = this.state;
        return (
            <div className="container">
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
                                            name="name"
                                            value={name}
                                            onChange={this.onChange}
                                        />
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
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="name"><h6>Email:</h6></label>
                                        <input 
                                            className="form-control" 
                                            type="text" 
                                            placeholder="Nhập email"
                                            name="email"
                                            value={email}
                                            onChange={this.onChange}
                                        />
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="name"><h6>Phone:</h6></label>
                                        <input 
                                            className="form-control" 
                                            type="text" 
                                            placeholder="Nhập số điện thoại"
                                            name="phone"
                                            value={phone}
                                            onChange={this.onChange}
                                        />
                                    </div>
                                    <button type="submit" className="btn btn-outline-info my-2 float-right" style={{width: '110px'}}>Đăng kí</button>&nbsp;
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