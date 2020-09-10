import React, { Component } from 'react';

import { LoginContext } from '../contexts/LoginContext';

class FormLogin extends Component {
    constructor (props) {
        super(props);
        this.state = {
            user: {
                userName: '',
                password: ''
            },
            messager: {
                errLogin: false,
                errName: false,
                errPassword: false
            }
        }
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }
    onChange(event) {
        let name = event.target.name;
        let value = event.target.value;
        this.setState(state => ({
            user: {
                ...state.user,
                [name]: value
            }
        }));
    }
    onSubmit(event) {
        event.preventDefault();
        let { userName, password } = this.state.user;
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
    }
    render() {
        let { messager } = this.state;
        let { userName, password } = this.state.user;

        return (
            <LoginContext.Consumer >
                {({ onSubmitLogin }) => (
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
                                {messager.errName ? '* Bạn chưa nhập tên!!!' : ''}
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
                                {messager.errPassword ? '* Bạn chưa nhập password!!!' : ''}
                            </p>
                        </div>
                        <br />
                        <div className="text-center">
                            <div className="row">
                                <div className="col-6">

                                </div>
                                <div className="col-6">
                                    <button
                                        type="submit"
                                        className="btn btn-outline-info"
                                        style={{ width: '110px' }}
                                        onClick={(() => {
                                            if (userName !== '' && password !== '') {
                                                onSubmitLogin(this.state.user);
                                            }
                                        })}
                                    >Đăng nhập</button>&nbsp;
                        </div>
                            </div>
                        </div>
                    </form>
                )}
            </LoginContext.Consumer>
        );
    }
}

export default FormLogin;