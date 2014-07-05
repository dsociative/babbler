import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class OperatorTest {
    public Operator operator;
    public static final byte[] HELLO_TALKER = new byte[]{
        0x00, 0x00, 0x00, 0x1b, 0x7b, 0x22, 0x63, 0x6f,
        0x6d, 0x6d, 0x61, 0x6e, 0x64, 0x22, 0x3a, 0x20,
        0x22, 0x68, 0x65, 0x6c, 0x6c, 0x6f, 0x2e, 0x74,
        0x61, 0x6c, 0x6b, 0x65, 0x72, 0x22, 0x7d
    };

    @Before
    public void setUp() throws IOException {
        operator = new Operator("localhost", 8885);
    }

    @Test
    public void connect() throws IOException {
        operator.connect();
        assertEquals(operator.is_connected(), true);
    }

    @Test
    public void send() throws IOException {
        operator.connect();
        operator.send(HELLO_TALKER);
    }
}
