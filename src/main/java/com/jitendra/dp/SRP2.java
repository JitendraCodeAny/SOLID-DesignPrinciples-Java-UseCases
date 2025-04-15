package com.jitendra.dp;

// SRP - Single Responsibility Principle - A class should do only one job
// This code follows SRP

/*   
 *   Single Responsibility Principle
	 A class should do only one job
	 There should be only one purpose to modify a class.
  
 	 Refer class SRPViolation2, which violates SRP due to Librarian class handles multiple things.
	 Here, each class implement one functionality such as BookManagement manage books to add and remove 
	 Similarly other classes contains one functionality. So it follows SRP.
	  
	 Key benefits - 
	 - Easy to read and understand, as it handles one job
	 - Simple to test - due to single functionality, it minimizes the need to mock irrelevant dependencies
	 - Easy to maintain - When changes required, need to modify only single functionality 
	 - Flexible and extendible - Upgrade or extend features of the functionality without breaking others 
	 - Easy to debug - Easy to resolve error at change required at one place only
	 - Re-usable - class with specific functionality reused by different classes in same or different projects
 */

class BookManagement{
	public void addBook() {
		// add book logic
		System.out.println("add book");
	}

	public void removeBook() {
		// remove book logic
		System.out.println("remove book");
	}
}

class BookAllocation {
	public void allocateBook() {
		// remove book logic
		System.out.println("allocate book");
	}
}

class UserManagement{
	public void registerUser() {
		// register user logic
		System.out.println("register user");
	}

	void removeUser() {
		// remove user logic
		System.out.println("remove user");
	}
}

class ReportGeneration{
	public void createReport() {
		// report generation logic
		System.out.println("create report for books available and allocated");
	}
}

class Librarian{
	BookManagement bookManager = new BookManagement();
	BookAllocation allocateManager = new BookAllocation();
	UserManagement userManager = new UserManagement();
	ReportGeneration reportGenerator = new ReportGeneration();
	
	public void manage(){
		bookManager.addBook();
		bookManager.removeBook();
		allocateManager.allocateBook();
		userManager.registerUser();
		userManager.removeUser();
		reportGenerator.createReport();
	}
}

public class SRP2 {
	public static void main(String[] args) {
		Librarian manager = new Librarian();
		manager.manage();
	}
}
