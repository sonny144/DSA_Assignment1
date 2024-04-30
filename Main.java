public class Main {

    public static void main(String[] args) {
        // Create a server node
        ServerNode server = new ServerNode();

        // Create client nodes with unique IDs (adjust as needed)
        int clientId = 1;
        ClientNode client1 = new ClientNode(clientId++, server);
        ClientNode client2 = new ClientNode(clientId++, server);
        ClientNode client3 = new ClientNode(clientId++, server);

        // Create a star network
        Star network = new Star(server);

        // Insert client nodes into the star network
        network.insertNode(client1);
        network.insertNode(client2);
        network.insertNode(client3);

        // Send messages with compression (targeted delivery)
        client1.send("Hello from Client1 to Client2."); // Targeted message
        client2.send("Greetings from Client2 to all!"); // Broadcast message
        client3.send("Hi everyone, this is Client3.");  // Broadcast message

        System.out.println("\n--- After sending messages ---");
    }
}
