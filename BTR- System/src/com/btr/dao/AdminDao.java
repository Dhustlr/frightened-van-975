package com.btr.dao;

import java.util.List;

import com.btr.exceptions.BusEx;
import com.btr.exceptions.CustomerEX;
import com.btr.model.Bus;
import com.btr.model.BusDto;
import com.btr.model.Customer;

public interface AdminDao {


	public Customer Alogin(String username, String password) throws CustomerEX;

	public List<BusDto> getBusesAllDetails(String source, String destination) throws BusEx;


}
