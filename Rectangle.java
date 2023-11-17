public class Rectangle extends Shapes2{
  private double width;
  private double height;
  
  public Rectangle() {
    }// end default constructior
  
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;

    }// end rectangle method
  
    //return width
    public double getWidth(){
        return width;
      
    }// return width
  
    // set a new width
    public void setWidth(double width){
        this.width = width;

      
    }// set a new width
  
    // return height
    public double getHeight() {
        return height;
      
    }// return height
  
    // set a new height
    public void setHeight(double height){
        this.height = height;
    
    }// end set a new height
  
    // return area
    public double getArea(){
      return width * height;
    }// return area
  
    // return perimeter
    public double getPerimeter(){
      return 2 * (width + height);
    }// return perimeter
  
} // end public class Rectangle