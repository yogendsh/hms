package com.cg.onlinehotelmanagementsystem.dto;

import java.io.Serializable;

public class RoomDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int numberOfPersons;
	private String roomType;
	private int roomId;
	private double price;

	public int getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
