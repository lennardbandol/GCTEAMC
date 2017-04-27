package com.example.business;

public class Room {
	
	private String roomNo = null;
	private String roomType = null;
	private String isSmoking = null;
	
	public Room(String roomNo, String roomType, String isSmoking){
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.isSmoking = isSmoking;
	}
	
	public String getRoomNo(){
		return roomNo;
	}
	public String getRoomType(){
		return roomType;
	}
	public String getIsSmoking(){
		return isSmoking;
	}
}
