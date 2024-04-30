public class Main {
    public static void main(String[] args) {
        // Create a star network
        Star network = new Star("CentralServer");

        // Create client nodes
        ClientNode client1 = new ClientNode("Client1");
        ClientNode client2 = new ClientNode("Client2");

        // Insert client nodes into the network
        network.insertNode(client1);
        network.insertNode(client2);

        // Simulate message sending
        client1.send(network.centralNode, "Hello from Client1");
        client2.send(network.centralNode, "Hello from Client2");

        // Delete a node from the network
        network.deleteNode(client1);

        // Message after deletion
        client2.send(network.centralNode, "Hello again from Client2");
    }
}