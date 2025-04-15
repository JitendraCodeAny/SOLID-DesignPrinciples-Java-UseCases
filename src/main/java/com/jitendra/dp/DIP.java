package com.jitendra.dp;

// DIP - Dependancy Inversion principle
// Refer class DIPViolation.java that violates DIP

/*
	 Class should interact with abstractions not concrete implementations
	 Code contains class: HRService, which interact with abstraction not concrete class
*/

/*
	For any other recruiter to support such as LeadRecruiter, HRService class will not be modified 
	Here, class HRService does not interact with concrete class such as 
	ManagerRecruiter and this dependancy is separated from class HRService
 
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
