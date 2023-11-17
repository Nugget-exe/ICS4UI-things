package constructor;

public class fishing extends boatclass {
    private int numofpeople;
    private double speed;
    private String Powersource;

    public fishing() {

    }//default

    public fishing(int numofpeople, double speed, String Powersource) {
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
       return "The boat has "+numofpeople+" person and goes " +speed+ " and is powered by " +Powersource;
    }




    
}
