/**
 * This package contains servlets that act as entry points for HTTP requests
 * to the backend services.
 * <p>
 * These servlets serve as controllers that map incoming requests to the appropriate
 * service layer logic, process input parameters, and return responses to the client.
 * <p>
 * Each servlet may handle specific functionalities based on user roles, such as
 * login, registration, booking, or admin operations.
 *
 * @see go.base.services.UserService
 * @see go.base.services.ManagerService
 * @see go.base.services.AdminService
 */
package go.base.services.servlets;
