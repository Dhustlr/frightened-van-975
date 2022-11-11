package com.btr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.btr.model.Bus;
import com.btr.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String Alogin(String userid, String pass) {

		String msg = "Invalid user";

		if (userid.equals(AdminDao.userid) && pass.equals(AdminDao.pass))
			msg = "Login Successful";

		return msg;

	}

	@Override
	public String addBus(Bus bus) {

		String msg = "Bus adding fail";

		try (Connection con = DBUtil.getConnetion()) {

			PreparedStatement ps = con.prepareStatement("insert into bus values(?,?,?,?,?,?,?,?,?,?)");

			ps.setInt(1, bus.getbNo());
			ps.setString(2, bus.getbName());
			ps.setString(3, bus.getRouteFrom());
			ps.setString(4, bus.getRouteTo());
			ps.setString(5, bus.getbType());
			ps.setString(6, bus.getArrival());
			ps.setString(7, bus.getDeparture());
			ps.setInt(8,bus.getTotalSeats());
			ps.setInt(9, bus.getAvailSeats());
			ps.setInt(10, bus.getFares());	
			
			
			int i = ps.executeUpdate();
			
			if (i > 0)
				msg = "Bus added successfully";

		} catch (SQLException e) {
			// TODO: handle exception
			msg = e.getMessage();

		}

		return msg;
	}

	@Override
	public String updatestatus(int cid) {

		String msg = "Status Not changed";

		try (Connection con = DBUtil.getConnetion()) {

			PreparedStatement ps = con.prepareStatement("update booking set status like true where cusId = ?");

			int i = ps.executeUpdate();

			if (i > 0)
				msg = "Status updated";

		} catch (SQLException e) {
			// TODO: handle exception
			msg = e.getMessage();

		}

		return msg;
	}

	@Override
	public void viewTickets() {

		boolean flag = false;
		try (Connection con = DBUtil.getConnetion()) {

			PreparedStatement ps = con.prepareStatement("select * from booking");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				flag = true;

				System.out.println(rs.getInt("bid"));
				System.out.println(rs.getInt("cusid"));
				System.out.println(rs.getInt("busNo"));
				System.out.println(rs.getInt("seatFrom"));
				System.out.println(rs.getInt("seatTo"));
				System.out.println(rs.getInt("status"));

			}

			if (flag == false)
				System.out.println("No Tickets");

		} catch (SQLException e) {
			// TODO: handle exception

			System.out.println(e.getMessage());

		}

	}

}
