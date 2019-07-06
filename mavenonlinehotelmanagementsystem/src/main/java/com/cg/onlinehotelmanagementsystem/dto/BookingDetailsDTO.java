package com.cg.onlinehotelmanagementsystem.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class BookingDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int bookingid;
	private LocalDate checkinbook;
	private LocalDate checkoutbook;
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public LocalDate getCheckinbook() {
		return checkinbook;
	}
	public void setCheckinbook(LocalDate checkinbook) {
		this.checkinbook = checkinbook;
	}
	public LocalDate getCheckoutbook() {
		return checkoutbook;
	}
	public void setCheckoutbook(LocalDate checkoutbook) {
		this.checkoutbook = checkoutbook;
	}

	
}
