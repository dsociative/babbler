import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class MessageWriter {
    private OutputStream output;

    public MessageWriter(OutputStream output){
        this.output = output;
    }

    public byte[] pack(JSONObject message) {
        byte[] data = message.toString().getBytes();
        ByteBuffer size = ByteBuffer.allocate(4 + data.length);
        size.putInt(data.length);
        size.put(data);
        return size.array();
    }

    public void write(JSONObject message) throws IOException {
        output.write(pack(message));
    }
}
