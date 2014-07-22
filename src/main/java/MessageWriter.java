import org.json.JSONObject;

import java.nio.ByteBuffer;

public class MessageWriter {
    public byte[] pack(JSONObject message) {
        byte[] data = message.toString().getBytes();
        ByteBuffer size = ByteBuffer.allocate(4 + data.length);
        size.putInt(data.length);
        size.put(data);
        return size.array();
    }
}
