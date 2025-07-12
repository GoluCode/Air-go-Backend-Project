package go.base.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import go.base.Flight;


/**
 * FlightsDao
 * 
 * Data Access Object (DAO) class for handling flight-related operations.
 * This class is responsible for interacting with the database to perform
 * CRUD operations (Create, Read, Update, Delete) on flight records.
 * 
 * Examples of operations that might be added in this class:
 * - addFlight()
 * - getAllFlights()
 * - getFlightById()
 * - updateFlight()
 * - deleteFlight()
 * 
 * This class acts as a bridge between the service layer and the database layer.
 */
public class FlightsDao {
	
	public static List<Flight> getAvailableFlights(String s , String d){
		Session session = HibernateUtil.getSessionFactory().openSession();
	    List<Flight> flights = new ArrayList<Flight>();

	    try {
	        Query<Flight> query = session.createQuery(
	            "from Flight where source = :src AND destination = :destination", Flight.class);
	        query.setParameter("src", s);
	        query.setParameter("destination", d);
	        flights = query.getResultList();
	    } finally {
	        session.close();
	    }
	    return flights;
	}
	
	
	
	
	
}

