package com.btr.dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.btr.exceptions.BusEx;
import com.btr.exceptions.CustomerEX;
import com.btr.model.Bus;
import com.btr.model.BusDto;
import com.btr.model.Customer;
import com.btr.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Customer Alogin(String username, String password) throws CustomerEX {

		Customer c = null;

		try (Connection conn = DBUtil.getConnetion()) {

			PreparedStatement ps = conn.prepareStatement("select * from customer where email = ? AND password = ?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				c = new Customer();
				c.setName(name);

			} else
				throw new CustomerEX("Not valid input");

		} catch (SQLException e) {
			throw new CustomerEX(e.getMessage());
		}

		return c;
	}

	@Override
	public List<BusDto> getBusesAllDetails(String source, String destination) throws BusEx {
		// TODO Auto-generated method stub

		List<BusDto> ls = new ArrayList<>();

		try (Connection conn = DBUtil.getConnetion()) {

			PreparedStatement ps = conn.prepareStatement("select * from bus where routeFrom = ? AND routeTo = ?");

			ps.setString(1, source);
			ps.setString(2, destination);

			ResultSet rs = ps.executeQuery();
//			System.out.println(rs);
			try {

				int count = 0;

				while (rs.next()) {
					count++;

					Timestamp timestamp = rs.getTimestamp("arrival");

					LocalDateTime arrivalTime = timestamp.toLocalDateTime();

					Timestamp timestamp1 = rs.getTimestamp("departure");

					LocalDateTime departureTime = timestamp1.toLocalDateTime();

					BusDto busDTO = new BusDto(rs.getString("name"), rs.getString("routeFrom"),rs.getString("btype"),
							rs.getInt("availSeats"), arrivalTime, departureTime);
					ls.add(busDTO);

				}
				if (count == 0) {
					throw new BusEx("No buses available ");
				}

			} catch (BusEx e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			throw new BusEx(e.getMessage());
		}

		return ls;
	}

}
