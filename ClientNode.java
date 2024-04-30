import java.util.List;
import java.util.ArrayList;

public class ClientNode {
    private String ID;
    private List<String> messages;

    public ClientNode(String ID) {
        this.ID = ID;
        messages = new ArrayList<>();
    }

    public void send(String message, ServerNode server,ClientNode recipient) {
        System.out.println(this.ID + " sending message: \"" + message + "\"");
        byte[] compressedMessage = CompressionUtil.compress(message);
        server.brokerMessage(compressedMessage, this.ID);
        recipient.receive(compressedMessage,this.ID);
    }
   
    public void receive(byte[] compressedMessage, String senderID) {
        String message = CompressionUtil.decompress(compressedMessage);
        messages.add("Received from " + senderID + ": \"" + message + "\"");
        System.out.println(this.ID + " received message from " + senderID + ": \"" + message + "\"");
    }
    

    public String getID() {
        return ID;
    }
}
