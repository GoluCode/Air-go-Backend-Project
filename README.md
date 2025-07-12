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
│ │ └── air/go/
│ │ ├── files/
│ │ │ ├── BookingLogs.java
│ │ │ └── CreateDocument.java
│ │ └── base/
│ │ ├── dao/
│ │ ├── services/
│ │ ├── BookingDetails.java
│ │ ├── Flight.java
│ │ ├── Users.java
│ │ ├── Transactions.java
│ │ └── package-info.java
│ └── resources/
│ ├── bookings.json
│ └── hibernate.cfg.xml
├── webapp/
│ ├── WEB-INF/
│ ├── add-flight.jsp
│ ├── admin.jsp
│ ├── book-flight.jsp
│ ├── booking-form.jsp
│ ├── confirm.jsp
│ ├── edit-flight.jsp
│ ├── index.jsp
│ ├── manager.jsp
│ ├── payment.jsp
│ └── show-aval-flights.jsp

### 🧠 Explanation of Key Folders & Files

- `files/` → Booking document generation using Apache POI  
  - `CreateDocument.java`: Exports booking info to DOCX  
  - `BookingLogs.java`: (Planned) To log booking activities

- `base/` → Main logic + models  
  - `dao/`: All database operation classes  
  - `services/`: Interfaces and implementations for Admin/User/Manager logic  
  - `BookingDetails.java`: Holds booking data (flight, user, seat, etc.)  
  - `Flight.java`: Holds flight info (source, destination, etc.)  
  - `Users.java`: Holds user info (login, role, etc.)  
  - `Transactions.java`: Holds payment/transaction records

- `resources/` → Config and mock data  
  - `hibernate.cfg.xml`: Hibernate DB connection config  
  - `bookings.json`: Sample data for testing

- `webapp/` → JSP front-end and routing  
  - `add-flight.jsp`: Admin adds new flights  
  - `admin.jsp`: Admin dashboard  
  - `book-flight.jsp`: Final user booking confirmation  
  - `booking-form.jsp`: User enters booking info  
  - `confirm.jsp`: Confirmation page  
  - `edit-flight.jsp`: Edit flights (Admin/Manager)  
  - `index.jsp`: Home or login page  
  - `manager.jsp`: Manager dashboard  
  - `payment.jsp`: Payment input form  
  - `show-aval-flights.jsp`: Displays all available flights


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
>**My focus was on:**
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







