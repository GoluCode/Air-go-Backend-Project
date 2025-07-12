package go.base.services.impl;

import java.util.List;

import go.base.Flight;
import go.base.Transactions;
import go.base.dao.AdminDao;
import go.base.dao.TransactionDao;
import go.base.services.AdminService;

/**
 * Implementation of the AdminService interface.
 * Provides admin-related services such as managing flights and viewing transactions.
 */
public class AdminServicesImpl extends ManagerServicesImpl implements AdminService {

    // DAO for handling transaction-related database operations
    private final TransactionDao transactionDao;

    // DAO for handling admin-specific flight operations
    private final AdminDao adminDao;

    /**
     * Public constructor initializes the DAOs.
     */
    public AdminServicesImpl() {
        this.transactionDao = new TransactionDao();
        this.adminDao = new AdminDao();
    }

    /**
     * Retrieves all transactions from the system.
     * 
     * @return List of Transactions
     */
    @Override
    public List<Transactions> getAllTransactions() {
        return transactionDao.getAllTransactions();
    }

    /**
     * Adds a new flight record to the system.
     * 
     * @param newFlightInfo Flight object containing flight details
     * @return true if the flight was successfully added, false otherwise
     */
    @Override
    public boolean addNewFlights(Flight newFlightInfo) {
        return adminDao.addFlight(newFlightInfo);
    }
}
