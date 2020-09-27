package com.connect4.connect4.exceptions;

public class Connect4Exceptions extends Exception {

	private static final long serialVersionUID = 1L;

	private Integer code;

	public Connect4Exceptions(String message, Integer code) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
