package go.base.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import go.base.BookingDetails;

public class UserDao{
	
	/**
	 * Saves booking information to the database.
	 *
	 * @param details the BookedData object to be persisted
	 * @return true if the booking information was successfully saved; false otherwise
	 */
	public boolean saveBookingInfo(BookingDetails details) {
	    Transaction tx = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        tx = session.beginTransaction();
	        
	        session.save(details); 

	        tx.commit(); 
	        return true;
	    } catch (Exception e) {
	        
	        if (tx != null) tx.rollback();
	        e.printStackTrace(); 
	        return false;
	    }
	}

	
	/**
	 * Fetches the booking details for a given PNR.
	 *
	 * @param pnr the booking PNR to search for
	 * @return the corresponding BookedData object, or null if not found
	 */
	public BookingDetails fetchBookingDetails(String pnr) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Query<BookingDetails> query = session.createQuery(
	            "FROM BookedData WHERE pnr = :pnr", BookingDetails.class
	        );
	        query.setParameter("pnr", pnr);
	        return query.uniqueResult();
	    } catch (Exception e) {
	        e.printStackTrace(); // Replace with proper logging in production
	    }
	    return null;
	}
}
