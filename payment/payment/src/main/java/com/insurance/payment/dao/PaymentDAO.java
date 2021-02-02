/**
 * 
 */
package com.insurance.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.payment.core.entity.User;

/**
 * This is used as the DAO Interface for the payment services 
 *
 * @author Madhan
 * @version 
 * @see
 *
 */

@Repository
public interface PaymentDAO extends JpaRepository <User ,Integer>{
	
	
public String payUser(User user);

}
