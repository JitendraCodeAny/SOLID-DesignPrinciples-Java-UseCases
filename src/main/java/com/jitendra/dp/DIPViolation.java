package com.jitendra.dp;

//Dependancy Inversion principle
/ Class should interact with abstractions not concrete implementations.

/*
	This code contains HRService class which is high level class, directly interact
	with concrete class ManagerRecruiter, which creates tight coupling. 
	
	Challenges: For any other recruiter to support such as LeadRecruiter, the
	HRService class is to be modified, which is inflexible and hard to test and
	extend.
	
	Here HRService class interact with concrete class ManagerRecruiter.
	So, this code violates DIP
*/


// High level module
class HRService { // high level class
	private ManagerRecruiter managerRecruiter; // low level class

	public HRService() { // dependancy (low level class) injected
		managerRecruiter = new ManagerRecruiter(); 
	}

	public void hire() {
		managerRecruiter.hire();
	}
}

// low level module
class ManagerRecruiter {
	public void hire() {
		System.out.println("Hiring Manager");
	}
}

public class DIPViolation {
	public static void main(String[] args) {
		HRService hr = new HRService();
		hr.hire();
	}
}
