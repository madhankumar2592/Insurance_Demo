/**
 * 
 */
package com.insurance.payment.core.entity;


import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;

@Component
@Entity
public class User {






	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;

	private String name;

	private String gender;

	private int age;

	private String[] currentHealth;

	private String[] habit;

	private double  premium ;


	public User(Integer id, String name, String gender, int age, String[] currentHealth, String[] habit,
			double premium) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.currentHealth = currentHealth;
		this.habit = habit;
		this.premium = premium;
	}





	public void setId(Integer id) {
		this.id = id;
	}




	protected User() {

	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String[] getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(String[] currentHealth) {
		this.currentHealth = currentHealth;
	}

	public String[] getHabit() {


		return habit;
	}

	public void setHabit(String[] habit) {
		this.habit = habit;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPremium() {
		return premium;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", premium=" + premium
				+ ", currentHealth=" + currentHealth + ", habit=" + habit + "]";
	}



	public void setPremium(double premium) {
		this.premium = premium;
	}



}
