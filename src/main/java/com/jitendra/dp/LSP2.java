package com.jitendra.dp;

//LSP - Liskov Substitution Principle
// Refer LSPViolation.java that does not support LSP.

/*
	LSP - When subclass objects substitute super class objects and override methods
    then should not break existing superclass functionality.
	
	In LSPViolation class, BankAccount is super class contains both 'deposit' and 'withdraw'
	methods and when FixedDepositAccount class extend super class and override its
	methods then it breaks super class functionality
	
	But, this code fix it and follows LSP.
	Instead of forcing all accounts to behave same, 'withdraw' method is separated  
	from BankAccount using interface 'Withdrawable'.
	This ensures each subclass when they override super class methods behave consistently
	and does not break the super class functionality
	
	Benefit: 
	Simple to test as subclass behaviour is predictable
	Code Re-usability - Reuse subclasses without breaking super class functionality
	Flexible and extendible - Add new subclasses as behaviour is predictable
	Avoid weird runtime bug with safe inheritance tree
*/

abstract class BankAccount {
	public abstract void deposit(double amount);

}

interface Withdrawal{
	public abstract void withdraw(double amount);
}

class FixedDepositAccount extends BankAccount{
	
	public void deposit(double amount) {
		System.out.println("Fixed Deposit Account - Deposit amount : " + amount);
	}

}

// Saving Account
class SavingsAccount extends BankAccount, implements Withdrawal{
	public void deposit(double amount) {
		System.out.println("Savings Account - Deposit amount : " + amount);
	}

	public void withdraw(double amount) {
		System.out.println("Savings Account - Withdraw amount : " + amount);
	}
}

public class LSP2 {
	public static void main(String[] args) {
		BankAccount savingsAccount = new SavingsAccount();
		savingsAccount.deposit(10000); // Expected behaviour
		savingsAccount.withdraw(5000); // Expected behaviour

		BankAccount fdAccount = new FixedDepositAccount();
		fdAccount.deposit(50000); // Expected behaviour
	}
}

