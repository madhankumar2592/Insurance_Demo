package com.poc.insurance.core.entity;

import org.springframework.stereotype.Component;

@Component
public class User {

	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", age=" + age + ", currentHealth=" + currentHealth
				+ ", habit=" + habit + "]";
	}

	private String name;

	private String gender;

	private int age;
	
	private String[] currentHealth;

	private String[] habit;

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


}
