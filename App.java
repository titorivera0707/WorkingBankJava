import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int userChoice = 0;

        System.out.println("Welcome to Java Bank!\n\nWhat would you like to do?\n");

        do {

            Person person = new Person(0, null, null, null);
            Account account = new Account(0, null, 0, null);
            Bank newBank = new Bank(null);

            try{

                System.out.println("1 - Open a checking account\n2 - Open Savings Account\n3 - List Accounts\n4 - Account Statement");
                System.out.println("5 - Deposit Funds\n6 - Withdraw Funds\n7 - Close an account\n8 - Exit");
                System.out.print("Choose an option: ");
                userChoice = keyboard.nextInt();
                keyboard.nextLine();
                if(userChoice < 1 || userChoice > 8) {
                    System.out.print("Invalid number, choose another option: ");
                    userChoice = keyboard.nextInt();
                    keyboard.nextLine();
                }

                if(userChoice == 1){

                    System.out.print("\nEnter first name: ");
                    String fName = keyboard.nextLine();

                    System.out.print("Enter last name: ");
                    String lName = keyboard.nextLine();

                    System.out.print("Enter social security number: ");
                    String SSN = keyboard.nextLine();
                    System.out.print("Enter overdraft limit: ");
                    int overdraft = keyboard.nextInt();
                    keyboard.nextLine();
                    //Overdraft Protection once I have basic function.
                    String accountType = "Checking";
                    person.setFirstName(fName);
                    

                    newBank.openAccount(fName, lName, SSN, overdraft, accountType);

                }
                if(userChoice == 2){
                    System.out.print("\nEnter first name: ");
                    String fName = keyboard.nextLine();

                    System.out.print("Enter last name: ");
                    String lName = keyboard.nextLine();

                    System.out.print("Enter social security number: ");
                    String SSN = keyboard.nextLine();
                    //Overdraft Protection once I have basic function.
                    String accountType = "Savings";
                    person.setFirstName(fName);
                    int overdraft = 0;

                    newBank.openAccount(fName, lName, SSN, overdraft, accountType);
                }
                if(userChoice == 3){

                    System.out.println(newBank);
                    
                }
                if(userChoice == 4){

                    System.out.print("Enter an account number: ");
                    int accountNumber = keyboard.nextInt();

                    System.out.println(newBank.findAccount(accountNumber));

                    
                }
                if(userChoice == 5){

                    System.out.print("Enter an account number: ");
                    int accountNumber = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.print("How much would you like to deposit?");
                    double deposit = keyboard.nextDouble();
                    System.out.println(newBank.deposit(accountNumber, deposit));
                    
                }
                if(userChoice == 6){

                    System.out.print("Enter an account number: ");
                    int accountNumber = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.print("How much would you like to withdraw?");
                    double withdraw = keyboard.nextDouble();
                    System.out.println(newBank.withdraw(accountNumber, withdraw));
                    
                }
                if(userChoice == 7){

                    System.out.print("Enter an account number: ");
                    int accountNumber = keyboard.nextInt();
                    System.out.println(newBank.closeAccount(accountNumber));
                    
                }

            }catch(Exception e) {}
            finally{
                //System.out.println(newBank);
            }

        }while(userChoice>0 && userChoice<8);
        
    }
}