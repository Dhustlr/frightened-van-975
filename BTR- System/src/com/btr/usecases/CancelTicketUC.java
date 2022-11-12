package com.btr.usecases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.btr.dao.CustomerDao;
import com.btr.dao.CustomerDaoImpl;
import com.btr.exceptions.BusEx;

public class CancelTicketUC {

	//MH14GJ4085
			//2022-11-10 10:30:00
	
	public static void main(String[] args) throws BusEx {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Bus Number");
		String busNumber = sc.nextLine();
		
		System.out.println("Enter Journey Date and Time");
		String dateTime = sc.nextLine();
		
		System.out.println("Enter No of Seats");
		int noOfSeats = sc.nextInt();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime journeyDateTime = LocalDateTime.parse(dateTime, formatter);

		CustomerDao customerDao = new CustomerDaoImpl();
		System.out.println(customerDao.cancelTicket(busNumber, journeyDateTime, noOfSeats));

	}

}
