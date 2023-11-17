public class Circle extends Shapes2 {
  private double radius;

  public Circle() {

  } // default constructor

  public Circle(double radius) {
    this.radius = radius;
    
  }// end public Circle 

  // return radius
  public double getRadius(){//get the radisu
    return radius;

    
  }// end return radius

  // set a new radius
  public void setRadius(double radius) {
    this.radius = radius;

  }
 

  

  // return area
  public double getArea() {
    return radius * radius * Math.PI;
  }// end return area

  // return diameter
  public double getDiameter(){
    return 2 * radius;
  }// return diameter

  // return perimeter
  public double getPerimeter(){
    return 2 * radius * Math.PI;
  }// return perimeter

  // print the circle information
  public void printCircle(){
    System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
  }// end print circle info
} // end public class Circle