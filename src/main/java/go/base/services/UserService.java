package go.base.services;


import go.base.BookingDetails;

public interface UserService {
	
	boolean bookFilght(BookingDetails details); // User can book a flight
	
	BookingDetails getBookingDetails(String pnr); // user can check his booking detials 
	
	
	
		
}
