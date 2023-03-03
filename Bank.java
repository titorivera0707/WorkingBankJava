import java.util.Scanner;
import java.util.ArrayList;

public class Bank {
	private static ArrayList<Account> accounts=new ArrayList<Account>();
	private static int accountNumbers=100;
	private static int id=1;
	public Bank(String s) {
		this.accounts = accounts;
	}
	
	public static Account openAccount(String firstName, String lastName, String SSN, int overdraft, String accountType) {
		Person customer=new Person(id++, firstName, lastName,SSN);
		Account account=new Account(accountNumbers++, accountType, overdraft, customer);
		accounts.add(account);
		return account;

	}
	
	public static void printAccounts() {
	
		for(Account a: accounts) {
			System.out.println(a);
		}

	}	
	
	
	//The following methods must be implemented
	
	
	public Account findAccount(int accountNumber) {
		
		for(Account acc: accounts) {

			if(acc.getAccountNumber() == accountNumber) {
				return acc;
			}

		}
		return null;
	}
	
	
	public String withdraw(int accountNumber, double amount) {

		for(Account acc: accounts) {

			if(acc.getAccountNumber() == accountNumber) {
				if((acc.getBalance()+acc.getOverDraft()) > amount){
					amount = acc.getBalance() - amount;
					acc.setBalance(amount);
				return "Withdraw Successful, new balance is " + amount;
				}
				else{
					return "Withdraw failed, the balance is $" + acc.getBalance();
				}
			}

		}

		return "Account not found";

    }

    
   	
	public String deposit(int accountNumber, double amount) {

		for(Account acc: accounts) {

			if(acc.getAccountNumber() == accountNumber) {
				if(amount>0){
					amount = acc.getBalance() + amount;
					acc.setBalance(amount);
				return "Deposit Successful, new balance is " + amount;
				}
				else{
					return "Deposit failed, the balance is $" + acc.getBalance();
				}
			}

		}

		return "Account not found";
	
    } 
    
    	
	public String closeAccount(int accountNumber) {

		int x =0;
		for(Account acc: accounts) {
			

			if(acc.getAccountNumber() == accountNumber) {
				double balance = acc.getBalance();
				accounts.remove(x);
				if(balance < 0)return "The bank is now $" + balance + " poorer.";
				else return "The bank is now $" + balance + " richer. Thank you.";
			}
			x++;
		}
		return "Account not found.";

    }

	@Override
	public String toString() {
		return accounts.toString();
	}
	
}