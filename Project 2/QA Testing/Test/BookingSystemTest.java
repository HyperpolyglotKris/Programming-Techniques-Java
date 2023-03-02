import com.example.BookingSystem;
import org.junit.jupiter.api.Test;
import com.example.Room;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

//Name: Kristiyan Stoilov
//Student ID: 260990847

public class BookingSystemTest {
    @Test
    void test_getRandomType() {
        assertNotNull(BookingSystem.getRandomType());
    }

    @Test
    void test_getRandomNumberOfRooms() {
        assertNotNull(BookingSystem.getRandomNumberOfRooms());
    }

    @Test
    void test_createRooms() {
        Room[] rooms = BookingSystem.createRooms(1);
        assertEquals(1, rooms.length);
    }
}