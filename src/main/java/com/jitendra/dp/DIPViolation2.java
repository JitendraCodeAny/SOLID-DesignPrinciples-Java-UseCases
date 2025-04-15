package com.jitendra.dp;

//Dependancy Inversion principle
//Class should interact with abstractions not concrete implementations. 

/*
	This code contains PaymentService class which is high level class, directly interact
	with concrete class CreditCardPayment which creates tight coupling. 
	
	Challenges: For any other recruiter to support such as DebitCardPayment, the
	Payment class is to be modified, which is inflexible and hard to test and
	extend.
	
	Here Payment class interact with concrete class CreditCardPayment.
	So, this code violates DIP
*/


// High level module
class PaymentService { // high level class
	private CreditCardPayment creditCardPayment; // low level class

	public Payment() { // dependancy (low level class) injected
		creditCardPayment = new CreditCardPayment(); 
	}

	public void process() {
		creditCardPayment.process();
	}
}

// low level module
class CreditCardPayment extends Payment {
	public void process(double amount) {
		System.out.println("Credit card payment process amount for " + amount);
	}
}

public class DIPViolation2 {
	public static void main(String[] args) {
		Payment payment = new CreditCardPayment();
		payment.process();
	}
}
