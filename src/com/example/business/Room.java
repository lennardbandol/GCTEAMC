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
