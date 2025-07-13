package org.atm;

public class user_bank_account {
	private int balance=2000;
	public void withdraw(int amount) {
		if(amount>balance) {
			System.out.println("Insufficient balance,amount is greater than balance");
		}
		else if(amount<=0) {
			System.out.println("Invalid amount");
		}
		else {
			balance-=amount;
			System.out.println("Amount withdrawn successfully "+"RS"+amount);
		}
	}
	public void deposit(int amount) {
		if(amount<0) {
			System.out.println("Negative amount is invalid");
		}
		else {
			balance+=amount;
			System.out.println("Amount deposited Successfully "+"RS "+amount);
		}
		
}
	public void checkBalance() {
		System.out.println("Balance Amount:"+"RS"+balance);
	}
}
