import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class OperatorTest {
    public Operator operator;
    private JSONObject message;
    private String host = System.getenv("HOST");

    @Before
    public void setUp() throws IOException, JSONException {
        operator = new Operator(host, 8885);
        operator.connect();

        message = new JSONObject();
        message.put("command", "whatever");
    }

    @Test
    public void connect() throws IOException {
        assertEquals(operator.isConnected(), true);
    }

    @Test
    public void send() throws IOException {
        operator.send(message);
    }

    @Test
    public void receive() throws IOException, InterruptedException, JSONException {
        operator.send(message);
        assertEquals("{\"hello\":\"world\"}", operator.receive().toString());
    }
}
