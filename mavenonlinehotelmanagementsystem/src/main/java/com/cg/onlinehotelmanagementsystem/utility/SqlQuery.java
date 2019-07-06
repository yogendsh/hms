package com.cg.onlinehotelmanagementsystem.utility;

	public class SqlQuery {
	
	public static final String GET_ROOM_DETAILS = "SELECT bookingdetails.roomid from ROOMDETAILS,BOOKINGDETAILS where (bookingdetails.roomid=? and ROOMDETAILS.HOTELID = BOOKINGDETAILS.HOTELID) and( CHECKIN<=TO_DATE(?,'dd-MM-yyyy') and BOOKINGDETAILS.CHECKOUT>=TO_DATE(?,'dd-MM-yyyy') OR CHECKIN<=TO_DATE(?,'dd-MM-yyyy') aND BOOKINGDETAILS.CHECKOUT>=TO_DATE(?,'dd-MM-yyyy')) AND CHECKIN NOT BETWEEN TO_DATE(?,'dd-MM-yyyy') AND TO_DATE(?,'dd-MM-yyyy') AND CHECKOUT NOT BETWEEN TO_DATE(?,'dd-MM-yyyy') AND TO_DATE(?,'dd-MM-yyyy')";

	public static final String SET_BOOK_DETAILS = "insert into bookingdetails(BOOKINGID, HOTELID, ROOMID, CUSTOMERID, CHECKIN, CHECKOUT ) values(bookseq.NEXTVAL, 123456, ?, 1, ?, ?)";
	
	public static final String CANCEL_BOOKING ="DELETE FROM BOOKINGDETAILS WHERE BOOKINGID=?";
}
