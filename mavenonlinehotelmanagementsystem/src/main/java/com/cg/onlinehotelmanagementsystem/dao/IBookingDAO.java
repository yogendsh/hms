package com.cg.onlinehotelmanagementsystem.dao;



import com.cg.onlinehotelmanagementsystem.dto.BookingDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.RoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.ExceptionHandling;

public interface IBookingDAO {
	int bookingConnection(int roomId,BookingDetailsDTO bookingDetailsDTO) throws ExceptionHandling;
	int setBookingDetails(BookingDetailsDTO bookingDetailsDTO, RoomDetailsDTO roomDetailsDTO) throws ExceptionHandling;

}
