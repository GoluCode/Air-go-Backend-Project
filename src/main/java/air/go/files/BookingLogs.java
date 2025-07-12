package air.go.files;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BookingLogs {

   
    public static class BookingEntry {
        public String name;
        public String pnr;
        public String bookingId;
        public String flightId;
        public String vendor;
        public String travelClass;

        // Required for Jackson
        public BookingEntry() {}

        public BookingEntry(String bookingId, String name, String flightId, String vendor, String travelClass, String pnr) {
            this.bookingId = bookingId;
            this.name = name;
            this.flightId = flightId;
            this.vendor = vendor;
            this.travelClass = travelClass;
            this.pnr = pnr;
        }
    }

    public static void writeBookingDetail(String bookingId, String passenger_name, String flight_id, String vendor,
                                          String fclass, String pnr) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("C:\\Shyam Sunder Roy\\Java Workspace\\Air-go-Backend-Project\\src\\main\\resources\\bookings.json");

            List<BookingEntry> logs = new ArrayList<>();
            if (file.exists() && file.length() > 0) {
                logs = new ArrayList<>(Arrays.asList(mapper.readValue(file, BookingEntry[].class)));
            }

            BookingEntry entry = new BookingEntry(bookingId, passenger_name, flight_id, vendor, fclass, pnr);
            logs.add(entry);

            mapper.writerWithDefaultPrettyPrinter().writeValue(file, logs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
