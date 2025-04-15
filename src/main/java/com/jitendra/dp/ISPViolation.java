package com.jitendra.dp;

/*
 	ISP - Interface Segregation Principle
	A class should not be forced to use unnecessary large interface and all its methods.
	Rather, split large interface into smaller ones and use them which are usefull.
*/

/*
	Here, interface Person contains the methods which are forced to implement 
	by the classes when they implement Person, even if not needed. 
	Such as Singer class implementing Person, has to implement all the methods sing(), dance() and perfomMusic() 
	which may not be actually needed. So this code does not follow ISP.
	
	Challenges with code that does not follow ISP-
	- It force classes to implement unused methods
	- Large interface contain multiple functionalities so also violates ISP
	- Very prone to bug as classes implementing unused method may be left empty, 
	  or incorrectly implement or may crash.
	- Difficult to test, as needs to test all the unused functionality as well
	- Less flexible because of code is tightly coupled, any change in any method 
	  in interface will force the classes to be updated even if they dont use the method 
	- Less code re-usability - Classes implementing unnecessary methods not efficiently reused
*/

interface Person {
	public void sing();

	public void dance();

	public void perfomMusic();
}

class Singer implements Person {
	public void sing() {
		System.out.println("Singer singing ..");
	}

	public void dance() {
		System.out.println("Singer rarely dance ..");
	}

	public void perfomMusic() {
		System.out.println("Singer do nothing ..");
	}
}

class Dancer implements Person {
	public void sing() {
		System.out.println("Dancer do nothing ..");
	}

	public void dance() {
		System.out.println("Dancer dancing..");
	}

	public void perfomMusic() {
		System.out.println("Dancer rarely do..");
	}
}

class Musician implements Person {
	public void sing() {
		System.out.println("Musician sometime sing..");
	}

	public void dance() {
		System.out.println("Musician do nothing..");
	}

	public void perfomMusic() {
		System.out.println("Musician paying music..");
	}

}
// Some methods are actually not needed but implemented by the classes
// ISP violation
	
public class ISPViolation{
	public static void main(String[] args) {
		Person singer = new Singer();
		singer.sing();
		singer.dance();
		singer.perfomMusic();
		
		Person dancer = new Dancer();
		dancer.sing();
		dancer.dance();
		dancer.perfomMusic();
		
		Person musician = new Musician();
		musician.sing();
		musician.dance();
		musician.perfomMusic();
	}
}
	
