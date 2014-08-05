import junit.framework.TestCase;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MessageWriterTest extends TestCase {
    public static final byte[] HELLO_TALKER = new byte[]{
        0, 0, 0, 26, 123, 34, 99, 111, 109, 109, 97, 110, 100,
        34, 58, 34, 104, 101, 108, 108, 111, 46, 116, 97, 108,
        107, 101, 114, 34, 125
    };
    private MessageWriter writer;
    private JSONObject message;
    private MockBuffer buffer;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        buffer = new MockBuffer();
        writer = new MessageWriter(buffer);

        message = new JSONObject();
        message.put("command", "hello.talker");
    }

    public void testPack() throws JSONException {
        assertEquals(Arrays.toString(HELLO_TALKER), Arrays.toString(writer.pack(message)));
    }

    public void testWrite() throws IOException {
        writer.write(message);
        assertEquals(Arrays.toString(HELLO_TALKER), Arrays.toString(buffer.data.array()));
    }

    private class MockBuffer extends OutputStream {
        private ByteBuffer data;

        public MockBuffer(){
            data = ByteBuffer.allocate(30);
        }

        @Override
        public void write(int i) throws IOException {
            data.put((byte) i);
        }
    }
}