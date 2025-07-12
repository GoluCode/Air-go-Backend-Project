package go.base.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import go.base.Users;

public class HelperDao {

    /**
     * Validates whether a user with the provided credentials exists.
     *
     * @param username the username
     * @param password the password
     * @return true if user exists, false otherwise
     */
    public boolean isExistingUser(String username, String password) {
        boolean userExists = false;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Users WHERE username = :username AND password = :password";
            Query<Users> query = session.createQuery(hql, Users.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            userExists = (query.uniqueResult() != null);
        } catch (Exception e) {
            e.printStackTrace(); // Use proper logging
        }

        return userExists;
    }

    /**
     * Retrieves the role of a user if credentials are valid.
     *
     * @param username the username
     * @param password the password
     * @return the user's role, or null if user does not exist
     */
    public String getRole(String username, String password) {
        if (!isExistingUser(username, password)) {
            return null;
        }

        String role = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT role FROM Users WHERE username = :u AND password = :p";
            Query<String> query = session.createQuery(hql, String.class);
            query.setParameter("u", username);
            query.setParameter("p", password);

            role = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return role;
    }
    
    public static String getName(String username) {
    	String name = null;
    	try (Session session = HibernateUtil.getSessionFactory().openSession()){
    		String hql = "SELECT name FROM Users WHERE username = :u";
			Query<String> query = session.createQuery(hql,String.class);
			query.setParameter("u", username);
			name = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return name;
    }
    
    public static String generatePNR() {
        return "PNR-" + java.util.UUID
            .randomUUID()
            .toString()
            .substring(0, 8)
            .toUpperCase();
    }

}
