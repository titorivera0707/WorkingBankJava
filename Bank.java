import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import java.io.*;

public class Bank {
	private static ArrayList<Account> accounts=new ArrayList<Account>();
	private static ArrayList<Transactions> transactions = new ArrayList<Transactions>();
	private static int accountNumbers=100;
	private static int transactionID = 1;
	private static int id=1;
	
	public String openAccount(String firstName, String lastName, String SSN, int overdraft, String accountType) {
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

				for(Transactions states: transactions) {

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
				if(acc.getAccountStatus().equals("Closed")&&(acc.getBalance()<=0)){
					return "Account closed, only deposits allowed.";
				}

				else if((acc.getBalance()+acc.getOverDraft()) > amount){
					Transactions newStatement = new Transactions(transactionID, "debit", amount, accountNumber);
					transactions.add(newStatement);
					transactionID++;
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
   	
	public String deposit(int accountNumber, double amount){

		for(Account acc: accounts) {

			if(acc.getAccountNumber() == accountNumber) {
				if(acc.getAccountStatus().equals("Closed")&&(acc.getBalance()>=0)){
					return "Account closed, only withdrawals allowed.";
				}
				else if(amount>0){
					Transactions newStatement = new Transactions(transactionID, "credit", amount, accountNumber);
					transactions.add(newStatement);
					transactionID++;
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

	public void saveFile()  throws IOException{

		File newFile = new File("transactions.txt");
		if(newFile.createNewFile()) {
			System.out.println("File created: "+newFile.getName());
		}
		else{ 
			System.out.println("File already exists");
		}
		PrintWriter printWriter = new PrintWriter(newFile);
		String newData;

		for(Account acc: accounts) {

			for(Transactions states: transactions) {
			
					//System.out.println(states.toString());
					printWriter.append(states.toString());
			}
		}
		System.out.println("Successfully saved transactions.");
		printWriter.flush();
		printWriter.close();

	}

	@Override
	public String toString() {
		return accounts.toString();
	}
	
}