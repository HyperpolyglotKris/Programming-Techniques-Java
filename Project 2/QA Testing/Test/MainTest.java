import com.example.Main;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Test;
import com.example.Room;
import org.junit.jupiter.api.function.Executable;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import java.io.*;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

//Name: Kristiyan Stoilov
//Student ID: 260990847

public class MainTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void test_Main_case1() throws Exception {
        String string = "Hotel\n1\nBob\nDouble\n5";
        InputStream inputStream = new ByteArrayInputStream(string.getBytes());
        System.setIn(inputStream);
        Main.main(new String[0]);
    }
    @Test
    public void test_Main_case2() throws Exception {
        String string = "Hotel\n2\nBob\nDouble\n5";
        InputStream inputStream = new ByteArrayInputStream(string.getBytes());
        System.setIn(inputStream);
        Main.main(new String[0]);
    }
    @Test
    public void test_Main_case3() throws Exception {
        String string = "Hotel\n3\nBob\n5";
        InputStream inputStream = new ByteArrayInputStream(string.getBytes());
        System.setIn(inputStream);
        Main.main(new String[0]);
    }
    @Test
    public void test_Main_case4() throws Exception {
        String string = "Hotel\n4\n5";
        InputStream inputStream = new ByteArrayInputStream(string.getBytes());
        System.setIn(inputStream);
        Main.main(new String[0]);
    }
    @Test
    public void test_Main_case5() throws Exception {
        String string = "Hotel\n5";
        InputStream inputStream = new ByteArrayInputStream(string.getBytes());
        System.setIn(inputStream);
        Main.main(new String[0]);
    }
    @Test
    public void test_Main_caseDefault() throws Exception {
        String string = "Hotel\n6\n5";
        InputStream inputStream = new ByteArrayInputStream(string.getBytes());
        System.setIn(inputStream);
        Main.main(new String[0]);
    }
}
