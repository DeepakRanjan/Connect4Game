package com.connect4.connect4.utilities;

import com.connect4.connect4.beans.JsonResponse;

public class JsonResponseWrapper {

	public static JsonResponse getSuccessResponse(final Object result, final String message, int code) {
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setCode(code);
		jsonResponse.setMessage(message);
		jsonResponse.setResult(result);
		jsonResponse.setStatus(JsonResponse.SUCCESS);
		return jsonResponse;
	}
	
	public static JsonResponse getFailureResponse(final Object result, final String message, int code) {
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setCode(code);
		jsonResponse.setMessage(message);
		jsonResponse.setResult(result);
		jsonResponse.setStatus(JsonResponse.FAILURE);
		return jsonResponse;
	}
}
