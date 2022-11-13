package com.btr.usecases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.btr.dao.CustomerDao;
import com.btr.dao.CustomerDaoImpl;
import com.btr.exceptions.BusEx;
import com.btr.model.Customer;
import com.btr.model.DriverDto;

public class BookTicketUC {

	//MH14GJ4085
		//2022-11-10 10:30:00
	
	public static void booking() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter busNumber");

		String busNumber = sc.nextLine();

		System.out.println("Enter no of seats");

		int noOfSeats = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter arrival date in this format(yyyy-MM-dd HH:mm:ss)");

		String dateTime = sc.nextLine();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		LocalDateTime journeyDate = LocalDateTime.parse(dateTime, formatter);
		
		CustomerDao customerDao = new CustomerDaoImpl();

		try {
			DriverDto driverDTO = customerDao.bookTicket(busNumber, journeyDate, noOfSeats);
			
			System.out.println("ticket booked successfully");
//			System.out.println(customerDao);
		} catch (BusEx e) {

			System.out.println(e.getMessage());
		}

	}

}
