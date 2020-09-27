package com.connect4.connect4.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.connect4.connect4.constants.Connect4Constants;
import com.connect4.connect4.exceptions.Connect4Exceptions;

@Repository
public class Connect4DaoImpl implements Connect4Dao {

	private static Map<String, char[][]> data = new HashMap<String, char[][]>();

	private static Integer userNumber = 0;
	
	private static char player = 'Y';

	@Override
	public String startGame() {

		char[][] userData = new char[6][7];

		// initialize array
		for (int row = 0; row < userData.length; row++) {
			for (int col = 0; col < userData[0].length; col++) {
				userData[row][col] = ' ';
			}
		}

		data.put("user" + ++userNumber, userData);
		return "user" + userNumber;
	}

	@Override
	public void registerNextMove(Integer columnNumber, String userName) throws Connect4Exceptions {

	}

	@Override
	public char[][] getDataForUser(String userName) throws Connect4Exceptions {

		if (data.containsKey(userName))
			return data.get(userName);
		else
			throw new Connect4Exceptions("user" + userNumber + Connect4Constants.INVALID_USER, 401);
	}

	@Override
	public void updateDataForUser(Integer columnNumber, String userName) throws Connect4Exceptions {
		
		char[][] userData = getDataForUser(userName);
		for (int row = userData.length-1; row >= 0; row--){
			if(userData[row][columnNumber] == ' '){
				userData[row][columnNumber] = player;
				player = (player == 'Y') ? 'R' : 'Y';
				break;
			}
		}
	}

	@Override
	public char getCurrentPlayer() {
		
		return player;
	}
}
