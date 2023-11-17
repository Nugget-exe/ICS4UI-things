
package Searching;
/*
Searching - different types...
Since the for-each style FOR can only cycle through an array sequentially, from start to finish it is useful for searching. If unsorted, this is one of the best ways to search for a value...
This example will stop if it finds the value.
*/
class Search1 {
  public static void main(String[] args) {
    int nums[ ] = {6,8,2,7,3,9,1,5};
    int val = 3;
    boolean found = false;

    // use a for-each style to search for nums for val
    for(int x : nums) {
      if(x == val){
        found = true;
        break;
      } // end if check x = nums
    }// end for
    if(found)
      System.out.println("Value of "+ val + " found!");
  }//end if
  
}//end Search