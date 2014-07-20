import org.json.JSONException;

import java.io.*;
import java.net.Socket;

public class Operator {
    private Socket socket;
    private final String host;
    private final int port;

    private MessageReader reader;

    public Operator(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
    }

    public void connect() throws IOException {
        socket = new Socket(host, port);
        reader = new MessageReader(socket.getInputStream());
    }

    public boolean is_connected() {
        return socket.isConnected();
    }

    public void send(byte[] data) throws IOException {
        OutputStream stream = socket.getOutputStream();
        stream.write(data);
    }

    public org.json.JSONObject receive() throws IOException, JSONException {
        return reader.message();
    }
}
