package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.util.Date;

public class Employee {
	
	enum EmploymentState{
		CURRENT_EMPLOYEE, EX_EMPLOYEE;
	}

	private boolean accessToOfficeBerlin;
	private boolean accessToWebapp;
	private double salary;
	private EmploymentState employmentState;
	private Date unemploymentDate;
	
	public void unemploy(){
		
		if(employmentState == EmploymentState.EX_EMPLOYEE){
			throw new IllegalStateException("employee already unemployed");
		}

		employmentState = EmploymentState.EX_EMPLOYEE;
		unemploymentDate = new Date();
		
		accessToOfficeBerlin = false;
		accessToWebapp = false;
		
		salary = 0.0;
	}
}
