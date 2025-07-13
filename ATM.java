package org.atm;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		user_bank_account account= new user_bank_account();
		System.out.println("Welcome to Atm Interface");
		boolean want_to_continue=true;
		while(want_to_continue) {
			System.out.println("User Interface\n1.)Withdraw amount\n2.)Deposit amount\n3.)Check Balance\n4.)Exit");
			System.out.println("Enter your choice:");
			int choice= input.nextInt();
			switch(choice) {
			case 1:{
				System.out.print("Enter amount:"+"RS");
				int amt1=input.nextInt();
				account.withdraw(amt1);
				break;
			}
			case 2:{
				System.out.print("Enter amount:"+"RS");
				int amt2=input.nextInt();
				account.deposit(amt2);
				break;
			}
			case 3:{
				account.checkBalance();
				break;
			}
			case 4:{
				System.out.println("Thank you for using ATM");
				want_to_continue=false;
				break;
			}
			default:{
				System.out.println("Invalid Choice.Try Again");
			}
			}
			input.close();
			
			
			
		}
		

	}
	

}
