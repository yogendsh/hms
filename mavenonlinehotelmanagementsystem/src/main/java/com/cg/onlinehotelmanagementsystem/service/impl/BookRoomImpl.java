package com.cg.onlinehotelmanagementsystem.service.impl;

import java.time.temporal.ChronoUnit;
import java.util.List;

import com.cg.onlinehotelmanagementsystem.dao.BookingDAO;
import com.cg.onlinehotelmanagementsystem.dto.BookingDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.RoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.ExceptionHandling;
import com.cg.onlinehotelmanagementsystem.service.IBookRoom;
import com.cg.onlinehotelmanagementsystem.utility.IExceptionClass;
import com.cg.onlinehotelmanagementsystem.utility.Validation;

public class BookRoomImpl implements IBookRoom {
	public int bookRoom(RoomDetailsDTO roomDetailsDTO, BookingDetailsDTO bookingDetailsDTO) throws ExceptionHandling {
		BookingDAO bookingDAO = new BookingDAO();
		Validation validation = new Validation();
		validation.dateCheckIn(bookingDetailsDTO.getCheckinbook());
		validation.dateCheckout(bookingDetailsDTO.getCheckinbook(), bookingDetailsDTO.getCheckoutbook());
		validation.isValidRoom(roomDetailsDTO);
		int numberOfColumn = bookingDAO.bookingConnection(roomDetailsDTO.getRoomId(),bookingDetailsDTO);
		System.out.println(roomDetailsDTO.getRoomId());
		if (numberOfColumn==0) {

			if (roomDetailsDTO.getRoomId() == 1) {
				if (roomDetailsDTO.getNumberOfPersons() > 4)
					throw new ExceptionHandling(IExceptionClass.PERSON_EXCEED);
				else {
					int diffDays = (int) ChronoUnit.DAYS.between(bookingDetailsDTO.getCheckinbook(),
							bookingDetailsDTO.getCheckoutbook());
					roomDetailsDTO.setPrice(roomDetailsDTO.getPrice() * diffDays);
					
				}
			}
			else if (roomDetailsDTO.getRoomId() == 2) {
				System.out.println("2");
				if (roomDetailsDTO.getNumberOfPersons() > 3)
					throw new ExceptionHandling(IExceptionClass.PERSON_EXCEED);
				else {
					int diffDays = (int) ChronoUnit.DAYS.between(bookingDetailsDTO.getCheckinbook(),
							bookingDetailsDTO.getCheckoutbook());
					roomDetailsDTO.setPrice(roomDetailsDTO.getPrice() * diffDays);
					
				}
			}
			else if (roomDetailsDTO.getRoomId() == 3) {
				if (roomDetailsDTO.getNumberOfPersons() > 5)
					throw new ExceptionHandling(IExceptionClass.PERSON_EXCEED);
				else {
					int diffDays = (int) ChronoUnit.DAYS.between(bookingDetailsDTO.getCheckinbook(),
							bookingDetailsDTO.getCheckoutbook());
					roomDetailsDTO.setPrice(roomDetailsDTO.getPrice() * diffDays);
					
				}
			}
			else if (roomDetailsDTO.getRoomId() == 4) {
				if (roomDetailsDTO.getNumberOfPersons() > 4)
					throw new ExceptionHandling(IExceptionClass.PERSON_EXCEED);
				else {
					int diffDays = (int) ChronoUnit.DAYS.between(bookingDetailsDTO.getCheckinbook(),
							bookingDetailsDTO.getCheckoutbook());
					roomDetailsDTO.setPrice(roomDetailsDTO.getPrice() * diffDays);
					
				}
			}

			if (bookingDAO.setBookingDetails(bookingDetailsDTO, roomDetailsDTO) == 1)
				return 1;
			else
				new ExceptionHandling(IExceptionClass.ERROR_IN_BOOKING);

		} else
			throw new ExceptionHandling(IExceptionClass.ROOM_BOOKED);
		return 0;

	}

	public int cancelBooking(int bookingId) throws ExceptionHandling {

		BookingDAO bookingDAO = new BookingDAO();
		if (bookingDAO.searchIdForCancel(bookingId) == 1)
			return 1;
		else
			throw new ExceptionHandling(IExceptionClass.CANCEL_BOOKING);

	}

}
