package com.connect4.connect4.enums;

public enum Player {

	Y("YELLOW"), R("RED");

	public String value;
	
	Player(String value) {	
		this.value = value;
	}

	public String getPlayer(String value) {
		return Player.valueOf(value).toString();
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
