// does shapes, circle and rectangle work as written?
// Only one task today;
//a) Return to boat class (where we had canoe, speedboat, kayak... all of them)
// and create boat which calls each type, just like testCircleRect calls Circle 
// and Rectangle.
// When finished this, Day 26, complete Day 25 and if not yet completed Day 24.
//
// If finished all programmming for this week, work on Assignment 1 due Tomorrow.

import java.lang.Math;
import java.util.Scanner;       


public class TestCircleRect{
  public static void main(String[] args){
    Circle circle = new Circle(1);
    System.out.println("A circle "+ circle.toString());
    System.out.println("The radius is "+ circle.getRadius());
    System.out.println("The area is  "+ circle.getArea());
    System.out.println("The diameter is "+ circle.getDiameter());

    // now the rectangle
    Rectangle rectangle = new Rectangle(2,4);
    System.out.println("\nA rectangle "+ rectangle.toString());
    System.out.println("The area is  "+ rectangle.getArea());
    System.out.println("The perimeter is "+ rectangle.getPerimeter());
  }// end void main
}// end testCircleRectangle