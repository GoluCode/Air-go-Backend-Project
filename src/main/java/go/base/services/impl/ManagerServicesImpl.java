package go.base.services.impl;

import go.base.Flight;
import go.base.Users;
import go.base.services.ManagerService;

public class ManagerServicesImpl extends UserServiceImpl implements ManagerService {

	@Override
	public boolean editFlightInfo(Flight filghtid) {
		
		return false;
	}

	@Override
	public boolean editUserPassword(Users userId) {
		
		return false;
	}

}
