import React, { Component } from 'react';

class Control extends Component {
    constructor(props){
        super(props);
        this.state = {
            sort:{
                atoz: 1,
                ztoa:1
            },
            search:''
        }
        this.onClick = this.onClick.bind(this);
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }
    onClick(data){
        this.props.onSort(data);
    }
    onChange(event){
        this.setState({
            [event.target.name]: event.target.value
        })
    }
    onSubmit(event){
        event.preventDefault();
        this.props.onSearch(this.state.search);
        this.setState({
            search:''
        })
    }
    render() {
        return (
            <div className="row">
                <div className="col-3"></div>
                <div className="col-4 my-3" >
                    <form 
                        className="input-group"
                        onSubmit={this.onSubmit}
                    >
                        <input 
                            type="text" 
                            className="form-control"
                            placeholder="tìm kiếm"
                            name="search"
                            value={this.state.search}
                            onChange={this.onChange}
                        />
                        <button className="btn btn-primary ">search</button>
                    </form>
                </div>
                <div className="col-2  my-3">
                    <div className="dropdown float-right">
                        <button type="button" className="btn btn-primary dropdown-toggle" data-toggle="dropdown" style={{width: '100px'}}>
                        Sort
                        </button>
                        <div className="dropdown-menu">
                        {/* <a class="dropdown-item" href="#"></a>
                                <a class="dropdown-item" href="#">Link 2</a>
                                <a class="dropdown-item" href="#">Link 3</a>
                                <div class="dropdown-divider"></div> */}
                        <div 
                            className="dropdown-item"
                            onClick={() => { this.onClick(1)}}
                        >Sắp xếp A-Z</div>
                        <div 
                            className="dropdown-item"
                            onClick={() => { this.onClick(-1)}}
                        >Sắp xếp Z-A</div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Control;