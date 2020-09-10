import React, { Component } from 'react';


// /categories?page=1
class Pagination extends Component {
    constructor (props) {
        super(props);
        this.state = {

        }
    }
    onClick= (i)=>{
        this.props.chosePage(i);
    }
    render() {
        let {currentPage, totalCatePerPage} = this.props;
        let elePage = [];
        for(let i=1; i<=totalCatePerPage; i++){
            elePage.push(<a className="page-link" onClick={()=>this.onClick(i)}>{i}</a>);
        }
        let showPage = elePage.map((item, index)=>{
            return <li key={index} className={ (index+1)===currentPage ? "page-item active" : "page-item" }>{item} </li>;
        })
        return (
            <ul 
                className="pagination pagination-sm justify-content-center" 
                style={{paddingBottom:"10px !importance", position: "absolute", bottom:"10px", right:"50px"}}
            >{showPage}</ul>
            
        );
    }
}

export default Pagination;