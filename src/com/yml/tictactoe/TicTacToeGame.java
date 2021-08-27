package com.yml.tictactoe;

import java.util.Scanner;

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
		Scanner in = new Scanner(System.in);

		System.out.println("Choose the letter(X/O) ");
		char ch = in.next().charAt(0);
		
		if(ch == 'X') {
			pChoice = 'X';
			cChoice = 'O';
		}else {
			pChoice = 'O';
			cChoice = 'X';
		}
		
		in.close();
	}

	public void showBoard() {
		System.out.println(board[1]+" | "+board[2]+" | "+board[3]+" | ");
		System.out.println(board[4]+" | "+board[5]+" | "+board[6]+" | ");
		System.out.println(board[7]+" | "+board[8]+" | "+board[9]+" | ");
	}
	
}
