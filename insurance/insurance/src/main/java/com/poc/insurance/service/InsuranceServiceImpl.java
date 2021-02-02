/**
 * 
 */
package com.poc.insurance.service;

import org.springframework.stereotype.Service;

import com.poc.insurance.core.constant.InsuranceTypeConstants;
import com.poc.insurance.core.entity.User;

/**
 * This is used as the services class for the Insurance operations
 *
 * @author Madhan
 * @version 
 * @see
 *
 */

@Service
public class InsuranceServiceImpl implements InsuranceService {

	/**
	 * 
	 * The method is to check premium amount . The user will enter userDetails
	 * to  find the insurance premium. 
	 * The method is invoked on when the user clicks check premium button.
	 * 
	 * @param User user
	 * @return premiumAmount
	 */	
	@Override
	public double checkPremium(User user) {

		double premiumAmount=InsuranceTypeConstants.BASE_PREMIUM;

		premiumAmount=checkByAge(user.getAge(),premiumAmount);

		premiumAmount=checkByGender(user.getGender(), premiumAmount);

		premiumAmount=checkByHealth(user.getCurrentHealth(), premiumAmount);

		premiumAmount=checkByHabit(user.getHabit(), premiumAmount);

		return premiumAmount;
	}


	/**
	 * 
	 * The method is to check premium amount by age . The user will enter userDetails
	 * to  find the insurance premium. 
	 * The method is invoked on when the user clicks check premium button.
	 * 
	 * @param user's age
	 * @return premiumAmount
	 */	
	@Override
	public double checkByAge(int age, double premiumAmount) {

		if(age>18) {
			premiumAmount=(premiumAmount + (premiumAmount * InsuranceTypeConstants.AGE_GROUP_ONE));
		}

		if (age>25){

			premiumAmount =(premiumAmount + (premiumAmount * InsuranceTypeConstants.AGE_GROUP_ONE));
		}

		if(age>30) {
			premiumAmount= (premiumAmount + (premiumAmount * InsuranceTypeConstants.AGE_GROUP_ONE));
		}
		if(age>35 ) {
			premiumAmount= (premiumAmount + (premiumAmount * InsuranceTypeConstants.AGE_GROUP_ONE));
		}

		if(age>40) {
			for(int i=40;i<age;i=i+5){
				if(age>i) {	
					premiumAmount=  (premiumAmount + (premiumAmount * InsuranceTypeConstants.AGE_GROUP_TWO));
				}

			}
		}
		return premiumAmount;
	}


	/**
	 * 
	 * The method is to check premium amount by Gender . The user will enter userDetails
	 * to  find the insurance premium. 
	 * The method is invoked on when the user clicks check premium button.
	 * 
	 * @param user's Gender
	 * @return premiumAmount
	 */	
	@Override
	public double checkByGender(String gender, double premiumAmount) {
		// TODO Auto-generated method stub
		if(gender.equalsIgnoreCase("MALE")) {
			return (long) (premiumAmount + (premiumAmount*InsuranceTypeConstants.GENDER_MALE));
		}

		return premiumAmount;
	}


	/**
	 * 
	 * The method is to check premium amount by HealthStatus . The user will enter userDetails
	 * to  find the insurance premium. 
	 * The method is invoked on when the user clicks check premium button.
	 * 
	 * @param  user's healthstatus
	 * @return premiumAmount
	 */	
	@Override
	public double checkByHealth(String[] healthCondition, double premiumAmount) {

		for(int i=0;i<healthCondition.length;i++)
		{

			if(healthCondition[i]!=null) {

				if(healthCondition[i].equalsIgnoreCase("HYPERTENSION")) {
					premiumAmount=(premiumAmount + (premiumAmount*InsuranceTypeConstants.HEALTH_ISSUE));
				}
				if(healthCondition[i].equalsIgnoreCase("BLOOD PRESSURE")) {
					premiumAmount=(premiumAmount + (premiumAmount*InsuranceTypeConstants.HEALTH_ISSUE));
				}
				if(healthCondition[i].equalsIgnoreCase("BLOOD SUGAR")) {
					premiumAmount=(premiumAmount + (premiumAmount*InsuranceTypeConstants.HEALTH_ISSUE));
				}
				if(healthCondition[i].equalsIgnoreCase("OVER WEIGHT")) {
					System.out.println("Inside Over Weight");

					premiumAmount= (premiumAmount + (premiumAmount*InsuranceTypeConstants.HEALTH_ISSUE));
				}

			}

		}

		return premiumAmount;


	}

	/**
	 * 
	 * The method is to check premium amount by Habits . The user will enter userDetails
	 * to  find the insurance premium. 
	 * The method is invoked on when the user clicks check premium button.
	 * 
	 * @param  user's habits
	 * @return premiumAmount
	 */	
	@SuppressWarnings("unused")
	@Override
	public double checkByHabit(String[] habits, double premiumAmount) {
		double counter=0;
		boolean goodhabit=true;
		for(int i=0;i<habits.length;i++)
		{
			if(habits[i]!=null){
				if(habits[i].equalsIgnoreCase("SMOKING")) {
					++counter;
					goodhabit=false;
				}
				if(habits[i].equalsIgnoreCase("ALCOHOL")) {
					++counter;
					goodhabit=false;
				}

				if(habits[i].equalsIgnoreCase("DRUGS")) {
					++counter;
					goodhabit=false;
				}

				if(habits[i].equalsIgnoreCase("DAILY EXERCISE")) {
					if(!goodhabit) {
						counter--;
					}else {
						counter=1;}
				}}}

		premiumAmount=(double) (premiumAmount + ( premiumAmount * (counter*InsuranceTypeConstants.HABITS) ));

		return premiumAmount;


	}

}
