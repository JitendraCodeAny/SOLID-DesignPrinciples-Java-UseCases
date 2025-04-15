package com.jitendra.dp;

// SRP - Single Responsibility Principle - 
// A class should do only one joby
// Code does not follow SRP

/*
	 Code Violates SRP This code logic demonstrates Library management system.
	 Here, class Librarian contains multiple functionalities, handles multiple things,
  	 There should be only one purpose to modify a class.
	 so it violates SRP
	  
	 Challenges with code that does not follow SRP -
	 - Hard to understand code as multiple functonalities at one place
	 - Difficult to maintain - when change one functonalities, it may break other
	   functonalities in same class, due to dependencies
	 - Difficult to test due to dependencies multiple functionalities
	 - Less code re-usable - Due to class contains multiple things and dependencies
*/

class Librarian {

	public void addBook() {
		// add book logic
		System.out.println("add book");
	}


	public void removeBook() {
		// remove book logic
		System.out.println("remove book");
	}

	public void allocateBook() {
		// remove book logic
		System.out.println("allocate book");
	}

	public void registerUser() {
		// register user logic
		System.out.println("register user");
	}

	void removeUser() {
		// remove user logic
		System.out.println("remove user");
	}

	public void createReport() {
		// report generation logic
		System.out.println("create report for books available and borrowed");
	}

}

public class SRPViolation2 {
	public static void main(String[] args) {
		Librarian manager = new Librarian();
		manager.addBook();
		manager.removeBook();
		manager.allocateBook();
		manager.registerUser();
		manager.removeUser();
		manager.createReport();
	}
}
