package constructor;

public class boats {
    public static void main(String[] args) { // Fix: Changed Strings[] to String[]
        canoe daboatCanoe = new canoe(1, 4.7, "human power");
        daboatCanoe.setpowersource(true);

        System.out.println(daboatCanoe.getinformation());
        System.out.println(daboatCanoe.printresult());

        cargo cargoship = new cargo(12,10.0,"idk diesel?");
        System.out.println(cargoship.getinformation());

        fishing fishing = new fishing(3,100.0,"trolley motor");
        System.out.println(fishing.getinformation());

        
        yatch yatch = new yatch(12,10.0,"big engine");
        System.out.println(yatch.getinformation()); 
        
        speedboat speedboat = new speedboat(3, 100.0, "gas engine");
        System.out.println(speedboat.getinformation()); 

        
    }
}
