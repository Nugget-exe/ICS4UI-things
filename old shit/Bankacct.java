/*
 * 1.create withdrawl(similar to example, but as a class now)
 * 2. chat the program to ask for the use of deposit and withdrawl amounts
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class Bankacct {
    

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        
        

        Bankaccount account = new  Bankaccount("1234", 10000);
        System.out.println("What do you want to do?");
        String choice = Input.nextLine().toLowerCase();

        switch (choice) {
            
            case "deposit":
                System.out.println("Enter amount to be deposited");
                double dollars = Input.nextDouble();
                account.deposit(dollars);
                break;

            case "withdraw":
            try{
                System.out.println("Enter amount to be withdrawn");
                double wdollars = Input.nextDouble();
                account.wtihdrawl(wdollars);
                
            }catch (InputMismatchException e) {
                System.out.println(e);
            }
            break;

            default:
                System.out.println("Invalid input");
                
        }

       
    
        account.printAccountInfo();

        Input.close();

    }
    
}
