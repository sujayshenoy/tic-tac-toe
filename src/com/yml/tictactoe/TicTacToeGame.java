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
	public boolean winFlag;
	public int winPlayer;
	
	public TicTacToeGame() {
		
	}
	
	public void createBoard() {
		for(int i=1;i<board.length;i++) {
			board[i] = ' ';
		}
	}
	
	public void choice() {
		Scanner in = new Scanner(System.in);

		print("Choose the letter(X/O) ");
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
		print(board[1]+" | "+board[2]+" | "+board[3]);
		print("----------");
		print(board[4]+" | "+board[5]+" | "+board[6]);
		print("----------");
		print(board[7]+" | "+board[8]+" | "+board[9]);
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

		//check if computer can win
		if((board[1]==' ')&&((board[2]==board[3]&&board[2]==cChoice)||(board[4]==board[7]&&board[4]==cChoice)||(board[5]==board[9]&&board[5]==cChoice)))
			{
				return 1;			
			}
			else if((board[2]==' ')&&((board[1]==board[3]&&board[3]==cChoice)||(board[5]==board[8]&&board[8]==cChoice)))
			{
				return 2;
			}
			else if((board[3]==' ')&&((board[1]==board[2]&&board[2]==cChoice)||(board[6]==board[9]&&board[9]==cChoice)||(board[5]==board[7]&&board[7]==cChoice)))
			{
				return 3;
			}
			else if((board[4]==' ')&&((board[1]==board[7]&&board[1]==cChoice)||(board[5]==board[6]&&board[6]==cChoice)))
			{
				return 4;
			}
			else if((board[5]==' ')&&((board[1]==board[9]&&board[2]==cChoice)||(board[7]==board[3]&&board[7]==cChoice)||(board[2]==board[8]&&board[8]==cChoice)||(board[4]==board[6]&&board[6]==cChoice)))
			{
				return 5;
			}
			else if((board[6]==' ')&&((board[9]==board[3]&&board[3]==cChoice)||(board[5]==board[4]&&board[4]==cChoice)))
			{
				return 6;
			}
			else if((board[7]==' ')&&((board[1]==board[4]&&board[4]==cChoice)||(board[3]==board[5]&&board[3]==cChoice)||(board[8]==board[9]&&board[8]==cChoice)))
			{
				return 7;
			}
			else if((board[8]==' ')&&((board[9]==board[7]&&board[7]==cChoice)||(board[2]==board[5]&&board[2]==cChoice)))
			{
				return 8;
			}
			else if((board[9]==' ')&&((board[1]==board[5]&&board[5]==cChoice)||(board[6]==board[3]&&board[3]==cChoice)||(board[8]==board[7]&&board[7]==cChoice)))
			{
				return 9;
			}
			
			//choices that block player win
			//Rest of the if else conditions will block the player's move in case the player is about to win
			else if((board[1]==' ')&&((board[2]==board[3]&&board[2]==pChoice)||(board[4]==board[7]&&board[4]==pChoice)||(board[5]==board[9]&&board[5]==pChoice)))
			{
				return 1;	
			}
			else if((board[2]==' ')&&((board[1]==board[3]&&board[3]==pChoice)||(board[5]==board[8]&&board[8]==pChoice)))
			{
				return 2;
			}
			else if((board[3]==' ')&&((board[1]==board[2]&&board[2]==pChoice)||(board[6]==board[9]&&board[9]==pChoice)||(board[5]==board[7]&&board[7]==pChoice)))
			{
				return 3;
			}
			else  if((board[4]==' ')&&((board[1]==board[7]&&board[1]==pChoice)||(board[5]==board[6]&&board[6]==pChoice)))
			{
				return 4;
			}	
			else if((board[5]==' ')&&((board[1]==board[9]&&board[1]==pChoice)||(board[7]==board[3]&&board[7]==pChoice)||(board[2]==board[8]&&board[8]==pChoice)||(board[4]==board[6]&&board[6]==pChoice)))
			{
				return 5;
			}
			else if((board[6]==' ')&&((board[9]==board[3]&&board[3]==pChoice)||(board[5]==board[4]&&board[4]==pChoice)))
			{
				return 6;
			}
			else 	if((board[7]==' ')&&((board[1]==board[4]&&board[4]==pChoice)||(board[6]==board[9]&&board[9]==pChoice)||(board[5]==board[7]&&board[7]==pChoice)))
			{
				return 7;
			}
			else if((board[8]==' ')&&((board[9]==board[7]&&board[7]==pChoice)||(board[2]==board[5]&&board[2]==pChoice)))
			{
				return 8;
			}
			else if((board[9]==' ')&&((board[1]==board[5]&&board[5]==pChoice)||(board[6]==board[3]&&board[3]==pChoice)||(board[8]==board[7]&&board[7]==pChoice)))
			{	
				return 9;
			}
		
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
	
	public void isAWin() {
		//check horizontal
		for(int i=1;i<10;i+=3) {
			if(board[i] == ' ')
				continue;
			char pattern = board[i];
			int j = i+1;
			while(j<i+3) {
				if(pattern != board[j] || board[j] == ' ')
					break;
				j++;
			}
			if(j == i+3) {
				winFlag = true;
				switchPlayer();
				winPlayer = currentPlayer;
				return;
			}	
		}
		
		//check vertical
		
		for(int i=1;i<=3;i++) {
			if(board[i] == ' ')
				continue;
			char pattern = board[i];
			int j = i+3;
			while(j<=i+6) {
				char myVal = board[j];
				if(pattern != board[j] || board[j] == ' ')
					break;
				j+=3;
			}
			if(j == i+9) {
				winFlag = true;
				switchPlayer();
				winPlayer = currentPlayer;
				return;
			}	
		}
		
		//check primary diagonal
		{
			char pattern = board[1];
			int i;
			for(i=1;i<10;i+=4) {
				if(board[i] != pattern || board[i] == ' ') {
					break;
				}
			}
			
			if(i>9) {
				winFlag = true;
				switchPlayer();
				winPlayer = currentPlayer;
				return;
			}
		}
		//check the secondary diagonal
		
		char pattern = board[3];
		int i;
		for(i=3;i<8;i+=2) {
			if(board[i] != pattern || board[i] == ' ') {
				break;
			}
		}
		
		if(i>7) {
			winFlag = true;
			switchPlayer();
			winPlayer = currentPlayer;
			return;
		}
		
		
	}
	
}
