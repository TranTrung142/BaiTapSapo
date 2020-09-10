import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class FormCategory extends Component {
    constructor (props) {
        super(props);
        this.state = {
            name: '',
            description: '',
            message: '',
            warning: ''
        }
    }
    componentWillMount(){
        let {category} = this.props;
        if(category !== null){
            this.setState({
                name: category.name,
                description: category.description
            })
        }
    }
    componentWillReceiveProps(nextProps){
        if(nextProps.category){
            this.setState({
                name: nextProps.category.name,
                description: nextProps.category.description
            });
        }else if(nextProps.category === null){
            this.setState({
                name: '',
                description: ''
            });
        }
    }
    onChange = (event) => {
        let name = event.target.name;
        let value = event.target.value;
        this.setState(state=>({
            ...state,
            [name]: value
        }));
        
    }
    onSubmit = (event) => {
        event.preventDefault();
        let { name, description } = this.state;

        if (name === '') {
            this.setState({
                warning: 'name'
            })
            return;
        }
        if (description === '') {
            this.setState({
                warning: 'description'
            })
            return;
        }
        this.props.onReciver(name, description);
    }
    render() {
        let { name, description, warning } = this.state;
        //submit thieu name hoac thieu description
        let tbname = '';
        let tbdes = '';
        if (warning === 'name') {
            tbname = '* Bạn chưa nhập tên category!!!'
        }
        if (warning === 'description') {
            tbdes = '* Bạn chưa nhập mô tả cho category!!!'
        }
        return (
            <div className="card text-left">
                <div className="card-header text-center">
                    <h4>Category</h4>
                </div>
                <form
                    className="card-body"
                    onSubmit={this.onSubmit}
                >
                    <div className="form-group">
                        <label htmlFor="name"><h5>Name: </h5></label>
                        <input
                            type="text"
                            className="form-control"
                            placeholder="Nhập tên"
                            id="name"
                            name="name"
                            value={name}
                            onChange={this.onChange}
                        />
                        {tbname}
                    </div>
                    <div className="form-group">
                        <label htmlFor="description"><h5>Description: </h5></label>
                        <textarea
                            id="description"
                            className="form-control"
                            rows="4"
                            placeholder="Mô tả chi tiết"
                            name="description"
                            value={description}
                            onChange={this.onChange}
                        ></textarea>
                        {tbdes}
                    </div>
                    <button
                        className="btn btn-success float-right"
                        type="submit"
                        style={{ width: "150px" }}
                    >Lưu lại</button>
                </form>

            </div>
        );
    }
}

export default FormCategory;