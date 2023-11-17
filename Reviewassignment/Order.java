package Reviewassignment;


public class Order {
    private String item = "";// "" and 0 are default values
    private int number = 0;
    public Order(String item, int number) {
        this.item = item;
        this.number = number;


    }

    

    public void amount(int newnumber) {//function for adding items. wont accept input less than 0
        if (number < 0) {
            System.out.println("Invalid amount");
        } else {
            number += newnumber;
            System.out.println("Added "+ newnumber);

        }

    }

    public void Print() {
        System.out.println("item: " + item + " Amount: " + number);
        //this function prints out the object information(name,num)
      
    }



    
}
