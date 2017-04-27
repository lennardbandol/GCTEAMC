package com.example.business;

import java.util.ArrayList;
import java.util.Date;

public class Booking {

	private User user;
	private ArrayList<Room> room;
	private Deal deal;
	private String bookingID;
	private boolean checkedIn;
	private String offer;
	private Date arrDate;
	private Date depDate;
	
	public Booking(User user,ArrayList<Room> room,Deal deal,String bookingID,boolean checkedIn,String offer,Date arrDate,Date depDate)
	{
		this.user=user;
		this.room=room;
		this.deal=deal;
		this.bookingID=bookingID;
		this.checkedIn=checkedIn;
		this.offer=offer;
		this.arrDate=arrDate;
		this.depDate=depDate;
		
	}
	
}
