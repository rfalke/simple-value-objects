package de.codecentric.demo.simple.value.objects.hibernate.entities;

import java.util.Date;

public class Employee {
	
	enum EmploymentState{
		CURRENT_EMPLOYEE, FORMER_EMPLOYEE;
	}

	private boolean accessToOfficeBerlin;
	private boolean accessToWebapp;
	private double salary;
	private EmploymentState employmentState;
	private Date dismissalDate;
	
	public void dismiss(){
		if(employmentState == EmploymentState.FORMER_EMPLOYEE){
			throw new IllegalStateException("employee already dismissed");
		}

		employmentState = EmploymentState.FORMER_EMPLOYEE;
		dismissalDate = new Date();
		
		accessToOfficeBerlin = false;
		accessToWebapp = false;
		
		salary = 0.0;
	}
}
