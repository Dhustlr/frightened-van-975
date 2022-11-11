package com.btr.dao;

import com.btr.model.Bus;

public interface AdminDao {

	public final String userid = "Admin";
	public final String pass = "0000";

	public String Alogin(String userid, String pass);

	public String addBus(Bus bus);

	public String updatestatus(int cid);

	public void viewTickets();

}
