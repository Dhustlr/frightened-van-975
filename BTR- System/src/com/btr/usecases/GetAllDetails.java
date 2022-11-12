package com.btr.usecases;

import java.util.List;
import java.util.Scanner;

import com.btr.dao.AdminDao;
import com.btr.dao.AdminDaoImpl;
import com.btr.exceptions.BusEx;
import com.btr.model.BusDto;

public class GetAllDetails {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter source");
		String source = sc.nextLine();
		System.out.println("Enter Destination");
		String destination = sc.nextLine();

		AdminDao adminDao = new AdminDaoImpl();
		try {
			List<BusDto> busList = adminDao.getBusesAllDetails(source, destination);
			System.out.println("All Buses");
			System.out.println("**************************************************************");
			System.out.println();
			for (BusDto i : busList) {
				System.out.println("Name -> " + i.getName() + " , type -> " + i.getType() + " , route -> "
						+ i.getRoute() + " , availableSeats -> " + i.getAvailableSeats() + " , arrivalTime-> "
						+ i.getArrivalTime() + " , departureTime - > " + i.getDepartureTime());
			}
		} catch (BusEx e) {
			System.out.println(e.getMessage());
		}

	}

}
