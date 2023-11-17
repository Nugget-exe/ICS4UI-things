/*
The next version of Shapes
*/

import java.lang.Math;
import java.util.Scanner;

public class Shapes2 {
  private String color = "white";
  private boolean filled;
  private java.util.Date dateCreated; // did you know you could do this? if you need it once
  //construct a default Shape object
  public Shapes2(){
    dateCreated = new java.util.Date(); 
  }// end default shape object

  // return colour
  public String getColor(){
    return color;
   
  }// end String getColor

  // set a new colour
  public void setColor(String color){
    this.color = color;
  
  }// end void setColor

  // return filled. Since filled is boolean, its get method
  // is named isFilled
  public boolean isFilled() {
    return filled;
    
  }// end isFilled

  //Set a new filled
  public void setFilled(boolean filled){
    this.filled = filled;
   
  }// end void setFilled

  // get Date Created
  public java.util.Date getDateCreated(){
    return dateCreated;
    
  }// end get date created

  // return a string representation of this object
  public String toString() {
    return "Created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
  }// end return string object representation

} // end Shapes, public class
