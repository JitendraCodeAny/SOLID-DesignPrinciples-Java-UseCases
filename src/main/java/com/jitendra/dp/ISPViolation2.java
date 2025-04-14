package com.jitendra.dp;

/*
 	ISP - Interface Segregation Principle

	A class should not be forced to implement interface and have methods, 
	which are not needed and irrelevant.
	
	Instead, split the large interface into smaller specific interfaces and classes
	to implement them based on their interest and have methods which are actually needed by them.
	
*/

/*
	This code provides ecommerce functionaly, uses large interface ECommerceManager
	contains the methods which are forced to be implemented by classe though some methods
	even if not needed by them.
	Such as Customer class implementing ECommerceManager, has to implement all the methods 
	including registerSeller, manageUser and handleCustomerSupport which are not needed by it
	Similarly with Seller and Admin. So this code violates ISP.
	
	Challenges with larger interface -
	- It force classes to implement unused methods
	- Large interface contain multiple functionalities so also violates SRP
	- Very prone to bug as classes implementing unused method may be left empty, 
	  or incorrectly implement or may crash.
	- Difficult to test, as needs to test all the unused functionality as well
	- Less flexible because of code is tightly coupled, any change in any method 
	  in interface will force the classes to be updated even if they dont use the method 
	- Less code re-usability - Classes implementing unnecessary methods not efficiently reused
*/

// Large interface violating ISP
interface ECommerceManager {
	public void placeOrder();
	public void cancelOrder();
	public void makePayment();
	public void registerSeller();
	public void manageUser();
	public void handleCustomerSupport();
}

// Customer is being forced to implement irrlevant methods
class Customer implements ECommerceManager {
	
	public void placeOrder() {
		System.out.println("Customer placed order");
	}
	public void cancelOrder() {
		System.out.println("Customer cancelled order");
	}
	public void makePayment() {
		System.out.println("Customer made payment");
	}
	public void registerSeller() {
		throw new UnsupportedOperationException("Customer cannot register as seller");
	}
	public void manageUser() {
		throw new UnsupportedOperationException("Customer cannot manage user");
	}
	public void handleCustomerSupport() {
		throw new UnsupportedOperationException("Customer cannot handle support");
	}

}

//Seller is being forced to implement irrlevant methods
class Seller implements ECommerceManager {
	
	public void placeOrder() {
		throw new UnsupportedOperationException("Seller cannot place order");
	}
	public void cancelOrder() {
		throw new UnsupportedOperationException("Seller cannot cancel order");
	}
	public void makePayment() {
		throw new UnsupportedOperationException("Seller cannot make payment");
	}
	public void registerSeller() {
		System.out.println("Seller registered");
	}
	public void manageUser() {
		throw new UnsupportedOperationException("Seller cannot manage user");
	}
	public void handleCustomerSupport() {
		throw new UnsupportedOperationException("Customer cannot handle support");
	}

}

//Admin is being forced to implement irrlevant methods
class Admin implements ECommerceManager {
	
	public void placeOrder() {
		throw new UnsupportedOperationException("Admin cannot place order");
	}
	public void cancelOrder() {
		throw new UnsupportedOperationException("Admin cannot cancel order");
	}
	public void makePayment() {
		throw new UnsupportedOperationException("Admin cannot make payment");
	}
	public void registerSeller() {
		throw new UnsupportedOperationException("Admin cannot register as seller");
	}
	public void manageUser() {
		System.out.println("Admin manage users");
	}
	public void handleCustomerSupport() {
		System.out.println("Admin handle customer support");
	}

}

public class ISPViolation2{
	public static void main(String[] args) {
		ECommerceManager customer = new Customer();
		customer.placeOrder();
		customer.cancelOrder();
		customer.makePayment();
		customer.registerSeller();
		customer.manageUser();
		customer.handleCustomerSupport();
		
		ECommerceManager seller = new Seller();
		seller.placeOrder();
		seller.cancelOrder();
		seller.makePayment();
		seller.registerSeller();
		seller.manageUser();
		seller.handleCustomerSupport();
		
		ECommerceManager admin = new Admin();
		admin.placeOrder();
		admin.cancelOrder();
		admin.makePayment();
		admin.registerSeller();
		admin.manageUser();
		admin.handleCustomerSupport();
	}
}