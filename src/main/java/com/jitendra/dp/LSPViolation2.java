package com.jitendra.dp;

//LSP - Liskov Substitution Principle

/*
	Subclass should not break super class functionality when they replace or substitute superclass
	
	Avoid creating subclasses that does not support the super class functionality.
	In this case, subclass don't behave like superclass and restricts or breaks
	upper class functionality when subclass object substitue super class object 
	and call overriden method. To prevent this, separate unsupported functionality 
	using an interface and build it.

    Here in this code, any class that extends and substitute BankAccount class
    should behave like all accounts can deposit and withdraw.
    However, Fixed Deposit Account cannot withdraw.This breaks the expected behavior
    of the super class BankAccount, when coding() withdraw is overridden. 
    So it does not follow LSP.
    
    Challenges: 
    Difficult to test and reuse as subclass behaviour is not predictable
    Less maintainable because hard to add new feature
*/

abstract class BankAccount {
	public abstract void deposit(double amount);

	public abstract void withdraw(double amount);
}

class FixedDepositAccount extends BankAccount {
	public void deposit(double amount) {
		System.out.println("Fixed Deposit Account - Deposit amount : " + amount);
	}

	public void withdraw(double amount) {
		throw new UnsupportedOperationException("Fixed Deposit Account cannot withdraw");
	}
}

// Saving Account
class SavingsAccount extends BankAccount {
	public void deposit(double amount) {
		System.out.println("Savings Account - Deposit amount : " + amount);
	}

	public void withdraw(double amount) {
		System.out.println("Savings Account - Withdraw amount : " + amount);
	}
}

public class LSPViolation2 {
	public static void main(String[] args) {
		BankAccount savingsAccount = new SavingsAccount();
		savingsAccount.deposit(10000); // Expected behaviour
		savingsAccount.withdraw(5000); // Expected behaviour

		BankAccount fdAccount = new FixedDepositAccount();
		fdAccount.deposit(50000); // Expected behaviour
		fdAccount.withdraw(10000); // Unexpected behaviour. This throws an exception, violating LSP
	}
}
