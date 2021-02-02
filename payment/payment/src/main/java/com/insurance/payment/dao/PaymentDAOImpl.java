package com.insurance.payment.dao;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * This is used as the DAO class for the payment services 
 *
 * @author Madhan
 * @version 
 * @see
 *
 */

import com.insurance.payment.core.entity.User;

public class PaymentDAOImpl {

	@Autowired
	PaymentDAO paymentDAO;

	public static Integer counter=0;

	/**
	 * 
	 * The method is to pay premium amount . The user will enter userDetails
	 * to  find the insurance premium and the data will be passed to this method 
	 * The method is invoked on when the user clicks pay premium button.
	 * 
	 * @param User user
	 * @return status
	 */	
	public String payUser(User user) {

		user.setId(++counter);	  

		if(user!=null) {
			paymentDAO.save(user);

		}

		return "paid";
	}

}
