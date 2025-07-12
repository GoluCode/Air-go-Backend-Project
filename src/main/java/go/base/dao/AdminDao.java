package go.base.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import go.base.Flight;

/**
 * DAO class responsible for admin-related database operations,
 * particularly related to flight management.
 */
public class AdminDao extends ManagerDao {

    /**
     * Adds a new flight record to the database using Hibernate session.
     *
     * @param flightObj Flight object to be persisted
     * @return true if the flight is successfully saved, false if an error occurs
     */
    public boolean addFlight(Flight flightObj) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(flightObj);
            tx.commit();
            return true;
        } catch (Exception e) {
            // Rollback in case of failure
            if (tx != null) tx.rollback();
            e.printStackTrace();  // Consider using a logger in production
            return false;
        }
    }
}
