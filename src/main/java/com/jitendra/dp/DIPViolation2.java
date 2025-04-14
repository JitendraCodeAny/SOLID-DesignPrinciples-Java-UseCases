package com.jitendra.dp;

//Dependancy Inversion principle
//High level modules/class should not depend on low level modules/class (concrete class)
//Both should depend on abstractions to comply with DI principle

/*
	This code contains HRService class which is high level class, directly interact
	with low level class ManagerRecruiter by injecting, which creates tight
	coupling. 
	
	Challenges: For any other recruiter to support such as LeadRecruiter, the
	HRService class is to be modified, which is inflexible and hard to test and
	extend.
	
	Here both HRService and ManagerRecruiter class interact with abstraction.
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

public class DIPViolation2 {
	public static void main(String[] args) {
		HRService hr = new HRService();
		hr.hire();
	}d
}