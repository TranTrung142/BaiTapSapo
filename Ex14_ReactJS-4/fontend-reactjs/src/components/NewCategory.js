import React, { Component } from 'react';
import Axios from 'axios';
import {Redirect, Link, Prompt} from 'react-router-dom';

import FormCategory from './FormCategory';
import Logout from './Logout';

class NewCategory extends Component {
    constructor(props){
        super(props);
        this.state = {
            name: '',
            description: '',
            message:'',
            warning: '',
            redirect:false,
            isExit: false
        };
    }
    onSubmit = (name, description)=>{
        Axios.post("/sapo/category", {name, description})
            .then((resp)=> {
                this.setState({
                    message: resp.data
                })
                return resp.data;
            })
            .catch((err)=>console.log(err));
    }
    onHandler=()=>{
        setTimeout(() => {
            this.setState(prev => ({...prev, redirect: !prev.redirect}));
        }, 1000);
    }
    render() {
        let { message,  redirect, isExit} = this.state;
        
        //submit thanh cong, hien thong bao
        let notifi = '';
        if(message !== ''){
            notifi = <div className="alert alert-danger text-center">
                        <strong>Thông báo:</strong> Bạn đã thêm mới category thành công ^^
                    </div>;
            this.onHandler();
            //return <Redirect to="/categories" />
            //this.onHandler();
            // setTimeout(()=> {
            //     window.location = "http://localhost:3000/categories"
            //     //return <Redirect to="/categories" />
            // }, 1000);
        }
        return (
            redirect ? <Redirect  to={{pathname:"/categories", state:{}}} />
            :
            (
            <div className="container">
                {notifi}
                <Logout />
                <h2 className="text-center my-4">Thêm mới Category</h2>
                <hr className="light"/>
                <div className="row">
                    <div className="col-2">
                        <Link to="/categories">
                            <button 
                                className="btn btn-primary"
                            >Trở lại</button>
                        </Link>
                    </div>
                    <div className="col-8">
                        <FormCategory 
                        onReciver={this.onSubmit}
                        category={null}
                        />
                    </div>
                </div>
                <Prompt 
                    when={true}
                    message={location => (`Bạn có muốn thoát khỏi form điền!`) }
                />
            </div>)
        );
    }
}

export default NewCategory;