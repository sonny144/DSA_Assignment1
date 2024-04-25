import java.util.ArrayList;
import java.util.List;

public class ClientNode {
  private String clientName; // Use a more descriptive name
  private List<String> messages;

  public ClientNode(String clientName) {
    this.clientName = clientName;
    messages = new ArrayList<>();
  }

  // Send method, wrapper around a call to server node
  public void send(String message, ServerNode server) {
    server.sendMessage(message, this); // Use sendMessage for consistency
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

  // Get the client name
  public String getClientName() {
    return clientName;
  }
}
