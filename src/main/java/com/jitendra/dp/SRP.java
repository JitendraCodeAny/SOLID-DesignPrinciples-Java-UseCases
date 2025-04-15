package com.jitendra.dp;

/* 
	 Single Responsibility Principle
	 A class should do only one job. There should be only one purpose to modify a class.
	 This code follows SRP
	
	 Here Developer class contains only one functionality, 
	 similarly Lead and Manager class does
	
	 Key benefits - 
	 - Easy to read and understand, as it handles one job
	 - Simple to test - due to single functionality, it minimizes the need to mock irrelevant dependencies
	 - Easy to maintain - When changes required, need to modify only single functionality 
	 - Flexible and extendible - Upgrade or extend features of the functionality without breaking others 
	 - Easy to debug - Easy to resolve error at change required at one place only
	 - Re-usable - class with specific functionality reused by different classes in same or diffrent projects
*/

class Developer {
	public void devlopCode() {
		System.out.println("Develop code..");
	}
}

class Lead {
	public void manageTeam() {
		System.out.println("Manage team...");
	}
}

class Manager {
	public void manageProject() {
		System.out.println("Manage project");
	}
}

public class SRP {
	public static void main(String[] args) {
		Developer developer = new Developer();
		developer.devlopCode();
		Lead lead = new Lead();
		lead.manageTeam();
		Manager manager = new Manager();
		manager.manageProject();
	}
}
