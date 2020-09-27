package com.connect4.connect4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connect4.connect4.constants.Connect4Constants;
import com.connect4.connect4.dao.Connect4Dao;
import com.connect4.connect4.exceptions.Connect4Exceptions;

@Service
public class Connect4ServiceImpl implements Connect4Service {

	@Autowired
	Connect4Dao connect4Dao;

	@Override
	public String startGame() {

		return connect4Dao.startGame();
	}

	@Override
	public void registerNextMove(Integer columnNumber, String userName) throws Connect4Exceptions {

		char[][] userData = connect4Dao.getDataForUser(userName);
		if (validate(columnNumber, userData))
			connect4Dao.updateDataForUser(columnNumber, userName);
		else
			throw new Connect4Exceptions(Connect4Constants.INVALID_COLUMN_NUMBER, 403);
	}

	private static boolean validate(int column, char[][] userData) {

		// valid column?
		if (column < 0 || column > userData[0].length) {
			return false;
		}

		// full column?
		if (userData[0][column] != ' ') {
			return false;
		}

		return true;
	}

	@Override
	public boolean isWinner(String userName) throws Connect4Exceptions {

		char player = connect4Dao.getCurrentPlayer();
		char[][] userData = connect4Dao.getDataForUser(userName);
		// check for 4 across
		for (int row = 0; row < userData.length; row++) {
			for (int col = 0; col < userData[0].length - 3; col++) {
				if (userData[row][col] == player && userData[row][col + 1] == player && userData[row][col + 2] == player
						&& userData[row][col + 3] == player) {
					return true;
				}
			}
		}
		// check for 4 up and down
		for (int row = 0; row < userData.length - 3; row++) {
			for (int col = 0; col < userData[0].length; col++) {
				if (userData[row][col] == player && userData[row + 1][col] == player && userData[row + 2][col] == player
						&& userData[row + 3][col] == player) {
					return true;
				}
			}
		}
		// check upward diagonal
		for (int row = 3; row < userData.length; row++) {
			for (int col = 0; col < userData[0].length - 3; col++) {
				if (userData[row][col] == player && userData[row - 1][col + 1] == player
						&& userData[row - 2][col + 2] == player && userData[row - 3][col + 3] == player) {
					return true;
				}
			}
		}
		// check downward diagonal
		for (int row = 0; row < userData.length - 3; row++) {
			for (int col = 0; col < userData[0].length - 3; col++) {
				if (userData[row][col] == player && userData[row + 1][col + 1] == player
						&& userData[row + 2][col + 2] == player && userData[row + 3][col + 3] == player) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public char[][] displayLiveStatus(String userName) throws Connect4Exceptions {
		
		char[][] userData = connect4Dao.getDataForUser(userName);
		char[][] result = new char[8][13];
		
		System.out.println(" 0 1 2 3 4 5 6");
		System.out.println("---------------");
		int colCount = 0;
		for (int col = 0; col < result[0].length; col++) {
			if(col % 2 == 0) {
				result[0][col] = Character.forDigit(colCount,10);
				result[7][col] = Character.forDigit(colCount,10);	
				colCount++;
			} else {
				result[0][col] = ' ';
				result[7][col] = ' ';	
			}	
		}
		for (int row = 0; row < userData.length; row++) {
			System.out.print("|");
			int cols = 0;
			for (int col = 0; col < userData[0].length; col++) {
				System.out.print(userData[row][col]);
				result[row+1][cols] = userData[row][col];
				cols++;
				System.out.print("|");
				if(col != userData[0].length - 1)
				result[row+1][cols++] = '|';
			}
			System.out.println();
			System.out.println("---------------");
		}
		System.out.println(" 0 1 2 3 4 5 6");
		System.out.println();
		return result;
	}

	@Override
	public char getCurrentPlayer() {

		return connect4Dao.getCurrentPlayer();
	}
}
