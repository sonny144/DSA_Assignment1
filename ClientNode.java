import java.util.List;
import java.util.ArrayList;

public class ClientNode { //this class represents the client node
    private String ID;  // unique identifier for the client
    private List<String> messages; //list to store the messages

    public ClientNode(String ID) {  //client node constructor,initialize new instance of client node with ID 
        this.ID = ID;
        messages = new ArrayList<>(); //initialize messages list
    }

    public void send(String message, ServerNode server,ClientNode recipient) { //send method to take in message,server and recipient client node
        System.out.println(this.ID + " sending message: \"" + message + "\""); 
        byte[] compressedMessage = CompressionUtil.compress(message); //compresses the message
        server.brokerMessage(compressedMessage, this.ID); //calls the brokerMessage method
        recipient.receive(compressedMessage,this.ID); // calls the receive method
    }
   
    public void receive(byte[] compressedMessage, String senderID) { //receive method
        String message = CompressionUtil.decompress(compressedMessage); //decompress the message
        messages.add("Received from " + senderID + ": \"" + message + "\"");
        System.out.println(this.ID + " received message from " + senderID + ": \"" + message + "\"");
    }
    

    public String getID() {
        return ID; // returns unique identifier for the clients
    }
}
