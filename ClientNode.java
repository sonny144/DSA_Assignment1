import java.util.List;
import java.util.ArrayList;

public class ClientNode { // this represents a client Node which can send and receive messages
    private String ID; // unique identifier for each client
    private List<String> messages; //list that will store the messages from the clients

    public ClientNode(String ID) { // constructor the clientNode which initializes new instance of ClientNode with its unique ID. 
        this.ID = ID;
        messages = new ArrayList<>(); //we initialize the list for the messages
    }

    public void send(String message, ServerNode server,ClientNode recipient) { // send method takes in the message to be sent server and client node to which the message is being sent
        System.out.println(this.ID + " sending message: \"" + message + "\"");
        byte[] compressedMessage = CompressionUtil.compress(message); //compress the message
        server.brokerMessage(compressedMessage, this.ID); // delivers message to the server
        recipient.receive(compressedMessage,this.ID); // message is received by the particular clientNode
    }

    public void receive(byte[] compressedMessage, String senderID) { // method to receive message from another node
        String message = CompressionUtil.decompress(compressedMessage); //decompress the message
        messages.add("Received from " + senderID + ": \"" + message + "\"");
        System.out.println(this.ID + " received message from " + senderID + ": \"" + message + "\"");
    }

    public String getID() {
        return ID;  // returns unique identifier for the clients
    }
}