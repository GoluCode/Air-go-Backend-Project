# ✅ TODO – Flight Booking System

This file contains a running list of tasks and improvements for the Flight Booking System project.  
It represents what's pending, in progress, and what has already been done .

---

## 🚧 In Progress

- [ ] Add unit tests for `UserServiceImpl` and `UserDao`
- [ ] Improve exception handling in Servlets and DAO
- [ ] Create simple admin dashboard to view all bookings
- [ ] Setup Hibernate relationships (One-to-Many, Many-to-One)

---

## 🔜 Planned Features

- [ ] Seat availability logic (live seat count updates)
- [ ] REST API endpoints (to replace servlet logic gradually)
- [ ] Integration with real-world calendar/clock for date checks
- [ ] Pagination support in flight listings
- [ ] Email booking confirmation (JavaMail API or console simulation)

---

## 🧪 Testing Goals

- [ ] Write JUnit tests for:
  - [ ] `UserServiceImpl.bookFlight()`
  - [ ] `UserDao.saveBookingInfo()`
  - [ ] `Login validation logic`
- [ ] Setup mock data for tests
- [ ] Explore H2 in-memory DB for isolated integration testing

---

## 🛠️ Refactoring Ideas

- [ ] Move DB config to external `.properties` file
- [ ] Apply interface segregation more strictly (split big interfaces if needed)
- [ ] Rename classes for clarity if needed (`UserServiceImpl` → `PassengerServiceImpl`, etc.)
- [ ] Use enums for role names instead of plain strings

---

## ✅ Done

- [x] Role-based access design
- [x] DAO separated from Servlets
- [x] Booking flow from JSP → Servlet → Service → DB
- [x] Session tracking for logged-in user
- [x] Project structure using MVC pattern (monolithic)
- [x] Apache POI integrated for booking docx generation

---

## 🧠 Personal Notes

> This file will evolve as I learn and grow.  
I use it to track my understanding of real-world backend systems — and how to improve them step-by-step.

