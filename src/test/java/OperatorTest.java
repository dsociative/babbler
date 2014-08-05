import junit.framework.TestCase;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class OperatorTest extends TestCase {
    public Operator operator;
    private JSONObject message;
    private String host = System.getenv("HOST");

    public void setUp() throws IOException, JSONException {
        operator = new Operator(host, 8885);
        operator.connect();

        message = new JSONObject();
        message.put("command", "whatever");
    }

    public void testConnect() throws IOException {
        assertEquals(operator.isConnected(), true);
    }

    public void testSend() throws IOException {
        operator.send(message);
    }

    public void testReceive() throws IOException, InterruptedException, JSONException {
        operator.send(message);
        assertEquals("{\"hello\":\"world\"}", operator.receive().toString());
    }
}
