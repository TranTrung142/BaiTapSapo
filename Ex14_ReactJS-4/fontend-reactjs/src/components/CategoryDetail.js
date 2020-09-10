import React, { Component } from 'react';
import axios from 'axios';
import { Link, Prompt } from 'react-router-dom';

import FormCategory from './FormCategory';
import Logout from './Logout';

class CategoryDetail extends Component {
    constructor (props) {
        super(props);
        this.state = {
            category: '',
            update: false
        }
    }
    componentWillMount() {
        this.getData();
    }
    getData = () => {
        let id = this.props.match.params.id; //url
        //console.log(typeof id);
        id = parseInt(id, 10);
        axios.get("/sapo/category/" + id).then((resp) => {
            //console.log(resp.data)
            let data = resp.data;
            let createDate = new Date(data.createdDate);
            let modifiedDate = new Date(data.modifiedDate);
            let convCreDate = `${("0" + createDate.getDate()).slice(-2)}/${("0" + (createDate.getMonth() + 1)).slice(-2)}/${createDate.getFullYear()} ${createDate.getHours()}h:${createDate.getMinutes()}p`;
            let convModiDate = `${("0" + modifiedDate.getDate()).slice(-2)}/${("0" + (modifiedDate.getMonth() + 1)).slice(-2)}/${modifiedDate.getFullYear()} ${modifiedDate.getHours()}h:${modifiedDate.getMinutes()}p`;
            // if (convCreDate === convModiDate) {
            //     convModiDate = '';
            // }
            // console.log(convCreDate)
            // console.log(convModiDate)
            // console.log(convCreDate === convModiDate)

            console.log();
            data = {
                ...data,
                createdDate: convCreDate,
                modifiedDate: convModiDate
            };
            this.setState({
                category: data
            })
            return resp.data
        })
            .catch((err) => {
                console.log(err);
                return err;
            })
    }
    printProducts = () => {
        if (this.state.category !== '') {
            return this.state.category.products.map((product, index) => {
                return <span key={index}>
                    - {product.name}
                    <br /></span>
            })
        }
    }
    onUpdate = () => {
        this.setState({
            update: !this.state.update
        })
    }
    onSubmit = (name, description) => {
        //console.log(name, description);
        let id = this.props.match.params.id; //url
        axios.put("/sapo/category/" + id, { name, description })
            .then((resp) => {
                console.log(resp.data);
                return resp.data;
            })
            .catch((err) => {
                console.log(err);
            });
        this.getData();
        this.setState(state => ({ update: false }));
        // this.setState({
        //     category: {
        //         name,
        //         description,
        //         products: this.state.category.products
        //     },
        //     update: false
        // })
    }
    onDelete = ()=>{
        let id = this.props.match.params.id; //url
        axios.delete('/sapo/category/'+id).then(resp => {
            return resp;
        })
        .catch(err => err);
        window.location = "http://localhost:3000/categories";
    }
    render() {
        let { category, update } = this.state;

        return (
            <div className="container padding">
                <div className="header ">
                    <Link to="/categories">
                        <button className="btn btn-primary float-left">Trở lại</button>
                    </Link>
                    <Logout />
                    <h2 className="my-3 text-center">Category</h2>
                    <hr />
                </div>
                <div className="row welcome">
                    <div className={update ? '' : "col-3"} />
                    <div className="col-6">
                        <div className="card text-left">
                            <div className="card-header text-center">
                                <h4>
                                    {category.name}
                                </h4>
                                <div className="row">
                                    <div className="col-4">
                                    <button
                                        className="btn btn-primary float-right"
                                        style={{ width: "100px" }}
                                        onClick={this.onDelete}
                                    >
                                        xóa
                                    </button>
                                    </div>
                                    
                                    <div className="col-4"></div>
                                    <div className="col-3">
                                    <button
                                        className="btn btn-primary float-right"
                                        style={{ width: "100px" }}
                                        onClick={this.onUpdate}
                                    >
                                        Sửa
                                    </button>
                                    </div>
                                    
                                </div>


                            </div>
                            <div className="card-body">
                                <div className="form-group">
                                    <div>
                                        <h6>Ngày tạo: <span><i>{category.createdDate} </i></span></h6>
                                        <h6>Ngày sửa: <i>{category.modifiedDate}</i></h6>
                                        {/* {category.modifiedDate !== '' ? (<h6>Ngày sửa: <i>{category.modifiedDate}</i></h6>) : ''} */}

                                    </div>
                                    <div>
                                        <h6>Description: </h6> <span>{category.description}</span>
                                    </div>
                                    <div className="my-3">
                                        <h6>Products: </h6>   {this.printProducts()}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className={update ? "col-6" : ""}>
                        {update ? <div><FormCategory
                                        category={category}
                                        onReciver={this.onSubmit}
                                        />
                                        <Prompt 
                                            when={true}
                                            message={location => (`Bạn có muốn thoát khỏi form điền!`) }
                                        />
                                    </div> : ""}
                    </div>
                </div>
            </div>
        );
    }
}

export default CategoryDetail;