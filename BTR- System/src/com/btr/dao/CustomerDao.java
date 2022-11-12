package com.btr.dao;



import java.time.LocalDateTime;

import com.btr.exceptions.BusEx;

import com.btr.model.DriverDto;

public interface CustomerDao {

	public DriverDto bookTicket(String busNumber, LocalDateTime journeyDate, int noOfSeats) throws BusEx;

	public String cancelTicket(String busNumber, LocalDateTime journeyDate, int noOfSeats) throws BusEx;

}
