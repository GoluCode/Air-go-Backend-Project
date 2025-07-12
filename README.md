# Air-go-Backend-Project (Java Servlets + JSP + JDBC + Hibernate)

This is a monolithic full-stack flight reservation system built using core Java technologies.  
It simulates the booking and management workflow of an airline system, designed with clean separation between presentation, business, and persistence layers.

> 💡 This project was designed **intuitively without formal knowledge of MVC**, but later recognized as a **well-structured Monolithic MVC architecture**.  
> It reflects real-world thinking in a beginner-friendly format.

---

## 📌 Key Features

- ✅ Role-based login: User, Manager, and Admin
- ✅ Polymorphism used to handle role-based services dynamically
- ✅ Clean 3-layered architecture:
  - **Controller** – Servlets
  - **Service Layer** – Interfaces and implementations
  - **DAO Layer** – Responsible for DB communication using JDBC and Hibernate
- ✅ Hibernate ORM integration for booking persistence
- ✅ Booking flow with session tracking
- ✅ Servlet forwarding, JSP responses, and clean form submission handling
- ✅ Docx file generation for booking confirmation (Apache POI)

---

## 📂 Project Structure (clean + fully aligned with actual code)

Air-go-Backend-Project/
├── src/
│ └── main/
│ ├── java/
│ │ └── air/
│ │ └── go/
│ │ ├── files/ # 📄 Handles booking document exports (e.g., .docx via Apache POI)
│ │ │ ├── BookingLogs.java # → [Planned/Bookings-related class]
│ │ │ └── CreateDocument.java # → Generates booking confirmation documents (in progress)
│ │ └── base/ # 🧱 Core package for business logic, DAO, and data models
│ │ ├── dao/ # 🛢 Data Access Objects: Handle DB operations
│ │ ├── services/ # 🔌 Business services & interfaces (Admin/User/Manager logic)
│ │ │ └── [UserService, AdminService, etc.]
│ │ ├── BookingDetails.java # 📦 Data class: Holds passenger + flight + seat booking data
│ │ ├── Flight.java # 📦 Data class: Flight details (source, destination, date, etc.)
│ │ ├── Users.java # 📦 Data class: User info (role, credentials, name, etc.)
│ │ ├── Transactions.java # 📦 Data class: Handles payment/transaction records
│ │ └── package-info.java # 🗂️ Optional package-level annotations
│ └── resources/
│ ├── bookings.json # 📄 Static/mock flight or booking data for testing
│ └── hibernate.cfg.xml # ⚙️ Hibernate configuration (DB connection settings)
├── webapp/
│ ├── WEB-INF/ # 🛠 Web descriptor config (contains web.xml)
│ ├── add-flight.jsp # 🧑‍✈️ Admin: Add flight data
│ ├── admin.jsp # 🧑‍✈️ Admin dashboard
│ ├── book-flight.jsp # 👤 User: Review and confirm booking
│ ├── booking-form.jsp # 👤 User: Fill booking details
│ ├── confirm.jsp # ✅ Booking confirmation
│ ├── edit-flight.jsp # 🧑‍✈️ Admin/Manager: Modify flight
│ ├── index.jsp # 🏠 Home/Login page
│ ├── manager.jsp # 🧑‍💼 Manager dashboard
│ ├── payment.jsp # 💳 Payment input
│ └── show-aval-flights.jsp # ✈️ Displays search results of available flights

---

## 🧑‍💻 Tech Stack

- Java (JDK 1.8)
- JSP + Servlets (Apache Tomcat 9)
- JDBC + Hibernate ORM
- Oracle DB (test DB)
- Apache POI (for docx export)
- JUnit (testing layer being added) ( in - progress)
- MVC Architecture (Monolithic, hand-built)

---

## 🚀 How to Run the Project

1. Clone this repo:  
   `git clone https://github.com/GoluCode/Air-go-Backend-Project`

2. Open in **Eclipse** as a Dynamic Web Project

3. Set up **Tomcat** (version 9 preferred)

4. Configure DB credentials in `hibernate.cfg.xml` and/or JDBC connection file

5. Import the provided `.sql` schema file if available (coming soon)

6. Run project → Start from `login.jsp`

---

## ✅ Upcoming Improvements

- [ ] REST API layer (for front-end independence)
- [ ] JUnit tests for services and DAO (in-progress)
- [ ] Real-time seat availability check
- [ ] One-to-Many + Many-to-One Hibernate relationships
- [ ] Centralized error handling + logging
- [ ] Admin dashboard for analytics and reports

---

## 🧠 Developer’s Notes

> This project was designed by intuition before learning about formal software architecture patterns.  
> Only later did I discover that my structure closely matches real-world Monolithic MVC.  
> My focus was on:
- Clean separation of responsibilities
- Scalable role management using polymorphism
- Future support for testing and modularization

I believe this foundation can be evolved into a microservice or RESTful API design over time.

---

## 📸 Screenshots (coming soon)

---

## 📄 License

This project is open for educational purposes. Use it, break it, improve it!

---

## 🙋‍♂️ Author

**Shyam Sunder Roy**  
Aspiring backend engineer who loves to build scalable, testable systems from scratch.

---







