package com.cg.onlinehotelmanagementsystem.service;


import com.cg.onlinehotelmanagementsystem.dto.BookingDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.RoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.ExceptionHandling;

public interface IBookRoom {
	int bookRoom(RoomDetailsDTO roomDetailsDTO,BookingDetailsDTO bookingDetailsDTO)throws ExceptionHandling;

	int cancelBooking(int bookingId)throws ExceptionHandling;

}
