package com.btr.model;

public class Customer {

	private int cusId;
	private String username;
	private String pass;
	private String name;
	private String address;
	private String mobile;

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Customer(int cusId, String username, String pass, String name, String address, String mobile) {
		super();
		this.cusId = cusId;
		this.username = username;
		this.pass = pass;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", username=" + username + ", pass=" + pass + ", name=" + name
				+ ", address=" + address + ", mobile=" + mobile + "]";
	}

}
