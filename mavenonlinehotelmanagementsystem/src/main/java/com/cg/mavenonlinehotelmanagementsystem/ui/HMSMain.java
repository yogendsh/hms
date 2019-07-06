package com.cg.mavenonlinehotelmanagementsystem.ui;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;
import com.cg.onlinehotelmanagementsystem.dto.BookingDetailsDTO;
import com.cg.onlinehotelmanagementsystem.dto.RoomDetailsDTO;
import com.cg.onlinehotelmanagementsystem.exception.ExceptionHandling;
import com.cg.onlinehotelmanagementsystem.service.IBookRoom;
import com.cg.onlinehotelmanagementsystem.service.impl.BookRoomImpl;

public class HMSMain {

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++)
			System.out.print("*");
		System.out.print("WELCOME TO ONLINE HOTEL BOOKING SYSTEM");
		for (int i = 0; i < 50; i++)
			System.out.print("*");
		while (true) {
			System.out.println("");
			for (int i = 0; i < 60; i++)
				System.out.print(" ");
			System.out.println("Press 1 for Booking");
			for (int i = 0; i < 58; i++)
				System.out.print(" ");
			System.out.println("Press 2 for Cancel Booking");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			IBookRoom bookRoomObject = null;
			try {
				int n = 0;
				try {
					n = scanner.nextInt();
				} catch (Exception e) {
					System.out.println("Press ctrl+f11 to continue!!!!");
					break;

				}
				switch (n) {
				case 1:
					System.out.println("List of Location");
					System.out.println("Pune");
					System.out.println("Jaipur");
					System.out.println("Mumbai");
					System.out.println("Delhi");
					System.out.println("Enter your location from above");
					@SuppressWarnings("unused") String locName = scanner.next();
					System.out.println("Hotel Name is");
					System.out.println("Taj");
					System.out.println("List of Room Types");
					System.out.println("Ac");
					System.out.println("NonAc");
					System.out.println("KingSize");
					System.out.println("QueenSize");
					System.out.println("Enter Room Type");
					String roomName = scanner.next();
					System.out.println("Enter the checkin date");
					String checkIn = scanner.next();
					System.out.println("Enter the checkout date");
					String checkOut = scanner.next();
					System.out.println("Enter Number of Persons");
					int numPersons = scanner.nextInt();
					RoomDetailsDTO roomDetailsDTO = new RoomDetailsDTO();
					if (roomName.equalsIgnoreCase("AC")) {
						roomDetailsDTO.setPrice(2500);
						roomDetailsDTO.setRoomId(1);
					} else if (roomName.equalsIgnoreCase("NonAC")) {
						roomDetailsDTO.setPrice(2000);
						roomDetailsDTO.setRoomId(2);
					} else if (roomName.equalsIgnoreCase("KingSize")) {
						roomDetailsDTO.setPrice(2800);
						roomDetailsDTO.setRoomId(3);
					} else if (roomName.equalsIgnoreCase("QueenSize")) {
						roomDetailsDTO.setPrice(2600);
						roomDetailsDTO.setRoomId(4);
					}
					roomDetailsDTO.setNumberOfPersons(numPersons);
					roomDetailsDTO.setRoomType(roomName);
					BookingDetailsDTO bookingDetailsDTO = new BookingDetailsDTO();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					bookingDetailsDTO.setCheckinbook(LocalDate.parse(checkIn, formatter));
					bookingDetailsDTO.setCheckoutbook(LocalDate.parse(checkOut, formatter));
					if(bookRoomObject==null)
						bookRoomObject=new BookRoomImpl();
					if (bookRoomObject.bookRoom(roomDetailsDTO, bookingDetailsDTO) == 1) {
						System.out.println("BOOKING IS CONFIRMED");
					}

					break;
				case 2:System.out.println("Enter Booking ID To cancel booking");
				int bookingId=scanner.nextInt();
				if(bookRoomObject==null)
					bookRoomObject=new BookRoomImpl();
				if(bookRoomObject.cancelBooking(bookingId)==1)
					System.out.println("Booking is cancelled");
				

				default:System.out.println("For contine press 1");
				int count = scanner.nextInt();
				if (count != 1)
					System.exit(1);
				break;
					

				}
			}  catch (ExceptionHandling handling) {
				System.out.println(handling.getMessage());
			}
			catch (Exception exception) {
				System.out.println("Provided Information is not correct");
				
			}

		}
	}
}
