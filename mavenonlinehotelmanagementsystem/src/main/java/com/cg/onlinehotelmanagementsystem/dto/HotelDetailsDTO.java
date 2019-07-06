package com.cg.onlinehotelmanagementsystem.dto;

import java.io.Serializable;

public class HotelDetailsDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int hotelid;
	private String hotelname;
	private String hoteladdress;
	private int numberofrooms;
    
	public HotelDetailsDTO(int hotelid, String hotelname, String hoteladdress, int numberofrooms) {
		super();
		this.hotelid = hotelid;
		this.hotelname = hotelname;
		this.hoteladdress = hoteladdress;
		this.numberofrooms = numberofrooms;
		
		
		
	}
	public int getHotelid() {
		return hotelid;
	}
	public String getHotelname() {
		return hotelname;
	}
	public String getHoteladdress() {
		return hoteladdress;
	}
	public int getNumberofrooms() {
		return numberofrooms;
	}
	
	
	@Override
	public String toString() {
		return "Hotel Id=" + hotelid + ", Hotel Address=" + hoteladdress
				+ ", Number of rooms=" + numberofrooms;
	}
	
	}
	
    
    
    
	


