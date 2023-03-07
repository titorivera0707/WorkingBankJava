import java.util.Scanner;
import java.util.ArrayList;

public class Bank {
	private static ArrayList<Account> accounts=new ArrayList<Account>();
	private static ArrayList<Statements> statements = new ArrayList<Statements>();
	private static int accountNumbers=100;
	private static int statementID = 1;
	private static int id=1;
	public Bank(String s) {
		this.accounts = accounts;
	}
	
	public static String openAccount(String firstName, String lastName, String SSN, int overdraft, String accountType) {
		Person customer=new Person(id++, firstName, lastName,SSN);
		Account account=new Account(accountNumbers++, accountType, overdraft, customer, "Open");
		accounts.add(account);
		return "Thank you, the account number is: " + (accountNumbers-1);

	}
	
	public static void printAccounts() {
	
		for(Account a: accounts) {
			System.out.println(a);
		}

	}	
	
	public void printStatement(int accountNumber) {

		  for(Account acc: accounts) {

			if(acc.getAccountNumber() == accountNumber) {

				for(Statements states: statements) {

					if(states.getAccNumber() == accountNumber) {
						System.out.println(states);
					}

				}

			}

		  }

	}
	
	public double getAccountBalance(int accountNumber) {
		
		for(Account acc: accounts) {

			if(acc.getAccountNumber() == accountNumber) {
				return acc.getBalance();
			}

		}
		return 0;
	}
	
	
	public String withdraw(int accountNumber, double amount) {

		for(Account acc: accounts) {

			if(acc.getAccountNumber() == accountNumber) {
				if(acc.getAccountStatus().equals("Closed")&&(acc.getBalance()<0)){
					System.out.println("Account closed, only deposits allowed.");
				}

				else if((acc.getBalance()+acc.getOverDraft()) > amount){
					Statements newStatement = new Statements(statementID, "debit", amount, accountNumber);
					statements.add(newStatement);
					statementID++;
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
					Statements newStatement = new Statements(statementID, "credit", amount, accountNumber);
					statements.add(newStatement);
					statementID++;
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

		for(Account acc: accounts) {
			

			if(acc.getAccountNumber() == accountNumber) {
				double balance = acc.getBalance();
				acc.setAccountStatus("Closed");
				if(acc.getBalance()>0){
					acc.setOverDraft(0);
					return "Account closed, current balance is $" + acc.getBalance() + ", deposits no longer allowed.";
				}
				else if(acc.getBalance()<0) {
					acc.setOverDraft(0);
					return "Account closed, current balance is $" + acc.getBalance() + ", withdrawals no longer allowed.";
				}
				else{return "Account closed, no deposits or withdrawals allowed.";}
			}
		}
		return "Account not found.";

    }

	@Override
	public String toString() {
		return accounts.toString();
	}
	
}