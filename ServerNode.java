import java.util.ArrayList;
import java.util.List;

public class ServerNode {
    private List<String> messages;
    
    public ServerNode() {
        messages = new ArrayList<>();
    }
    
    // Broker messages sent by client node objects
    public void brokerMessage(String message, String senderID) {
        String formattedMessage = "Message from " + senderID + ": " + message;
        messages.add(formattedMessage);
        System.out.println("Server received message: " + formattedMessage);
    }
    
    // Method to display all messages stored in the server
    public void displayMessages() {
        for (String message : messages) {
            System.out.println(message);
        }
    }
}
