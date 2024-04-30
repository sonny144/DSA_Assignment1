import java.util.ArrayList;
import java.util.List;

public class ServerNode {
    private List<ClientNode> clientNodes = new ArrayList<>();

    public void addClientNode(ClientNode node) {
        clientNodes.add(node);
    }

    public void brokerMessage(byte[] compressedMessage, String senderID) {
        // Decompressing the message to log it, then recompress for sending
        String message = CompressionUtil.decompress(compressedMessage);
        System.out.println("Server is brokering a message from " + senderID + ": \"" + message + "\"");

        // Recompress message for sending to other clients
        byte[] recompressedMessage = CompressionUtil.compress(message);

        for (ClientNode node : clientNodes) {
            if (!node.getID().equals(senderID)) {
                System.out.println("Server sending message to " + node.getID());
                node.receive(recompressedMessage, senderID);
            }
        }
    }
}


