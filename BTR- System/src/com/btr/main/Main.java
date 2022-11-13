package com.btr.main;

import java.util.Scanner;

import com.btr.exceptions.BusEx;
import com.btr.usecases.BookTicketUC;
import com.btr.usecases.CancelTicketUC;
import com.btr.usecases.GetAllDetails;
import com.btr.usecases.LoginUC;

public class Main {

	public static void run() {

		System.out.println("Welcome to Patil's Bus Services");
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter 1 for login");
		System.out.println("Please enter 2 to go back");

		int n = sc.nextInt();

		switch (n) {
		case 1:
			LoginUC.login();

			System.out.println("Please enter 1 to Book Ticket");
			System.out.println("Please enter 2 to Cancel Ticket");
			System.out.println("Please enter 3 to Get Details");
			System.out.println("Please enter 4 to go back");
			Scanner s = new Scanner(System.in);
			int i = sc.nextInt();

			switch (i) {
			case 1:
				BookTicketUC.booking();

				break;
			case 2:

				try {
					CancelTicketUC.cancel();
				} catch (BusEx e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:

				GetAllDetails.details();

				break;

			case 4:

				LoginUC.login();

				break;

			default:

				System.out.println("Please enter valid input");

				break;

			}

		case 2:
			System.out.println("See you Again!");
			break;

		default:
			break;
		}

	}

}
