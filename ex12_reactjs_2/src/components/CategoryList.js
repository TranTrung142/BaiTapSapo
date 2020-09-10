import React, { Component } from 'react';
import CategoryItem from './CategoryItem'
import CategoryData from '../data/category.json';
import Control from './Control'

class CategoryList extends Component {
    constructor(props){
        super(props);
        this.state = {
            sort: 1,
            search:''
        }
        this.onSort = this.onSort.bind(this);
        this.onSearch = this.onSearch.bind(this);
    }
    onSort(value){
        //console.log(typeof value);
        this.setState({
            sort: value
        })
    }
    onSearch(value){
        //console.log(value);
        this.setState({
            search: value
        })
    }
    render() {
        let {sort, search} = this.state;
        let Categories = CategoryData.sort((a, b)=> {
            if(a.name > b.name) return sort;
            else if(a.name < b.name) return -sort;
            else return 0;
        })
        if(search !== ''){
            Categories = Categories.filter((category) => {
                return category.name.toLowerCase().indexOf(search.toLowerCase()) !== -1;
            })
        }
        let eleCategory = Categories.map((category, index)=>{
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
                            <div className="card-body">
                                <div className="form-group">
                                    {eleCategory}
                                </div>
                            </div>
                    </div>
                    </div>
                </div>
            </div>

        );
    }
}

export default CategoryList;