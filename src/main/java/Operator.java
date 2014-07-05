import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Operator {
    private Socket socket;
    private final String host;
    private final int port;

    public Operator(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
    }

    public void connect() throws IOException {
        socket = new Socket(host, port);
    }

    public boolean is_connected() {
        return socket.isConnected();
    }

    public void send(byte[] data) throws IOException {
        OutputStream stream = socket.getOutputStream();
        stream.write(data);
    }

    public byte[] receive() throws IOException {
        byte[] size = new byte[22];
        socket.getInputStream().read(size);
        return size;
    }
}
