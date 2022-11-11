package com.btr.dao;

import java.time.LocalDateTime;

import com.btr.exceptions.BusEx;
import com.btr.exceptions.CustomerEX;
import com.btr.model.Customer;

public interface CustomerDao {

	
	public String bookTicket(int bno, LocalDateTime journeyDate, int noOfSeats) throws BusEx;

	public String cancelTicket(String bname, int cusdId) throws BusEx;

	

}
