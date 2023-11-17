package constructor;// remove this 

public class boatclass {
    
    private boolean humanpowered;

    private java.util.Date dateCreated; // did you know you could do this? if you need it once

    public boatclass() {
        dateCreated = new java.util.Date(); 
    }

    public void setpowersource(boolean yes){
        this.humanpowered = yes;
       
      }// end void setFilled
    

    

    //is humanpowered
    public boolean ishumanpowered() {
        return humanpowered;


    }

    //print results

    public String printresult() {
        return "this type of boat was created" + dateCreated + " and humanpowered: " + humanpowered;
    }
}
