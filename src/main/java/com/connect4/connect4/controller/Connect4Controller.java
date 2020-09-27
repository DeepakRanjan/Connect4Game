package com.connect4.connect4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.connect4.connect4.beans.JsonResponse;
import com.connect4.connect4.constants.Connect4Constants;
import com.connect4.connect4.enums.GameStatus;
import com.connect4.connect4.enums.Player;
import com.connect4.connect4.exceptions.Connect4Exceptions;
import com.connect4.connect4.service.Connect4Service;
import com.connect4.connect4.utilities.JsonResponseWrapper;

@RestController
public class Connect4Controller {

	@Autowired
	Connect4Service connect4Service;

	@PostMapping("/playGameConnect4")
	public JsonResponse playGameConnect4(@RequestParam(value = "instruction") String instruction) {
		JsonResponse jsonResponse = new JsonResponse();
		try {
			String assignedUser = null;
			if (GameStatus.START.name().equalsIgnoreCase(instruction))
				assignedUser = connect4Service.startGame();
			else
				throw new Connect4Exceptions(Connect4Constants.INVALID_INSTRUCTION, 400);
			jsonResponse = JsonResponseWrapper.getSuccessResponse(
					Connect4Constants.ASSIGNED_USER + assignedUser + Connect4Constants.GAME_START_INSTRUCTION,
					Connect4Constants.START_GAME, 200);
		} catch (Connect4Exceptions e) {
			jsonResponse = JsonResponseWrapper.getFailureResponse(null, e.getMessage(), e.getCode());
		}
		return jsonResponse;
	}

	@PostMapping("/playGameConnect4/{userName}")
	public JsonResponse playGameConnect4(@RequestParam(value = "columnNumber") Integer columnNumber,
			@PathVariable(value = "userName") String userName) {
		JsonResponse jsonResponse = new JsonResponse();
		try {
			connect4Service.registerNextMove(columnNumber, userName);
			String message = null;
			
			if(connect4Service.isWinner(userName)) 
				message = Player.valueOf(String.valueOf(connect4Service.getCurrentPlayer())) + " wins.";
			else
				message = Connect4Constants.VALID_MOVE;
			jsonResponse = JsonResponseWrapper.getSuccessResponse(connect4Service.displayLiveStatus(userName), message, 200);
		} catch (Connect4Exceptions e) {
			jsonResponse = JsonResponseWrapper.getFailureResponse(null, e.getMessage(), e.getCode());
		}
		return jsonResponse;
	}
}
