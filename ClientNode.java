import java.util.List;
import java.util.ArrayList;

public class ClientNode { // this represents a client Node which can send and receive messages
    private String ID; // unique identifier for each client
    private List<String> messages; //list that will store the messages from the clients

    public ClientNode(String ID) { // constructor the clientNode which initializes new instance of ClientNode with its unique ID. 
        this.ID = ID;
        messages = new ArrayList<>(); //we initialize the list for the messages
    }

    public void send(String message, ServerNode server) { // send method takes in the message to be sent and also the server node to which the message is being sent
        System.out.println(this.ID + " sending message: \"" + message + "\"");
        byte[] compressedMessage = CompressionUtil.compress(message); //compress the message
        server.brokerMessage(compressedMessage, this.ID); // delivers messahe to the server
    }

    public void receive(byte[] compressedMessage, String senderID) { // method to receive message from another node
        String message = CompressionUtil.decompress(compressedMessage); //decompress the message
        messages.add("Received from " + senderID + ": \"" + message + "\"");
        System.out.println(this.ID + " received message from " + senderID + ": \"" + message + "\"");
    }

    public void displayMessages() { //method to display all the messages that are sent
        if (messages.isEmpty()) {
            System.out.println(this.ID + " has no messages."); 
        } else {
            System.out.println(this.ID + " messages:"); // in situation where the there is no message
            for (String msg : messages) {
                System.out.println(msg);
            }
        }
    }

    public String getID() {
        return ID;  // returns unique identifier for the clients
    }
}