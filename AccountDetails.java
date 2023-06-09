import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.Scanner;

public class AccountDetails {
    String username;
    String password;
    String accountNo;
    float balance = 80000f;
    int NoOfTransactions = 0;

    String transactionHistory = " ";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username - ");
        this.username = sc.nextLine();
        System.out.println("Enter Your Password - ");
        this.password = sc.nextLine();
        System.out.println("Enter Your Account Number - ");
        this.accountNo = sc.nextLine();
        System.out.println("Registration completed..kindly login");
    }

    public boolean login() {
        boolean LoggedIn = false;
        Scanner sc = new Scanner(System.in);
        while (!LoggedIn) {
            System.out.println("Enter username - ");
            String UserName = sc.nextLine();
            if (UserName.equals(username)) {
                while (!LoggedIn) {
                    System.out.println("Enter Your Password - ");
                    String PassWord = sc.nextLine();
                    if (PassWord.equals(password)) {
                        System.out.println("Login successful!!");
                        LoggedIn = true;
                    }
                    else {
                        System.out.println("Incorrect Password try again!");
                    }
                }

            }
            else {
                System.out.println("Username not found.");
            }
        }
        return LoggedIn;
    }

    public void withdraw() {
        System.out.println("Enter the amount you want to withdraw - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        try {
            if(balance>=amount){
                NoOfTransactions++;
                balance -= amount;
                System.out.println("Transaction successful");
                String str = "\n" + amount + "Rs. withdrawn";
                transactionHistory = transactionHistory.concat(str);
            }
            else {
                System.out.println("Insufficient Balance");
            }
        } catch (Exception e){

        }
    }

    public void deposit() {
        System.out.println("Enter the amount you want to deposit");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        try {
            if(amount <= 100000f){
                NoOfTransactions++;
                balance += amount;
                System.out.println("Transaction successful");
                String str = "\n" + amount + "Rs. deposited";
                transactionHistory = transactionHistory.concat(str);
            }
            else{
                System.out.println("Transaction failed.\nLimit is 100000.");
            }
        }catch (Exception e){

        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the recipient - ");
        String recipient = sc.nextLine();
        System.out.println("Enter the amount to transfer - ");
        float amount = sc.nextFloat();

        try {
            if(amount <= balance){
                if(amount <= 50000f){
                    NoOfTransactions++;
                    balance -= amount;
                    System.out.println("Successfully transferred Rs." + amount + " to " + recipient);
                    String str = "\n" + amount + "Rs. transferred to " + recipient;
                    transactionHistory = transactionHistory.concat(str);
                }
                else{
                    System.out.println("Limit is 50000.");
                }
            }
            else {
                System.out.println("Insufficient balance");
            }
        }catch (Exception e){

        }
    }

    public void checkBalance() {
        System.out.println(balance + "Rs.");
    }

    public void viewTransactionHistory() {
        System.out.print("\nTransaction History:- ");
        if(NoOfTransactions == 0){
            System.out.println("Empty");
        }
        else {
            System.out.print(transactionHistory + "\n");
        }
    }
}
