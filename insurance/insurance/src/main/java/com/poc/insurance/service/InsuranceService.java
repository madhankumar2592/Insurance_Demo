/**
 * 
 */
package com.poc.insurance.service;

import com.poc.insurance.core.entity.User;

/**
 * This is used as the services interface for the Insurance 
 *
 * @author Madhan
 * @version 
 * @see
 *
 */
public interface InsuranceService {
	
	
public double checkPremium(User user)	;

public double checkByAge(int age,double premiumAmount);

public double checkByGender(String gender,double premiumAmount);

public double checkByHealth(String[] healthCondition,double premiumAmount);

public double checkByHabit(String[] habits,double premiumAmount);



}
