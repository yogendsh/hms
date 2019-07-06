package com.cg.onlinehotelmanagementsystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.onlinehotelmanagementsystem.dto.BookingDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.RoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.ExceptionHandling;
import com.cg.onlinehotelmanagementsystem.utility.DbUtil;
import com.cg.onlinehotelmanagementsystem.utility.IExceptionClass;
import com.cg.onlinehotelmanagementsystem.utility.SqlQuery;

public class BookingDAO implements IBookingDAO {

	public int bookingConnection(int roomId,BookingDetailsDTO bookingDetailsDTO) throws ExceptionHandling {
		Connection connection = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			
			preparedStatement = connection.prepareStatement(SqlQuery.GET_ROOM_DETAILS);
			preparedStatement.setInt(1, roomId);
			preparedStatement.setDate(2,Date.valueOf(bookingDetailsDTO.getCheckinbook()));
			preparedStatement.setDate(3,Date.valueOf(bookingDetailsDTO.getCheckinbook()));
			preparedStatement.setDate(4,java.sql.Date.valueOf(bookingDetailsDTO.getCheckoutbook()));
			preparedStatement.setDate(5,java.sql.Date.valueOf(bookingDetailsDTO.getCheckoutbook()));
			preparedStatement.setDate(6,java.sql.Date.valueOf(bookingDetailsDTO.getCheckinbook()));
			preparedStatement.setDate(7,java.sql.Date.valueOf(bookingDetailsDTO.getCheckoutbook()));
			preparedStatement.setDate(8,java.sql.Date.valueOf(bookingDetailsDTO.getCheckinbook()));
			preparedStatement.setDate(9,java.sql.Date.valueOf(bookingDetailsDTO.getCheckoutbook()));
			ResultSet resultSet = preparedStatement.executeQuery();
			connection.commit();
			
			
			 int numberOfColumn=resultSet.getRow();
			 //System.out.println(numberOfColumn);
				
             return numberOfColumn;
             
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			 System.out.println("hghjgh3434");
			throw new ExceptionHandling(IExceptionClass.SQL);
		}

	}

	public int setBookingDetails(BookingDetailsDTO bookingDetailsDTO, RoomDetailsDTO roomDetailsDTO)
			throws ExceptionHandling {
		Connection connection = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SqlQuery.SET_BOOK_DETAILS);
			
			preparedStatement.setInt(1, roomDetailsDTO.getRoomId());

			preparedStatement.setDate(2, java.sql.Date.valueOf(bookingDetailsDTO.getCheckinbook()));

			preparedStatement.setDate(3, java.sql.Date.valueOf(bookingDetailsDTO.getCheckoutbook()));

			int execute= preparedStatement.executeUpdate();
			connection.commit();
			return execute;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new ExceptionHandling(IExceptionClass.SQL);
		}

	}

	public int searchIdForCancel(int bookingId) throws ExceptionHandling {
		Connection connection = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SqlQuery.CANCEL_BOOKING);
			preparedStatement.setInt(1, bookingId);
			connection.commit();
			return preparedStatement.executeUpdate();
		} catch (SQLException sqlException) {

			throw new ExceptionHandling(IExceptionClass.SQL);
		}

	}

}
