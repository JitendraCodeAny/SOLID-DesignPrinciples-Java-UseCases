package com.jitendra.dp;

//DIP - Dependancy Inversion principle
//Refer class DIPViolation.java that violates DIP

/*
    Class should interact with abstractions not concrete implementations
	
        Here PaymentService class does not interact with complete class DebitCardPayment
	rather it interact with abstract class Payment.
 	So for any other payment type to support such as DebitCardPayment.
	PaymentService class will not be modified.
	Here, class interact with abstraction Payment. It does not interact with concrete class such as CreditCardPayment. So, it is compilant with DIP
	
	Benefit: exensible, maintainable, scalable and easy to test.
	It helps to write loosely coupled code which will be easier to to mock during unit test and maintain
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
