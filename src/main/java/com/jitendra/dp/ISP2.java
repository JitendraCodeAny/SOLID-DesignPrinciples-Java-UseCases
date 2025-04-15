package com.jitendra.dp;

/*
	ISP - Interface Segregation Principle
	
	A class should not be forced to use unnecessary large interface and all its methods.
        Rather, split large interface into smaller ones and use them which are usefull.
	
	Instead, split the large interface into smaller specific interfaces and classes
	to implement them based on their interest and have methods which are actually needed by them.

	Refer class ISPVIolation2 that provides ecommerce functionaly, uses large interface
	ECommerceManager contains the methods which are forced to be implemented by classe though some methods
	even if not needed by them.
	
	This code split the large interface ECommerceManager into smaller and specific interfaces
	such as OrderService and PaymentService implemented by Customer class defines methods 
	which are actually needed. Similarly with Seller and Admin does.
	
	So this code follows ISP.
	
	Key benefits with smaller interfaces -
	- Classes implement relevant interfaces
	- Easy to test classes using relevant interfaces 
	- Re-usable - Because class contains specific functionality, so easily reused by
	  different classes in same or different projects
	- Flexible and extensible - code is loosely coupled due to less dependency, 
	  so can change existing code or add new features without breaking other classes
	  Using focused interfaces helps creating less boilerplate code
*/

interface OrderService {
	public void placeOrder();

	public void cancelOrder();
}

interface PaymentService{

	public void makePayment();
}

interface SellerRegistration {
	public void registerSeller();
}

interface UserManagement {
	public void manageUser();
}

interface CustomerSupport {
	public void handleCustomerSupport();
}

// Customer implementing specific interfaces wich are used
class Customer implements OrderService, PaymentService {

	public void placeOrder() {
		System.out.println("Customer placed order");
	}

	public void cancelOrder() {
		System.out.println("Customer cancelled order");
	}

	public void makePayment() {
		System.out.println("Customer made payment");
	}
}

class Seller implements SellerRegistration {

	public void registerSeller() {
		System.out.println("Seller registered");
	}

}

class Admin implements UserManagement, CustomerSupport {

	public void manageUser() {
		System.out.println("Admin manage users");
	}

	public void handleCustomerSupport() {
		System.out.println("Admin handle customer support");
	}

}

public class ISP2 {
	public static void main(String[] args) {
		OrderService customerOrder = new Customer();
		customerOrder.placeOrder();
		customerOrder.cancelOrder();

		PaymentService customerPayment = new Customer();
		customerPayment.makePayment();

		SellerRegistration seller = new Seller();
		seller.registerSeller();

		UserManagement userManager = new Admin();
		userManager.manageUser();

		CustomerSupport supportHandler = new Admin();
		supportHandler.handleCustomerSupport();
	}
}
