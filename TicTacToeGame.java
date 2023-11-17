/*
Here's a popular 2D array game that you should be able to now understand and create.
Tic tac toe or Noughts and Crosses has a 3 x 3 grid (2D array) to represent the game board.
Players take turns placing their symbols (usually 'x' and 'o') on the grid, with the goal of 3 in a row, column, or diagonal to win the game.
Here's a simplified version to begin with.

Created by Ms. Harris with a few texts and past knowledge for ICS4UI - recap from the REVIEW assignment # 2
Technical notes:
> the game board is represented as a 3x3 2D array called board.
> the displayBoard function displays the current state of the game board
> the isValidMove function checks if a move is valid (within bounds an dthe cell is empty.)
> the isWinner function checks if the currentl player has won by examining rows, columns, and diagonals.
> the main game loop allows players to take turns, make moves, and checks for a winner or draw.

YOUR TASKS: (Due Monday the holiday - will take up in class on Tuesday)
a) add appropriate error checking
b) write to a csv or txt file the current winner of the game, not overwritting past winners CHALLENGE - show these winners when requested
c) Nice user messaging with tie, loss and winner of a games and ask if they want to play again
d) CHALLENGE - change the game/functions to classes and a more modular program - IN A SEPARATE FILE (want to keep the original intact, with a and b) - this is a simplified form of versioning
DUE: ideally Thursday's class, but you CAN work on this practice over the weekend - DUE MONDAY, so we can review on Tuesday.
*/
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
class TicTacToeGame {
  public static void main(String[] args) {
    //Create a 3x3 game board using a 2D array
    char[][]board = new char[3][3];

    // initialize the game board with empty spaces
    for (int row=0; row < 3; row++){
      for(int col=0; col < 3; col++){
        board[row][col] = ' ';
      }// end for column game board    
    }// end for row game board
    //Create a Scanner for user input
    Scanner scanner = new Scanner(System.in);

    boolean gameOver = false;
    char currentPlayer = 'X';
    // main game loop
    while (!gameOver){
      // Display the current state of the game board
      displayBoard(board);
      
      // Prompt the current player for their move
      System.out.println("Player" + currentPlayer + "enter your move (row and column): ");
      int row = scanner.nextInt();
      int column = scanner.nextInt();
      if (isValidMove(board, row, column)){
        //update game board
        board[row][column] = currentPlayer;
        //check if player has won
        if (isWinner(board, currentPlayer)) {
            displayBoard(board);
            System.out.println("Player" + currentPlayer + "Wins!");
            gameOver = true;

        } else {
            //switch to other player
            System.out.println();
            currentPlayer = (currentPlayer == 'X')? '0':'X';//tenary opterator
        }



      }else {
        System.out.println("invalid move. please try again");
      }
      
    }//end while game not Over

    // close the scanner - good practice
    scanner.close();
  } // end public static void main
  //Display the current state of the game board
  public static void displayBoard(char[][] board){
    System.out.println("  0 1 2");
    for (int row =0;row<3;row++) {
        System.out.print(row + " ");
        for (int col = 0;col<3;col++) {
            System.out.print(board[row][col] + " ");

        }
        System.out.println();

    }

    
  }// end public static displayBoard
  // check if a move is valid (within the bounds and cell is empty)
  public static boolean isValidMove(char[][] board, int row, int col){
    return (row >= 0 && row < 3 && col >=0 && col < 3 && board[row][col] == ' ');

    
  }//end boolean is Valid move
  // Check if the current player has won
  public static boolean isWinner(char[][]board, char player){
    for (int i=0;i<3;i++) {
        if ((board[i][0] == player && board [i][1] == player && board[i][2] == player) || (board[0][i] == player && board[1][i]== player && board[2][i]==player)|| (board[0][0] == player && board[1][1]== player && board[2][2]==player)|| (board[2][0] == player && board[1][1]== player && board[0][2]==player)){
            return true;

        }
        
    }
    return false;
    // check rows, columns, and diagonals for a winning combination


  }// end boolean isWinner  
}// end TicTacToe class (classes start with Caps)