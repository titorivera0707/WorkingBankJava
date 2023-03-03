
public class Account {

    private int accountNumber;
	private String type;
	private boolean accountOpen;
	private double balance;
	private Person accountHolder;
	private int overDraft;
	
	//Constructor
	public Account(int accountNumber, String type, int overDraft, Person accountHolder) {
		this.accountNumber = accountNumber;
		this.type = type;
		this.overDraft = overDraft;
		this.accountHolder = accountHolder;
		balance = 0;
		accountOpen=true;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAccountHolder(Person accountHolder) {
		this.accountHolder = accountHolder;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getType() {
		return type;
	}

	public boolean isAccountOpen() {
		return accountOpen;
	}

	public Person getAccountHolder() {
		return accountHolder;
	}

	public int getOverDraft() {
		return overDraft;
	}

	public boolean withdraw(double amount) {
		if(this.balance-amount<0) return false;
		this.balance=this.balance-amount;
		return true;
	}
	
	public boolean deposit(double amount) {
		if(amount<0 || !isOpen()) return false;
		this.balance=this.balance+amount;
		return true;
		
	}
	
	public boolean isOpen() {
		return this.accountOpen;
	}
	
	public void closeAccount() {
		this.accountOpen=false;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	
	public String toString() {
		return "\n"+this.accountNumber+":"+type+":"+this.balance+":"+overDraft+":["+this.accountHolder.toString()+"]";
	}

}