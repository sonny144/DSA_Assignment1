class Star {
    public ServerNode centralNode;

    public Star(String centralNodeName) {
        this.centralNode = new ServerNode(centralNodeName);
    }

    // Insert a node to the model
    public void insertNode(ClientNode client) {
        centralNode.addClient(client);
    }

    // Delete a node from the model
    public void deleteNode(ClientNode client) {
        centralNode.removeClient(client);
    }
}