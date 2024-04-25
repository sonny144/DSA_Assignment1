public class ServerNode {
    // Existing fields and methods...

    // Modifies brokerMessage to decompress message before broadcasting
    public void brokerMessage(byte[] compressedMessage, String senderID) {
        String message = CompressionUtil.decompress(compressedMessage);
        messages.add("From " + senderID + ": " + message);
        for (ClientNode node : clientNodes) {
            if (!node.getID().equals(senderID)) {
                node.receive(message);
            }
        }
    }
}
