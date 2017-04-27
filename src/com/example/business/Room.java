<<<<<<< HEAD
package com.example.business;

import java.util.ArrayList;

import com.example.dao.RoomDao;

public class Room {

	private int number;
	private String type;
	private int noOfPeople;
	private boolean smoking;
	private String details;
	private float price;
	
	public Room(int number,String type,int noOfPeople,boolean smoking,String details,float price)
	{
		this.number=number;
		this.type=type;
		this.noOfPeople=noOfPeople;
		this.smoking=smoking;
		this.details=details;
		this.price=price;
	}
}
=======
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
>>>>>>> 449c644f9b12a4add793758ff66233fd7fe24dcc
