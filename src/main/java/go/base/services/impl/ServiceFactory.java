package go.base.services.impl;

import go.base.dao.HelperDao;
import go.base.services.UserService;

public class ServiceFactory {
	
    private final HelperDao dao = new HelperDao();

    public UserService getServiceForRole(String username, String password) {
        String role = dao.getRole(username, password);

        if (role == null) {
            throw new IllegalArgumentException("Invalid credentials or user not found.");
        }

        UserService service;

        switch (role.toLowerCase()) {
            case "admin":
                service = new AdminServicesImpl();
                break;
            case "manager":
                service = new ManagerServicesImpl();
                break;
            case "user":
                service = new UserServiceImpl();
                break;
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }

        return service;
    }
}


