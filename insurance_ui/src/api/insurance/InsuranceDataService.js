
import axios from 'axios'


class InsuranceDataService{

     retrivePremium(userDetails){
        console.log('******************')
        console.log(userDetails)
        return axios.post(`http://localhost:8080/user`,userDetails);          
    }

    payPremium(userDetails){
        console.log('********Inside Payment**********')
        console.log(userDetails)
        return axios.post(`http://localhost:8081/pay`,userDetails);          
    }
}

export default new InsuranceDataService()