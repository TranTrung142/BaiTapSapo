import React, { Component } from 'react';
import axios from 'axios';
import {Redirect, Link} from 'react-router-dom';

import CategoryItem from './CategoryItem'
import Control from './Control';
import Pagination from './Pagination';
import Logout from './Logout';

const categoriesPerPage = 3;

class CategoryList extends Component {
    constructor (props) {
        super(props);
        let token = localStorage.getItem("token");
        let loggedIn = false;
        if(token !== null){
            loggedIn = true;
        }
        this.state = {
            data: [],
            sort: 1,
            search: '',
            pagination: {
                currentPage: 1,
                catePerPage: categoriesPerPage
            },
            loggedIn,
            totalPage: 0
        }
        this.onSort = this.onSort.bind(this);
        this.onSearch = this.onSearch.bind(this);
    }
    componentWillMount() {
        let {currentPage, catePerPage} = this.state.pagination;
        if (this.state.data.length === 0) {
            axios.get("/sapo/category?page="+currentPage+"&limit="+catePerPage).then((resp) => {
                //console.log(resp);
                this.setState({
                    data: resp.data.listCategory,
                    totalPage: resp.data.totalPage
                });
            }).catch((err) => {
                console.log(err);
            })
        }
        let user = localStorage.getItem('user');
    }
    onSort(value) {
        //console.log(typeof value);
        this.setState({
            sort: value
        })
    }
    onSearch(value) {
        //console.log(value);
        this.setState({
            search: value
        })
    }
    chosePage=(i)=>{
        //console.log(typeof i);
        this.setState({
            pagination:{
                currentPage: i,
                catePerPage: categoriesPerPage
            }
        })
        axios.get("/sapo/category?page="+i+"&limit="+categoriesPerPage).then((resp) => {
            //console.log(resp);
            this.setState({
                data: resp.data.listCategory,
                totalPage: resp.data.totalPage
            });
        }).catch((err) => {
            console.log(err);
        })
    }
    render() {
        let { data, sort, search, pagination, loggedIn, totalPage } = this.state;
        //console.log(this.props.location.state.name);
        if(loggedIn === false){
            return <Redirect to="/login" />
        }
        // let totalCatePerPage = Math.ceil(data.length / pagination.catePerPage);
        // let indexOfLastCate = pagination.currentPage * pagination.catePerPage;
        // let indexOfFirstCate = indexOfLastCate - pagination.catePerPage; //0-3, 3-6
        // data = data.slice(indexOfFirstCate, indexOfLastCate);
        let Categories = data.sort((a, b) => {
            if (a.name > b.name) return sort;
            else if (a.name < b.name) return -sort;
            else return 0;
        })
        if (search !== '') {
            Categories = Categories.filter((category) => {
                return category.name.toLowerCase().indexOf(search.toLowerCase()) !== -1;
            })
        }
        let eleCategory = Categories.map((category, index) => {
            return <CategoryItem
                key={category.id}
                category={category} />
        })
        let user = JSON.parse(localStorage.getItem('user'));
        return (
            <div className="container padding">
                <div className="header ">
                    {/* <h5 className="float-left">User: {user} </h5> */}
                    <div className="row">
                        <div className="col-4 media border p-3">
                            <img src="https://www.w3schools.com/bootstrap4/img_avatar3.png" alt="John Doe" className="mr-3 mt-3 rounded-circle" style={{width:"100px"}} />
                            <div className="media-body">
                            <h4>{user.userName}<small><i></i></small></h4>
                            <p>Thông tin chi tiết</p> 
                            <p>Ngày tạo: {user.createdDate} </p>     
                            </div>
                        </div>
                        <div className="col-4">
                            <h2 className="my-3 text-center my-5">List category</h2>
                        </div>
                        <div className="col-3 my-5">
                            <Logout />
                        </div>
                        
                        <hr />
                    </div>
                    
                </div>
                <Control
                    onSort={this.onSort}
                    onSearch={this.onSearch}
                />
                <div className="row welcome">
                    <div className="col-3" >
                        
                    </div>
                    <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <div className="card text-left">
                            <div className="card-header text-center">
                                <h4>
                                    Categories
                        </h4>
                            </div>
                            <div className="card-body" style={{height:"243px", position: "relative"}}>
                                <div className="form-group">
                                    {eleCategory}
                                </div>
                                
                                    <Pagination
                                        currentPage={pagination.currentPage}
                                        totalCatePerPage={totalPage}
                                        chosePage={this.chosePage}
                                    />
                                
                            </div>
                        </div>

                    </div>
                    <div className="col-3">
                        <Link to="/newcategory" >
                            <button className="btn btn-warning">
                                Thêm mới
                            </button>
                        </Link>
                    </div>
                </div>
            </div>
        );
    }
}

export default CategoryList;