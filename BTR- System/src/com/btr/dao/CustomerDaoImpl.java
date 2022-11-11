package com.btr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.btr.exceptions.BusEx;
import com.btr.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public String bookTicket(int bno, LocalDateTime journeyDate, int noOfSeats) throws BusEx{

		String msg = "Booking unsuccessful";

		try (Connection con = DBUtil.getConnetion()) {

			PreparedStatement ps = con.prepareStatement("select * from bus where bno = ? AND arrival = ?");

			ps.setInt(1, bno);
			ps.setString(2, journeyDate.toString());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
			int avail =	rs.getInt("availSeats");
			
			if(avail < noOfSeats) {
				throw new BusEx("Seat not Available");
			}
			else {
				
				ps = con.prepareStatement("update bus set availSeats = ? where bno = ? AND arrival = ? ");
				
				ps.setInt(1, avail - noOfSeats);
				
				
				
			}
				
				

			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		return msg;
	}

	@Override
	public String cancelTicket(String bname, int cusdId) throws BusEx {
		// TODO Auto-generated method stub
		return null;
	}

}
