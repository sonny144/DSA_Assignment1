class ClientNode {
    private String name;

    public ClientNode(String name) {
        this.name = name;
    }

    // Send message, wrapper around server's method
    public void send(ServerNode server, String message) {
        server.brokerMessage(this, message);
    }

    // Receive message
    public void receive(String message, String senderName) {
        System.out.println("Message from " + senderName + ": " + message);
    }

    public String getName() {
        return name;
    }
}