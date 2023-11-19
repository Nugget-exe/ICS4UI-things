
package Assignment3;

import java.util.ArrayList;

class bank {// make class bank with some methods that return nothing
  public double getinterest(double time) {
    return 0.0 * time;
  }

  public String gethist() {
    return "";
  }

}

class savings extends bank {// make savings class that extends bank
  private double cash;
  private ArrayList<String> transactionhistory = new ArrayList<String>();

  public savings(double cash) {
    this.cash = cash;//assign cash to a field of the same name(cash)

  }

  // example of overloading: using same method name but different actionx
  public void addmoney(double amt) {//basic logic that i dont want to explain, but if money greatrer than 0 then add money
    if (amt > 0) {
      cash += amt;
      System.out.println("Deposited: " + amt);
      transactionhistory.add("Deposited: " + amt);

    } else {
      System.out.println("Invalid deposit amount");
    }

  }

  public void takemoners(double wamt) {
    if (wamt > 0 && wamt <= cash) {//if monet less greater than 0 and less than amount in savings then take money
      cash -= wamt;
      System.out.println("Withdrawn: " + wamt);
      transactionhistory.add("Withdrawn: " + wamt);

    } else {
      System.out.println("Invalid withdrawal amount or insuffient funds");
    }
  }
  //override getinterest function
  @Override
  public double getinterest(double time) {
    return cash * time;

  }


  //override gethist function

  @Override
  public String gethist() {
    return transactionhistory.toString();
  }

}

class cacc extends bank {//same logic as above but for cheuqing account
  private double cash;
  private ArrayList<String> transactionhistory = new ArrayList<String>();

  public cacc(double cash) {//same as above: assign value of param to a field of the same name
    this.cash = cash;

  }

  public void addmoney(double amt) {// add money if its larger than 0, othereise output error
    if (amt > 0) {
      cash += amt;
      System.out.println("Deposited: " + amt);
      transactionhistory.add("Deposited: " + amt);

    } else {
      System.out.println("Invalid deposit amount");
    }

  }

  public void takemoners(double wamt) {//take money if its greater than 0 and lessthan or equal to cash
    if (wamt > 0 && wamt <= cash) {
      cash -= wamt;
      System.out.println("Withdrawn: " + wamt);
      transactionhistory.add("Withdrawn: " + wamt);

    } else {
      System.out.println("Invalid withdrawal amount or insuffient funds");
    }
  }
//override get interest
  @Override
  public double getinterest(double time) {
    return cash * time * 2;
  }
//override gethist
  @Override
  public String gethist() {
    return transactionhistory.toString();
  }
}