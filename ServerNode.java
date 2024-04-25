import java.util.ArrayList;
import java.util.List;

//This class represents the Server Node in the star topology network
public class ServerNode {

    //This list stores all the client nodes connected to the server node
    private List<ClientNode> clientNodes;
    
    //This list stores all the messages brokered by the server node
    private List<String> messages;

    //Constructor to initialize the server node
    public ServerNode() {

        //Initialize the list of client nodes
        clientNodes = new ArrayList<>();
        
        //Initialize the list of messages
        messages = new ArrayList<>();
    }

    //Method to add a client node to the server's list of client nodes
    public void addClientNode(ClientNode node) {

        //Add the client node to the list of client nodes
        clientNodes.add(node);
    }

    //Method to broker a message sent by a client node
    public void brokerMessage(String message, String senderID) {
        
        //Add the message to the server's list of messages

        //The message is formatted to include the sender's ID
        messages.add("From " + senderID + ": " + message);
        
        //Send the message to all client nodes except the sender
        for (ClientNode node : clientNodes) {

            //Check if the current client node is not the sender
            if (!node.getID().equals(senderID)) {

                //Send the message to the client node
                node.receive(message);
            }
        }
    }
}