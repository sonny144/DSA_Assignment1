public class ClientNode {
    // Existing fields and methods...

    // changes send method to compress message before sending
    public void send(String message, ServerNode server) {
        byte[] compressedMessage = CompressionUtil.compress(message);
        server.brokerMessage(compressedMessage, ID);
    }
}

//To integrate RLE compression, we need to modify how messages are sent and brokered.
