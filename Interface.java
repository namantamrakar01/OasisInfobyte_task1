import java.sql.SQLOutput;
import java.util.Scanner;

public class Interface extends AccountDetails {
    public static int IntegerInputEntered(int limit) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean temp = false;

        while ( !temp ) {
            try {
                input = sc.nextInt();
                temp = true;

                if ( temp && input > limit || input < 1 ) {
                    System.out.println("Choose the number between 1 to " + limit);
                    temp = false;
                }
            }
            catch ( Exception e ) {
                System.out.println("Enter only integer value");
                temp = false;
            }
        };
        return input;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------WELCOME------------------");
        System.out.println("Enter 1 to register \nEnter 2 to exit");
        System.out.println("Enter your choice here - ");

        int choice = IntegerInputEntered(2);

        if(choice == 1){
            AccountDetails ac = new AccountDetails();
            ac.register();
            while(true) {
                System.out.println("Enter 1 to Login\nEnter 2 to Exit");
                System.out.println("Enter your choice here - ");
                int ch = IntegerInputEntered(2);
                if(ch == 1){
                    if(ac.login()){
                        boolean finished = false;
                        while (!finished){
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.println("Enter your choice - ");
                            int c = IntegerInputEntered(6);
                            switch(c) {
                                case 1:
                                    ac.withdraw();
                                    break;
                                case 2:
                                    ac.deposit();
                                    break;
                                case 3:
                                    ac.transfer();
                                    break;
                                case 4:
                                    ac.checkBalance();
                                    break;
                                case 5:
                                    ac.viewTransactionHistory();
                                    break;
                                case 6:
                                    finished = true;
                                    break;

                            }

                        }
                    }
                }
                else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
