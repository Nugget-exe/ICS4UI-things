
package Assignment3;

import java.util.ArrayList;

class bank {
  public double getinterest(double time) {
    return 0.0 * time;
  }

  public String gethist() {
    return "";
  }

}

class savings extends bank {
  private double cash;
  private ArrayList<String> transactionhistory = new ArrayList<String>();

  public savings(double cash) {
    this.cash = cash;

  }

  // example of overloading: using same method name but different actionx
  public void addmoney(double amt) {
    if (amt > 0) {
      cash += amt;
      System.out.println("Deposited: " + amt);
      transactionhistory.add("Deposited: " + amt);

    } else {
      System.out.println("Invalid deposit amount");
    }

  }

  public void takemoners(double wamt) {
    if (wamt > 0 && wamt <= cash) {
      cash -= wamt;
      System.out.println("Withdrawn: " + wamt);
      transactionhistory.add("Withdrawn: " + wamt);

    } else {
      System.out.println("Invalid withdrawal amount or insuffient funds");
    }
  }

  @Override
  public double getinterest(double time) {
    return cash * time;

  }

  @Override
  public String gethist() {
    return transactionhistory.toString();
  }

}

class cacc extends bank {
  private double cash;
  private ArrayList<String> transactionhistory = new ArrayList<String>();

  public cacc(double cash) {
    this.cash = cash;

  }

  public void addmoney(double amt) {
    if (amt > 0) {
      cash += amt;
      System.out.println("Deposited: " + amt);
      transactionhistory.add("Deposited: " + amt);

    } else {
      System.out.println("Invalid deposit amount");
    }

  }

  public void takemoners(double wamt) {
    if (wamt > 0 && wamt <= cash) {
      cash -= wamt;
      System.out.println("Withdrawn: " + wamt);
      transactionhistory.add("Withdrawn: " + wamt);

    } else {
      System.out.println("Invalid withdrawal amount or insuffient funds");
    }
  }

  @Override
  public double getinterest(double time) {
    return cash * time * 2;
  }

  @Override
  public String gethist() {
    return transactionhistory.toString();
  }
}