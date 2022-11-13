package com.btr.usecases;

import java.util.Scanner;

import com.btr.dao.AdminDao;
import com.btr.dao.AdminDaoImpl;
import com.btr.exceptions.CustomerEX;
import com.btr.model.Customer;

public class LoginUC {
	
	public static void login() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter email:");
		String uname = sc.next();

		System.out.println("Enter Password:");
		String pass = sc.next();

		AdminDao dao = new AdminDaoImpl();

		try {
			Customer user = dao.Alogin(uname, pass);

			System.out.println("Welcome Mr. " + user.getName());

		} catch (CustomerEX e) {
			System.out.println(e.getMessage());
		}
	}

}
