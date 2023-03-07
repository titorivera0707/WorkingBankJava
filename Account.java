
public class Account {

    private int accountNumber;
	private String type;
	private String accountStatus;
	private double balance;
	private Person accountHolder;
	private int overDraft;
	
	//Constructor
	public Account(int accountNumber, String type, int overDraft, Person accountHolder, String accountStatus) {
		this.accountNumber = accountNumber;
		this.type = type;
		this.overDraft = overDraft;
		this.accountHolder = accountHolder;
		this.accountStatus = accountStatus;
		balance = 0;
		accountStatus = "Open";
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

	public Person getAccountHolder() {
		return accountHolder;
	}

	public void setOverDraft(int overDraft) {
		this.overDraft = overDraft;
	}

	public int getOverDraft() {
		return overDraft;
	}
	
	
	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	
	public String toString() {
		return "\n"+this.accountNumber+" : "+type+" : $" + String.format("%.2f", this.balance) + " : "+this.accountHolder.toString()+" : Account "+this.accountStatus;
	}

}