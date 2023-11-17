/* Very basic program to ease you in after the long weekend. 
 Your teacher will walk through this code, then you will write code with the following additions;
 a) create user input to request the two values
 b) then create a method to calculate the min value
 c) then create a method to calculate the average of 5 values
 d) then create a method to find the prime number of 10 numbers input by the user.  Give an appropriate answer if none of the numbers are prime.
 e) then Play and show results from using ceil, floor, rint, round, and abs.
 f) then Play and show results from using pow, sqrt, cbrt, and hypot.
 g) CHALLENGE - show me something with sin, cos and tan
 HINT: import math!
 HINT: import java.util.Scanner too
*/


// hint! i was too tired to bother doing the challenges :(
import java.util.Scanner; 

public class MaxVal {

    

    
  public static void main(String[] args) {
    
    double Sum = 0; 

    Scanner Input = new Scanner(System.in);
  // main method
    int i = Input.nextInt();
    int j = Input.nextInt();
    int k = max( i,j);
    int mini = min(i,j);
    System.out.println("The maximum between " + i + " and " + j + " is " + k);
    System.out.println("The min between " + i + " and " + j + " is " + mini);
    System.out.println("input 5 numnbers line by line");
    for (int l = 0; l < 5; l++) {
        double num = Input.nextInt();
        Sum += num;
       

    }
    double average = avg(Sum);
    System.out.println(average);

    for (int dos = 0; dos < 10; dos++) {
        System.out.println("enter a number greater than 1");
        int sumthing = Input.nextInt();
        if (sumthing > 1) {
            boolean isitprime = Isprime(sumthing);
            System.out.println("prime? "+ isitprime);

        }else {
            System.out.println("try again");
        }
        

    }

    System.out.println("Enter a double");

    double floorex = Input.nextDouble();
    System.out.println(Math.floor(floorex));

    // yes i was tired how did you know? 

    //not knowing why my pc can boot from USB is pain

    System.out.println("example of random number"+ Math.random());
    System.out.println("example of rounding 3.4"+ Math.round(3.4));
    System.out.println("example of abs value of -3"+ Math.abs(-3));
    System.out.println("example of raising a number to a power"+ Math.pow(2.0,3.0));//source; https://stackoverflow.com/questions/8842504/raising-a-number-to-a-power-in-java
    System.out.println("example of cubing a number"+ Math.cbrt(8.0));
    System.out.println("example of using hypot???? of 2 and 3"+ Math.hypot(2.0,3.0));
    //to tired to do sin/cos/tan




    
   


    /* 


    for (int d = 0; d < 10; d++) {
        int num = Input.nextInt();
        if (ifprime(num) == true) {
            System.out.println("Number is prime");


        }else {
            System.out.println("Number is not prime");
        }
        
       

    }
*/

    Input.close();
    
    

  }// end main

  public static int max(int num1, int num2) {
    int answer;

    if (num1 > num2){
      answer = num1;
    }else{
      answer = num2;
    }// end if
    return answer;


 
  }// end max

  public static int min(int num1, int num2) {
    int answer;

    if (num1 < num2){
      answer = num1;
    }else{
      answer = num2;
    }// end if
    return answer;


 
  }// end max


  public static double avg(double int1) {// really simple average calculator
    double response;
  
    
    
    response = int1/5;
    return response;

        

   
    
    
  }

  public static boolean Isprime(int num) {
    for (int factor = 2; factor < Math.ceil(num);factor++) {// peter said this is better because you're repeating factors after the sqrt of a num once the factor gets there
        if (num % factor ==0) {
            return false;
            
        }
    }
    return true;

  }

 
  
}// end MaxVal