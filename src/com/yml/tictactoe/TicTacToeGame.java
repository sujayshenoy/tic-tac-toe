package com.yml.tictactoe;

public class TicTacToeGame {
	
	private char board[] = new char[10];
	private char pChoice;
	private char cChoice;
	
	public TicTacToeGame() {
		
	}
	
	public void createBoard() {
		for(int i=1;i<board.length;i++) {
			board[i] = ' ';
		}
	}
	
	public void choice() {
		System.out.println("Choose the letter(X/O) ");
		char ch = in.next().charAt(0);
		
		if(ch == 'X') {
			pChoice = 'X';
			cChoice = 'O';
		}else {
			pChoice = 'O';
			cChoice = 'X';
		}		
	}
	
}
