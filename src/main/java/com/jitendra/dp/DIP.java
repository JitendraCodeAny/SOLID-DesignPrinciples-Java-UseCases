package com.jitendra.dp;

// DIP - Dependancy Inversion principle
// Refer class DIPViolation.java that violates DIP

/*
	 High level modules (class) should not interact with low level modules (class)
	 Both high level module (class) and low level module(class) should interact with 
	 abstraction to follow DI principle.
	 Code contains high level class: HRService, interact with abstraction.
	 instead of interacting low level class, so it is not injected and this dependency is separated
*/

/*
	For any other recruiter to support such as LeadRecruiter, HRService class will not be modified 
	Here, High level class HRService does not interact with low level class such as 
	ManagerRecruiter and so dependancy injection is separated from class HRService 
	It is compilant with DIP
	Benefit: code is exensible, maintainable, scalable and easy to test
	it helps to write loosely coupled code which will be easier to to mock during unit test and maintain
	
*/

//Abstraction (Interface)
interface Recruiter {
	void hire();
}

class HRService {
	private Recruiter recruiter; // abstraction

	public HRService(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	public void hire() {
		recruiter.hire();
	}
}

//Low-level module 1: ManagerRecruiter
class ManagerRecruiter implements Recruiter {
	@Override
	public void hire() {
		System.out.println("Hiring Manager");
	}
}

//Low-level module 2: LeadRecruiter
class LeadRecruiter implements Recruiter {
	@Override
	public void hire() {
		System.out.println("Hiring Lead");
	}
}

//Low-level module 3: DeveloperRecruiter
class DeveloperRecruiter implements Recruiter {
	@Override
	public void hire() {
		System.out.println("Hiring Developer");
	}
}

public class DIP {
	public static void main(String[] args) {
		// Create low-level modules
		Recruiter managerRecruiter = new ManagerRecruiter();

		// Create high-level module
		HRService hr = new HRService(managerRecruiter);
		hr.hire();

		Recruiter leadRecruiter = new LeadRecruiter();
		hr = new HRService(leadRecruiter);
		hr.hire();

		// Demonstrates the ease of switching implementations
		Recruiter developerRecruiter = new DeveloperRecruiter();
		hr = new HRService(developerRecruiter);
		hr.hire();
	}
}
