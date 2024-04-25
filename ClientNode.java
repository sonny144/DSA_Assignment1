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
    public void receive(String message, String senderID) {
        // Print the received message along with the sender's ID
        System.out.println("Received from " + senderID + ": " + message);
    }

    // Get the ID of the client node
    public String getID() {
        return ID;
    }
}

// Main class to demonstrate the functionality
public class StarTopologyDemo {
    public static void main(String[] args) {
        // Create a server node
        ServerNode server = new ServerNode();
        
        // Create client nodes
        ClientNode client1 = new ClientNode("Client1");
        ClientNode client2 = new ClientNode("Client2");
        ClientNode client3 = new ClientNode("Client3");
        
        // Add client nodes to the server
        server.addClientNode(client1);
        server.addClientNode(client2);
        server.addClientNode(client3);
        
        // Send messages from client nodes
        client1.send("Hello from Client1", server);
        client2.send("Hi from Client2", server);
        client3.send("Hey from Client3", server);
    }
}
