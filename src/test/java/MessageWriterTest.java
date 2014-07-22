import junit.framework.TestCase;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MessageWriterTest extends TestCase {
    public static final byte[] HELLO_TALKER = new byte[]{
        0x00, 0x00, 0x00, 0x1b, 0x7b, 0x22, 0x63, 0x6f,
        0x6d, 0x6d, 0x61, 0x6e, 0x64, 0x22, 0x3a, 0x20,
        0x22, 0x68, 0x65, 0x6c, 0x6c, 0x6f, 0x2e, 0x74,
        0x61, 0x6c, 0x6b, 0x65, 0x72, 0x22, 0x7d
    };
    private MessageWriter writer;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        writer = new MessageWriter();
    }

    public void test_pack() throws JSONException {
        JSONObject message = new JSONObject();
        message.put("command", "hello.talker");
        assertEquals(Arrays.toString(HELLO_TALKER), Arrays.toString(writer.pack(message)));
    }

}