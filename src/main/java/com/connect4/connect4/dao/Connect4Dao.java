package com.connect4.connect4.dao;

import com.connect4.connect4.exceptions.Connect4Exceptions;

public interface Connect4Dao {

	public String startGame();
	
	public void registerNextMove(Integer columnNumber, String userName) throws Connect4Exceptions;
	
	public char[][] getDataForUser(String userName) throws Connect4Exceptions;
	
	public void updateDataForUser(Integer columnNumber, String userName) throws Connect4Exceptions;
	
	public char getCurrentPlayer();
}
