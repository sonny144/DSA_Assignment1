public class ClientNode {
    private int id;
    private ServerNode server;

    public ClientNode(int id, ServerNode server) { // Add missing closing parenthesis and semicolon
        this.id = id;
        this.server = server;
    }

    public String getID() {
        return String.valueOf(id);
    }

    public void send(String message) {
        server.brokerMessage(message, this);
    }

    // Implement method to receive individual characters during decompression
    public void receiveChar(char c) {
        // Implement logic to handle the received character (e.g., display on console, store in a buffer)
        System.out.print(c); // Example: Print the character to the console
    }
}
