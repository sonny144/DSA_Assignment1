import java.util.ArrayList;
import java.util.List;

public class ClientNode {
    private String ID;
    private List<String> messages;

    public ClientNode(String ID) {
        this.ID = ID;
        messages = new ArrayList<>();
    }

    // Send method, wrapper around a call to server node
    public void send(String message, ServerNode server) {
        server.brokerMessage(message, ID);
    }

    // Receive method
    public void receive(String message) {
        messages.add("Received: " + message);
    }

    // Display received messages
    public void displayMessages() {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    // Get the ID of the client node
    public String getID() {
        return ID;
    }
}
