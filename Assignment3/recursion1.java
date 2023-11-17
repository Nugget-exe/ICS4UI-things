package Assignment3;

import java.util.Arrays;
import java.util.Scanner;

public class recursion1 {

    public static void dfswordsearch(int row, int col, String word, int direct ) {

    }
    public static void main(String[] args) {

        
        Scanner Input = new Scanner(System.in);
        String wordtofind = Input.nextLine();
        String row = Input.nextLine();
        String col = Input.nextLine();
        int rowing = Integer.parseInt(row);
        int coling = Integer.parseInt(col);
        char[][] Aarray = new char[rowing][coling];


        for(int i=0;i<rowing; i++){
            char[] WordstoCharArray = new char[coling];
            
            String word = Input.nextLine();
            for (int l = 0; l<word.length();l++) {
                
                WordstoCharArray[l] = word.charAt(l);
            }
            Aarray[i] = WordstoCharArray;
            

        }

        System.out.println(Arrays.deepToString(Aarray));//https://stackoverflow.com/questions/19648240/the-best-way-to-print-a-java-2d-array
        
        Input.close();
    }

    
    
    
}
