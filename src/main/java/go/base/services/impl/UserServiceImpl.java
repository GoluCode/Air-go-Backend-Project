package go.base.services.impl;

import java.util.List;
import java.util.Scanner;

import go.base.BookingDetails;
import go.base.dao.UserDao;
import go.base.services.UserService;

public class UserServiceImpl implements UserService {

	 // DAO instance used to interact with booking-related database operations
	UserDao dao ;
	public UserServiceImpl(){
		dao = new UserDao();
	}
	
	
    /**
     * Book a flight by saving booking details to the database.
     *
     * @param details BookingDetails object containing all booking info
     * @return true if booking is successful, false otherwise
     */
	@Override
	public boolean bookFilght(BookingDetails details) {
		return dao.saveBookingInfo(details);
	}

	
    /**
     * Retrieve booking details based on the given PNR.
     *
     * @param pnr Passenger Name Record
     * @return BookingDetails object with matching PNR or null if not found
     */
	@Override
	public BookingDetails getBookingDetails(String pnr) {
		return dao.fetchBookingDetails(pnr);
	}

}
