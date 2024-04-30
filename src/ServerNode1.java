import java.util.ArrayList;
import java.util.List;

public class ServerNode {
    private List<ClientNode> clients;

    public ServerNode() {
        clients = new ArrayList<>();
    }

    /**
     * Adds a client to the server.
     * @param client The client node to be added.
     */
    public void addClient(ClientNode client) {
        clients.add(client);
    }

    /**
     * Removes a client from the server.
     * @param client The client node to be removed.
     */
    public void removeClient(ClientNode client) {
        clients.remove(client);
    }

    /**
     * Broadcasts a message from a client to all other clients in the network.
     * @param message The message to be sent.
     * @param sender The client sending the message.
     */
    public void broadcastMessage(String message, ClientNode sender) {
        System.out.println("[" + sender.getID() + "] sent: " + message);
        for (ClientNode client : clients) {
            if (client != sender) {
                client.receiveMessage(message, sender.getID()); // Forward message without compression
            }
        }
    }
}
