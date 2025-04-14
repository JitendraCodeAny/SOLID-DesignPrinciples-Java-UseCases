package com.jitendra.dp;

//DIP - Dependancy Inversion principle
//Refer class DIPViolation.java that violates DIP

/*
     High level modules (class) should not interact with low level modules (class)
	 Both high level module (class) and low level module(class) should interact with 
	 abstraction to follow DI principle.
*/

/*
	For any other payment type to support such as DebitCardPayment, PaymentService class
	will not be modified
	Here, High level class PaymentService does not interact with low level class such as 
	CreditCardPayment and so dependancy injection is separated from class PaymentService 
	It is compilant with DIP
	Benefit: exensible, maintainable, scalable and easy to test
	it helps to write loosely coupled code which will be easier to to mock during unit test and maintain
*/

//Abstraction (Abstract class)
abstract class Payment {
	abstract void process(double amount);
}

class CreditCardPayment extends Payment {
	public void process(double amount) {
		System.out.println("Credit card payment process amount for " + amount);
	}
}

class DebitCardPayment extends Payment {
	public void process(double amount) {
		System.out.println("Debit card payment process amount for " + amount);
	}
}

class NetBankingPayment extends Payment {
	public void process(double amount) {
		System.out.println("Netbanking payment process amount for " + amount);
	}
}

class UPIPayment extends Payment {
	public void process(double amount) {
		System.out.println("UPI payment process amount for " + amount);
	}
}

class PaymentService {
	private Payment payment;

	public PaymentService(Payment payment) {
		this.payment = payment;
	}

	public void processPayment(double amount) {
		payment.process(amount);
	}
}

// Uses Runtime Polymorphism, for each new payment type, PaymentService class is not changed
public class DIP2 {
	public static void main(String[] args) {
		double amount = 100.00;
		Payment creditCard = new CreditCardPayment();
		PaymentService pService = new PaymentService(creditCard);
		pService.processPayment(amount);

		Payment netBanking = new NetBankingPayment();
		pService = new PaymentService(netBanking);
		pService.processPayment(amount);

		Payment debitCard = new DebitCardPayment();
		pService = new PaymentService(debitCard);
		pService.processPayment(amount);
		
		Payment upi = new UPIPayment();
		pService = new PaymentService(upi);
		pService.processPayment(amount);

	}
}