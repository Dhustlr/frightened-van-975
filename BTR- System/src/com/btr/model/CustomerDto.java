package com.btr.model;

public class CustomerDto {

	private int bId;
	private int bNo;
	private String bName;
	private String name;
	private String mobile;
	private String routeFrom;
	private String routeTo;
	private String arrival;
	private String departure;
	private int fare;
	private int seatFrom;
	private int seatTo;
	private boolean status;

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRouteFrom() {
		return routeFrom;
	}

	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public int getSeatFrom() {
		return seatFrom;
	}

	public void setSeatFrom(int seatFrom) {
		this.seatFrom = seatFrom;
	}

	public int getSeatTo() {
		return seatTo;
	}

	public void setSeatTo(int seatTo) {
		this.seatTo = seatTo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public CustomerDto(int bId, int bNo, String bName, String name, String mobile, String routeFrom, String routeTo,
			String arrival, String departure, int fare, int seatFrom, int seatTo, boolean status) {
		super();
		this.bId = bId;
		this.bNo = bNo;
		this.bName = bName;
		this.name = name;
		this.mobile = mobile;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.arrival = arrival;
		this.departure = departure;
		this.fare = fare;
		this.seatFrom = seatFrom;
		this.seatTo = seatTo;
		this.status = status;
	}

	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerDto [bId=" + bId + ", bNo=" + bNo + ", bName=" + bName + ", name=" + name + ", mobile=" + mobile
				+ ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", arrival=" + arrival + ", departure="
				+ departure + ", fare=" + fare + ", seatFrom=" + seatFrom + ", seatTo=" + seatTo + ", status=" + status
				+ "]";
	}

}
