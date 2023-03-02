import org.junit.jupiter.api.Test;
import com.example.Reservation;
import com.example.Room;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

//Name: Kristiyan Stoilov
//Student ID: 260990847

public class ReservationTest {
    @Test
    void test_Reservation(){
        Room room = new Room("Double");
        Reservation reservation = new Reservation(room,"Bob");
        assertNotNull(reservation);
    }

    @Test
    void test_getName(){
        Room room = new Room("Double");
        Reservation reservation = new Reservation(room,"Bob");
        assertEquals("Bob", reservation.getName());
    }

    @Test
    void test_getRoom(){
        Room room = new Room("Double");
        Reservation reservation = new Reservation(room,"Bob");
        assertEquals(room, reservation.getRoom());
    }

}