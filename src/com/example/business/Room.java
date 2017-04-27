package com.example.business;

public class Room {
	
	private String roomNo = null;
	private String roomType = null;
	private Boolean isSmoking = null;
	
	public void room(String roomNo, String roomType, Boolean isSmoking){
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
	public Boolean getIsSmoking(){
		return isSmoking;
	}
}
