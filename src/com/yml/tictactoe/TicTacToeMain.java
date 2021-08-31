package com.yml.tictactoe;

import java.io.PrintWriter;
import java.util.Scanner;

public class TicTacToeMain {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out,true);
		Scanner in = new Scanner(System.in);
		
		out.println("Welcome to Tic Tac Toe Game");
		
		while(true) {
			TicTacToeGame game = new TicTacToeGame();
			game.createBoard();
			game.choice();
			
			out.println("Choose a Side , Head/Tail");
			out.println("1.HEAD\n2.TAIL");
			int playerTossChoice = in.nextInt();
			game.toss(playerTossChoice);
			
			while( game.posLeft > 0 && !game.winFlag ) {
				if(game.currentPlayer == game.COMPUTER) {
					game.computerPlay();
				}
				else {
					out.println("Select position to mark your spot");
					game.showBoard();
					int playerPos = in.nextInt();
					game.playerPlay(playerPos);
				}
				game.isAWin();
				if(game.winFlag){
					game.showBoard();
				}
			}
			
			if(game.winPlayer == game.PLAYER) {
				out.println("Player wins the game");
			}
			else if(game.winPlayer == game.COMPUTER){
				out.println("Computer wins the game");
			}
			else{
				out.println("Game is a tie");
			}
			
			out.println("Do you want to play again??Y/N");
			in.nextLine();
			char choice = in.nextLine().toUpperCase().charAt(0);
			if(choice == 'N') {
				break;
			}
		}
		
	}

}
