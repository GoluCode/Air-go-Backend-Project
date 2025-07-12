package go.base.services;

import go.base.Flight;
import go.base.Users;

public interface ManagerService {
	
	boolean editFlightInfo(Flight filghtid);  // manager can edit flight related info which is added by Admin
	boolean editUserPassword(Users userId) ; // manager can change the password of user
	
}
