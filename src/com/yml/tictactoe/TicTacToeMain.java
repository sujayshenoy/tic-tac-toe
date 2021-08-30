package com.yml.tictactoe;

import java.io.PrintWriter;
import java.util.Scanner;

public class TicTacToeMain {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out,true);
		Scanner in = new Scanner(System.in);
		
		out.println("Welcome to Tic Tac Toe Game");
		TicTacToeGame game = new TicTacToeGame();
		game.createBoard();
		game.choice();
		
		out.println("Choose a Side , Head/Tail");
		out.println("1.HEAD\n2.TAIL");
		int playerTossChoice = in.nextInt();
		game.toss(playerTossChoice);
		
		while(game.posLeft > 0) {
			if(game.currentPlayer == game.COMPUTER) {
				game.computerPlay();
			}
			else {
				out.println("Select position to mark your spot");
				game.showBoard();
				int playerPos = in.nextInt();
				game.playerPlay(playerPos);
			}
		}
		
		
	}

}
