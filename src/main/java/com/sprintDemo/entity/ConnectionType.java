package com.sprintDemo.entity;

public enum ConnectionType
{
	NON_INDUSTRIAL(0), INDUSTRIAL(1), AGRICULTURAL(2);
	

	private int type;
	ConnectionType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	

}
