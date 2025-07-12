package go.base.services;

import java.util.List;

import go.base.Flight;
import go.base.Transactions;

/**
 * Interface for admin-level services such as managing flights
 * and viewing all transactions in the system.
 */
public interface AdminService {

    /**
     * Retrieves all transactions made in the system.
     *
     * @return List of Transactions
     */
    List<Transactions> getAllTransactions();

    /**
     * Adds a new flight to the system.
     *
     * @param newFlightInfo Flight object containing the new flight's details
     * @return true if the flight was successfully added; false otherwise
     */
    boolean addNewFlights(Flight newFlightInfo);
}

