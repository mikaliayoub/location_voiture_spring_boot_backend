package com.cars.entity;

import java.util.Date;

public class ReservationRequest {
    private Date startDate;
    private Date endDate;
    private int carId;
	public ReservationRequest() {
		super();
	}
	public ReservationRequest(Date startDate, Date endDate, int carId) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.carId = carId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
    
}
