import React, { Component } from 'react';
import './Pagination.css';

// /categories?page=1
class Pagination extends Component {
    constructor (props) {
        super(props);
        this.state = {

        }
    }
    onClick= (i)=>{
        if(i <= 0) {
            return;
        }
        if(i > this.props.totalCatePerPage) {
            return;
        }
        this.props.chosePage(i);
    }
    render() {
        let {currentPage, totalCatePerPage} = this.props;
        let elePage = [];
        for(let i=1; i<=totalCatePerPage; i++){
            elePage.push(<li class="page-item"><a className="page-link" onClick={()=>this.onClick(i)}>{i}</a></li>);
        }
        let showPage = elePage.map((item, index)=>{
            return <li key={index} className={ (index+1)===currentPage ? "page-item active" : "page-item" }>{item} </li>;
        })
        return (
            <ul 
                className="pagination pagination-sm justify-content-center" 
                style={{paddingBottom:"10px !importance", position: "absolute", bottom:"10px", right:"50px"}}
            >
                <li class="page-item" onClick={()=>this.onClick(currentPage-1)}><a class="page-link">Previous</a></li>
                {showPage}
                <li class="page-item" onClick={()=>this.onClick(currentPage+1)}><a class="page-link">Next</a></li>
            </ul>
            
        );
    }
}

export default Pagination;