package com.yml.tictactoe;

import java.io.PrintWriter;
import java.util.Scanner;

public class TicTacToeMain {

	public static void main(String[] args) {
		
		final int COMPUTER = 1;
		final int PLAYER = 2;
		
		PrintWriter out = new PrintWriter(System.out,true);
		Scanner in = new Scanner(System.in);
		
		out.println("Welcome to Tic Tac Toe Game");
		TicTacToeGame game = new TicTacToeGame();
		game.createBoard();
		game.choice();
		
		while(game.posLeft > 0) {
			out.println("Select position to mark your spot");
			game.showBoard();
			int playerPos = in.nextInt();
			
			if(game.playerPlay(playerPos)) {
				game.computerPlay();
			}
		}
		
		
	}

}
