package com.poc.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.insurance.core.entity.User;
import com.poc.insurance.service.InsuranceService;


/**
 * The Controller class for Insurance . The methods in the class will be
 * mapped as per the UI requests. The UI front controller will redirect to the
 * respective methods based on the request and the request parameters.
 * 
 * @author Madhan
 * @version 
 * @see
 * 
 */

@RestController
@CrossOrigin(origins  = "http://localhost:4200")
public class Homecontroller {

	@Autowired	
	InsuranceService insuranceService;	


	/**
	 * 
	 * The method is to check premium amount. The user will enter userDetails
	 * to  find the insurance premium. The
	 * method is invoked on when the user cliks check premium button.
	 * 
	 * @param User user
	 * @return premiumAmount
	 */	
	@PostMapping("/user")	
	public double checkPremium(@RequestBody User user) {

		double premium=0;

		premium=insuranceService.checkPremium(user);

		return Math.ceil(premium) ;

	}

}
