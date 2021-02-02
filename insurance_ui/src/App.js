import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import HomePageComponent from './components/Insurance/HomePageComponent'
import Header from './components/Insurance/Header'
import './bootstrap.css';





class App extends Component {

  render(){
    return(
      <div className="App">
           <Header></Header>
           <HomePageComponent></HomePageComponent>
     </div> 
    )

  }
 
}


export default App;
