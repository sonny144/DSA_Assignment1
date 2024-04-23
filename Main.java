public class Main {
    public static void main(String[] args) {
        // Create server node
        ServerNode server = new ServerNode();
        
        // Create client nodes
        ClientNode client1 = new ClientNode("Client1");
        ClientNode client2 = new ClientNode("Client2");
        ClientNode client3 = new ClientNode("Client3");
        ClientNode client4 = new ClientNode("Client4");
        
        // Create star network
        Star starNetwork = new Star();
        
        // Insert client nodes into the star network
        starNetwork.insertNode(client1);
        starNetwork.insertNode(client2);
        starNetwork.insertNode(client3);
        starNetwork.insertNode(client4);
        
        // Send messages between client nodes
        client1.send("Hello from Client1", server);
        client2.send("Hi from Client2", server);
        client3.send("Greetings from Client3", server);
        client3.send("Greetings from Client4, how is everyone?", server);
        
        // Display messages received by client nodes
        client1.displayMessages();
        client2.displayMessages();
        client3.displayMessages();
        client4.displayMessages();
        
        System.out.println("\nBefore deletion:");
        starNetwork.displayClientNodes(); // Display client nodes before deletion
        starNetwork.deleteNode(client3); // Delete client2
        System.out.println("\nAfter deletion:");
        starNetwork.displayClientNodes(); // Display client nodes after deletion
    }
}
