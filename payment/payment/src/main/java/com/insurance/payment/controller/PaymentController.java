/**
 * 
 */
package com.insurance.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.payment.core.entity.User;
import com.insurance.payment.service.PaymentService;

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
public class PaymentController {

	@Autowired	
	PaymentService paymentService;


	@PostMapping("/pay")	
	public String loadPayment(@RequestBody User user) {

		System.out.println("Inside Payment"+user.toString());

		paymentService.payment(user);


		return "paid";

	}


}
