import React, { Component } from 'react';

import {Link} from 'react-router-dom';

class CategoryItem extends Component {
    
    render() {
        let {category} =this.props ;
        return (
            <Link to={"/category/"+category.id}>
                <h6>{category.name}</h6>
                <hr className="light"/>
            </Link >
            
        );
    }
}

export default CategoryItem;