package com.connect4.connect4.service;

import com.connect4.connect4.exceptions.Connect4Exceptions;

public interface Connect4Service {

	public String startGame();
	
	public char[][] displayLiveStatus(String userName) throws Connect4Exceptions;
	
	public boolean isWinner(String userName) throws Connect4Exceptions;
	
	public char getCurrentPlayer();
	
	public void registerNextMove(Integer columnNumber, String userName) throws Connect4Exceptions;
}
