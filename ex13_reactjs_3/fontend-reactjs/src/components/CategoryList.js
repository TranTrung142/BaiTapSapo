import React, { Component } from 'react';
import axios from 'axios';

import CategoryItem from './CategoryItem'
import Control from './Control';
import Pagination from './Pagination';

const getCategoryAction = () => {
    return axios.get("/sapo/category")
}

const categoriesPerPage = 3;

class CategoryList extends Component {
    constructor (props) {
        super(props);
        this.state = {
            data: [],
            sort: 1,
            search: '',
            pagination: {
                currentPage: 1,
                catePerPage: categoriesPerPage
            }
        }
        this.onSort = this.onSort.bind(this);
        this.onSearch = this.onSearch.bind(this);
    }
    componentWillMount() {
        if (this.state.data.length === 0) {
            getCategoryAction().then((resp) => {
                //console.log(resp);
                this.setState({
                    data: resp.data
                });
            }).catch((err) => {
                console.log(err);
            })
        }
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
    }
    render() {
        let { data, sort, search, pagination } = this.state;

        let totalCatePerPage = Math.ceil(data.length / pagination.catePerPage);
        let indexOfLastCate = pagination.currentPage * pagination.catePerPage;
        let indexOfFirstCate = indexOfLastCate - pagination.catePerPage; //0-3, 3-6

        data = data.slice(indexOfFirstCate, indexOfLastCate);

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




        return (
            <div className="container padding">
                <div className="header ">
                    <h2 className="my-3 text-center">List category</h2>
                    <hr />
                </div>
                <Control
                    onSort={this.onSort}
                    onSearch={this.onSearch}
                />
                <div className="row welcome">
                    <div className="col-3" />
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
                                        totalCatePerPage={totalCatePerPage}
                                        chosePage={this.chosePage}
                                    />
                                
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        );
    }
}

export default CategoryList;