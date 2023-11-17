/*
A bit of theory, just a bit... see the markup file called theory - notes for definitions and descriptions, shortened in the code below with inline comments.
Your tasks: Beginning with easiest following through to challenge for the advanced people
a) round the area to 2 decimal points
b) request user input regarding the circle radius
c) add a square, after all that is why the class is called Shapes NOTE: Rectangle class would gave height and width.
d) Add perimeter to the Rectangle Class
e) add multiple shapes (circles, Squares, triangles, polygon)
f) CHALLENGE - add an array of Circles
g) CHALLENGE - add an array of Squares
i) SUPER CHALLENGE - Change to JavaFX and add graphics in addition to the console output for the shapes. {you are pioneers with ReplIt - I have not yet tried to see how slow JavaFX is in ReplIt and if there are any quirks...}

Looking ahead - "this" and Super and Sub on Thursday
*/
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

class Shapes {
  // main method
  public static void main(String[] args) {

    
    //create a circle with a radius of 10.0
    Shapes myCircle = new Shapes(10,0,0,0,"circle");

    System.out.println("Area with radius "+ myCircle.radius + " is " +myCircle.getArea());

   


    

    // create a circle with radius 1
    Scanner Input = new Scanner(System.in);
    System.out.println("Input also theres no error checking: ");
    

    
    Double radius = Input.nextDouble();
    Shapes yourCircle = new Shapes(radius,0,0,0,"circle");
    System.out.println("Area with radius "+ radius + " is "+ yourCircle.getArea());

  

    
    Input.close();

    System.out.println("Square fucntion with a side of 20");

    Shapes mySquare = new Shapes(0,20,0,0,"square");
    Shapes s = new Shapes(0,2,0,0,"square");


    Shapes[] Square = new Shapes[] {new Shapes(0,20, 0, 0, "square"),new Shapes(0,2,0,0,"square")};
    System.out.println("rect fucntion with a sides of 30 and 20");
    Shapes myRect = new Shapes(0,0,20, 30, "rect");

    System.out.println("Area "+ mySquare.getArea());

    System.out.println("Perimiter as well");

     System.out.println("Area "+ myRect.getArea() + " Perimeter "+myRect.getPer());

    for (int i = 0;i<2;i++) {
      System.out.println(Square[i].toaString());

    }

    
    


    

    //Modify circle radius



    
  } // end main method

  double radius;
  double length;
  double height;
  double side;

  String type;
  String message;

  double area;

  double perimeter;

  //Construct a circle with radius 1
  Shapes () {
    radius = 1.0;
    
    
  }


  

  


  

  //Construct a shape
  Shapes(double radius, double side,double length, double height, String type) {
    
    switch (type) {
      case "circle":
      double r = radius;
      area = Math.round((r*r*Math.PI) * 100.0) / 100.0;
      break;

      case "square":
      area = side*side;
      break;

      case"rect":
      area = length *height;
      perimeter = (2*height) + (2*length);
      break;

      case "triangle":
      area = (length*height)/2;

      default:
      System.out.println("unkown shape");




    }
  } 




  

  //return the area of your shape, so far circle

  double getArea() {
    return area;
    
  }

  double getPer() {
    return perimeter;
  }

  String toaString() {
    return "Radius: " + radius + ", Side: " + side + ", Length: " + length + ", Height: " + height + ", Type: " + type;
}

 
  
  
}// end class Shapes