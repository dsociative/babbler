import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;


public class MessageReader {

    private final InputStream stream;

    public MessageReader(InputStream stream) {
        this.stream = stream;
    }

    public int readSize() throws IOException {
        byte[] size_buffer = new byte[4];
        stream.read(size_buffer, 0, 4);
        return ByteBuffer.wrap(size_buffer).getInt();
    }

    public JSONObject message() throws IOException, JSONException {

        return new JSONObject(stringMessage());
    }

    public String stringMessage() throws IOException {
        int size = readSize();
        byte[] buffer = new byte[size];
        stream.read(buffer, 0, size);
        return new String(buffer);
    }
}
