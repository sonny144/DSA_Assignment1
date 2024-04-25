import java.util.ArrayList;
import java.util.List;

//This class represents the Server Node in the star topology network
public class ServerNode {

    //This list stores all the client nodes connected to the server node
    private List<ClientNode> clientNodes;
    
    //Constructor to initialize the server node
    public ServerNode() {
        //Initialize the list of client nodes
        clientNodes = new ArrayList<>();
    }

    //Method to add a client node to the server's list of client nodes
    public void addClientNode(ClientNode node) {
        //Add the client node to the list of client nodes
        clientNodes.add(node);
    }

    //Method to broker a message sent by a client node
    public void brokerMessage(String message, String senderID) {
        // Send the message to all client nodes except the sender
        for (ClientNode node : clientNodes) {
            // Check if the current client node is not the sender
            if (!node.getID().equals(senderID)) {
                // Send the message to the client node
                node.receive(message, senderID);
            }
        }
    }
}
