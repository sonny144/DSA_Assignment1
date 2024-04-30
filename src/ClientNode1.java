public class ClientNode {
    private int id; // Unique identifier for the client

    public ClientNode(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    /**
     * Sends a message to the server.
     * @param server The server to send the message to.
     * @param message The message to be sent.
     */
    public void sendMessage(ServerNode server, String message) {
        server.broadcastMessage(message, this); // Send message to server for broadcasting
    }

    /**
     * Receives a message from another client through the server.
     * @param message The received message.
     * @param senderID The ID of the sender.
     */
    public void receiveMessage(String message, int senderID) {
        System.out.println("[" + senderID + "] -> [" + id + "]: " + message);
    }
}
