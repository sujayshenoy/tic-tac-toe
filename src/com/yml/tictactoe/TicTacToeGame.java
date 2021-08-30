package com.yml.tictactoe;

import java.io.PrintWriter;
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
		char choice = Character.toUpperCase(in.next().charAt(0));
		
		if(choice == 'X') {
			pChoice = 'X';
			cChoice = 'O';
		}else {
			pChoice = 'O';
			cChoice = 'X';
		}

	}

	public void showBoard() {
		System.out.println(board[1]+" | "+board[2]+" | "+board[3]);
		System.out.println("----------");
		System.out.println(board[4]+" | "+board[5]+" | "+board[6]);
		System.out.println("----------");
		System.out.println(board[7]+" | "+board[8]+" | "+board[9]);
	}
	
	public void playerPlay(int playerPos) {
		
		if(board[playerPos] != ' ') {
			print("Position is already taken");
			return;
		}
		
		board[playerPos] = pChoice;
		
		print("----------");
		showBoard();
	}
	
	public void print(String msg) {
		PrintWriter out = new PrintWriter(System.out);
		out.println(msg);
		out.flush();
	}
	
}
