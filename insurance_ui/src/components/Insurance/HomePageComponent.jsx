import React ,{Component} from 'react';
import InsuranceDataService from '../../api/insurance/InsuranceDataService.js'



  class HomePageComponent extends Component{
    constructor(props)
       {
        super(props)
        this.state={
            name:'',
            gender:'',
            age:'',
            premium:'',
            currentHealth:'',
            habit:'',
            showPremium:false,
            showLogin:true,
            Hypertension:"null",
            Bloodpressure:"null",
            Bloodsugar:"null",
            Overweight:"null",
            Smoking :"null",
            Alcohol:"null",
            Dailyexercise :"null",
            Drugs:"null"
        }
        
        this.handleChange=this.handleChange.bind(this)
        this.handleSubmit=this.handleSubmit.bind(this)
        this.handlePayment=this.handlePayment.bind(this)

    }

    
handleChange(event){    
    this.setState({
        [event.target.name]:event.target.value
    })

                    }

 handleSubmit(event)
 { 
     var currentHealthstatus=[this.state.Hypertension,this.state.Bloodpressure,this.state.Bloodsugar
        ,this.state.Overweight]
     
     var habits=[this.state.Smoking,this.state.Alcohol,this.state.Dailyexercise
            ,this.state.Drugs] 

     let userDetails={
        name: this.state.name,
        gender: this.state.gender,
        age: this.state.age,
        currentHealth:currentHealthstatus,
        habit:habits
    }

    InsuranceDataService.retrivePremium(userDetails).then(

    response => {
            this.setState({premium:response.data,showPremium:true,showLogin:false,name:this.state.name})
                 } )
     
  }  
    
 handlePayment(event)
 {
     var currentHealthstatus=[this.state.Hypertension,this.state.Bloodpressure,this.state.Bloodsugar
            ,this.state.Overweight]
         
    var habits=[this.state.Smoking,this.state.Alcohol,this.state.Dailyexercise
                ,this.state.Drugs] 

    let userDetails={
           name: this.state.name,
           gender: this.state.gender,
           age: this.state.age,
           currentHealth:currentHealthstatus,
           habit:habits,
           premium:this.state.premium
                       }
                   
    InsuranceDataService.payPremium(userDetails).then(
                   
     response => {
            this.setState({premium:response.data,showPremium:true,showLogin:false})
                 })
    } 
    
    componentDidMount() {
        document.title = "Health Insurance";
    }
                                                     

    render(){
        return(

            <div>   
            <h3>Enter Your Details</h3>
            <div className="container">
            {this.state.showInvalidCredentials && <div className="alert alert-warning">Invalid Creds </div>}
           {/*{this.state.showSuccess && <div>Succesfully Logged in  </div>}*/}

            <table className="table" >
                <tbody>
             <tr> <td>Name : </td><td><input type="text"  name="name"  
                value={this.state.userName} onChange={this.handleChange} required></input></td> </tr>
             <tr> <td> Gender: </td> <td> <input type="text"  name="gender" 
                value={this.state.gender}  onChange={this.handleChange} required ></input></td></tr>
             <tr><td> Age:  </td><td>       <input type="text"  name="age" 
                value={this.state.age}  onChange={this.handleChange} required></input></td></tr>
             <tr> <td> Current Health  </td>
                <td align="center">
             <tr> 
                    <td align ="right" >
                      <input type="checkbox" name="Hypertension" value="Hypertension" onChange={this.handleChange}/>
                      <label for="Hypertension">Hyper Tension</label>
                      <input type="checkbox"  name="Bloodpressure" value="Blood Pressure" onChange={this.handleChange}/>
                      <label for="Blood">Blood Pressure </label><br></br>
                   </td> 
             </tr>
                 <tr>
                     <td align ="left" >
                      <input type="checkbox" name="Bloodsugar" value="Blood Sugar" onChange={this.handleChange}/>
                      <label for="Blood Sugarer">Blood Sugar</label>
                      <input type="checkbox" name="Overweight" value="Over Weight" onChange={this.handleChange}/>
                      <label for="Over Weight">Over Weight</label>                    
                     </td>
                 </tr>                 
                </td>
         </tr> 
          
             <tr><td> Habit: </td>
                 <td align="center">
                  <tr> 
                    <td align ="left" > <input type="checkbox" name="Smoking" value="Smoking" onChange={this.handleChange}/>
                    <label for="Smoking">Smoking</label></td>
                    <td align ="right">
                    <input type="checkbox"  name="Alcohol" value="Alcohol" onChange={this.handleChange}/>
                    <label for="Alcohol">Alcohol </label><br></br>
                    </td> 
                   </tr>
                  <tr>
                   <td align ="left">
                   <input aria-colspan="100px" type="checkbox" name="Dailyexercise" value="Daily Exercise" onChange={this.handleChange}/>
                   <label for="Daily Exercise">Daily Exercise</label></td>
                   <td> <input type="checkbox" name="Drugs" value="Drugs" onChange={this.handleChange}/>
                   <label for="Drugs">Drugs</label> 
                    </td> 
               </tr>            
            </td>
            </tr>
                </tbody>
            </table>
           <div>  {this.state.showLogin &&
              <button className="btn btn-success" onClick={this.handleSubmit}> Check Premium</button>}
            </div>
            <div> 
                {this.state.showPremium && 
                <div className="alert alert-warning">
                        <label>Your Premium Amount is :: </label>
                                            {this.state.premium} </div>}
            </div>
           <div> 
                {this.state.showPremium && 
                 <button className="btn btn-success" onClick={this.handlePayment}> Pay</button>}
          </div>
            </div></div>

        )
    }

}
export default HomePageComponent