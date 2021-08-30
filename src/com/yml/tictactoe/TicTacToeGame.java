package com.yml.tictactoe;

import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	final int COMPUTER = 1;
	final int PLAYER = 2;
	
	private char board[] = new char[10];
	private char pChoice;
	private char cChoice;
	public int posLeft = 9;
	public int currentPlayer;
	
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
	
	public boolean playerPlay(int playerPos) {
		
		if(board[playerPos] != ' ') {
			print("Position is already taken");
			return false;
		}
		
		board[playerPos] = pChoice;
		posLeft--;
		switchPlayer();
		return true;
		
	}
	
	public void print(String msg) {
		PrintWriter out = new PrintWriter(System.out);
		out.println(msg);
		out.flush();
	}
	
	public void computerPlay() {
		print("");
		print("Computer is playing");
		
		while(posLeft > 0) {
			int choice = generateChoice();
			
			if(board[choice] == ' ') {
				board[choice] = cChoice;
				posLeft--;
				switchPlayer();
				break;
			}
		}
		
	}
	
	private void switchPlayer() {
		if(currentPlayer == PLAYER) {
			currentPlayer = COMPUTER;
		}
		else {
			currentPlayer = PLAYER;
		}
	}
	
	private int generateChoice() {
		Random rand = new Random();
		return rand.nextInt(9)+1;
	}
	
	public void toss(int playerTossChoice) {
		final int HEAD = 1;
		final int TAIL = 2;
		
		double prob = Math.random();
		
		int winningSide;
		if(prob > 0.5) {
			winningSide = HEAD;
			print("Coin landed on HEAD");
		}
		else {
			winningSide = TAIL;
			print("Coin landed on TAIL");
		}
		
		if(playerTossChoice == winningSide) {
			print("player won the toss");;
			currentPlayer = PLAYER;
		}
		else {
			print("computer won the toss");
			currentPlayer = COMPUTER;
		}
	}
	
}
