package com.example.business;

import java.util.Date;

public class Deal {

	private Room room;
	private String name;
	private float price;
	private float discountOff;
	private int discountPer;
	private Date dateFrom;
	private Date dateTo;
	private String code;
	
	public Deal(Room room,String name,float price,float discountOff,int discountPer,Date dateFrom,Date dateTo,String code)
	{
		this.room=room;
		this.name=name;
		this.price=price;
		this.discountOff=discountOff;
		this.discountPer=discountPer;
		this.dateFrom=dateFrom;
		this.dateTo=dateTo;
		this.code=code;		
	}
}
