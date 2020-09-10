import React, { Component } from 'react';
import axios from 'axios';


class CategoryDetail extends Component {
    constructor (props) {
        super(props);
        this.state = {
            category: ''
        }
    }
    componentWillMount() {
        let id = this.props.match.params.id; //url
        //console.log(typeof id);
        id = parseInt(id, 10);
        axios.get("/sapo/category/" + id).then((resp) => {
            //console.log(resp.data)
            this.setState({
                category: resp.data
            })
            return resp.data
        })
    }
    printProducts = ()=>{
        if(this.state.category !== ''){
            return this.state.category.products.map((product, index)=>{
                return <span key={index}>
                            - {product.name}
                        <br/></span>
            })
        }
    }
    render() {
        let { category } = this.state;
        
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
                                    {category.name}
                                </h4>
                            </div>
                            <div className="card-body">
                                <div className="form-group">
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
                </div>
            </div>
        );
    }
}

export default CategoryDetail;