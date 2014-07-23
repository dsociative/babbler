import junit.framework.TestCase;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MessageWriterTest extends TestCase {
    public static final byte[] HELLO_TALKER = new byte[]{
        0, 0, 0, 26, 123, 34, 99, 111, 109, 109, 97, 110, 100,
        34, 58, 34, 104, 101, 108, 108, 111, 46, 116, 97, 108,
        107, 101, 114, 34, 125
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