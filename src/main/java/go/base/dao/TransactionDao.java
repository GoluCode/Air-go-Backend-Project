package go.base.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import go.base.Transactions;

/**
 * DAO class for handling transaction-related database operations.
 */
public class TransactionDao extends ManagerDao {

    /**
     * Generates a unique booking ID based on the current timestamp
     * and a 4-digit random number suffix.
     *
     * @return a unique booking ID in the format BK-<timestamp>-<random>
     */
    public static String generateBookingID() {
        long timestamp = System.currentTimeMillis();
        int randomSuffix = (int) (Math.random() * 9000) + 1000; // 4-digit random number
        return "BK-" + timestamp + "-" + randomSuffix;
    }

    /**
     * Retrieves all transactions from the database.
     *
     * @return a list of all Transactions, or an empty list if none exist or on error
     */
    public List<Transactions> getAllTransactions() {
        List<Transactions> transactionList = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Transactions> query = session.createQuery("FROM Transactions", Transactions.class);
            transactionList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Use proper logging in production
        }

        return transactionList;
    }
}

