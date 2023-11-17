package Polymorshism;
import java.lang.Math;
class Shape {
    public double calcArea() {
        return 0.0;

    }
}

class Circle extends Shape {
    private double radius;
    public Circle(double r) {
        this.radius = r;

    }
    @Override
    public double calcArea() {
        return Math.round((radius*radius*Math.PI) * 100.0) / 100.0;
    }
    
    
}

class Square extends Shape {
    private double side;
    public Square(double s) {
        this.side = s;

    }
    @Override
    public double calcArea(){
        return side*side;
    }
}

class Polygon extends Shape {
   
    private double s;
    private double n;
  

    public Polygon(double sidelen, int sides) {
        this.s = sidelen;
        this.n = sides;
        

    }

    @Override
    public double calcArea(){
        return ((s*s)*n)/(4*Math.tan((180/n)/(180/Math.PI)));//https://www.mathopenref.com/polygonregulararea.html
    }
}

public class Shapesoverride{
    public static void main(String[] args) {

        Shape circle = new Circle(1.8);
        System.out.println(circle.calcArea());

        Shape Square = new Square(5);
        System.out.println(Square.calcArea());

        Shape Poly = new Polygon(10, 6);
        System.out.println(Poly.calcArea());

        

    }
}