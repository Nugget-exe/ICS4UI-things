package constructor;

public class speedboat extends boatclass {
    private int numofpeople;
    private double speed;
    private String Powersource;

    public speedboat() {

    }//default

    public speedboat(int numofpeople, double speed, String Powersource) {
        this.numofpeople = numofpeople;
        this.speed=speed;
        this.Powersource = Powersource;
        
    }// 

    public int getpeople() {
        return numofpeople;

    }

    public void setpeople(int people) {
        this.numofpeople = people;

    }
    public double getspeed() {
        return speed;



    }

    
    public void setspeed(double speed) {
        this.speed = speed;

    }
    public String getpow() {
        return Powersource;
    }
    public void setpow(String power) {
        this.Powersource = power;
    }

    public String getinformation(){
       return "The boat has "+numofpeople+ " person and goes " +speed+ " and is powered by " +Powersource;
    }




    
}
