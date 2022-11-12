package com.btr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.btr.exceptions.BusEx;
import com.btr.model.DriverDto;
import com.btr.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao {

	
	@Override
	public DriverDto bookTicket(String busNumber, LocalDateTime journeyDate, int noOfSeats) throws BusEx {

		DriverDto d = null;

		try (Connection conn = DBUtil.getConnetion()) {

			PreparedStatement ps = conn.prepareStatement("select * from bus where bno = ? AND arrival = ?");

			ps.setString(1, busNumber);
			ps.setString(2, journeyDate.toString());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int availableSeats = rs.getInt("availSeats");
				if (availableSeats < noOfSeats) {
					throw new BusEx("Seats are not avaiable");
				} else {
					ps = conn.prepareStatement("update bus set availSeats=? where bno = ? AND arrival= ?");
					ps.setInt(1, availableSeats - noOfSeats);

					ps.setString(2, busNumber);

					ps.setString(3, journeyDate.toString());
					ps.executeUpdate();

					ps = conn.prepareStatement("select * from customer where id = ?");
					ps.setInt(1, rs.getInt("did"));
					ResultSet rs1 = ps.executeQuery();
					if (rs1.next()) {
						d = new DriverDto(rs1.getString("name"), rs1.getString("mobile"), rs1.getString("email"));
					}
				}

			} else
				throw new BusEx("Write valid bus number");

		} catch (SQLException e) {
			throw new BusEx(e.getMessage());
		}

		return d;

	}

	@Override
	public String cancelTicket(String busNumber, LocalDateTime journeyDate, int noOfSeats) throws BusEx {

		String msg = "Please insert valid details";

		try (Connection conn = DBUtil.getConnetion()) {

			PreparedStatement ps = conn.prepareStatement("select * from bus where bno = ? AND arrival = ?");

			ps.setString(1, busNumber);
			ps.setString(2, journeyDate.toString());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int availableSeats = rs.getInt("availSeats");
				ps = conn.prepareStatement("update bus set availSeats=? where bno = ? AND arrival= ?");
				ps.setInt(1, availableSeats + noOfSeats);
				ps.setString(2, busNumber);
				ps.setString(3, journeyDate.toString());
				ps.executeUpdate();

				msg = "ticket cancelled successfully";

			} else
				throw new BusEx("Enter valid bus number");

		} catch (SQLException e) {
			throw new BusEx(e.getMessage());
		}


		return msg;

	}

}