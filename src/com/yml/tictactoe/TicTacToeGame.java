package com.yml.tictactoe;

public class TicTacToeGame {
	
	private char board[] = new char[10];
	
	public TicTacToeGame() {
		
	}
	
	public void createBoard() {
		for(int i=1;i<board.length;i++) {
			board[i] = ' ';
		}
	}
	
	
}
