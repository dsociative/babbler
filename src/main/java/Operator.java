import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

public class Operator {
    private Socket socket;
    private final String host;
    private final int port;

    private MessageReader reader;
    private MessageWriter writer;

    public Operator(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
    }

    public void connect() throws IOException {
        socket = new Socket(host, port);
        reader = new MessageReader(socket.getInputStream());
        writer = new MessageWriter(socket.getOutputStream());
    }

    public boolean isСonnected() {
        return socket.isConnected();
    }

    public void send(JSONObject message) throws IOException {
        writer.write(message);
    }

    public org.json.JSONObject receive() throws IOException, JSONException {
        return reader.message();
    }
}
