import org.junit.jupiter.api.Test;
import com.example.Room;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

//Name: Kristiyan Stoilov
//Student ID: 260990847

public class RoomTest {
    @Test
    void test_Room() {
        Room room = new Room("Double");
        assertNotNull(room);
    }

    @Test
    void test_getType_double() {
        Room room = new Room("Double");
        assertEquals("double", room.getType());
    }

    @Test
    void test_getType_queen() {
        Room room = new Room("Queen");
        assertEquals("queen", room.getType());
    }

    @Test
    void test_getType_king() {
        Room room = new Room("King");
        assertEquals("king", room.getType());
    }

    @Test
    void test_getType_illegal() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
                    public void execute() throws Throwable {
                Room room = new Room("illegal");
                room.getType();
            }
        });
    }

    @Test
    void test_getPrice() {
        Room room = new Room("Double");
        assertEquals(90, room.getPrice());
    }

    @Test
    void test_getAvailability() {
        Room room = new Room("Double");
        assertTrue(room.getAvailability());
    }

    @Test
    void test_changeAvailability() {
        Room room = new Room("Double");
        room.changeAvailability();
        assertFalse(room.getAvailability());
    }

    @Test
    void test_findAvailableRoom_null() {
        Room[] rooms = new Room[2];
        rooms[0] = new Room("Double");
        rooms[1] = new Room("Double");
        rooms[0].changeAvailability();
        rooms[1].changeAvailability();
        assertEquals(null, Room.findAvailableRoom(rooms, "Double"));
    }

    @Test
    void test_findAvailableRoom() {
        Room[] rooms = new Room[2];
        rooms[0] = new Room("Double");
        Room room = new Room("Double");
        assertEquals(room.getAvailability(), Room.findAvailableRoom(rooms, "Double").getAvailability());
    }

    @Test
    void test_findAvailableRoom_notFound() {
        Room[] rooms = new Room[1];
        rooms[0] = new Room("Queen");
        assertEquals(rooms[0], Room.findAvailableRoom(rooms, "Queen"));
    }
}
