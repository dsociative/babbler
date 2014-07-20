import junit.framework.TestCase;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class MessageReaderTest extends TestCase {
    private MessageReader reader;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        reader = new MessageReader(new MockStream());
    }

    public void test_size() throws IOException {
        assertEquals(18, reader.read_size());
    }

    public void test_sting_message() throws IOException {
        assertEquals("{\"hello\": \"world\"}", reader.string_message());
    }

    public void test_message() throws IOException, JSONException {
        JSONObject message = new JSONObject();
        message.put("hello", "world");
        assertEquals(message.toString(), reader.message().toString());
    }

    private class MockStream extends InputStream {
        private byte[] buffer;

        public MockStream() {
            buffer = new byte[]{
                0x00, 0x00, 0x00, 0x12, 0x7b, 0x22, 0x68, 0x65,
                0x6c, 0x6c, 0x6f, 0x22, 0x3a, 0x20, 0x22, 0x77,
                0x6f, 0x72, 0x6c, 0x64, 0x22, 0x7d
            };
        }

        @Override
        public int read(byte[] bytes, int i, int i2) throws IOException {
            System.arraycopy(buffer, i, bytes, 0, i2);
            buffer = Arrays.copyOfRange(buffer, i2, buffer.length);
            return bytes.length;
        }

        @Override
        public int read() throws IOException {
            return read(new byte[1], 0, 1);
        }
    }
}