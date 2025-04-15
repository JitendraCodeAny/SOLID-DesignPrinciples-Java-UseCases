package com.jitendra.dp;

// SRP - Single Responsibility Principle -
// A class should do only one job
// Code does not follow SRP

 /*
	 Here, DeveloperTask class contains multiple functionalities. Doing many things
  	 There should be only one purpose to modify a class.
	 So it does not follow SRP.
	 
	  Challenges with code that does not follow SRP -
	 - Hard to understand code as multiple functonalities at one place
	 - Difficult to maintain - when change one functonalities, it may break other
	   functonalities in same class, due to dependencies
	 - Difficult to test due to dependencies multiple functionalities
	 - Less code re-usable - Due to class contains multiple things and dependencies
  */
 

class DeveloperTask {

	void developCode() {
		System.out.println("Inside developCode");
	}

	void manageTeam() {
		System.out.println("Inside manageTeam");
	}

	void manageProject() {
		System.out.println("Inside manageProject");
	}

}

public class SRPViolation {
	public static void main(String[] args) {
		DeveloperTask task = new DeveloperTask();
		task.developCode();
		task.manageTeam();
		task.manageProject();
	}
}
