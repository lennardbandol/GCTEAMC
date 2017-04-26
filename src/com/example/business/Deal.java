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
	public Room[] getDeals(Date dateFrom,Date dateTo)
	{
		return DealDao.getDeals(dateFrom,dateTo);
	}
	public boolean checkCode(String code)
	{
		return DealDao.checkCode(code);
	}
	public Deal useCode(String code)
	{
		return DealDao.useCode(code);	
	}
	
	public boolean addDeals(Room room,String name,float price,float discountOff,int discountPer,Date dateFrom,Date dateTo,String code)
	{
		return DealDao.addDeals(room,name,price,discountOff,discountPer,dateFrom,dateTo,code);
	}
	public boolean removeDeal(Room room,String name,float price,float discountOff,int discountPer,Date dateFrom,Date dateTo,String code)
	{
		return DealDao.removeDeal(room,name,price,discountOff,discountPer,dateFrom,dateTo,code);
	}
	public boolean ammendDeal(Room room,String name,float price,float discountOff,int discountPer,Date dateFrom,Date dateTo,String code)
	{
		return DealDao.ammendDeal(room,name,price,discountOff,discountPer,dateFrom,dateTo,code);
	}
}
