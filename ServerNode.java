import java.util.ArrayList;
import java.util.List;

class ServerNode {
    private String name;
    private List<ClientNode> clients;

    public ServerNode(String name) {
        this.name = name;
        this.clients = new ArrayList<>();
    }

    // Broker messages sent by client node objects
    public void brokerMessage(ClientNode sender, String message) {
        for (ClientNode client : clients) {
            if (!client.equals(sender)) {
                client.receive(message, sender.getName());
            }
        }
    }

    // Add a client to the server node
    public void addClient(ClientNode client) {
        clients.add(client);
    }

    // Remove a client from the server node
    public void removeClient(ClientNode client) {
        clients.remove(client);
    }
}