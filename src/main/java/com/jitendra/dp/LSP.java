package com.jitendra.dp;

//LSP - Liskov Substitution Principle
// Refer LSPViolation.java that violates LSP.

/*
	Subclass should not break super class functionality when they replace or substitute superclass
    
	In LSPViolation class, Employee class contains both coding and meeting methods and when 
	Recruiter class extend and override the methods it breaks Employee class functionality
	
	But, this code fix it and comply with LSP.
	Instead of forcing all employees to behave the same, responsibilities ('Coding' method) 
	separated using interface 'Codable', to ensure each subtype/subclass behave consistently.
	and does not break the expected behavior of the super class when they override methods 

	Benefit: 
	Simple to test as subclass behaviour is predictable
	Code Re-usability - Reuse subclasses without breaking super class functionality
	Flexible and extendible - Add new subclasses as behaviour is predictable
	Avoid weird runtime bug with safe inheritance tree
*/

interface Coder {
	public void coding();
}

class Employee {
	public void meeting(){
		System.out.println(this + " >> Meeting");
	}
	
}

class Developer extends Employee implements Coder {
	
	public void coding() {	
		System.out.println("Developer >> Coding");  // implement interface method
	}
	
   //inherits meeting method 
	
	@Override
	public String toString() {
		return "Developer";
	}
}

class Recruiter extends Employee{
	
	// inherits method meeting()  -- does not break super class functionality
	
	@Override
	public String toString() {
		return "Recruiter";
	}
}

public class LSP {
	public static void main(String[] args) {
		Employee developer = new Developer();
		developer.meeting(); // Expected behaviour
		Coder coder = new Developer();
		coder.coding(); // Expected behaviour
		
		Employee recruiter = new Recruiter();
		recruiter.meeting(); // Expected behaviour
	}
}

