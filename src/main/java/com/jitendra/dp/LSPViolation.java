package com.jitendra.dp;

//LSP - Liskov Substitution Principle

/*
  When subclass objects substitute super class objects then overriden methods
  should not restrict or break existing superclass functionality.
  
  Avoid creating subclasses that does not support the super class functionality.
  In this case, subclass don't behave like superclass and restricts or breaks
  upper class functionality when subclass object substitue super class object 
  and call overriden method. To prevent this, separate unsupported functionality 
  using an interface and build it.
*/

/*
    Here in this code, any class that extends and substitute Employee class
    should behave like all employees can code.
    However, Recruiter doesn't code. This breaks the expected behavior of the super
	class Employee, when coding() method is overridden. 
	So it does not follow LSP.
	
	Challenges: 
    Difficult to test and reuse as subclass behaviour is not predictable
    Less maintainable because hard to add new feature
*/

class Employee {
	public void coding() {
		System.out.println(this + " >> coding");
	}

	public void meeting() {
		System.out.println(this + " >> meeting");
	}
}

class Developer extends Employee {
	// inherits both methods -- does not break superclass functionality
	
	@Override
	public String toString() {
		return "Developer";
	}

}

class Recruiter extends Employee {
	// inherits method meeeting() -- does not break 
	
	@Override
	public void coding() {  // break superclass behavior
		throw new UnsupportedOperationException("Recruiter doesn't code");
	}
	
	@Override
	public String toString() {
		return "Recruiter";
	}

}

public class LSPViolation {
	public static void main(String[] args) {
		Employee developer = new Developer();
		developer.meeting(); // Expected behaviour
		developer.coding(); // Expected behaviour
		
		Employee recruiter = new Recruiter();
		recruiter.meeting(); // Expected behaviour
		recruiter.coding(); // Unexpected behaviour. This throws an exception, violating LSP
	}
}
