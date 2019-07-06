package com.cg.onlinehotelmanagementsystem.utility;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.cg.onlinehotelmanagementsystem.dto.RoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.ExceptionHandling;

public class Validation {
	final static String DATE_FORMAT = "dd-MM-yyyy";
	static DateFormat dateformat = new SimpleDateFormat(DATE_FORMAT);
	DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	public boolean dateCheckIn(LocalDate checkin) throws ExceptionHandling {

		dateformat.setLenient(false);
		try {
		dateformat.parse(checkin.format(dateTimeFormatter).toString());
		LocalDate currentDate=LocalDate.now();
	
		if (currentDate.compareTo(checkin) < 0 || currentDate.compareTo(checkin) == 0) {
			
			return true;
		}
		
		throw new ExceptionHandling(IExceptionClass.WRONG_DATE);
		}
		catch (ParseException parseException) {
			parseException.printStackTrace();
			throw new ExceptionHandling(IExceptionClass.WRONG_DATE);
		}
		
}

	public boolean dateCheckout(LocalDate checkInDate, LocalDate checkOutDate) throws ExceptionHandling {

		dateformat.setLenient(false);
		try {
			
		dateformat.parse(checkOutDate.format(dateTimeFormatter).toString());
		
		}
		catch (ParseException parseException) {
			
			throw new ExceptionHandling(IExceptionClass.WRONG_DATE);
		}
		if (checkOutDate.compareTo(checkInDate) > 0 || checkOutDate.compareTo(checkInDate) == 0) {
			
			return true;
		}
			
        
		throw new ExceptionHandling(IExceptionClass.WRONG_DATE);

	}
	public boolean isValidRoom(RoomDetailsDTO roomDetailsDTO)throws ExceptionHandling {
		if(roomDetailsDTO.getRoomType().equalsIgnoreCase("AC")||roomDetailsDTO.getRoomType().equalsIgnoreCase("NonAC")||roomDetailsDTO.getRoomType().equalsIgnoreCase("KingSize")||roomDetailsDTO.getRoomType().equalsIgnoreCase("QueenSize"))
			return true;	
		throw new ExceptionHandling(IExceptionClass.WRONG_CITY);
	}

}
