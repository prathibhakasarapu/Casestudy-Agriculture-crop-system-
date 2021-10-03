import React, { Component } from "react";
import UserService from "../services/UserService";
import "bootstrap/dist/css/bootstrap.min.css";
import './styles.css';
export default class Home extends Component {
    constructor(props) {
      super(props);
  
      this.state = {
        content: ""
      };
    }
  
    componentDidMount() {
      UserService.getPublicContent().then(
        response => {
          this.setState({
            content: response.data
          });
        },
        error => {
          this.setState({
            content:
              (error.response && error.response.data) ||
              error.message ||
              error.toString()
          });
        }
      );
    }
  
    render() {
      return (
        <div className="home">
        <div className="container">
          <header className="jumbotron">
            <h3>{this.state.content}</h3>
          </header>
          <div className="image" >
          <h1 style={{paddingTop:"250px"}} className="blink_me"><center>WELCOME TO CROP DEAL SITE AND HAVE A HAPPY PURCHASING OF CROPS FROM FARM!</center></h1>
        </div>
        </div>
        </div>
      );
    }
  }