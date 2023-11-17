package Searching;
import java.util.HashMap;
/* 
// Create a class to represent Canoe
class Canoe {
    private String model;
    private int serialNumber;

    public Canoe(String model, int serialNumber) {
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return "Canoe [Model: " + model + ", Serial Number: " + serialNumber + "]";
    }
}

// Create a class to represent Kayak
class Kayak {
    private String model;
    private int serialNumber;

    public Kayak(String model, int serialNumber) {
        this.model = model;
        this.serialNumber = serialNumber;
    }// end public Kayak

    public String getModel() {
        return model;
    }// end getModel

    public int getSerialNumber() {
        return serialNumber;
    }// end getSerial

    @Override
    public String toString() {
        return "Kayak [Model: " + model + ", Serial Number: " + serialNumber + "]";
    }// end String returning Kayak
}

public class CanoeKayakSales {

    public static void main(String[] args) {
        // Create a HashMap to store Canoes and Kayaks
        HashMap<String, Object> salesInventory = new HashMap<>();

        

        // Add Canoes and Kayaks to the inventory
        // Note: this is test data only - a real inventory would be read in from a file/database etc.
      // hardcoded for testing
        Canoe canoe1 = new Canoe("Canoe Model A", 1001);
        Canoe canoe2 = new Canoe("Canoe Model B", 1002);
        Kayak kayak1 = new Kayak("Kayak Model X", 2001);
        Kayak kayak2 = new Kayak("Kayak Model Y", 2002);

        // Adding items to the inventory
      // Note: this is test data only - areal inventory would be read in from a file/database etc.
      // hardcoded for testing
        salesInventory.put(canoe1.getModel(), canoe1);
        salesInventory.put(canoe2.getModel(), canoe2);
        salesInventory.put(kayak1.getModel(), kayak1);
        salesInventory.put(kayak2.getModel(), kayak2);

        // Search for a Canoe or Kayak by model
        // hardcoded one, naturally you would ask your user 
        // and likely give a nice menu and suggested syntax.
        String searchModel = "Canoe Model A"; // Change this to the model you want to search for

        // Check if the inventory contains the specified model
        if(salesInventory.containsKey(searchModel)) {
            Object item = salesInventory.get(searchModel);
            System.out.println(item + "Found");
        } else {
            System.out.println("not found");
        }





      
    }// end void main
} // end Class Canoe & Kayak - hash Search
// you cannot really see the advantage of this search in this small dataset, with no possible collisions.

 */