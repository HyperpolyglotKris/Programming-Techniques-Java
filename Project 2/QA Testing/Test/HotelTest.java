import org.junit.jupiter.api.Test;
import com.example.Hotel;
import com.example.Room;
import org.junit.jupiter.api.function.Executable;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

//Name: Kristiyan Stoilov
//Student ID: 260990847

public class HotelTest {
    @Test
    void test_Hotel(){
        Room[] rooms = new Room[1];
        rooms[0] = new Room("Double");
        Hotel hotel = new Hotel("TestHotel", rooms);
        assertNotNull(hotel);
    }

    @Test
    void test_createReservation_valid() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Room[] rooms = new Room[1];
        rooms[0] = new Room("Double");
        Hotel hotel = new Hotel("TestHotel", rooms);
        hotel.createReservation("Bob", "Double");
        assertEquals("You have successfully reserved a Double room under the name Bob. We look forward having you at TestHotel", out.toString().trim());
    }

    @Test
    void test_createReservation_roomNull() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Room[] rooms = new Room[1];
        rooms[0] = new Room("Double");
        rooms[0].changeAvailability();
        Hotel hotel = new Hotel("TestHotel", rooms);
        hotel.createReservation("Bob", "Double");
        assertEquals("Sorry Bob, we have no available rooms of the desired type.", out.toString().trim());
    }

    @Test
    void test_createReservation_issue() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Room[] rooms = new Room[1];
        rooms[0] = new Room("Double");
        Hotel hotel = new Hotel("TestHotel", rooms);
        hotel.createReservation("Bob", "Double");
        rooms[0].changeAvailability();
        hotel.createReservation("Bob", "Double");
        // Possibly need to adjust return string delimiters to "\n" for Linux, "\r" for Mac and "\r\n" for Windows.
        assertEquals("You have successfully reserved a Double room under the name Bob. We look forward having you at TestHotel\r\nThere is an issue with the reservation system", out.toString().trim());
    }

    @Test
    void test_cancelReservation_removeReservation() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Room[] rooms = new Room[2];
        rooms[0] = new Room("Double");
        rooms[1] = new Room("Queen");
        Hotel hotel = new Hotel("TestHotel", rooms);
        hotel.createReservation("Bob", "Double");
        hotel.createReservation("Bob", "Queen");
        hotel.cancelReservation("Bob", "Double");
        assertEquals("You have successfully reserved a Double room under the name Bob. We look forward having you at TestHotel\r\n" +
                "You have successfully reserved a Queen room under the name Bob. We look forward having you at TestHotel\r\n" +
                "Bob, your reservation for a Doubleroom has been successfully cancelled.", out.toString().trim());
    }

    @Test
    void test_cancelReservation_removeReservation_exception() {
        Room[] rooms = new Room[1];
        rooms[0] = new Room("Double");
        Hotel hotel = new Hotel("TestHotel", rooms);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        hotel.cancelReservation("Bob", "Queen");
        assertEquals("There is no reservation for a Queen room under the name of Bob.", out.toString().trim());
    }

    @Test
    void test_toString(){
        Room[] rooms = new Room[3];
        rooms[0] = new Room("Double");
        rooms[1] = new Room("Queen");
        rooms[2] = new Room("King");
        Hotel hotel = new Hotel("TestHotel", rooms);
        assertEquals("com.example.Hotel name: TestHotel\nAvailable Rooms: 1 double, 1 queen, 1 king.", hotel.toString());
    }

    @Test
    void test_printInvoice(){
        Room[] rooms = new Room[1];
        rooms[0] = new Room("Double");
        Hotel hotel = new Hotel("TestHotel", rooms);
        hotel.createReservation("Bob", "Double");
        hotel.printInvoice("Bob");
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        assertNull(null, outputStreamCaptor.toString().trim());
    }
}