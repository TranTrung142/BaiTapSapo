import React, { Component } from 'react';

import DataCategory from '../data/category.json';

class CategoryDetail extends Component {

    render() {
        let id = this.props.match.params.id; //url
        //console.log(typeof id);
        id = parseInt(id, 10);
        let elecate;
        DataCategory.map((category, index)=>{
            if(category.id === id){
                 elecate = category;
            }
        })
        return (
            <div className="container padding">
                <div className="header ">
                    <h2 className="my-3 text-center">Category</h2>
                    <hr />
                </div>
                <div className="row welcome">
                    <div className="col-3" />
                    <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <div className="card text-left">
                        <div className="card-header text-center">
                        <h4>
                            {elecate.name}
                        </h4>
                        </div>
                        <div className="card-body">
                        <div className="form-group">
                            <div>
                            <h6>Description: </h6> <span>{elecate.description}</span>
                            </div>
                            <div className="my-3">
                            <h6>Manufacturer: </h6> <span>{elecate.manufacturer}</span>
                            </div>
                        </div>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CategoryDetail;