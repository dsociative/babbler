import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;


public class MessageReader {

    private final InputStream stream;

    public MessageReader(InputStream stream) {
        this.stream = stream;
    }

    public int read_size() throws IOException {
        byte[] size_buffer = new byte[4];
        stream.read(size_buffer, 0, 4);
        return ByteBuffer.wrap(size_buffer).getInt();
    }

    public JSONObject message() throws IOException, JSONException {

        return new JSONObject(string_message());
    }

    public String string_message() throws IOException {
        int size = read_size();
        byte[] buffer = new byte[size];
        stream.read(buffer, 0, size);
        return new String(buffer);
    }
}
